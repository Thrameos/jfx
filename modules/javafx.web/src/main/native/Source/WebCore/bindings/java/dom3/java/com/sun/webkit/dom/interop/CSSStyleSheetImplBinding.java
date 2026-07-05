package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.ByteExchange;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;
import org.w3c.dom.DOMException;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSStyleSheetImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CSSStyleSheetImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_OWNER_RULE = bind(CSSStyleSheetImplSignature.GET_OWNER_RULE);
    private static final MethodHandle GET_CSS_RULES = bind(CSSStyleSheetImplSignature.GET_CSS_RULES);
    private static final MethodHandle GET_RULES = bind(CSSStyleSheetImplSignature.GET_RULES);
    private static final MethodHandle INSERT_RULE = bind(CSSStyleSheetImplSignature.INSERT_RULE);
    private static final MethodHandle DELETE_RULE = bind(CSSStyleSheetImplSignature.DELETE_RULE);
    private static final MethodHandle ADD_RULE = bind(CSSStyleSheetImplSignature.ADD_RULE);
    private static final MethodHandle REMOVE_RULE = bind(CSSStyleSheetImplSignature.REMOVE_RULE);

    private CSSStyleSheetImplBinding() {
    }

    private static MethodHandle bind(CSSStyleSheetImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static long getOwnerRule(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_OWNER_RULE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleSheetImplSignature.GET_OWNER_RULE.symbol(), t);
        }
    }

    public static long getCssRules(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_CSS_RULES.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleSheetImplSignature.GET_CSS_RULES.symbol(), t);
        }
    }

    public static long getRules(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_RULES.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleSheetImplSignature.GET_RULES.symbol(), t);
        }
    }

    public static int insertRule(long peer, String rule, int index) {
        try (Transfer ruleUtf8 = CString8.of(rule, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            int result;
            try {
                result = (int) INSERT_RULE.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), ruleUtf8.segment(), index);
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleSheetImplSignature.INSERT_RULE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result;
        }
    }

    public static void deleteRule(long peer, int index) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                DELETE_RULE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), index);
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleSheetImplSignature.DELETE_RULE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static int addRule(long peer, String selector, String style, int index) {
        try (Transfer selectorUtf8 = CString8.of(selector, TransferPool.SHARED);
                Transfer styleUtf8 = CString8.of(style, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            int result;
            try {
                result = (int) ADD_RULE.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), selectorUtf8.segment(), styleUtf8.segment(), index);
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleSheetImplSignature.ADD_RULE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result;
        }
    }

    public static void removeRule(long peer, int index) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                REMOVE_RULE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), index);
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleSheetImplSignature.REMOVE_RULE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
