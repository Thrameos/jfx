package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLFontElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_font_element_api", includes = { "<stdint.h>" })
public enum HTMLFontElementImplSignature implements NativeSignatureEntry {
    GET_COLOR("jfxpanama_dom_HTMLFontElement_getColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FONT_ELEMENT)),
    SET_COLOR("jfxpanama_dom_HTMLFontElement_setColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FONT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_FACE("jfxpanama_dom_HTMLFontElement_getFace",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FONT_ELEMENT)),
    SET_FACE("jfxpanama_dom_HTMLFontElement_setFace",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FONT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SIZE("jfxpanama_dom_HTMLFontElement_getSize",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FONT_ELEMENT)),
    SET_SIZE("jfxpanama_dom_HTMLFontElement_setSize",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FONT_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLFontElementImplSignature(String symbol, Signature signature) {
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
