package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLStyleElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_style_element_api", includes = { "<stdint.h>" })
public enum HTMLStyleElementImplSignature implements NativeSignatureEntry {
    GET_DISABLED("jfxpanama_dom_HTMLStyleElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_STYLE_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLStyleElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_STYLE_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_MEDIA("jfxpanama_dom_HTMLStyleElement_getMedia",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_STYLE_ELEMENT)),
    SET_MEDIA("jfxpanama_dom_HTMLStyleElement_setMedia",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_STYLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLStyleElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_STYLE_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLStyleElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_STYLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SHEET("jfxpanama_dom_HTMLStyleElement_getSheet",
            Signature.of(DomKind.STYLE_SHEET, DomKind.HTML_STYLE_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLStyleElementImplSignature(String symbol, Signature signature) {
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
