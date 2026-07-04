package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLBodyElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLBodyElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle SET_ALINK = bind(HTMLBodyElementImplSignature.SET_ALINK);
    private static final MethodHandle SET_BACKGROUND = bind(HTMLBodyElementImplSignature.SET_BACKGROUND);
    private static final MethodHandle SET_BGCOLOR = bind(HTMLBodyElementImplSignature.SET_BGCOLOR);
    private static final MethodHandle SET_LINK = bind(HTMLBodyElementImplSignature.SET_LINK);
    private static final MethodHandle SET_TEXT = bind(HTMLBodyElementImplSignature.SET_TEXT);
    private static final MethodHandle SET_VLINK = bind(HTMLBodyElementImplSignature.SET_VLINK);
    private static final MethodHandle GET_ALINK = bind(HTMLBodyElementImplSignature.GET_ALINK);
    private static final MethodHandle GET_BACKGROUND = bind(HTMLBodyElementImplSignature.GET_BACKGROUND);
    private static final MethodHandle GET_BGCOLOR = bind(HTMLBodyElementImplSignature.GET_BGCOLOR);
    private static final MethodHandle GET_LINK = bind(HTMLBodyElementImplSignature.GET_LINK);
    private static final MethodHandle GET_TEXT = bind(HTMLBodyElementImplSignature.GET_TEXT);
    private static final MethodHandle GET_VLINK = bind(HTMLBodyElementImplSignature.GET_VLINK);

    private HTMLBodyElementImplBinding() {
    }

    private static MethodHandle bind(HTMLBodyElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static void setALink(long peer, String value) {
        invokeSetter(SET_ALINK, HTMLBodyElementImplSignature.SET_ALINK.symbol(), peer, value);
    }

    public static void setBackground(long peer, String value) {
        invokeSetter(SET_BACKGROUND, HTMLBodyElementImplSignature.SET_BACKGROUND.symbol(), peer, value);
    }

    public static void setBgColor(long peer, String value) {
        invokeSetter(SET_BGCOLOR, HTMLBodyElementImplSignature.SET_BGCOLOR.symbol(), peer, value);
    }

    public static void setLink(long peer, String value) {
        invokeSetter(SET_LINK, HTMLBodyElementImplSignature.SET_LINK.symbol(), peer, value);
    }

    public static void setText(long peer, String value) {
        invokeSetter(SET_TEXT, HTMLBodyElementImplSignature.SET_TEXT.symbol(), peer, value);
    }

    public static void setVLink(long peer, String value) {
        invokeSetter(SET_VLINK, HTMLBodyElementImplSignature.SET_VLINK.symbol(), peer, value);
    }

    private static String invokeGetter(MethodHandle handle, String symbol, long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            handle.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static String getALink(long peer) {
        return invokeGetter(GET_ALINK, HTMLBodyElementImplSignature.GET_ALINK.symbol(), peer);
    }

    public static String getBackground(long peer) {
        return invokeGetter(GET_BACKGROUND, HTMLBodyElementImplSignature.GET_BACKGROUND.symbol(), peer);
    }

    public static String getBgColor(long peer) {
        return invokeGetter(GET_BGCOLOR, HTMLBodyElementImplSignature.GET_BGCOLOR.symbol(), peer);
    }

    public static String getLink(long peer) {
        return invokeGetter(GET_LINK, HTMLBodyElementImplSignature.GET_LINK.symbol(), peer);
    }

    public static String getText(long peer) {
        return invokeGetter(GET_TEXT, HTMLBodyElementImplSignature.GET_TEXT.symbol(), peer);
    }

    public static String getVLink(long peer) {
        return invokeGetter(GET_VLINK, HTMLBodyElementImplSignature.GET_VLINK.symbol(), peer);
    }
}
