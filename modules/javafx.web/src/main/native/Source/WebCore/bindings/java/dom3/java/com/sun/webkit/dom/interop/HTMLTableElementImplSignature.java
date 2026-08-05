package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLTableElementImpl}.
 * insertRow/deleteRow are excluded -- both forward exceptions
 * (raiseOnDOMError) and take an int index, outside every proven shape so
 * far. deleteTHead/deleteTFoot/deleteCaption are also excluded -- void
 * no-arg "action" methods aren't one of the four proven shapes yet.
 */
@NativeHeader(value = "dom_html_table_element_api", includes = { "<stdint.h>" })
public enum HTMLTableElementImplSignature implements NativeSignatureEntry {
    GET_CAPTION("jfxpanama_dom_HTMLTableElement_getCaption",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    GET_THEAD("jfxpanama_dom_HTMLTableElement_getTHead",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    GET_TFOOT("jfxpanama_dom_HTMLTableElement_getTFoot",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    CREATE_THEAD("jfxpanama_dom_HTMLTableElement_createTHead",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    CREATE_TFOOT("jfxpanama_dom_HTMLTableElement_createTFoot",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    CREATE_TBODY("jfxpanama_dom_HTMLTableElement_createTBody",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),
    CREATE_CAPTION("jfxpanama_dom_HTMLTableElement_createCaption",
            Signature.of(DomKind.ELEMENT, DomKind.HTML_TABLE_ELEMENT)),

    SET_ALIGN("jfxpanama_dom_HTMLTableElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_BGCOLOR("jfxpanama_dom_HTMLTableElement_setBgColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_BORDER("jfxpanama_dom_HTMLTableElement_setBorder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CELLPADDING("jfxpanama_dom_HTMLTableElement_setCellPadding",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CELLSPACING("jfxpanama_dom_HTMLTableElement_setCellSpacing",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_FRAME("jfxpanama_dom_HTMLTableElement_setFrame",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_RULES("jfxpanama_dom_HTMLTableElement_setRules",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SUMMARY("jfxpanama_dom_HTMLTableElement_setSummary",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_WIDTH("jfxpanama_dom_HTMLTableElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLTableElementImplSignature(String symbol, Signature signature) {
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
