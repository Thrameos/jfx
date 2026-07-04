package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLSelectElementImpl}.
 * setAutocomplete is deliberately NOT migrated -- no JNI implementation
 * exists for it (grepped, zero matches), so there is no working baseline
 * behavior to preserve. item/namedItem/add are excluded -- object-handle or
 * multi-arg-with-exception shapes not proven yet.
 */
@NativeHeader(value = "dom_html_select_element_api", includes = { "<stdint.h>" })
public enum HTMLSelectElementImplSignature implements NativeSignatureEntry {
    GET_AUTOFOCUS("jfxpanama_dom_HTMLSelectElement_getAutofocus",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    SET_AUTOFOCUS("jfxpanama_dom_HTMLSelectElement_setAutofocus",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DISABLED("jfxpanama_dom_HTMLSelectElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLSelectElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_MULTIPLE("jfxpanama_dom_HTMLSelectElement_getMultiple",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    SET_MULTIPLE("jfxpanama_dom_HTMLSelectElement_setMultiple",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_REQUIRED("jfxpanama_dom_HTMLSelectElement_getRequired",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    SET_REQUIRED("jfxpanama_dom_HTMLSelectElement_setRequired",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_SIZE("jfxpanama_dom_HTMLSelectElement_getSize",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_SELECT_ELEMENT)),
    SET_SIZE("jfxpanama_dom_HTMLSelectElement_setSize",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.INT)),
    GET_LENGTH("jfxpanama_dom_HTMLSelectElement_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_SELECT_ELEMENT)),
    GET_SELECTED_INDEX("jfxpanama_dom_HTMLSelectElement_getSelectedIndex",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_SELECT_ELEMENT)),
    SET_SELECTED_INDEX("jfxpanama_dom_HTMLSelectElement_setSelectedIndex",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.INT)),
    GET_WILL_VALIDATE("jfxpanama_dom_HTMLSelectElement_getWillValidate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    CHECK_VALIDITY("jfxpanama_dom_HTMLSelectElement_checkValidity",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SELECT_ELEMENT)),
    REMOVE("jfxpanama_dom_HTMLSelectElement_remove",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.INT)),

    SET_NAME("jfxpanama_dom_HTMLSelectElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VALUE("jfxpanama_dom_HTMLSelectElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CUSTOM_VALIDITY("jfxpanama_dom_HTMLSelectElement_setCustomValidity",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SELECT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    GET_FORM("jfxpanama_dom_HTMLSelectElement_getForm",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_SELECT_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLSelectElementImplSignature(String symbol, Signature signature) {
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
