package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.ByteExchange;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;
import org.w3c.dom.DOMException;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSValueImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 *
 * <p>DISPOSE is deliberately not bound here -- dispose() retirement across
 * every migrated CSS OM class is a separate, dedicated pass, not something
 * to bundle into one class's attribute migration (see dom_css_rule.cpp's
 * header comment).
 */
public final class CSSValueImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_CSS_TEXT = bind(CSSValueImplSignature.GET_CSS_TEXT);
    private static final MethodHandle SET_CSS_TEXT = bind(CSSValueImplSignature.SET_CSS_TEXT);
    private static final MethodHandle GET_CSS_VALUE_TYPE = bind(CSSValueImplSignature.GET_CSS_VALUE_TYPE);

    private CSSValueImplBinding() {
    }

    private static MethodHandle bind(CSSValueImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static String getCssText(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSValueImplSignature.GET_CSS_TEXT.symbol(), t);
        }
    }

    public static void setCssText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSValueImplSignature.SET_CSS_TEXT.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static short getCssValueType(long peer) {
        try {
            return (short) GET_CSS_VALUE_TYPE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSValueImplSignature.GET_CSS_VALUE_TYPE.symbol(), t);
        }
    }
}
