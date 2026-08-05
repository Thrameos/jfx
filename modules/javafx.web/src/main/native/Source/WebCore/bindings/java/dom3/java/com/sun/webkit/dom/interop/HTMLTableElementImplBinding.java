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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLTableElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLTableElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_CAPTION = bind(HTMLTableElementImplSignature.GET_CAPTION);
    private static final MethodHandle GET_THEAD = bind(HTMLTableElementImplSignature.GET_THEAD);
    private static final MethodHandle GET_TFOOT = bind(HTMLTableElementImplSignature.GET_TFOOT);
    private static final MethodHandle CREATE_THEAD = bind(HTMLTableElementImplSignature.CREATE_THEAD);
    private static final MethodHandle CREATE_TFOOT = bind(HTMLTableElementImplSignature.CREATE_TFOOT);
    private static final MethodHandle CREATE_TBODY = bind(HTMLTableElementImplSignature.CREATE_TBODY);
    private static final MethodHandle CREATE_CAPTION = bind(HTMLTableElementImplSignature.CREATE_CAPTION);
    private static final MethodHandle SET_ALIGN = bind(HTMLTableElementImplSignature.SET_ALIGN);
    private static final MethodHandle SET_BGCOLOR = bind(HTMLTableElementImplSignature.SET_BGCOLOR);
    private static final MethodHandle SET_BORDER = bind(HTMLTableElementImplSignature.SET_BORDER);
    private static final MethodHandle SET_CELLPADDING = bind(HTMLTableElementImplSignature.SET_CELLPADDING);
    private static final MethodHandle SET_CELLSPACING = bind(HTMLTableElementImplSignature.SET_CELLSPACING);
    private static final MethodHandle SET_FRAME = bind(HTMLTableElementImplSignature.SET_FRAME);
    private static final MethodHandle SET_RULES = bind(HTMLTableElementImplSignature.SET_RULES);
    private static final MethodHandle SET_SUMMARY = bind(HTMLTableElementImplSignature.SET_SUMMARY);
    private static final MethodHandle SET_WIDTH = bind(HTMLTableElementImplSignature.SET_WIDTH);

    private HTMLTableElementImplBinding() {
    }

    private static MethodHandle bind(HTMLTableElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static long invokeObjectReturn(MethodHandle handle, String symbol, long peer) {
        try {
            MemorySegment result = (MemorySegment) handle.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static long getCaption(long peer) {
        return invokeObjectReturn(GET_CAPTION, HTMLTableElementImplSignature.GET_CAPTION.symbol(), peer);
    }

    public static long getTHead(long peer) {
        return invokeObjectReturn(GET_THEAD, HTMLTableElementImplSignature.GET_THEAD.symbol(), peer);
    }

    public static long getTFoot(long peer) {
        return invokeObjectReturn(GET_TFOOT, HTMLTableElementImplSignature.GET_TFOOT.symbol(), peer);
    }

    public static long createTHead(long peer) {
        return invokeObjectReturn(CREATE_THEAD, HTMLTableElementImplSignature.CREATE_THEAD.symbol(), peer);
    }

    public static long createTFoot(long peer) {
        return invokeObjectReturn(CREATE_TFOOT, HTMLTableElementImplSignature.CREATE_TFOOT.symbol(), peer);
    }

    public static long createTBody(long peer) {
        return invokeObjectReturn(CREATE_TBODY, HTMLTableElementImplSignature.CREATE_TBODY.symbol(), peer);
    }

    public static long createCaption(long peer) {
        return invokeObjectReturn(CREATE_CAPTION, HTMLTableElementImplSignature.CREATE_CAPTION.symbol(), peer);
    }

    public static void setAlign(long peer, String value) {
        invokeSetter(SET_ALIGN, HTMLTableElementImplSignature.SET_ALIGN.symbol(), peer, value);
    }

    public static void setBgColor(long peer, String value) {
        invokeSetter(SET_BGCOLOR, HTMLTableElementImplSignature.SET_BGCOLOR.symbol(), peer, value);
    }

    public static void setBorder(long peer, String value) {
        invokeSetter(SET_BORDER, HTMLTableElementImplSignature.SET_BORDER.symbol(), peer, value);
    }

    public static void setCellPadding(long peer, String value) {
        invokeSetter(SET_CELLPADDING, HTMLTableElementImplSignature.SET_CELLPADDING.symbol(), peer, value);
    }

    public static void setCellSpacing(long peer, String value) {
        invokeSetter(SET_CELLSPACING, HTMLTableElementImplSignature.SET_CELLSPACING.symbol(), peer, value);
    }

    public static void setFrame(long peer, String value) {
        invokeSetter(SET_FRAME, HTMLTableElementImplSignature.SET_FRAME.symbol(), peer, value);
    }

    public static void setRules(long peer, String value) {
        invokeSetter(SET_RULES, HTMLTableElementImplSignature.SET_RULES.symbol(), peer, value);
    }

    public static void setSummary(long peer, String value) {
        invokeSetter(SET_SUMMARY, HTMLTableElementImplSignature.SET_SUMMARY.symbol(), peer, value);
    }

    public static void setWidth(long peer, String value) {
        invokeSetter(SET_WIDTH, HTMLTableElementImplSignature.SET_WIDTH.symbol(), peer, value);
    }
}
