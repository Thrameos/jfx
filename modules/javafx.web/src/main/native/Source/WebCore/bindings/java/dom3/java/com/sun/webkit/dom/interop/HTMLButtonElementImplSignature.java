package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLButtonElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_button_element_api", includes = { "<stdint.h>" })
public enum HTMLButtonElementImplSignature implements NativeSignatureEntry {
    GET_AUTOFOCUS("jfxpanama_dom_HTMLButtonElement_getAutofocus",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_BUTTON_ELEMENT)),
    SET_AUTOFOCUS("jfxpanama_dom_HTMLButtonElement_setAutofocus",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DISABLED("jfxpanama_dom_HTMLButtonElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_BUTTON_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLButtonElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_FORM("jfxpanama_dom_HTMLButtonElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_BUTTON_ELEMENT)),
    GET_FORM_ACTION("jfxpanama_dom_HTMLButtonElement_getFormAction",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    GET_FORM_ENCTYPE("jfxpanama_dom_HTMLButtonElement_getFormEnctype",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    GET_FORM_METHOD("jfxpanama_dom_HTMLButtonElement_getFormMethod",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    GET_TYPE("jfxpanama_dom_HTMLButtonElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    GET_FORM_NO_VALIDATE("jfxpanama_dom_HTMLButtonElement_getFormNoValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_BUTTON_ELEMENT)),
    SET_FORM_NO_VALIDATE("jfxpanama_dom_HTMLButtonElement_setFormNoValidate",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_FORM_TARGET("jfxpanama_dom_HTMLButtonElement_getFormTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    SET_FORM_TARGET("jfxpanama_dom_HTMLButtonElement_setFormTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLButtonElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLButtonElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_VALUE("jfxpanama_dom_HTMLButtonElement_getValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    SET_VALUE("jfxpanama_dom_HTMLButtonElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLButtonElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_BUTTON_ELEMENT)),
    GET_VALIDATION_MESSAGE("jfxpanama_dom_HTMLButtonElement_getValidationMessage",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BUTTON_ELEMENT)),
    GET_LABELS("jfxpanama_dom_HTMLButtonElement_getLabels",
            Signature.of(DomKind.NODE_LIST, DomKind.HTML_BUTTON_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLButtonElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_BUTTON_ELEMENT)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLButtonElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BUTTON_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLButtonElementImplSignature(String symbol, Signature signature) {
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
