package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.Downcall;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSFontFaceRuleImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CSSFontFaceRuleImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_STYLE = bind(CSSFontFaceRuleImplSignature.GET_STYLE);

    private CSSFontFaceRuleImplBinding() {
    }

    private static MethodHandle bind(CSSFontFaceRuleImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static long getStyle(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_STYLE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSFontFaceRuleImplSignature.GET_STYLE.symbol(), t);
        }
    }
}
