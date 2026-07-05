package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.ByteExchange;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;
import org.w3c.dom.DOMException;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link DOMImplementationImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 *
 * <p>DISPOSE is deliberately not bound here -- dispose() retirement across
 * every migrated CSS OM class is a separate, dedicated pass, not something
 * to bundle into one class's attribute migration (see dom_css_rule.cpp's
 * header comment).
 */
public final class DOMImplementationImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle CREATE_DOCUMENT_TYPE = bind(DOMImplementationImplSignature.CREATE_DOCUMENT_TYPE);
    private static final MethodHandle CREATE_DOCUMENT = bind(DOMImplementationImplSignature.CREATE_DOCUMENT);
    private static final MethodHandle CREATE_CSS_STYLE_SHEET = bind(DOMImplementationImplSignature.CREATE_CSS_STYLE_SHEET);
    private static final MethodHandle CREATE_HTML_DOCUMENT = bind(DOMImplementationImplSignature.CREATE_HTML_DOCUMENT);

    private DOMImplementationImplBinding() {
    }

    private static MethodHandle bind(DOMImplementationImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static long createDocumentType(long peer, String qualifiedName, String publicId, String systemId) {
        try (Transfer qualifiedNameUtf8 = CString8.of(qualifiedName, TransferPool.SHARED);
                Transfer publicIdUtf8 = CString8.of(publicId, TransferPool.SHARED);
                Transfer systemIdUtf8 = CString8.of(systemId, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) CREATE_DOCUMENT_TYPE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        qualifiedNameUtf8.segment(), publicIdUtf8.segment(), systemIdUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(DOMImplementationImplSignature.CREATE_DOCUMENT_TYPE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }

    public static long createDocument(long peer, String namespaceURI, String qualifiedName, long doctype) {
        try (Transfer namespaceURIUtf8 = CString8.of(namespaceURI, TransferPool.SHARED);
                Transfer qualifiedNameUtf8 = CString8.of(qualifiedName, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) CREATE_DOCUMENT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        namespaceURIUtf8.segment(), qualifiedNameUtf8.segment(), MemorySegment.ofAddress(doctype));
            } catch (Throwable t) {
                throw Downcall.failed(DOMImplementationImplSignature.CREATE_DOCUMENT.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }

    public static long createCSSStyleSheet(long peer, String title, String media) {
        try (Transfer titleUtf8 = CString8.of(title, TransferPool.SHARED);
                Transfer mediaUtf8 = CString8.of(media, TransferPool.SHARED)) {
            MemorySegment result = (MemorySegment) CREATE_CSS_STYLE_SHEET.invokeExact(
                    MemorySegment.ofAddress(peer), titleUtf8.segment(), mediaUtf8.segment());
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DOMImplementationImplSignature.CREATE_CSS_STYLE_SHEET.symbol(), t);
        }
    }

    public static long createHTMLDocument(long peer, String title) {
        try (Transfer titleUtf8 = CString8.of(title, TransferPool.SHARED)) {
            MemorySegment result = (MemorySegment) CREATE_HTML_DOCUMENT.invokeExact(MemorySegment.ofAddress(peer), titleUtf8.segment());
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(DOMImplementationImplSignature.CREATE_HTML_DOCUMENT.symbol(), t);
        }
    }
}
