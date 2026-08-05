package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLTableColElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_table_col_element_api", includes = { "<stdint.h>" })
public enum HTMLTableColElementImplSignature implements NativeSignatureEntry {
    GET_ALIGN("jfxpanama_dom_HTMLTableColElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLTableColElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH("jfxpanama_dom_HTMLTableColElement_getCh",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_CH("jfxpanama_dom_HTMLTableColElement_setCh",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CH_OFF("jfxpanama_dom_HTMLTableColElement_getChOff",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_CH_OFF("jfxpanama_dom_HTMLTableColElement_setChOff",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SPAN("jfxpanama_dom_HTMLTableColElement_getSpan",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_SPAN("jfxpanama_dom_HTMLTableColElement_setSpan",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.INT)),
    GET_V_ALIGN("jfxpanama_dom_HTMLTableColElement_getVAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_V_ALIGN("jfxpanama_dom_HTMLTableColElement_setVAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLTableColElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_TABLE_COL_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLTableColElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_TABLE_COL_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLTableColElementImplSignature(String symbol, Signature signature) {
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
