package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.Downcall;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSValueListImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CSSValueListImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_LENGTH = bind(CSSValueListImplSignature.GET_LENGTH);
    private static final MethodHandle ITEM = bind(CSSValueListImplSignature.ITEM);

    private CSSValueListImplBinding() {
    }

    private static MethodHandle bind(CSSValueListImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSValueListImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static long item(long peer, int index) {
        try {
            MemorySegment result = (MemorySegment) ITEM.invokeExact(MemorySegment.ofAddress(peer), index);
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSValueListImplSignature.ITEM.symbol(), t);
        }
    }
}
