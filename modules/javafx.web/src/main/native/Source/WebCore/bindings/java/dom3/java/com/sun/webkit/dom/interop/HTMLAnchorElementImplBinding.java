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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLAnchorElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLAnchorElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle SET_CHARSET = bind(HTMLAnchorElementImplSignature.SET_CHARSET);
    private static final MethodHandle SET_COORDS = bind(HTMLAnchorElementImplSignature.SET_COORDS);
    private static final MethodHandle SET_HREFLANG = bind(HTMLAnchorElementImplSignature.SET_HREFLANG);
    private static final MethodHandle SET_NAME = bind(HTMLAnchorElementImplSignature.SET_NAME);
    private static final MethodHandle SET_PING = bind(HTMLAnchorElementImplSignature.SET_PING);
    private static final MethodHandle SET_REL = bind(HTMLAnchorElementImplSignature.SET_REL);
    private static final MethodHandle SET_REV = bind(HTMLAnchorElementImplSignature.SET_REV);
    private static final MethodHandle SET_SHAPE = bind(HTMLAnchorElementImplSignature.SET_SHAPE);
    private static final MethodHandle SET_TARGET = bind(HTMLAnchorElementImplSignature.SET_TARGET);
    private static final MethodHandle SET_TYPE = bind(HTMLAnchorElementImplSignature.SET_TYPE);
    private static final MethodHandle SET_TEXT = bind(HTMLAnchorElementImplSignature.SET_TEXT);
    private static final MethodHandle SET_HREF = bind(HTMLAnchorElementImplSignature.SET_HREF);
    private static final MethodHandle SET_PROTOCOL = bind(HTMLAnchorElementImplSignature.SET_PROTOCOL);
    private static final MethodHandle SET_USERNAME = bind(HTMLAnchorElementImplSignature.SET_USERNAME);
    private static final MethodHandle SET_PASSWORD = bind(HTMLAnchorElementImplSignature.SET_PASSWORD);
    private static final MethodHandle SET_HOST = bind(HTMLAnchorElementImplSignature.SET_HOST);
    private static final MethodHandle SET_HOSTNAME = bind(HTMLAnchorElementImplSignature.SET_HOSTNAME);
    private static final MethodHandle SET_PORT = bind(HTMLAnchorElementImplSignature.SET_PORT);
    private static final MethodHandle SET_PATHNAME = bind(HTMLAnchorElementImplSignature.SET_PATHNAME);
    private static final MethodHandle SET_SEARCH = bind(HTMLAnchorElementImplSignature.SET_SEARCH);
    private static final MethodHandle SET_HASH = bind(HTMLAnchorElementImplSignature.SET_HASH);

    private HTMLAnchorElementImplBinding() {
    }

    private static MethodHandle bind(HTMLAnchorElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static void setCharset(long peer, String value) {
        invokeSetter(SET_CHARSET, HTMLAnchorElementImplSignature.SET_CHARSET.symbol(), peer, value);
    }

    public static void setCoords(long peer, String value) {
        invokeSetter(SET_COORDS, HTMLAnchorElementImplSignature.SET_COORDS.symbol(), peer, value);
    }

    public static void setHreflang(long peer, String value) {
        invokeSetter(SET_HREFLANG, HTMLAnchorElementImplSignature.SET_HREFLANG.symbol(), peer, value);
    }

    public static void setName(long peer, String value) {
        invokeSetter(SET_NAME, HTMLAnchorElementImplSignature.SET_NAME.symbol(), peer, value);
    }

    public static void setPing(long peer, String value) {
        invokeSetter(SET_PING, HTMLAnchorElementImplSignature.SET_PING.symbol(), peer, value);
    }

    public static void setRel(long peer, String value) {
        invokeSetter(SET_REL, HTMLAnchorElementImplSignature.SET_REL.symbol(), peer, value);
    }

    public static void setRev(long peer, String value) {
        invokeSetter(SET_REV, HTMLAnchorElementImplSignature.SET_REV.symbol(), peer, value);
    }

    public static void setShape(long peer, String value) {
        invokeSetter(SET_SHAPE, HTMLAnchorElementImplSignature.SET_SHAPE.symbol(), peer, value);
    }

    public static void setTarget(long peer, String value) {
        invokeSetter(SET_TARGET, HTMLAnchorElementImplSignature.SET_TARGET.symbol(), peer, value);
    }

    public static void setType(long peer, String value) {
        invokeSetter(SET_TYPE, HTMLAnchorElementImplSignature.SET_TYPE.symbol(), peer, value);
    }

    public static void setText(long peer, String value) {
        invokeSetter(SET_TEXT, HTMLAnchorElementImplSignature.SET_TEXT.symbol(), peer, value);
    }

    public static void setHref(long peer, String value) {
        invokeSetter(SET_HREF, HTMLAnchorElementImplSignature.SET_HREF.symbol(), peer, value);
    }

    public static void setProtocol(long peer, String value) {
        invokeSetter(SET_PROTOCOL, HTMLAnchorElementImplSignature.SET_PROTOCOL.symbol(), peer, value);
    }

    public static void setUsername(long peer, String value) {
        invokeSetter(SET_USERNAME, HTMLAnchorElementImplSignature.SET_USERNAME.symbol(), peer, value);
    }

    public static void setPassword(long peer, String value) {
        invokeSetter(SET_PASSWORD, HTMLAnchorElementImplSignature.SET_PASSWORD.symbol(), peer, value);
    }

    public static void setHost(long peer, String value) {
        invokeSetter(SET_HOST, HTMLAnchorElementImplSignature.SET_HOST.symbol(), peer, value);
    }

    public static void setHostname(long peer, String value) {
        invokeSetter(SET_HOSTNAME, HTMLAnchorElementImplSignature.SET_HOSTNAME.symbol(), peer, value);
    }

    public static void setPort(long peer, String value) {
        invokeSetter(SET_PORT, HTMLAnchorElementImplSignature.SET_PORT.symbol(), peer, value);
    }

    public static void setPathname(long peer, String value) {
        invokeSetter(SET_PATHNAME, HTMLAnchorElementImplSignature.SET_PATHNAME.symbol(), peer, value);
    }

    public static void setSearch(long peer, String value) {
        invokeSetter(SET_SEARCH, HTMLAnchorElementImplSignature.SET_SEARCH.symbol(), peer, value);
    }

    public static void setHash(long peer, String value) {
        invokeSetter(SET_HASH, HTMLAnchorElementImplSignature.SET_HASH.symbol(), peer, value);
    }
}
