package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CharacterDataImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class CharacterDataImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_LENGTH = bind(CharacterDataImplSignature.GET_LENGTH);
    private static final MethodHandle SET_DATA = bind(CharacterDataImplSignature.SET_DATA);
    private static final MethodHandle APPEND_DATA = bind(CharacterDataImplSignature.APPEND_DATA);
    private static final MethodHandle GET_PREVIOUS_ELEMENT_SIBLING = bind(CharacterDataImplSignature.GET_PREVIOUS_ELEMENT_SIBLING);
    private static final MethodHandle GET_NEXT_ELEMENT_SIBLING = bind(CharacterDataImplSignature.GET_NEXT_ELEMENT_SIBLING);

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
}
