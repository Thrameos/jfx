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
 * Real {@link Binder}-bound {@link MethodHandle}s for
 * {@link CSSStyleDeclarationImplSignature}'s entries -- DISPOSE is
 * deliberately not bound here, same rationale as {@link CSSRuleImplBinding}.
 */
public final class CSSStyleDeclarationImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_CSS_TEXT = bind(CSSStyleDeclarationImplSignature.GET_CSS_TEXT);
    private static final MethodHandle SET_CSS_TEXT = bind(CSSStyleDeclarationImplSignature.SET_CSS_TEXT);
    private static final MethodHandle GET_LENGTH = bind(CSSStyleDeclarationImplSignature.GET_LENGTH);
    private static final MethodHandle GET_PARENT_RULE = bind(CSSStyleDeclarationImplSignature.GET_PARENT_RULE);
    private static final MethodHandle GET_PROPERTY_VALUE = bind(CSSStyleDeclarationImplSignature.GET_PROPERTY_VALUE);
    private static final MethodHandle GET_PROPERTY_CSS_VALUE = bind(CSSStyleDeclarationImplSignature.GET_PROPERTY_CSS_VALUE);
    private static final MethodHandle REMOVE_PROPERTY = bind(CSSStyleDeclarationImplSignature.REMOVE_PROPERTY);
    private static final MethodHandle GET_PROPERTY_PRIORITY = bind(CSSStyleDeclarationImplSignature.GET_PROPERTY_PRIORITY);
    private static final MethodHandle SET_PROPERTY = bind(CSSStyleDeclarationImplSignature.SET_PROPERTY);
    private static final MethodHandle ITEM = bind(CSSStyleDeclarationImplSignature.ITEM);
    private static final MethodHandle GET_PROPERTY_SHORTHAND = bind(CSSStyleDeclarationImplSignature.GET_PROPERTY_SHORTHAND);
    private static final MethodHandle IS_PROPERTY_IMPLICIT = bind(CSSStyleDeclarationImplSignature.IS_PROPERTY_IMPLICIT);

    private CSSStyleDeclarationImplBinding() {
    }

    private static MethodHandle bind(CSSStyleDeclarationImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static String getCssText(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_CSS_TEXT.symbol(), t);
        }
    }

    public static void setCssText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_CSS_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleDeclarationImplSignature.SET_CSS_TEXT.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static long getParentRule(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PARENT_RULE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_PARENT_RULE.symbol(), t);
        }
    }

    public static String getPropertyValue(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PROPERTY_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), nameUtf8.segment());
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_PROPERTY_VALUE.symbol(), t);
        }
    }

    public static long getPropertyCSSValue(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED)) {
            MemorySegment result = (MemorySegment) GET_PROPERTY_CSS_VALUE.invokeExact(
                    MemorySegment.ofAddress(peer), nameUtf8.segment());
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_PROPERTY_CSS_VALUE.symbol(), t);
        }
    }

    public static String removeProperty(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            try {
                REMOVE_PROPERTY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), nameUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleDeclarationImplSignature.REMOVE_PROPERTY.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return exchange.value();
        }
    }

    public static String getPropertyPriority(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PROPERTY_PRIORITY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), nameUtf8.segment());
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_PROPERTY_PRIORITY.symbol(), t);
        }
    }

    public static void setProperty(long peer, String propertyName, String value, String priority) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED);
                Transfer valueUtf8 = CString8.of(value, TransferPool.SHARED);
                Transfer priorityUtf8 = CString8.of(priority, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_PROPERTY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        nameUtf8.segment(), valueUtf8.segment(), priorityUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSStyleDeclarationImplSignature.SET_PROPERTY.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static String item(long peer, int index) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            ITEM.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), index);
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.ITEM.symbol(), t);
        }
    }

    public static String getPropertyShorthand(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PROPERTY_SHORTHAND.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), nameUtf8.segment());
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.GET_PROPERTY_SHORTHAND.symbol(), t);
        }
    }

    public static boolean isPropertyImplicit(long peer, String propertyName) {
        try (Transfer nameUtf8 = CString8.of(propertyName, TransferPool.SHARED)) {
            return (boolean) IS_PROPERTY_IMPLICIT.invokeExact(MemorySegment.ofAddress(peer), nameUtf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(CSSStyleDeclarationImplSignature.IS_PROPERTY_IMPLICIT.symbol(), t);
        }
    }
}
