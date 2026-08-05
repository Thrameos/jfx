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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CharacterDataImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CharacterDataImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_LENGTH = bind(CharacterDataImplSignature.GET_LENGTH);
    private static final MethodHandle GET_DATA = bind(CharacterDataImplSignature.GET_DATA);
    private static final MethodHandle SET_DATA = bind(CharacterDataImplSignature.SET_DATA);
    private static final MethodHandle APPEND_DATA = bind(CharacterDataImplSignature.APPEND_DATA);
    private static final MethodHandle GET_PREVIOUS_ELEMENT_SIBLING = bind(CharacterDataImplSignature.GET_PREVIOUS_ELEMENT_SIBLING);
    private static final MethodHandle GET_NEXT_ELEMENT_SIBLING = bind(CharacterDataImplSignature.GET_NEXT_ELEMENT_SIBLING);
    private static final MethodHandle SUBSTRING_DATA = bind(CharacterDataImplSignature.SUBSTRING_DATA);
    private static final MethodHandle INSERT_DATA = bind(CharacterDataImplSignature.INSERT_DATA);
    private static final MethodHandle DELETE_DATA = bind(CharacterDataImplSignature.DELETE_DATA);
    private static final MethodHandle REPLACE_DATA = bind(CharacterDataImplSignature.REPLACE_DATA);
    private static final MethodHandle REMOVE = bind(CharacterDataImplSignature.REMOVE);

    private CharacterDataImplBinding() {
    }

    private static MethodHandle bind(CharacterDataImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(CharacterDataImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static String getData(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            try {
                GET_DATA.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.GET_DATA.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return exchange.value();
        }
    }

    public static void setData(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_DATA.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(CharacterDataImplSignature.SET_DATA.symbol(), t);
        }
    }

    public static void appendData(long peer, String data) {
        try (Transfer utf8 = CString8.of(data, TransferPool.SHARED)) {
            APPEND_DATA.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(CharacterDataImplSignature.APPEND_DATA.symbol(), t);
        }
    }

    public static long getPreviousElementSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PREVIOUS_ELEMENT_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CharacterDataImplSignature.GET_PREVIOUS_ELEMENT_SIBLING.symbol(), t);
        }
    }

    public static long getNextElementSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_NEXT_ELEMENT_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(CharacterDataImplSignature.GET_NEXT_ELEMENT_SIBLING.symbol(), t);
        }
    }

    public static String substringData(long peer, int offset, int length) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            try {
                SUBSTRING_DATA.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), offset, length);
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.SUBSTRING_DATA.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return exchange.value();
        }
    }

    public static void insertData(long peer, int offset, String data) {
        try (Transfer dataUtf8 = CString8.of(data, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                INSERT_DATA.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), offset, dataUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.INSERT_DATA.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void deleteData(long peer, int offset, int count) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                DELETE_DATA.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), offset, count);
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.DELETE_DATA.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void replaceData(long peer, int offset, int count, String data) {
        try (Transfer dataUtf8 = CString8.of(data, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                REPLACE_DATA.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), offset, count, dataUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.REPLACE_DATA.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void remove(long peer) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                REMOVE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(CharacterDataImplSignature.REMOVE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
