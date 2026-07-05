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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CSSMediaRuleImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CSSMediaRuleImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_MEDIA = bind(CSSMediaRuleImplSignature.GET_MEDIA);
    private static final MethodHandle GET_CSS_RULES = bind(CSSMediaRuleImplSignature.GET_CSS_RULES);
    private static final MethodHandle INSERT_RULE = bind(CSSMediaRuleImplSignature.INSERT_RULE);
    private static final MethodHandle DELETE_RULE = bind(CSSMediaRuleImplSignature.DELETE_RULE);

    private CSSMediaRuleImplBinding() {
    }

    private static MethodHandle bind(CSSMediaRuleImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static long getMedia(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_MEDIA.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSMediaRuleImplSignature.GET_MEDIA.symbol(), t);
        }
    }

    public static long getCssRules(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_CSS_RULES.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSMediaRuleImplSignature.GET_CSS_RULES.symbol(), t);
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
                throw Downcall.failed(CSSMediaRuleImplSignature.INSERT_RULE.symbol(), t);
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
                throw Downcall.failed(CSSMediaRuleImplSignature.DELETE_RULE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
