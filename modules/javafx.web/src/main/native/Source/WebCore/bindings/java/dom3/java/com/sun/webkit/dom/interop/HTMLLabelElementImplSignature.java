package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLLabelElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_label_element_api", includes = { "<stdint.h>" })
public enum HTMLLabelElementImplSignature implements NativeSignatureEntry {
    GET_FORM("jfxpanama_dom_HTMLLabelElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_LABEL_ELEMENT)),
    GET_HTML_FOR("jfxpanama_dom_HTMLLabelElement_getHtmlFor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LABEL_ELEMENT)),
    SET_HTML_FOR("jfxpanama_dom_HTMLLabelElement_setHtmlFor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LABEL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CONTROL("jfxpanama_dom_HTMLLabelElement_getControl",
            Signature.of(DomKind.HTML_ELEMENT, DomKind.HTML_LABEL_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLLabelElementImplSignature(String symbol, Signature signature) {
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
