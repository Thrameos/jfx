package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;

public final class CSSStyleRuleImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_SELECTOR_TEXT = bind(CSSStyleRuleImplSignature.GET_SELECTOR_TEXT);
    private static final MethodHandle SET_SELECTOR_TEXT = bind(CSSStyleRuleImplSignature.SET_SELECTOR_TEXT);
    private static final MethodHandle GET_STYLE = bind(CSSStyleRuleImplSignature.GET_STYLE);

    private CSSStyleRuleImplBinding() {
    }

    private static MethodHandle bind(CSSStyleRuleImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static String getSelectorText(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SELECTOR_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleRuleImplSignature.GET_SELECTOR_TEXT.symbol(), t);
        }
    }

    public static void setSelectorText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_SELECTOR_TEXT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleRuleImplSignature.SET_SELECTOR_TEXT.symbol(), t);
        }
    }

    public static long getStyle(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_STYLE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleRuleImplSignature.GET_STYLE.symbol(), t);
        }
    }
}
