package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSImportRuleImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CSSImportRuleImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_HREF = bind(CSSImportRuleImplSignature.GET_HREF);
    private static final MethodHandle GET_MEDIA = bind(CSSImportRuleImplSignature.GET_MEDIA);
    private static final MethodHandle GET_STYLE_SHEET = bind(CSSImportRuleImplSignature.GET_STYLE_SHEET);

    private CSSImportRuleImplBinding() {
    }

    private static MethodHandle bind(CSSImportRuleImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static String getHref(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_HREF.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSImportRuleImplSignature.GET_HREF.symbol(), t);
        }
    }

    public static long getMedia(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_MEDIA.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSImportRuleImplSignature.GET_MEDIA.symbol(), t);
        }
    }

    public static long getStyleSheet(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_STYLE_SHEET.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSImportRuleImplSignature.GET_STYLE_SHEET.symbol(), t);
        }
    }
}
