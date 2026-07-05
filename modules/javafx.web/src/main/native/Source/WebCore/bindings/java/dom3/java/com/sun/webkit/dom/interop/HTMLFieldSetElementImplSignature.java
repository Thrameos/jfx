package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLFieldSetElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_field_set_element_api", includes = { "<stdint.h>" })
public enum HTMLFieldSetElementImplSignature implements NativeSignatureEntry {
    GET_DISABLED("jfxpanama_dom_HTMLFieldSetElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FIELD_SET_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLFieldSetElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FIELD_SET_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_FORM("jfxpanama_dom_HTMLFieldSetElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_FIELD_SET_ELEMENT)),
    GET_NAME("jfxpanama_dom_HTMLFieldSetElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FIELD_SET_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLFieldSetElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FIELD_SET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLFieldSetElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FIELD_SET_ELEMENT)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLFieldSetElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FIELD_SET_ELEMENT)),
    GET_VALIDATION_MESSAGE("jfxpanama_dom_HTMLFieldSetElement_getValidationMessage",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FIELD_SET_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLFieldSetElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FIELD_SET_ELEMENT)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLFieldSetElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FIELD_SET_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLFieldSetElementImplSignature(String symbol, Signature signature) {
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
