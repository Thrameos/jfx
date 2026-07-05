package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLTableCellElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_table_cell_element_api", includes = { "<stdint.h>" })
public enum HTMLTableCellElementImplSignature implements NativeSignatureEntry {
    GET_CELL_INDEX("jfxpanama_dom_HTMLTableCellElement_getCellIndex",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TABLE_CELL_ELEMENT)),
    GET_ALIGN("jfxpanama_dom_HTMLTableCellElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLTableCellElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_AXIS("jfxpanama_dom_HTMLTableCellElement_getAxis",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_AXIS("jfxpanama_dom_HTMLTableCellElement_setAxis",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_BG_COLOR("jfxpanama_dom_HTMLTableCellElement_getBgColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_BG_COLOR("jfxpanama_dom_HTMLTableCellElement_setBgColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH("jfxpanama_dom_HTMLTableCellElement_getCh",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_CH("jfxpanama_dom_HTMLTableCellElement_setCh",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH_OFF("jfxpanama_dom_HTMLTableCellElement_getChOff",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_CH_OFF("jfxpanama_dom_HTMLTableCellElement_setChOff",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_COL_SPAN("jfxpanama_dom_HTMLTableCellElement_getColSpan",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_COL_SPAN("jfxpanama_dom_HTMLTableCellElement_setColSpan",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.INT)),
    GET_ROW_SPAN("jfxpanama_dom_HTMLTableCellElement_getRowSpan",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_ROW_SPAN("jfxpanama_dom_HTMLTableCellElement_setRowSpan",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.INT)),
    GET_HEADERS("jfxpanama_dom_HTMLTableCellElement_getHeaders",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_HEADERS("jfxpanama_dom_HTMLTableCellElement_setHeaders",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HEIGHT("jfxpanama_dom_HTMLTableCellElement_getHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_HEIGHT("jfxpanama_dom_HTMLTableCellElement_setHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NO_WRAP("jfxpanama_dom_HTMLTableCellElement_getNoWrap",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_NO_WRAP("jfxpanama_dom_HTMLTableCellElement_setNoWrap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_V_ALIGN("jfxpanama_dom_HTMLTableCellElement_getVAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_V_ALIGN("jfxpanama_dom_HTMLTableCellElement_setVAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLTableCellElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLTableCellElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ABBR("jfxpanama_dom_HTMLTableCellElement_getAbbr",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_ABBR("jfxpanama_dom_HTMLTableCellElement_setAbbr",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SCOPE("jfxpanama_dom_HTMLTableCellElement_getScope",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_CELL_ELEMENT)),
    SET_SCOPE("jfxpanama_dom_HTMLTableCellElement_setScope",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_CELL_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLTableCellElementImplSignature(String symbol, Signature signature) {
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
