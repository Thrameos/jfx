package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.ByteExchange;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;
import org.w3c.dom.DOMException;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link ElementImplSignature}'s
 * entries -- separate from that pure-metadata enum specifically so the {@code .hj}
 * generator (which only requires {@code Kind}/{@code Signature} to be free of any
 * dependency on the native side) can read the signatures without ever touching this
 * class. Nothing else constrains this class: it may depend on native/library-loading
 * machinery as freely as it needs to, and a plain eager static field is enough --
 * no lazy-holder indirection required, since the generator never references it.
 *
 * <p>Every accessor calls {@code invokeExact} directly (fastest path -- see
 * {@link Downcall}'s class doc for why this replaced a generic {@code invoke}
 * wrapper) rather than going through any shared dispatch method.
 */
public final class ElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_CHILD_ELEMENT_COUNT = bind(ElementImplSignature.GET_CHILD_ELEMENT_COUNT);

    private static final MethodHandle GET_FIRST_ELEMENT_CHILD = bind(ElementImplSignature.GET_FIRST_ELEMENT_CHILD);
    private static final MethodHandle GET_PREVIOUS_ELEMENT_SIBLING = bind(ElementImplSignature.GET_PREVIOUS_ELEMENT_SIBLING);
    private static final MethodHandle GET_NEXT_ELEMENT_SIBLING = bind(ElementImplSignature.GET_NEXT_ELEMENT_SIBLING);
    private static final MethodHandle GET_LAST_ELEMENT_CHILD = bind(ElementImplSignature.GET_LAST_ELEMENT_CHILD);

    private static final MethodHandle GET_OFFSET_LEFT = bind(ElementImplSignature.GET_OFFSET_LEFT);
    private static final MethodHandle GET_OFFSET_TOP = bind(ElementImplSignature.GET_OFFSET_TOP);
    private static final MethodHandle GET_OFFSET_WIDTH = bind(ElementImplSignature.GET_OFFSET_WIDTH);
    private static final MethodHandle GET_OFFSET_HEIGHT = bind(ElementImplSignature.GET_OFFSET_HEIGHT);
    private static final MethodHandle GET_CLIENT_LEFT = bind(ElementImplSignature.GET_CLIENT_LEFT);
    private static final MethodHandle GET_CLIENT_TOP = bind(ElementImplSignature.GET_CLIENT_TOP);
    private static final MethodHandle GET_CLIENT_WIDTH = bind(ElementImplSignature.GET_CLIENT_WIDTH);
    private static final MethodHandle GET_CLIENT_HEIGHT = bind(ElementImplSignature.GET_CLIENT_HEIGHT);

    private static final MethodHandle GET_SCROLL_LEFT = bind(ElementImplSignature.GET_SCROLL_LEFT);
    private static final MethodHandle SET_SCROLL_LEFT = bind(ElementImplSignature.SET_SCROLL_LEFT);
    private static final MethodHandle GET_SCROLL_TOP = bind(ElementImplSignature.GET_SCROLL_TOP);
    private static final MethodHandle SET_SCROLL_TOP = bind(ElementImplSignature.SET_SCROLL_TOP);
    private static final MethodHandle GET_SCROLL_WIDTH = bind(ElementImplSignature.GET_SCROLL_WIDTH);
    private static final MethodHandle GET_SCROLL_HEIGHT = bind(ElementImplSignature.GET_SCROLL_HEIGHT);

    private static final MethodHandle HAS_ATTRIBUTES = bind(ElementImplSignature.HAS_ATTRIBUTES);
    private static final MethodHandle HAS_ATTRIBUTE = bind(ElementImplSignature.HAS_ATTRIBUTE);
    private static final MethodHandle REMOVE_ATTRIBUTE = bind(ElementImplSignature.REMOVE_ATTRIBUTE);

    private static final MethodHandle SET_ID = bind(ElementImplSignature.SET_ID);
    private static final MethodHandle SET_CLASS_NAME = bind(ElementImplSignature.SET_CLASS_NAME);
    private static final MethodHandle SET_INNER_HTML = bind(ElementImplSignature.SET_INNER_HTML);
    private static final MethodHandle SET_OUTER_HTML = bind(ElementImplSignature.SET_OUTER_HTML);

    private static final MethodHandle GET_TAG_NAME = bind(ElementImplSignature.GET_TAG_NAME);
    private static final MethodHandle GET_ID = bind(ElementImplSignature.GET_ID);

    private static final MethodHandle SET_ATTRIBUTE = bind(ElementImplSignature.SET_ATTRIBUTE);

    private ElementImplBinding() {
    }

    private static MethodHandle bind(ElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static int getChildElementCount(long peer) {
        try {
            return (int) GET_CHILD_ELEMENT_COUNT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_CHILD_ELEMENT_COUNT.symbol(), t);
        }
    }

    public static long getFirstElementChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FIRST_ELEMENT_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_FIRST_ELEMENT_CHILD.symbol(), t);
        }
    }

    public static long getPreviousElementSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PREVIOUS_ELEMENT_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_PREVIOUS_ELEMENT_SIBLING.symbol(), t);
        }
    }

    public static long getNextElementSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_NEXT_ELEMENT_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_NEXT_ELEMENT_SIBLING.symbol(), t);
        }
    }

    public static long getLastElementChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_LAST_ELEMENT_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_LAST_ELEMENT_CHILD.symbol(), t);
        }
    }

    public static double getOffsetLeft(long peer) {
        try {
            return (double) GET_OFFSET_LEFT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_OFFSET_LEFT.symbol(), t);
        }
    }

    public static double getOffsetTop(long peer) {
        try {
            return (double) GET_OFFSET_TOP.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_OFFSET_TOP.symbol(), t);
        }
    }

    public static double getOffsetWidth(long peer) {
        try {
            return (double) GET_OFFSET_WIDTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_OFFSET_WIDTH.symbol(), t);
        }
    }

    public static double getOffsetHeight(long peer) {
        try {
            return (double) GET_OFFSET_HEIGHT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_OFFSET_HEIGHT.symbol(), t);
        }
    }

    public static double getClientLeft(long peer) {
        try {
            return (double) GET_CLIENT_LEFT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_CLIENT_LEFT.symbol(), t);
        }
    }

    public static double getClientTop(long peer) {
        try {
            return (double) GET_CLIENT_TOP.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_CLIENT_TOP.symbol(), t);
        }
    }

    public static double getClientWidth(long peer) {
        try {
            return (double) GET_CLIENT_WIDTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_CLIENT_WIDTH.symbol(), t);
        }
    }

    public static double getClientHeight(long peer) {
        try {
            return (double) GET_CLIENT_HEIGHT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_CLIENT_HEIGHT.symbol(), t);
        }
    }

    public static int getScrollLeft(long peer) {
        try {
            return (int) GET_SCROLL_LEFT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_SCROLL_LEFT.symbol(), t);
        }
    }

    public static void setScrollLeft(long peer, int value) {
        try {
            SET_SCROLL_LEFT.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_SCROLL_LEFT.symbol(), t);
        }
    }

    public static int getScrollTop(long peer) {
        try {
            return (int) GET_SCROLL_TOP.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_SCROLL_TOP.symbol(), t);
        }
    }

    public static void setScrollTop(long peer, int value) {
        try {
            SET_SCROLL_TOP.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_SCROLL_TOP.symbol(), t);
        }
    }

    public static int getScrollWidth(long peer) {
        try {
            return (int) GET_SCROLL_WIDTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_SCROLL_WIDTH.symbol(), t);
        }
    }

    public static int getScrollHeight(long peer) {
        try {
            return (int) GET_SCROLL_HEIGHT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_SCROLL_HEIGHT.symbol(), t);
        }
    }

    public static boolean hasAttributes(long peer) {
        try {
            return (boolean) HAS_ATTRIBUTES.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.HAS_ATTRIBUTES.symbol(), t);
        }
    }

    public static boolean hasAttribute(long peer, String name) {
        try (Transfer utf8 = CString8.of(name, TransferPool.SHARED)) {
            return (boolean) HAS_ATTRIBUTE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.HAS_ATTRIBUTE.symbol(), t);
        }
    }

    public static void removeAttribute(long peer, String name) {
        try (Transfer utf8 = CString8.of(name, TransferPool.SHARED)) {
            REMOVE_ATTRIBUTE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.REMOVE_ATTRIBUTE.symbol(), t);
        }
    }

    public static void setId(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ID.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_ID.symbol(), t);
        }
    }

    public static void setClassName(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_CLASS_NAME.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_CLASS_NAME.symbol(), t);
        }
    }

    public static void setInnerHTML(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_INNER_HTML.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_INNER_HTML.symbol(), t);
        }
    }

    public static void setOuterHTML(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_OUTER_HTML.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.SET_OUTER_HTML.symbol(), t);
        }
    }

    public static String getTagName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_TAG_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_TAG_NAME.symbol(), t);
        }
    }

    public static String getId(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ID.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(ElementImplSignature.GET_ID.symbol(), t);
        }
    }

    // DOMException construction stays here, on the DOM-specific side of the
    // boundary -- ByteExchange only ever hands back a generic (int code,
    // String message) pair, never anything org.w3c.dom-shaped.
    public static void setAttribute(long peer, String name, String value) {
        try (Transfer nameUtf8 = CString8.of(name, TransferPool.SHARED);
                Transfer valueUtf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_ATTRIBUTE.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), nameUtf8.segment(), valueUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(ElementImplSignature.SET_ATTRIBUTE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
