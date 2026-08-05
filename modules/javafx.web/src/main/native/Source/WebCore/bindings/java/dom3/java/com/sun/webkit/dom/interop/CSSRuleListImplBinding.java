package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.Downcall;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSRuleListImplSignature}'s
 * entries -- DISPOSE is deliberately not bound here, same rationale as
 * {@link CSSRuleImplBinding}.
 */
public final class CSSRuleListImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_LENGTH = bind(CSSRuleListImplSignature.GET_LENGTH);
    private static final MethodHandle ITEM = bind(CSSRuleListImplSignature.ITEM);

    private CSSRuleListImplBinding() {
    }

    private static MethodHandle bind(CSSRuleListImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleListImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static long item(long peer, int index) {
        try {
            MemorySegment result = (MemorySegment) ITEM.invokeExact(MemorySegment.ofAddress(peer), index);
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleListImplSignature.ITEM.symbol(), t);
        }
    }
}
