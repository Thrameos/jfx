package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSStyleSheetImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_style_sheet_api", includes = { "<stdint.h>" })
public enum CSSStyleSheetImplSignature implements NativeSignatureEntry {
    GET_OWNER_RULE("jfxpanama_dom_CSSStyleSheet_getOwnerRule",
            Signature.of(DomKind.CSS_RULE, DomKind.CSS_STYLE_SHEET)),
    GET_CSS_RULES("jfxpanama_dom_CSSStyleSheet_getCssRules",
            Signature.of(DomKind.CSS_RULE_LIST, DomKind.CSS_STYLE_SHEET)),
    GET_RULES("jfxpanama_dom_CSSStyleSheet_getRules",
            Signature.of(DomKind.CSS_RULE_LIST, DomKind.CSS_STYLE_SHEET)),
    INSERT_RULE("jfxpanama_dom_CSSStyleSheet_insertRule",
            Signature.of(PrimitiveKind.INT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_SHEET, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.INT)),
    DELETE_RULE("jfxpanama_dom_CSSStyleSheet_deleteRule",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_SHEET, PrimitiveKind.INT)),
    ADD_RULE("jfxpanama_dom_CSSStyleSheet_addRule",
            Signature.of(PrimitiveKind.INT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_SHEET, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.INT)),
    REMOVE_RULE("jfxpanama_dom_CSSStyleSheet_removeRule",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_SHEET, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    CSSStyleSheetImplSignature(String symbol, Signature signature) {
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
