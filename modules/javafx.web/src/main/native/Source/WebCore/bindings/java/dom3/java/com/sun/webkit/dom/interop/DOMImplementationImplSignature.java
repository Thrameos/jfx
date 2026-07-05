package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DOMImplementationImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_dom_implementation_api", includes = { "<stdint.h>" })
public enum DOMImplementationImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_DOMImplementation_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_IMPLEMENTATION)),
    CREATE_DOCUMENT_TYPE("jfxpanama_dom_DOMImplementation_createDocumentType",
            Signature.of(DomKind.DOCUMENT_TYPE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOM_IMPLEMENTATION, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),
    CREATE_DOCUMENT("jfxpanama_dom_DOMImplementation_createDocument",
            Signature.of(DomKind.DOCUMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOM_IMPLEMENTATION, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, DomKind.DOCUMENT_TYPE)),
    CREATE_CSS_STYLE_SHEET("jfxpanama_dom_DOMImplementation_createCSSStyleSheet",
            Signature.of(DomKind.CSS_STYLE_SHEET, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOM_IMPLEMENTATION, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),
    CREATE_HTML_DOCUMENT("jfxpanama_dom_DOMImplementation_createHTMLDocument",
            Signature.of(DomKind.HTML_DOCUMENT, DomKind.DOM_IMPLEMENTATION, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    DOMImplementationImplSignature(String symbol, Signature signature) {
        this.symbol = symbol;
        this.signature = signature;
    }

    @Override
    public String symbol() {
        return symbol;
    }

    @Override
    public Signature signature() {
        return signature;
    }
}
