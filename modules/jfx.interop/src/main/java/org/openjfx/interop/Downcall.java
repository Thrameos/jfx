package org.openjfx.interop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception formatting for a failed downcall -- the one thing worth centralizing
 * once call sites use {@code MethodHandle.invokeExact} directly instead of going
 * through a generic {@code invoke(Object...)} wrapper. {@code invokeExact} requires
 * a statically-known exact {@code MethodType} at each call site (the whole point --
 * it is the fast path, unlike {@code invokeWithArguments}, which boxes every
 * argument into an {@code Object[]} and adapts types per call, closer to a
 * reflective call than a real signature-polymorphic dispatch), so there is no
 * single method left to wrap the actual invocation in; every {@code XBinding}
 * method calls {@code invokeExact} itself and catches {@code Throwable} (checked,
 * per {@code invokeExact}'s signature) around just that one call.
 *
 * <pre>{@code
 * try {
 *     return (int) GET_CHILD_ELEMENT_COUNT.invokeExact(MemorySegment.ofAddress(peer));
 * } catch (Throwable t) {
 *     throw Downcall.failed("jfxpanama_dom_Element_getChildElementCount", t);
 * }
 * }</pre>
 */
public final class Downcall {

    private static final Logger LOGGER = Logger.getLogger(Downcall.class.getName());

    private Downcall() {
    }

    /**
     * Logs the failure with the native symbol name attached -- by the time a
     * caller's own catch block (if any) runs, the call has already unwound past
     * the downcall boundary, so this is often the only record of which call
     * failed, not just that something did -- and returns a {@link RuntimeException}
     * for the call site to throw.
     */
    public static RuntimeException failed(String symbol, Throwable t) {
        LOGGER.log(Level.SEVERE, "Downcall failed: " + symbol, t);
        return new RuntimeException("Downcall failed: " + symbol + ": " + t.getMessage(), t);
    }
}
