package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLTableSectionElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_table_section_element_api", includes = { "<stdint.h>" })
public enum HTMLTableSectionElementImplSignature implements NativeSignatureEntry {
    GET_ALIGN("jfxpanama_dom_HTMLTableSectionElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_SECTION_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLTableSectionElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH("jfxpanama_dom_HTMLTableSectionElement_getCh",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_SECTION_ELEMENT)),
    SET_CH("jfxpanama_dom_HTMLTableSectionElement_setCh",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH_OFF("jfxpanama_dom_HTMLTableSectionElement_getChOff",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_SECTION_ELEMENT)),
    SET_CH_OFF("jfxpanama_dom_HTMLTableSectionElement_setChOff",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_V_ALIGN("jfxpanama_dom_HTMLTableSectionElement_getVAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_SECTION_ELEMENT)),
    SET_V_ALIGN("jfxpanama_dom_HTMLTableSectionElement_setVAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ROWS("jfxpanama_dom_HTMLTableSectionElement_getRows",
            Signature.of(DomKind.HTML_COLLECTION, DomKind.HTML_TABLE_SECTION_ELEMENT)),
    INSERT_ROW("jfxpanama_dom_HTMLTableSectionElement_insertRow",
            Signature.of(DomKind.HTML_ELEMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.INT)),
    DELETE_ROW("jfxpanama_dom_HTMLTableSectionElement_deleteRow",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_TABLE_SECTION_ELEMENT, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    HTMLTableSectionElementImplSignature(String symbol, Signature signature) {
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
