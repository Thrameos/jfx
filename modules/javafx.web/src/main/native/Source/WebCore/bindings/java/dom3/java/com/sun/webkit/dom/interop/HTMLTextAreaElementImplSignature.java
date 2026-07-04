package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLTextAreaElementImpl}.
 * No {@code Binder}/library-loading reference anywhere in this class or its
 * constructor -- see {@link ElementImplSignature}'s class doc for the full
 * rationale.
 *
 * <p>NOTE: setAutocomplete is NOT here -- confirmed via `nm -D` on the built
 * .so to have no working JNI implementation at all (not even a stub), so
 * migrating it would be new functionality, not a migration (same reasoning
 * as the phantom methods reverted in ElementImpl/DocumentImpl/
 * HTMLInputElementImpl, see CHECKLIST.md). getAutocomplete IS here -- its old
 * JNI implementation is real.
 */
@NativeHeader(value = "dom_html_text_area_element_api", includes = { "<stdint.h>" })
public enum HTMLTextAreaElementImplSignature implements NativeSignatureEntry {

    // Primitive getter/setter (shape 1).
    GET_AUTOFOCUS("jfxpanama_dom_HTMLTextAreaElement_getAutofocus",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_AUTOFOCUS("jfxpanama_dom_HTMLTextAreaElement_setAutofocus",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DISABLED("jfxpanama_dom_HTMLTextAreaElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLTextAreaElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_MAX_LENGTH("jfxpanama_dom_HTMLTextAreaElement_getMaxLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_MAX_LENGTH("jfxpanama_dom_HTMLTextAreaElement_setMaxLength",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.INT)),
    GET_READ_ONLY("jfxpanama_dom_HTMLTextAreaElement_getReadOnly",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_READ_ONLY("jfxpanama_dom_HTMLTextAreaElement_setReadOnly",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_REQUIRED("jfxpanama_dom_HTMLTextAreaElement_getRequired",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_REQUIRED("jfxpanama_dom_HTMLTextAreaElement_setRequired",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_ROWS("jfxpanama_dom_HTMLTextAreaElement_getRows",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_ROWS("jfxpanama_dom_HTMLTextAreaElement_setRows",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.INT)),
    GET_COLS("jfxpanama_dom_HTMLTextAreaElement_getCols",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_COLS("jfxpanama_dom_HTMLTextAreaElement_setCols",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.INT)),
    GET_TEXT_LENGTH("jfxpanama_dom_HTMLTextAreaElement_getTextLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLTextAreaElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_SELECTION_START("jfxpanama_dom_HTMLTextAreaElement_getSelectionStart",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_SELECTION_START("jfxpanama_dom_HTMLTextAreaElement_setSelectionStart",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.INT)),
    GET_SELECTION_END("jfxpanama_dom_HTMLTextAreaElement_getSelectionEnd",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SET_SELECTION_END("jfxpanama_dom_HTMLTextAreaElement_setSelectionEnd",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.INT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLTextAreaElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TEXT_AREA_ELEMENT)),
    SELECT("jfxpanama_dom_HTMLTextAreaElement_select",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT)),

    // Input-only string args (shape 2), void, no exception forwarding.
    SET_DIR_NAME("jfxpanama_dom_HTMLTextAreaElement_setDirName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_NAME("jfxpanama_dom_HTMLTextAreaElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PLACEHOLDER("jfxpanama_dom_HTMLTextAreaElement_setPlaceholder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_WRAP("jfxpanama_dom_HTMLTextAreaElement_setWrap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_DEFAULT_VALUE("jfxpanama_dom_HTMLTextAreaElement_setDefaultValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VALUE("jfxpanama_dom_HTMLTextAreaElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SELECTION_DIRECTION("jfxpanama_dom_HTMLTextAreaElement_setSelectionDirection",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ACCESS_KEY("jfxpanama_dom_HTMLTextAreaElement_setAccessKey",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLTextAreaElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    // Plain multi-arg (int, int, string), void, no exception forwarding --
    // old JNI's setSelectionRangeImpl never calls raiseOnDOMError, so no
    // ByteExchange is wired here, matching setMaxLength/setValue's
    // discard-on-purpose precedent above.
    SET_SELECTION_RANGE("jfxpanama_dom_HTMLTextAreaElement_setSelectionRange",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TEXT_AREA_ELEMENT,
                    PrimitiveKind.INT, PrimitiveKind.INT, PrimitiveKind.UTF8_CSTRING)),

    // String returns (shape 4).
    GET_DIR_NAME("jfxpanama_dom_HTMLTextAreaElement_getDirName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_NAME("jfxpanama_dom_HTMLTextAreaElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_PLACEHOLDER("jfxpanama_dom_HTMLTextAreaElement_getPlaceholder",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_WRAP("jfxpanama_dom_HTMLTextAreaElement_getWrap",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_TYPE("jfxpanama_dom_HTMLTextAreaElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_DEFAULT_VALUE("jfxpanama_dom_HTMLTextAreaElement_getDefaultValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_VALUE("jfxpanama_dom_HTMLTextAreaElement_getValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_VALIDATION_MESSAGE("jfxpanama_dom_HTMLTextAreaElement_getValidationMessage",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_SELECTION_DIRECTION("jfxpanama_dom_HTMLTextAreaElement_getSelectionDirection",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_ACCESS_KEY("jfxpanama_dom_HTMLTextAreaElement_getAccessKey",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_AUTOCOMPLETE("jfxpanama_dom_HTMLTextAreaElement_getAutocomplete",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TEXT_AREA_ELEMENT)),

    // Object-handle returns (shape 3).
    GET_FORM("jfxpanama_dom_HTMLTextAreaElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_TEXT_AREA_ELEMENT)),
    GET_LABELS("jfxpanama_dom_HTMLTextAreaElement_getLabels",
            Signature.of(DomKind.NODE_LIST, DomKind.HTML_TEXT_AREA_ELEMENT)),

    // Exception forwarding (shape 6), void.
    SET_RANGE_TEXT("jfxpanama_dom_HTMLTextAreaElement_setRangeText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_TEXT_AREA_ELEMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    SET_RANGE_TEXT_EX("jfxpanama_dom_HTMLTextAreaElement_setRangeTextEx",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_TEXT_AREA_ELEMENT,
                    PrimitiveKind.UTF8_CSTRING, PrimitiveKind.INT, PrimitiveKind.INT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLTextAreaElementImplSignature(String symbol, Signature signature) {
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
