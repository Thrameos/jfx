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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLImageElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLImageElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_IS_MAP = bind(HTMLImageElementImplSignature.GET_IS_MAP);
    private static final MethodHandle SET_IS_MAP = bind(HTMLImageElementImplSignature.SET_IS_MAP);
    private static final MethodHandle GET_COMPLETE = bind(HTMLImageElementImplSignature.GET_COMPLETE);
    private static final MethodHandle GET_NATURAL_HEIGHT = bind(HTMLImageElementImplSignature.GET_NATURAL_HEIGHT);
    private static final MethodHandle GET_NATURAL_WIDTH = bind(HTMLImageElementImplSignature.GET_NATURAL_WIDTH);
    private static final MethodHandle GET_X = bind(HTMLImageElementImplSignature.GET_X);
    private static final MethodHandle GET_Y = bind(HTMLImageElementImplSignature.GET_Y);
    private static final MethodHandle SET_NAME = bind(HTMLImageElementImplSignature.SET_NAME);
    private static final MethodHandle SET_ALIGN = bind(HTMLImageElementImplSignature.SET_ALIGN);
    private static final MethodHandle SET_ALT = bind(HTMLImageElementImplSignature.SET_ALT);
    private static final MethodHandle SET_BORDER = bind(HTMLImageElementImplSignature.SET_BORDER);
    private static final MethodHandle SET_LONG_DESC = bind(HTMLImageElementImplSignature.SET_LONG_DESC);
    private static final MethodHandle SET_SRC = bind(HTMLImageElementImplSignature.SET_SRC);
    private static final MethodHandle SET_SRCSET = bind(HTMLImageElementImplSignature.SET_SRCSET);
    private static final MethodHandle SET_SIZES = bind(HTMLImageElementImplSignature.SET_SIZES);
    private static final MethodHandle SET_USE_MAP = bind(HTMLImageElementImplSignature.SET_USE_MAP);
    private static final MethodHandle SET_LOWSRC = bind(HTMLImageElementImplSignature.SET_LOWSRC);

    private HTMLImageElementImplBinding() {
    }

    private static MethodHandle bind(HTMLImageElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static boolean getIsMap(long peer) {
        try {
            return (boolean) GET_IS_MAP.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_IS_MAP.symbol(), t);
        }
    }

    public static void setIsMap(long peer, boolean value) {
        try {
            SET_IS_MAP.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.SET_IS_MAP.symbol(), t);
        }
    }

    public static boolean getComplete(long peer) {
        try {
            return (boolean) GET_COMPLETE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_COMPLETE.symbol(), t);
        }
    }

    public static int getNaturalHeight(long peer) {
        try {
            return (int) GET_NATURAL_HEIGHT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_NATURAL_HEIGHT.symbol(), t);
        }
    }

    public static int getNaturalWidth(long peer) {
        try {
            return (int) GET_NATURAL_WIDTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_NATURAL_WIDTH.symbol(), t);
        }
    }

    public static int getX(long peer) {
        try {
            return (int) GET_X.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_X.symbol(), t);
        }
    }

    public static int getY(long peer) {
        try {
            return (int) GET_Y.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLImageElementImplSignature.GET_Y.symbol(), t);
        }
    }

    public static void setName(long peer, String value) {
        invokeSetter(SET_NAME, HTMLImageElementImplSignature.SET_NAME.symbol(), peer, value);
    }

    public static void setAlign(long peer, String value) {
        invokeSetter(SET_ALIGN, HTMLImageElementImplSignature.SET_ALIGN.symbol(), peer, value);
    }

    public static void setAlt(long peer, String value) {
        invokeSetter(SET_ALT, HTMLImageElementImplSignature.SET_ALT.symbol(), peer, value);
    }

    public static void setBorder(long peer, String value) {
        invokeSetter(SET_BORDER, HTMLImageElementImplSignature.SET_BORDER.symbol(), peer, value);
    }

    public static void setLongDesc(long peer, String value) {
        invokeSetter(SET_LONG_DESC, HTMLImageElementImplSignature.SET_LONG_DESC.symbol(), peer, value);
    }

    public static void setSrc(long peer, String value) {
        invokeSetter(SET_SRC, HTMLImageElementImplSignature.SET_SRC.symbol(), peer, value);
    }

    public static void setSrcset(long peer, String value) {
        invokeSetter(SET_SRCSET, HTMLImageElementImplSignature.SET_SRCSET.symbol(), peer, value);
    }

    public static void setSizes(long peer, String value) {
        invokeSetter(SET_SIZES, HTMLImageElementImplSignature.SET_SIZES.symbol(), peer, value);
    }

    public static void setUseMap(long peer, String value) {
        invokeSetter(SET_USE_MAP, HTMLImageElementImplSignature.SET_USE_MAP.symbol(), peer, value);
    }

    public static void setLowsrc(long peer, String value) {
        invokeSetter(SET_LOWSRC, HTMLImageElementImplSignature.SET_LOWSRC.symbol(), peer, value);
    }
}
