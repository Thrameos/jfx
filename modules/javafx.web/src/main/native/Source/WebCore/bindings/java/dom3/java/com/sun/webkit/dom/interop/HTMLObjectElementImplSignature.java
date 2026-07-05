package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLObjectElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_object_element_api", includes = { "<stdint.h>" })
public enum HTMLObjectElementImplSignature implements NativeSignatureEntry {
    GET_FORM("jfxpanama_dom_HTMLObjectElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_OBJECT_ELEMENT)),
    GET_CODE("jfxpanama_dom_HTMLObjectElement_getCode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_CODE("jfxpanama_dom_HTMLObjectElement_setCode",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ALIGN("jfxpanama_dom_HTMLObjectElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLObjectElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ARCHIVE("jfxpanama_dom_HTMLObjectElement_getArchive",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_ARCHIVE("jfxpanama_dom_HTMLObjectElement_setArchive",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_BORDER("jfxpanama_dom_HTMLObjectElement_getBorder",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_BORDER("jfxpanama_dom_HTMLObjectElement_setBorder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CODE_BASE("jfxpanama_dom_HTMLObjectElement_getCodeBase",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_CODE_BASE("jfxpanama_dom_HTMLObjectElement_setCodeBase",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CODE_TYPE("jfxpanama_dom_HTMLObjectElement_getCodeType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_CODE_TYPE("jfxpanama_dom_HTMLObjectElement_setCodeType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_DATA("jfxpanama_dom_HTMLObjectElement_getData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_DATA("jfxpanama_dom_HTMLObjectElement_setData",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_DECLARE("jfxpanama_dom_HTMLObjectElement_getDeclare",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OBJECT_ELEMENT)),
    SET_DECLARE("jfxpanama_dom_HTMLObjectElement_setDeclare",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_HEIGHT("jfxpanama_dom_HTMLObjectElement_getHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_HEIGHT("jfxpanama_dom_HTMLObjectElement_setHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HSPACE("jfxpanama_dom_HTMLObjectElement_setHspace",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLObjectElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLObjectElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_STANDBY("jfxpanama_dom_HTMLObjectElement_getStandby",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_STANDBY("jfxpanama_dom_HTMLObjectElement_setStandby",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLObjectElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLObjectElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_USE_MAP("jfxpanama_dom_HTMLObjectElement_getUseMap",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_USE_MAP("jfxpanama_dom_HTMLObjectElement_setUseMap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VSPACE("jfxpanama_dom_HTMLObjectElement_setVspace",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLObjectElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLObjectElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLObjectElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OBJECT_ELEMENT)),
    GET_VALIDATION_MESSAGE("jfxpanama_dom_HTMLObjectElement_getValidationMessage",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OBJECT_ELEMENT)),
    GET_CONTENT_DOCUMENT("jfxpanama_dom_HTMLObjectElement_getContentDocument",
            Signature.of(DomKind.DOCUMENT, DomKind.HTML_OBJECT_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLObjectElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OBJECT_ELEMENT)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLObjectElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OBJECT_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLObjectElementImplSignature(String symbol, Signature signature) {
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
