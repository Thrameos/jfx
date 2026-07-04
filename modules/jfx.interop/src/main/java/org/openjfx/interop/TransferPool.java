package org.openjfx.interop;

import java.lang.foreign.Arena;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bucketed slab allocator for {@link Transfer} blocks, ported from
 * {@code j2ni-remote}'s {@code org.j2ni.remote.wire.Transfers} (there, one pool per
 * remote session; here, one pool is enough since a single-threaded JFX app-thread
 * model has exactly one "session" worth of native traffic in flight at a time).
 *
 * <p>Requested sizes round up to the next power-of-two bucket from 256 bytes
 * ({@code 1 << BASE}) to 8Ki bytes ({@code BUCKETS} buckets); anything larger gets
 * a one-off {@link Dedicated} block with its own {@link Arena}, since dedicating a
 * whole bucket size class to a rare oversized transfer would waste the class on
 * every other block that bucket ever hands out. Recycled blocks go back onto a
 * free list per bucket rather than being freed, so steady-state traffic (repeatedly
 * exchanging similarly-sized strings/arrays across the same handful of DOM entry
 * points) reuses a small, stable set of native blocks instead of churning malloc/free.
 *
 * <p>{@code synchronized} for the same reason {@code Transfers} was: an upcall
 * (native calling back into Java) can land on a different OS thread than the
 * downcall that started the exchange, even in an otherwise single-threaded JFX
 * app-thread model.
 *
 * <p><b>Direct-index resolution.</b> Every block checked out via {@link #allocate}
 * also gets a small integer {@link Transfer#slot()} from a fixed-capacity table --
 * leverage of the same single-threaded assumption above: JFX's WebKit1 port makes
 * exactly one call chain at a time (ordinary recursive reentrancy aside -- see
 * {@code reentrancy}'s {@code ReentrantThreadIdentityTest}), so the number of blocks
 * ever simultaneously in flight is small and bounded by call-stack depth, not by
 * how many objects exist. That makes a small array plus a free-index stack enough:
 * {@link #resolve(int)} is a direct array read, no hashmap, no generation check --
 * unlike {@link Pool}, which exists for handles that must survive independently of
 * any call frame (tier6's persistent {@code EventListener} closures) and therefore
 * does need generation-checked slots. A closure token handed to native can carry a
 * transfer's {@code slot()} directly; the upcall hands it back verbatim and
 * {@link #resolve} finds the transfer (and, via {@link Transfer#attachment()},
 * whatever Java object owns it -- e.g. the {@code Exchange} that allocated it) in
 * one array access.
 *
 * <p><b>Not yet needed, flagged for when it is:</b> {@link #SHARED} is one pool for
 * the whole process. That is correct as long as all native traffic funnels through
 * one thread (the JFX app thread) -- true for this derisk and for WebKit1's real
 * threading model. If a future consumer of this machinery ever calls in from more
 * than one thread concurrently, the fix is a {@code ThreadLocal<TransferPool>}
 * (one pool -- and one in-flight slot table -- per calling thread) rather than
 * adding locking-around-contention to this single shared instance; not built now
 * since nothing in this project needs it yet.
 */
public final class TransferPool {

    private static final Logger LOGGER = Logger.getLogger(TransferPool.class.getName());

    private static final int BASE = 8; // smallest bucket: 1 << 8 = 256 bytes
    private static final int BUCKETS = 6; // largest bucket: 1 << 13 = 8192 bytes
    private static final int MESSY = 32 * 1024;
    private static final int INFLIGHT_CAPACITY = 64;

    /** One pool for the whole process -- see the class doc's "Not yet needed" note. */
    public static final TransferPool SHARED = new TransferPool();

    private Arena arena = Arena.ofShared();
    private int burned = 0;
    private final Transfer[] pool = new Transfer[BUCKETS];

    private final Transfer[] inFlight = new Transfer[INFLIGHT_CAPACITY];
    private final int[] freeSlots = new int[INFLIGHT_CAPACITY];
    private int freeSlotCount = INFLIGHT_CAPACITY;

    public TransferPool() {
        for (int i = 0; i < INFLIGHT_CAPACITY; i++) {
            freeSlots[i] = i;
        }
        PoolRegistry.register(this);
    }

    /**
     * Allocates (or reuses) a block sized for {@code elements * elementSize} bytes.
     * The block is zero-filled and ready to use; return it with {@link Transfer#close()}
     * when done.
     */
    public synchronized Transfer allocate(int elements, int elementSize) {
        long sz = (long) elements * elementSize;
        int u = (32 - Integer.numberOfLeadingZeros((int) Math.max(sz - 1, 0))) - BASE;
        if (u < 0) {
            u = 0;
        }

        Transfer out;
        if (u >= BUCKETS) {
            long aligned = ((sz + 128 + 4095) & ~4095L) - 128;
            out = new Dedicated(this, Arena.ofShared(), aligned, elements, elementSize);
        } else {
            // Try the exact bucket, then the next larger one (simple slab promotion)
            // rather than failing outright when the exact size class is empty.
            Transfer reused = null;
            int limit = Math.min(u + 2, BUCKETS);
            for (int i = u; i < limit; i++) {
                if (pool[i] != null) {
                    reused = pool[i];
                    pool[i] = reused.next;
                    reused.repurpose(elements, elementSize);
                    break;
                }
            }
            if (reused != null) {
                out = reused;
            } else {
                long mem = 1L << (u + BASE);
                burned += mem;
                out = new Transfer(this, arena, mem, elements, elementSize);
            }
        }

        acquireSlot(out);
        return out;
    }

    synchronized void recycle(Transfer transfer) {
        releaseSlot(transfer);

        if (transfer instanceof Dedicated dedicated) {
            dedicated.arena().close();
            return;
        }

        long sz = transfer.segment().byteSize();
        int u = (64 - Long.numberOfLeadingZeros(sz - 1)) - BASE;
        if (u >= 0 && u < BUCKETS) {
            transfer.next = pool[u];
            pool[u] = transfer;
        }
        // Outside the bucket range: drop it and let it be reclaimed with the arena
        // on the next trim() -- should not happen since allocate() never hands out
        // a pooled (non-Dedicated) block outside this range.
    }

    /** Direct-index lookup of a block currently checked out under {@code slot} --
     *  see the class doc's "Direct-index resolution" note. */
    public synchronized Transfer resolve(int slot) {
        if (slot < 0 || slot >= INFLIGHT_CAPACITY) {
            // Most likely a corrupted/garbage closure token reaching an upcall
            // trampoline -- exactly the kind of failure that can surface mid-upcall,
            // where an uncaught exception risks taking the whole JVM down with it
            // (see the exceptions module's UncaughtUpcallExceptionProbeTest). Logged
            // here so there is a record even if the process doesn't survive much longer.
            LOGGER.log(Level.SEVERE, "resolve() called with a slot outside capacity: {0}", slot);
            throw new IllegalStateException("no in-flight transfer at slot " + slot);
        }
        Transfer transfer = inFlight[slot];
        if (transfer == null) {
            LOGGER.log(Level.SEVERE, "resolve() called with a slot that is not currently checked out: {0}", slot);
            throw new IllegalStateException("no in-flight transfer at slot " + slot);
        }
        return transfer;
    }

    /** Non-throwing probe for {@link PoolRegistry#resolve} -- {@code null} on any mismatch. */
    synchronized Transfer peek(long token) {
        if (token < 0 || token >= INFLIGHT_CAPACITY) {
            return null;
        }
        return inFlight[(int) token];
    }

    private void acquireSlot(Transfer transfer) {
        if (freeSlotCount == 0) {
            // Loud and impossible to miss on purpose: this should never happen under
            // the single-threaded, bounded-reentrancy assumption the whole direct-index
            // scheme rests on (see the class doc), so hitting it means either that
            // assumption broke (unexpected concurrent/thread-hopping traffic) or a
            // Transfer leaked (allocated, never closed) -- both worth investigating
            // immediately, not just noting in a caught exception's message.
            LOGGER.severe("TransferPool: in-flight capacity (" + INFLIGHT_CAPACITY
                    + ") exhausted -- deeper reentrancy than expected, or a leaked (never-closed) "
                    + "Transfer. See TransferPool's class doc.");
            throw new IllegalStateException(
                    "TransferPool in-flight capacity (" + INFLIGHT_CAPACITY + ") exceeded");
        }
        int slot = freeSlots[--freeSlotCount];
        inFlight[slot] = transfer;
        transfer.slot = slot;
    }

    private void releaseSlot(Transfer transfer) {
        int slot = transfer.slot;
        if (slot < 0) {
            LOGGER.warning("Transfer already closed (double-close/double-recycle)");
            throw new IllegalStateException("Transfer already closed (double-close/double-recycle)");
        }
        inFlight[slot] = null;
        freeSlots[freeSlotCount++] = slot;
        transfer.slot = -1;
    }

    /**
     * Releases the whole pool's backing memory if it has grown past a "messy"
     * threshold, so a burst of unusually large traffic doesn't leave a permanently
     * oversized set of buckets sitting idle. Call this between DOM interaction
     * bursts (e.g. on navigation), not per-call.
     */
    public synchronized void trim() {
        if (burned < MESSY) {
            return;
        }
        arena.close();
        arena = Arena.ofShared();
        burned = 0;
        Arrays.fill(pool, null);
    }

    public synchronized int inFlightCount() {
        return INFLIGHT_CAPACITY - freeSlotCount;
    }

    @Override
    public synchronized String toString() {
        int idleRecycled = 0;
        for (Transfer bucket : pool) {
            for (Transfer t = bucket; t != null; t = t.next) {
                idleRecycled++;
            }
        }
        return "TransferPool[inFlight=" + inFlightCount() + "/" + INFLIGHT_CAPACITY
                + ", idleRecycled=" + idleRecycled + ", burned=" + burned + "]";
    }
}
