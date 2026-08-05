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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSRuleImplSignature}'s
 * entries -- DISPOSE is deliberately not bound here (see dom_css_rule.cpp's
 * header comment), only GET_TYPE/GET_CSS_TEXT/SET_CSS_TEXT/
 * GET_PARENT_STYLE_SHEET/GET_PARENT_RULE.
 */
public final class CSSRuleImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_TYPE = bind(CSSRuleImplSignature.GET_TYPE);
    private static final MethodHandle GET_CSS_TEXT = bind(CSSRuleImplSignature.GET_CSS_TEXT);
    private static final MethodHandle SET_CSS_TEXT = bind(CSSRuleImplSignature.SET_CSS_TEXT);
    private static final MethodHandle GET_PARENT_STYLE_SHEET = bind(CSSRuleImplSignature.GET_PARENT_STYLE_SHEET);
    private static final MethodHandle GET_PARENT_RULE = bind(CSSRuleImplSignature.GET_PARENT_RULE);

    private CSSRuleImplBinding() {
    }

    private static MethodHandle bind(CSSRuleImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static short getType(long peer) {
        try {
            return (short) GET_TYPE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleImplSignature.GET_TYPE.symbol(), t);
        }
    }

    public static String getCssText(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleImplSignature.GET_CSS_TEXT.symbol(), t);
        }
    }

    public static void setCssText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSRuleImplSignature.SET_CSS_TEXT.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static long getParentStyleSheet(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PARENT_STYLE_SHEET.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleImplSignature.GET_PARENT_STYLE_SHEET.symbol(), t);
        }
    }

    public static long getParentRule(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PARENT_RULE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSRuleImplSignature.GET_PARENT_RULE.symbol(), t);
        }
    }
}
