package org.openjfx.interop;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generational tagged-handle pool, ported from {@code j2ni}'s
 * {@code org.j2ni.pools.J2ReferencePool64}/{@code J2MappedPool}/{@code J2Pools} scheme
 * (confirmed real, working code there -- not a new design). A handle is
 * {@code (address << ADDRESS_SHIFT) | (generation << GENERATION_SHIFT) | (segment << SEGMENT_SHIFT) | index}.
 * Resolving with a stale generation throws immediately instead of silently reading
 * whatever now occupies a reused slot.
 *
 * <p>Used anywhere a native caller needs to reference a Java-side object across time
 * (tier6's persistent EventListener closure) rather than within a single call frame.
 *
 * <p>Prefer the no-arg constructor, which asks {@link PoolRegistry} for the next
 * unused address rather than the caller inventing one. Every {@code Pool}'s handles
 * already live in one shared 64-bit address space (that is exactly what the address
 * prefix is for), so two independent {@code Pool}s that happened to pick the same
 * hand-written code would silently defeat that check instead of tripping it. The
 * explicit-address constructor still exists for tests that need to force a
 * specific/colliding code on purpose.
 *
 * <p>The four-field bit split below is a pure Java-side encoding -- native only ever
 * sees an opaque {@code long} {@code closure} token and never decodes it, so nothing
 * here is a wire format anyone else depends on; it can change again later for free.
 * {@code address} (8 bits, 256 values) identifies which {@code Pool} -- a small,
 * bounded set of pool *kinds* (global/weak/transfer/generation, roughly), not one
 * code per page. {@code generation} (16 bits) is the same ABA guard as before, just
 * resized. {@code segment} (16 bits, currently always 0 -- reserved, not yet wired
 * to anything) is where a future WebKit2 port's per-page pool scoping lands: many
 * pages, each getting its own segment of the same {@code Pool}'s index space, without
 * needing a separate {@code Pool} instance (and therefore a separate {@code address})
 * per page. {@code index} keeps 24 bits (16M slots) *per segment*, which is what
 * actually matters once segments exist -- unbounded total capacity was never the
 * point of shrinking it. Not built for that today -- there is no "page" concept
 * anywhere in this codebase yet -- but there is no reason to let a stingy bit budget
 * become the reason a future page-scoped pool scheme has to change this encoding
 * under pressure instead of just using it.
 */
public final class Pool<T> {

    private static final Logger LOGGER = Logger.getLogger(Pool.class.getName());

    private static final int ADDRESS_SHIFT = 56;      // 8 bits: which Pool
    private static final int GENERATION_SHIFT = 40;   // 16 bits: ABA guard
    private static final int SEGMENT_SHIFT = 24;       // 16 bits: reserved for future per-page routing
    private static final long GENERATION_MASK = 0xFFFFL;
    private static final long SEGMENT_MASK = 0xFFFFL;
    private static final long INDEX_MASK = 0xFF_FFFFL; // 24 bits

    private final long address;

    private static final class Slot<T> {
        T value;
        int generation;
        boolean occupied;
    }

    private final List<Slot<T>> slots = new ArrayList<>();
    private final List<Integer> freeList = new ArrayList<>();

    /** Manager-assigned address -- see the class doc. */
    public Pool() {
        this(PoolRegistry.nextPoolCode());
    }

    public Pool(long address) {
        this.address = address;
        PoolRegistry.register(this);
    }

    public synchronized long register(T value) {
        int index;
        if (!freeList.isEmpty()) {
            index = freeList.remove(freeList.size() - 1);
        } else {
            index = slots.size();
            slots.add(new Slot<>());
        }
        Slot<T> slot = slots.get(index);
        slot.value = value;
        slot.occupied = true;
        return encode(index, slot.generation);
    }

    public synchronized T resolve(long handle) {
        checkAddress(handle);
        int index = decodeIndex(handle);
        int generation = decodeGeneration(handle);
        if (index < 0 || index >= slots.size()) {
            LOGGER.log(Level.WARNING, "Invalid pool handle (out of range): {0}", Long.toHexString(handle));
            throw new IllegalArgumentException("Invalid pool handle: " + Long.toHexString(handle));
        }
        Slot<T> slot = slots.get(index);
        if (!slot.occupied || slot.generation != generation) {
            LOGGER.log(Level.WARNING, "Stale pool handle resolved (already released or reused): {0}",
                    Long.toHexString(handle));
            throw new IllegalStateException("Stale pool handle: " + Long.toHexString(handle));
        }
        return slot.value;
    }

    public synchronized void release(long handle) {
        checkAddress(handle);
        int index = decodeIndex(handle);
        int generation = decodeGeneration(handle);
        if (index < 0 || index >= slots.size()) {
            LOGGER.log(Level.WARNING, "Invalid pool handle (out of range): {0}", Long.toHexString(handle));
            throw new IllegalArgumentException("Invalid pool handle: " + Long.toHexString(handle));
        }
        Slot<T> slot = slots.get(index);
        if (!slot.occupied || slot.generation != generation) {
            LOGGER.log(Level.WARNING, "Double-release or stale pool handle: {0}", Long.toHexString(handle));
            throw new IllegalStateException("Double-release or stale pool handle: " + Long.toHexString(handle));
        }
        slot.value = null;
        slot.occupied = false;
        slot.generation = (slot.generation + 1) & (int) GENERATION_MASK;
        freeList.add(index);
    }

    private void checkAddress(long handle) {
        long handleAddress = handle >>> ADDRESS_SHIFT;
        if (handleAddress != address) {
            LOGGER.log(Level.WARNING, "Handle belongs to a different pool (expected address {0}, got {1}): {2}",
                    new Object[] {Long.toHexString(address), Long.toHexString(handleAddress), Long.toHexString(handle)});
            throw new IllegalArgumentException("Handle belongs to a different pool: " + Long.toHexString(handle));
        }
    }

    private long encode(int index, int generation) {
        return (address << ADDRESS_SHIFT)
                | (((long) generation & GENERATION_MASK) << GENERATION_SHIFT)
                | (0L << SEGMENT_SHIFT) // segment: always 0 today -- reserved, see class doc
                | ((long) index & INDEX_MASK);
    }

    private static int decodeIndex(long handle) {
        return (int) (handle & INDEX_MASK);
    }

    private static int decodeGeneration(long handle) {
        return (int) ((handle >>> GENERATION_SHIFT) & GENERATION_MASK);
    }

    public synchronized int size() {
        return slots.size() - freeList.size();
    }

    /** Non-throwing probe for {@link PoolRegistry#resolve} -- {@code null} on any mismatch
     *  (wrong address, out of range, stale generation) rather than an exception. */
    synchronized Object peek(long handle) {
        if ((handle >>> ADDRESS_SHIFT) != address) {
            return null;
        }
        int index = decodeIndex(handle);
        int generation = decodeGeneration(handle);
        if (index < 0 || index >= slots.size()) {
            return null;
        }
        Slot<T> slot = slots.get(index);
        if (!slot.occupied || slot.generation != generation) {
            return null;
        }
        return slot.value;
    }

    @Override
    public synchronized String toString() {
        return "Pool[address=0x" + Long.toHexString(address) + ", occupied=" + size()
                + ", capacity=" + slots.size() + "]";
    }
}
