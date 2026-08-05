package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSRuleImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_rule_api", includes = { "<stdint.h>" })
public enum CSSRuleImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_CSSRule_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.CSS_RULE)),
    GET_TYPE("jfxpanama_dom_CSSRule_getType",
            Signature.of(PrimitiveKind.SHORT, DomKind.CSS_RULE)),
    GET_CSS_TEXT("jfxpanama_dom_CSSRule_getCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_RULE)),
    SET_CSS_TEXT("jfxpanama_dom_CSSRule_setCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_RULE, PrimitiveKind.UTF8_CSTRING)),
    GET_PARENT_STYLE_SHEET("jfxpanama_dom_CSSRule_getParentStyleSheet",
            Signature.of(DomKind.CSS_STYLE_SHEET, DomKind.CSS_RULE)),
    GET_PARENT_RULE("jfxpanama_dom_CSSRule_getParentRule",
            Signature.of(DomKind.CSS_RULE, DomKind.CSS_RULE));

    private final String symbol;
    private final Signature signature;

    CSSRuleImplSignature(String symbol, Signature signature) {
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
