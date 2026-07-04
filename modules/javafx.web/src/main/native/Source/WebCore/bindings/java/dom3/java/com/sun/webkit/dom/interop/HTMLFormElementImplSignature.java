package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLFormElementImpl}.
 * setEnctype/setEncoding/setMethod/setAutocomplete are deliberately NOT
 * migrated -- no JNI implementation exists for any of them (grepped, zero
 * matches), so there is no working baseline behavior to preserve.
 */
@NativeHeader(value = "dom_html_form_element_api", includes = { "<stdint.h>" })
public enum HTMLFormElementImplSignature implements NativeSignatureEntry {
    GET_NO_VALIDATE("jfxpanama_dom_HTMLFormElement_getNoValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FORM_ELEMENT)),
    SET_NO_VALIDATE("jfxpanama_dom_HTMLFormElement_setNoValidate",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FORM_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_LENGTH("jfxpanama_dom_HTMLFormElement_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_FORM_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLFormElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FORM_ELEMENT)),

    SET_ACCEPT_CHARSET("jfxpanama_dom_HTMLFormElement_setAcceptCharset",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FORM_ELEMENT, PrimitiveKind.STRING)),
    SET_ACTION("jfxpanama_dom_HTMLFormElement_setAction",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FORM_ELEMENT, PrimitiveKind.STRING)),
    SET_NAME("jfxpanama_dom_HTMLFormElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FORM_ELEMENT, PrimitiveKind.STRING)),
    SET_TARGET("jfxpanama_dom_HTMLFormElement_setTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FORM_ELEMENT, PrimitiveKind.STRING));

    private final String symbol;
    private final Signature signature;

    HTMLFormElementImplSignature(String symbol, Signature signature) {
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
