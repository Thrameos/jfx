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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link AttrImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class AttrImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_SPECIFIED = bind(AttrImplSignature.GET_SPECIFIED);
    private static final MethodHandle IS_ID = bind(AttrImplSignature.IS_ID);
    private static final MethodHandle SET_VALUE = bind(AttrImplSignature.SET_VALUE);
    private static final MethodHandle GET_OWNER_ELEMENT = bind(AttrImplSignature.GET_OWNER_ELEMENT);

    private AttrImplBinding() {
    }

    private static MethodHandle bind(AttrImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static boolean getSpecified(long peer) {
        try {
            return (boolean) GET_SPECIFIED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(AttrImplSignature.GET_SPECIFIED.symbol(), t);
        }
    }

    public static boolean isId(long peer) {
        try {
            return (boolean) IS_ID.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(AttrImplSignature.IS_ID.symbol(), t);
        }
    }

    public static void setValue(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_VALUE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(AttrImplSignature.SET_VALUE.symbol(), t);
        }
    }

    public static long getOwnerElement(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_OWNER_ELEMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(AttrImplSignature.GET_OWNER_ELEMENT.symbol(), t);
        }
    }
}
