package org.openjfx.interop;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Every {@link Pool}, {@link NativeHandlePool}, and {@link TransferPool} instance in
 * the process registers itself here on construction, purely so it stays reachable
 * for debugging. Each of these is typically a private field on some {@code *Binding}
 * (e.g. {@code NodeImplBinding}'s {@code NativeHandlePool}, {@code
 * EventListenerImplBinding}'s {@code Pool<EventListenerImpl>}) with no other path
 * back to it once construction finishes -- without this, "what's currently
 * outstanding in the tier7 handle pool" is only answerable by attaching a debugger
 * and walking object references from a `*Binding` instance you already have to know
 * to look for. {@link #dump()} answers it directly, from anywhere.
 *
 * <p>Weakly held: registering here must never keep a pool (or its owner) alive past
 * what the rest of the program would anyway. A single test run alone constructs
 * dozens of short-lived {@code Pool}/{@code TransferPool} instances that would
 * otherwise accumulate for the life of the JVM if held strongly.
 */
public final class PoolRegistry {

    private static final List<WeakReference<Object>> POOLS = new CopyOnWriteArrayList<>();

    // Matches Pool's ADDRESS_SHIFT = 56: the top 8 bits of a handle are its address.
    // 256 pool *kinds* is plenty -- see Pool's class doc's bit-budget note (the real
    // per-page scaling room is in the reserved 16-bit segment field, not here).
    private static final long MAX_POOL_CODE = 0xFFL;
    private static final AtomicLong NEXT_POOL_CODE = new AtomicLong(1);

    private PoolRegistry() {
    }

    static void register(Object pool) {
        POOLS.add(new WeakReference<>(pool));
    }

    /**
     * Hands out the next unused {@link Pool} code, so call sites never invent their
     * own small integer and risk two independent {@code Pool}s picking the same one
     * (silently defeating {@link Pool#resolve}'s cross-pool-code check -- a handle
     * meant for one pool would validate against the other). Reserved for {@link
     * Pool}'s manager-assigned constructor; {@code TransferPool} and {@code
     * NativeHandlePool} don't need a code from here -- see their own class docs for
     * why (a fixed small direct-index range, and real native addresses, respectively).
     */
    static long nextPoolCode() {
        long code = NEXT_POOL_CODE.getAndIncrement();
        if (code > MAX_POOL_CODE) {
            throw new IllegalStateException(
                    "PoolRegistry has handed out all " + (MAX_POOL_CODE + 1) + " available Pool addresses "
                            + "(Pool's handle format reserves 8 bits for the address)");
        }
        return code;
    }

    /** Every still-live registered pool, in registration order. Cleared (GC'd) entries are dropped. */
    public static List<Object> livePools() {
        List<Object> live = new ArrayList<>();
        for (WeakReference<Object> ref : POOLS) {
            Object pool = ref.get();
            if (pool == null) {
                POOLS.remove(ref);
            } else {
                live.add(pool);
            }
        }
        return live;
    }

    /**
     * A one-shot, human-readable dump of every live pool's diagnostic state (each
     * pool's own {@code toString()}) -- meant for pasting into a bug report or
     * printing from a debugger's evaluate-expression field, not for parsing.
     */
    public static String dump() {
        StringBuilder sb = new StringBuilder();
        for (Object pool : livePools()) {
            sb.append(pool.getClass().getSimpleName())
                    .append('@').append(Integer.toHexString(System.identityHashCode(pool)))
                    .append(": ").append(pool).append('\n');
        }
        return sb.toString();
    }

    /**
     * Every {@code Pool}/{@code TransferPool}/{@code NativeHandlePool} handle is
     * treated as one common address space for debugging purposes: whichever specific
     * pool a token was actually issued by, {@code resolve} finds it by asking every
     * live pool in turn, so a caller never needs to already know which pool a given
     * token came from. This is separate from (and slower than) each pool's own real
     * {@code resolve}/{@code acquire} used on the hot path -- those still go directly
     * to the one pool that issued the token, unchanged; this is the "I have a number,
     * what is it" debugging entry point, e.g. from a debugger's evaluate-expression
     * field with nothing but a {@code closure} value copied out of a stack frame.
     *
     * <p>Returns {@code null} if no live pool recognizes {@code token} -- a
     * heterogeneous scan across differently-shaped handle spaces (small
     * {@link TransferPool} slot ints, {@link Pool}'s pool-code-tagged 64-bit handles,
     * raw native addresses in {@link NativeHandlePool}) can't guarantee a false
     * positive is impossible, so treat a hit as a strong lead, not a proof.
     */
    public static Object resolve(long token) {
        for (Object pool : livePools()) {
            Object hit = peek(pool, token);
            if (hit != null) {
                return hit;
            }
        }
        return null;
    }

    private static Object peek(Object pool, long token) {
        if (pool instanceof Pool<?> p) {
            return p.peek(token);
        }
        if (pool instanceof TransferPool t) {
            return t.peek(token);
        }
        if (pool instanceof NativeHandlePool n) {
            return n.peek(token);
        }
        return null;
    }
}
