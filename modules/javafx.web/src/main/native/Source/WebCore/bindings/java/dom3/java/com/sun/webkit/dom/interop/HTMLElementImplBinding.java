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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_TRANSLATE = bind(HTMLElementImplSignature.GET_TRANSLATE);
    private static final MethodHandle SET_TRANSLATE = bind(HTMLElementImplSignature.SET_TRANSLATE);
    private static final MethodHandle GET_DRAGGABLE = bind(HTMLElementImplSignature.GET_DRAGGABLE);
    private static final MethodHandle SET_DRAGGABLE = bind(HTMLElementImplSignature.SET_DRAGGABLE);
    private static final MethodHandle GET_HIDDEN = bind(HTMLElementImplSignature.GET_HIDDEN);
    private static final MethodHandle SET_HIDDEN = bind(HTMLElementImplSignature.SET_HIDDEN);
    private static final MethodHandle GET_IS_CONTENT_EDITABLE = bind(HTMLElementImplSignature.GET_IS_CONTENT_EDITABLE);
    private static final MethodHandle GET_SPELLCHECK = bind(HTMLElementImplSignature.GET_SPELLCHECK);
    private static final MethodHandle SET_SPELLCHECK = bind(HTMLElementImplSignature.SET_SPELLCHECK);
    private static final MethodHandle SET_ID = bind(HTMLElementImplSignature.SET_ID);
    private static final MethodHandle SET_TITLE = bind(HTMLElementImplSignature.SET_TITLE);
    private static final MethodHandle SET_LANG = bind(HTMLElementImplSignature.SET_LANG);
    private static final MethodHandle SET_WEBKITDROPZONE = bind(HTMLElementImplSignature.SET_WEBKITDROPZONE);
    private static final MethodHandle SET_ACCESS_KEY = bind(HTMLElementImplSignature.SET_ACCESS_KEY);
    private static final MethodHandle SET_INNER_TEXT = bind(HTMLElementImplSignature.SET_INNER_TEXT);
    private static final MethodHandle SET_OUTER_TEXT = bind(HTMLElementImplSignature.SET_OUTER_TEXT);
    private static final MethodHandle SET_CONTENT_EDITABLE = bind(HTMLElementImplSignature.SET_CONTENT_EDITABLE);

    private HTMLElementImplBinding() {
    }

    private static MethodHandle bind(HTMLElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static boolean getTranslate(long peer) {
        try {
            return (boolean) GET_TRANSLATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.GET_TRANSLATE.symbol(), t);
        }
    }

    public static void setTranslate(long peer, boolean value) {
        try {
            SET_TRANSLATE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_TRANSLATE.symbol(), t);
        }
    }

    public static boolean getDraggable(long peer) {
        try {
            return (boolean) GET_DRAGGABLE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.GET_DRAGGABLE.symbol(), t);
        }
    }

    public static void setDraggable(long peer, boolean value) {
        try {
            SET_DRAGGABLE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_DRAGGABLE.symbol(), t);
        }
    }

    public static boolean getHidden(long peer) {
        try {
            return (boolean) GET_HIDDEN.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.GET_HIDDEN.symbol(), t);
        }
    }

    public static void setHidden(long peer, boolean value) {
        try {
            SET_HIDDEN.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_HIDDEN.symbol(), t);
        }
    }

    public static boolean getIsContentEditable(long peer) {
        try {
            return (boolean) GET_IS_CONTENT_EDITABLE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.GET_IS_CONTENT_EDITABLE.symbol(), t);
        }
    }

    public static boolean getSpellcheck(long peer) {
        try {
            return (boolean) GET_SPELLCHECK.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.GET_SPELLCHECK.symbol(), t);
        }
    }

    public static void setSpellcheck(long peer, boolean value) {
        try {
            SET_SPELLCHECK.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_SPELLCHECK.symbol(), t);
        }
    }

    public static void setId(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ID.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_ID.symbol(), t);
        }
    }

    public static void setTitle(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_TITLE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_TITLE.symbol(), t);
        }
    }

    public static void setLang(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_LANG.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_LANG.symbol(), t);
        }
    }

    public static void setWebkitdropzone(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_WEBKITDROPZONE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_WEBKITDROPZONE.symbol(), t);
        }
    }

    public static void setAccessKey(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ACCESS_KEY.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_ACCESS_KEY.symbol(), t);
        }
    }

    public static void setInnerText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_INNER_TEXT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_INNER_TEXT.symbol(), t);
        }
    }

    public static void setOuterText(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_OUTER_TEXT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_OUTER_TEXT.symbol(), t);
        }
    }

    public static void setContentEditable(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_CONTENT_EDITABLE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLElementImplSignature.SET_CONTENT_EDITABLE.symbol(), t);
        }
    }
}
