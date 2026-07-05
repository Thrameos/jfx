package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLOptionElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_option_element_api", includes = { "<stdint.h>" })
public enum HTMLOptionElementImplSignature implements NativeSignatureEntry {
    GET_DISABLED("jfxpanama_dom_HTMLOptionElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OPTION_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLOptionElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPTION_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_FORM("jfxpanama_dom_HTMLOptionElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_OPTION_ELEMENT)),
    GET_LABEL("jfxpanama_dom_HTMLOptionElement_getLabel",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OPTION_ELEMENT)),
    GET_DEFAULT_SELECTED("jfxpanama_dom_HTMLOptionElement_getDefaultSelected",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OPTION_ELEMENT)),
    SET_DEFAULT_SELECTED("jfxpanama_dom_HTMLOptionElement_setDefaultSelected",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPTION_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_SELECTED("jfxpanama_dom_HTMLOptionElement_getSelected",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OPTION_ELEMENT)),
    SET_SELECTED("jfxpanama_dom_HTMLOptionElement_setSelected",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPTION_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_VALUE("jfxpanama_dom_HTMLOptionElement_getValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OPTION_ELEMENT)),
    GET_TEXT("jfxpanama_dom_HTMLOptionElement_getText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OPTION_ELEMENT)),
    GET_INDEX("jfxpanama_dom_HTMLOptionElement_getIndex",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_OPTION_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLOptionElementImplSignature(String symbol, Signature signature) {
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
