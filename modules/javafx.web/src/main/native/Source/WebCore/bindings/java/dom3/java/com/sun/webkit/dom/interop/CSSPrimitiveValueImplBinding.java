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

public final class CSSPrimitiveValueImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_PRIMITIVE_TYPE = bind(CSSPrimitiveValueImplSignature.GET_PRIMITIVE_TYPE);
    private static final MethodHandle SET_FLOAT_VALUE = bind(CSSPrimitiveValueImplSignature.SET_FLOAT_VALUE);
    private static final MethodHandle GET_FLOAT_VALUE = bind(CSSPrimitiveValueImplSignature.GET_FLOAT_VALUE);
    private static final MethodHandle SET_STRING_VALUE = bind(CSSPrimitiveValueImplSignature.SET_STRING_VALUE);
    private static final MethodHandle GET_STRING_VALUE = bind(CSSPrimitiveValueImplSignature.GET_STRING_VALUE);
    private static final MethodHandle GET_COUNTER_VALUE = bind(CSSPrimitiveValueImplSignature.GET_COUNTER_VALUE);
    private static final MethodHandle GET_RECT_VALUE = bind(CSSPrimitiveValueImplSignature.GET_RECT_VALUE);
    private static final MethodHandle GET_RGB_COLOR_VALUE = bind(CSSPrimitiveValueImplSignature.GET_RGB_COLOR_VALUE);

    private CSSPrimitiveValueImplBinding() {
    }

    private static MethodHandle bind(CSSPrimitiveValueImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static short getPrimitiveType(long peer) {
        try {
            return (short) GET_PRIMITIVE_TYPE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_PRIMITIVE_TYPE.symbol(), t);
        }
    }

    public static void setFloatValue(long peer, short unitType, float floatValue) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                SET_FLOAT_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), unitType, floatValue);
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.SET_FLOAT_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static float getFloatValue(long peer, short unitType) {
        try (ByteExchange exchange = new ByteExchange()) {
            float result;
            try {
                result = (float) GET_FLOAT_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), unitType);
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_FLOAT_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result;
        }
    }

    public static void setStringValue(long peer, short stringType, String stringValue) {
        try (Transfer utf8 = CString8.of(stringValue, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_STRING_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), stringType, utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.SET_STRING_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static String getStringValue(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            try {
                GET_STRING_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_STRING_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return exchange.value();
        }
    }

    public static long getCounterValue(long peer) {
        try (ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) GET_COUNTER_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_COUNTER_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }

    public static long getRectValue(long peer) {
        try (ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) GET_RECT_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_RECT_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }

    public static long getRGBColorValue(long peer) {
        try (ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) GET_RGB_COLOR_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CSSPrimitiveValueImplSignature.GET_RGB_COLOR_VALUE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }
}
