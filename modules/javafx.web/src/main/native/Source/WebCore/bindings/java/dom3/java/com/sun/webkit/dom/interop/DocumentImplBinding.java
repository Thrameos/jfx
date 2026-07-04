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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link DocumentImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class DocumentImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle IS_HTML_DOCUMENT = bind(DocumentImplSignature.IS_HTML_DOCUMENT);
    private static final MethodHandle GET_XML_STANDALONE = bind(DocumentImplSignature.GET_XML_STANDALONE);
    private static final MethodHandle SET_XML_STANDALONE = bind(DocumentImplSignature.SET_XML_STANDALONE);
    private static final MethodHandle GET_HIDDEN = bind(DocumentImplSignature.GET_HIDDEN);
    private static final MethodHandle HAS_FOCUS = bind(DocumentImplSignature.HAS_FOCUS);
    private static final MethodHandle GET_CHILD_ELEMENT_COUNT = bind(DocumentImplSignature.GET_CHILD_ELEMENT_COUNT);

    private static final MethodHandle SET_DOCUMENT_URI = bind(DocumentImplSignature.SET_DOCUMENT_URI);
    private static final MethodHandle SET_TITLE = bind(DocumentImplSignature.SET_TITLE);
    private static final MethodHandle SET_SELECTED_STYLESHEET_SET = bind(DocumentImplSignature.SET_SELECTED_STYLESHEET_SET);

    private static final MethodHandle GET_INPUT_ENCODING = bind(DocumentImplSignature.GET_INPUT_ENCODING);
    private static final MethodHandle GET_XML_ENCODING = bind(DocumentImplSignature.GET_XML_ENCODING);
    private static final MethodHandle GET_XML_VERSION = bind(DocumentImplSignature.GET_XML_VERSION);
    private static final MethodHandle GET_DOCUMENT_URI = bind(DocumentImplSignature.GET_DOCUMENT_URI);
    private static final MethodHandle GET_CONTENT_TYPE = bind(DocumentImplSignature.GET_CONTENT_TYPE);
    private static final MethodHandle GET_TITLE = bind(DocumentImplSignature.GET_TITLE);
    private static final MethodHandle GET_REFERRER = bind(DocumentImplSignature.GET_REFERRER);
    private static final MethodHandle GET_DOMAIN = bind(DocumentImplSignature.GET_DOMAIN);
    private static final MethodHandle GET_URL = bind(DocumentImplSignature.GET_URL);
    private static final MethodHandle GET_LAST_MODIFIED = bind(DocumentImplSignature.GET_LAST_MODIFIED);
    private static final MethodHandle GET_CHARSET = bind(DocumentImplSignature.GET_CHARSET);
    private static final MethodHandle GET_DEFAULT_CHARSET = bind(DocumentImplSignature.GET_DEFAULT_CHARSET);
    private static final MethodHandle GET_READY_STATE = bind(DocumentImplSignature.GET_READY_STATE);
    private static final MethodHandle GET_CHARACTER_SET = bind(DocumentImplSignature.GET_CHARACTER_SET);
    private static final MethodHandle GET_PREFERRED_STYLESHEET_SET = bind(DocumentImplSignature.GET_PREFERRED_STYLESHEET_SET);
    private static final MethodHandle GET_SELECTED_STYLESHEET_SET = bind(DocumentImplSignature.GET_SELECTED_STYLESHEET_SET);
    private static final MethodHandle GET_COMPAT_MODE = bind(DocumentImplSignature.GET_COMPAT_MODE);
    private static final MethodHandle GET_VISIBILITY_STATE = bind(DocumentImplSignature.GET_VISIBILITY_STATE);
    private static final MethodHandle GET_ORIGIN = bind(DocumentImplSignature.GET_ORIGIN);

    private static final MethodHandle GET_DOCUMENT_ELEMENT = bind(DocumentImplSignature.GET_DOCUMENT_ELEMENT);
    private static final MethodHandle GET_BODY = bind(DocumentImplSignature.GET_BODY);
    private static final MethodHandle GET_HEAD = bind(DocumentImplSignature.GET_HEAD);
    private static final MethodHandle GET_ACTIVE_ELEMENT = bind(DocumentImplSignature.GET_ACTIVE_ELEMENT);
    private static final MethodHandle GET_SCROLLING_ELEMENT = bind(DocumentImplSignature.GET_SCROLLING_ELEMENT);
    private static final MethodHandle GET_FIRST_ELEMENT_CHILD = bind(DocumentImplSignature.GET_FIRST_ELEMENT_CHILD);
    private static final MethodHandle GET_LAST_ELEMENT_CHILD = bind(DocumentImplSignature.GET_LAST_ELEMENT_CHILD);

    private static final MethodHandle GET_COOKIE = bind(DocumentImplSignature.GET_COOKIE);

    private static final MethodHandle SET_COOKIE = bind(DocumentImplSignature.SET_COOKIE);
    private static final MethodHandle SET_XML_VERSION = bind(DocumentImplSignature.SET_XML_VERSION);

    private static final MethodHandle SET_BODY = bind(DocumentImplSignature.SET_BODY);

    private DocumentImplBinding() {
    }

    private static MethodHandle bind(DocumentImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static boolean isHTMLDocument(long peer) {
        try {
            return (boolean) IS_HTML_DOCUMENT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.IS_HTML_DOCUMENT.symbol(), t);
        }
    }

    public static boolean getXmlStandalone(long peer) {
        try {
            return (boolean) GET_XML_STANDALONE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_XML_STANDALONE.symbol(), t);
        }
    }

    public static void setXmlStandalone(long peer, boolean value) {
        try {
            SET_XML_STANDALONE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.SET_XML_STANDALONE.symbol(), t);
        }
    }

    public static boolean getHidden(long peer) {
        try {
            return (boolean) GET_HIDDEN.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_HIDDEN.symbol(), t);
        }
    }

    public static boolean hasFocus(long peer) {
        try {
            return (boolean) HAS_FOCUS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.HAS_FOCUS.symbol(), t);
        }
    }

    public static int getChildElementCount(long peer) {
        try {
            return (int) GET_CHILD_ELEMENT_COUNT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_CHILD_ELEMENT_COUNT.symbol(), t);
        }
    }

    public static void setDocumentURI(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_DOCUMENT_URI.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.SET_DOCUMENT_URI.symbol(), t);
        }
    }

    public static void setTitle(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_TITLE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.SET_TITLE.symbol(), t);
        }
    }

    public static void setSelectedStylesheetSet(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_SELECTED_STYLESHEET_SET.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.SET_SELECTED_STYLESHEET_SET.symbol(), t);
        }
    }

    public static String getInputEncoding(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_INPUT_ENCODING.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_INPUT_ENCODING.symbol(), t);
        }
    }

    public static String getXmlEncoding(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_XML_ENCODING.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_XML_ENCODING.symbol(), t);
        }
    }

    public static String getXmlVersion(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_XML_VERSION.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_XML_VERSION.symbol(), t);
        }
    }

    public static String getDocumentURI(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DOCUMENT_URI.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_DOCUMENT_URI.symbol(), t);
        }
    }

    public static String getContentType(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CONTENT_TYPE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_CONTENT_TYPE.symbol(), t);
        }
    }

    public static String getTitle(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_TITLE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_TITLE.symbol(), t);
        }
    }

    public static String getReferrer(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_REFERRER.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_REFERRER.symbol(), t);
        }
    }

    public static String getDomain(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DOMAIN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_DOMAIN.symbol(), t);
        }
    }

    public static String getURL(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_URL.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_URL.symbol(), t);
        }
    }

    public static String getLastModified(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_LAST_MODIFIED.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_LAST_MODIFIED.symbol(), t);
        }
    }

    public static String getCharset(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CHARSET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_CHARSET.symbol(), t);
        }
    }

    public static String getDefaultCharset(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DEFAULT_CHARSET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_DEFAULT_CHARSET.symbol(), t);
        }
    }

    public static String getReadyState(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_READY_STATE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_READY_STATE.symbol(), t);
        }
    }

    public static String getCharacterSet(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_CHARACTER_SET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_CHARACTER_SET.symbol(), t);
        }
    }

    public static String getPreferredStylesheetSet(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PREFERRED_STYLESHEET_SET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_PREFERRED_STYLESHEET_SET.symbol(), t);
        }
    }

    public static String getSelectedStylesheetSet(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SELECTED_STYLESHEET_SET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_SELECTED_STYLESHEET_SET.symbol(), t);
        }
    }

    public static String getCompatMode(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_COMPAT_MODE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_COMPAT_MODE.symbol(), t);
        }
    }

    public static String getVisibilityState(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_VISIBILITY_STATE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_VISIBILITY_STATE.symbol(), t);
        }
    }

    public static String getOrigin(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ORIGIN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_ORIGIN.symbol(), t);
        }
    }

    public static long getDocumentElement(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_DOCUMENT_ELEMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_DOCUMENT_ELEMENT.symbol(), t);
        }
    }

    public static long getBody(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_BODY.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_BODY.symbol(), t);
        }
    }

    public static long getHead(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_HEAD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_HEAD.symbol(), t);
        }
    }

    public static long getActiveElement(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_ACTIVE_ELEMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_ACTIVE_ELEMENT.symbol(), t);
        }
    }

    public static long getScrollingElement(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_SCROLLING_ELEMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_SCROLLING_ELEMENT.symbol(), t);
        }
    }

    public static long getFirstElementChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FIRST_ELEMENT_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_FIRST_ELEMENT_CHILD.symbol(), t);
        }
    }

    public static long getLastElementChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_LAST_ELEMENT_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DocumentImplSignature.GET_LAST_ELEMENT_CHILD.symbol(), t);
        }
    }

    // Combined string-return + exception-forwarding, same shape as
    // CharacterDataImplBinding.substringData: Document::cookie() is
    // ExceptionOr<String>.
    public static String getCookie(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            try {
                GET_COOKIE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            } catch (Throwable t) {
                throw Downcall.failed(DocumentImplSignature.GET_COOKIE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return exchange.value();
        }
    }

    // DOMException construction stays here, same rationale as
    // ElementImplBinding.setAttribute.
    public static void setCookie(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_COOKIE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(DocumentImplSignature.SET_COOKIE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void setXmlVersion(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_XML_VERSION.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(DocumentImplSignature.SET_XML_VERSION.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    // Exception forwarding with an object-handle argument instead of a
    // string one -- same mechanical shape as setCookie/setXmlVersion above,
    // but the argument is another DOM peer address rather than a UTF-8 blob.
    public static void setBody(long peer, long value) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                SET_BODY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), MemorySegment.ofAddress(value));
            } catch (Throwable t) {
                throw Downcall.failed(DocumentImplSignature.SET_BODY.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
