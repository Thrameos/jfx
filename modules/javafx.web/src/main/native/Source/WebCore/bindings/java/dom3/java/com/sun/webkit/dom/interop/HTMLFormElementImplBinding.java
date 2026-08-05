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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLFormElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLFormElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_NO_VALIDATE = bind(HTMLFormElementImplSignature.GET_NO_VALIDATE);
    private static final MethodHandle SET_NO_VALIDATE = bind(HTMLFormElementImplSignature.SET_NO_VALIDATE);
    private static final MethodHandle GET_LENGTH = bind(HTMLFormElementImplSignature.GET_LENGTH);
    private static final MethodHandle CHECK_VALIDITY = bind(HTMLFormElementImplSignature.CHECK_VALIDITY);
    private static final MethodHandle SET_ACCEPT_CHARSET = bind(HTMLFormElementImplSignature.SET_ACCEPT_CHARSET);
    private static final MethodHandle SET_ACTION = bind(HTMLFormElementImplSignature.SET_ACTION);
    private static final MethodHandle SET_NAME = bind(HTMLFormElementImplSignature.SET_NAME);
    private static final MethodHandle SET_TARGET = bind(HTMLFormElementImplSignature.SET_TARGET);

    private HTMLFormElementImplBinding() {
    }

    private static MethodHandle bind(HTMLFormElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static boolean getNoValidate(long peer) {
        try {
            return (boolean) GET_NO_VALIDATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLFormElementImplSignature.GET_NO_VALIDATE.symbol(), t);
        }
    }

    public static void setNoValidate(long peer, boolean value) {
        try {
            SET_NO_VALIDATE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLFormElementImplSignature.SET_NO_VALIDATE.symbol(), t);
        }
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLFormElementImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static boolean checkValidity(long peer) {
        try {
            return (boolean) CHECK_VALIDITY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLFormElementImplSignature.CHECK_VALIDITY.symbol(), t);
        }
    }

    public static void setAcceptCharset(long peer, String value) {
        invokeSetter(SET_ACCEPT_CHARSET, HTMLFormElementImplSignature.SET_ACCEPT_CHARSET.symbol(), peer, value);
    }

    public static void setAction(long peer, String value) {
        invokeSetter(SET_ACTION, HTMLFormElementImplSignature.SET_ACTION.symbol(), peer, value);
    }

    public static void setName(long peer, String value) {
        invokeSetter(SET_NAME, HTMLFormElementImplSignature.SET_NAME.symbol(), peer, value);
    }

    public static void setTarget(long peer, String value) {
        invokeSetter(SET_TARGET, HTMLFormElementImplSignature.SET_TARGET.symbol(), peer, value);
    }
}
