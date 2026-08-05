package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSPageRuleImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_page_rule_api", includes = { "<stdint.h>" })
public enum CSSPageRuleImplSignature implements NativeSignatureEntry {
    GET_SELECTOR_TEXT("jfxpanama_dom_CSSPageRule_getSelectorText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_PAGE_RULE)),
    SET_SELECTOR_TEXT("jfxpanama_dom_CSSPageRule_setSelectorText",
            Signature.of(PrimitiveKind.VOID, DomKind.CSS_PAGE_RULE, PrimitiveKind.UTF8_CSTRING)),
    GET_STYLE("jfxpanama_dom_CSSPageRule_getStyle",
            Signature.of(DomKind.CSS_STYLE_DECLARATION, DomKind.CSS_PAGE_RULE));

    private final String symbol;
    private final Signature signature;

    CSSPageRuleImplSignature(String symbol, Signature signature) {
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
