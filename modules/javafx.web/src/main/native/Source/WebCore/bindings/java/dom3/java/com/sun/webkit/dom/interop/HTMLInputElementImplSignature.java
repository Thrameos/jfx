package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLInputElementImpl}. No
 * {@code Binder}/library-loading reference anywhere in this class or its
 * constructor -- see {@link HTMLInputElementImplBinding} for that -- see
 * {@link ElementImplSignature}'s class doc for the full rationale.
 *
 * <p>NOTE: getIncremental/setIncremental and getDefaultValue/setDefaultValue
 * are NOT here -- confirmed via `nm -D` on the built .so to have no working
 * JNI implementation at all (not even a stub), so migrating them would be new
 * functionality, not a migration (same reasoning as the 10 phantom methods
 * reverted in ElementImpl/DocumentImpl, see CHECKLIST.md). getValueAsDate/
 * setValueAsDate are also NOT here -- deferred, not phantom: their old JNI
 * implementation is real, but it round-trips a WallTime through
 * `approximateMonotonicTime().get_time_value()`, a time-representation shape
 * with no proven Panama pattern yet, unlike everything else in this file.
 */
@NativeHeader(value = "dom_html_input_element_api", includes = { "<stdint.h>" })
public enum HTMLInputElementImplSignature implements NativeSignatureEntry {

    // Primitive getter/setter (shape 1).
    GET_AUTOFOCUS("jfxpanama_dom_HTMLInputElement_getAutofocus",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_AUTOFOCUS("jfxpanama_dom_HTMLInputElement_setAutofocus",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DEFAULT_CHECKED("jfxpanama_dom_HTMLInputElement_getDefaultChecked",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_DEFAULT_CHECKED("jfxpanama_dom_HTMLInputElement_setDefaultChecked",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_CHECKED("jfxpanama_dom_HTMLInputElement_getChecked",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_CHECKED("jfxpanama_dom_HTMLInputElement_setChecked",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DISABLED("jfxpanama_dom_HTMLInputElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLInputElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_FORM_NO_VALIDATE("jfxpanama_dom_HTMLInputElement_getFormNoValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_FORM_NO_VALIDATE("jfxpanama_dom_HTMLInputElement_setFormNoValidate",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_HEIGHT("jfxpanama_dom_HTMLInputElement_getHeight",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_INPUT_ELEMENT)),
    GET_INDETERMINATE("jfxpanama_dom_HTMLInputElement_getIndeterminate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_INDETERMINATE("jfxpanama_dom_HTMLInputElement_setIndeterminate",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_MAX_LENGTH("jfxpanama_dom_HTMLInputElement_getMaxLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_INPUT_ELEMENT)),
    // Old JNI never called raiseOnDOMError for setMaxLengthImpl even though
    // WebCore::setMaxLength returns ExceptionOr<void> -- preserved as-is
    // (discarded, no exchange) rather than newly wired up during migration.
    SET_MAX_LENGTH("jfxpanama_dom_HTMLInputElement_setMaxLength",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.INT)),
    GET_MULTIPLE("jfxpanama_dom_HTMLInputElement_getMultiple",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_MULTIPLE("jfxpanama_dom_HTMLInputElement_setMultiple",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_READ_ONLY("jfxpanama_dom_HTMLInputElement_getReadOnly",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_READ_ONLY("jfxpanama_dom_HTMLInputElement_setReadOnly",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_REQUIRED("jfxpanama_dom_HTMLInputElement_getRequired",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SET_REQUIRED("jfxpanama_dom_HTMLInputElement_setRequired",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.BOOLEAN)),
    // Old JNI never called raiseOnDOMError for setValueAsNumberImpl either,
    // same discard-on-purpose rationale as setMaxLength above.
    GET_VALUE_AS_NUMBER("jfxpanama_dom_HTMLInputElement_getValueAsNumber",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.HTML_INPUT_ELEMENT)),
    SET_VALUE_AS_NUMBER("jfxpanama_dom_HTMLInputElement_setValueAsNumber",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.DOUBLE)),
    GET_WIDTH("jfxpanama_dom_HTMLInputElement_getWidth",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_INPUT_ELEMENT)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLInputElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLInputElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_INPUT_ELEMENT)),
    SELECT("jfxpanama_dom_HTMLInputElement_select",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT)),
    CLICK("jfxpanama_dom_HTMLInputElement_click",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT)),

    // Input-only string args (shape 2), void, no exception forwarding.
    SET_ACCEPT("jfxpanama_dom_HTMLInputElement_setAccept",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ALT("jfxpanama_dom_HTMLInputElement_setAlt",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_DIR_NAME("jfxpanama_dom_HTMLInputElement_setDirName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_FORM_TARGET("jfxpanama_dom_HTMLInputElement_setFormTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_MAX("jfxpanama_dom_HTMLInputElement_setMax",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_MIN("jfxpanama_dom_HTMLInputElement_setMin",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_NAME("jfxpanama_dom_HTMLInputElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PATTERN("jfxpanama_dom_HTMLInputElement_setPattern",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PLACEHOLDER("jfxpanama_dom_HTMLInputElement_setPlaceholder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SRC("jfxpanama_dom_HTMLInputElement_setSrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_STEP("jfxpanama_dom_HTMLInputElement_setStep",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    // Old JNI never called raiseOnDOMError for setValueImpl even though
    // WebCore::setValue returns ExceptionOr<void> -- preserved as-is.
    SET_VALUE("jfxpanama_dom_HTMLInputElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ALIGN("jfxpanama_dom_HTMLInputElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_USE_MAP("jfxpanama_dom_HTMLInputElement_setUseMap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ACCESS_KEY("jfxpanama_dom_HTMLInputElement_setAccessKey",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLInputElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VALUE_FOR_USER("jfxpanama_dom_HTMLInputElement_setValueForUser",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    // Old JNI parses the string to an int before calling WebCore setSize(int);
    // same discard-exception rationale as setMaxLength/setValue above.
    SET_SIZE("jfxpanama_dom_HTMLInputElement_setSize",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_INPUT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    // String returns (shape 4).
    GET_ACCEPT("jfxpanama_dom_HTMLInputElement_getAccept",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_ALT("jfxpanama_dom_HTMLInputElement_getAlt",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_AUTOCOMPLETE("jfxpanama_dom_HTMLInputElement_getAutocomplete",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_DIR_NAME("jfxpanama_dom_HTMLInputElement_getDirName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_FORM_ACTION("jfxpanama_dom_HTMLInputElement_getFormAction",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_FORM_ENCTYPE("jfxpanama_dom_HTMLInputElement_getFormEnctype",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_FORM_METHOD("jfxpanama_dom_HTMLInputElement_getFormMethod",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_FORM_TARGET("jfxpanama_dom_HTMLInputElement_getFormTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_MAX("jfxpanama_dom_HTMLInputElement_getMax",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_MIN("jfxpanama_dom_HTMLInputElement_getMin",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_NAME("jfxpanama_dom_HTMLInputElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_PATTERN("jfxpanama_dom_HTMLInputElement_getPattern",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_PLACEHOLDER("jfxpanama_dom_HTMLInputElement_getPlaceholder",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    // Old JNI's getSizeImpl returns String::number(IMPL->size()) -- the
    // native shim keeps doing the int->string conversion, not Java.
    GET_SIZE("jfxpanama_dom_HTMLInputElement_getSize",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_SRC("jfxpanama_dom_HTMLInputElement_getSrc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_STEP("jfxpanama_dom_HTMLInputElement_getStep",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_TYPE("jfxpanama_dom_HTMLInputElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_VALUE("jfxpanama_dom_HTMLInputElement_getValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_VALIDATION_MESSAGE("jfxpanama_dom_HTMLInputElement_getValidationMessage",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_ALIGN("jfxpanama_dom_HTMLInputElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_USE_MAP("jfxpanama_dom_HTMLInputElement_getUseMap",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),
    GET_ACCESS_KEY("jfxpanama_dom_HTMLInputElement_getAccessKey",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_INPUT_ELEMENT)),

    // Object-handle returns (shape 3).
    GET_FORM("jfxpanama_dom_HTMLInputElement_getForm",
            Signature.of(DomKind.HTML_FORM_ELEMENT, DomKind.HTML_INPUT_ELEMENT)),
    GET_LABELS("jfxpanama_dom_HTMLInputElement_getLabels",
            Signature.of(DomKind.NODE_LIST, DomKind.HTML_INPUT_ELEMENT)),

    // Exception forwarding (shape 6), void.
    STEP_UP("jfxpanama_dom_HTMLInputElement_stepUp",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_INPUT_ELEMENT,
                    PrimitiveKind.INT)),
    STEP_DOWN("jfxpanama_dom_HTMLInputElement_stepDown",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_INPUT_ELEMENT,
                    PrimitiveKind.INT)),
    SET_RANGE_TEXT("jfxpanama_dom_HTMLInputElement_setRangeText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_INPUT_ELEMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    SET_RANGE_TEXT_EX("jfxpanama_dom_HTMLInputElement_setRangeTextEx",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_INPUT_ELEMENT,
                    PrimitiveKind.UTF8_CSTRING, PrimitiveKind.INT, PrimitiveKind.INT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLInputElementImplSignature(String symbol, Signature signature) {
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
