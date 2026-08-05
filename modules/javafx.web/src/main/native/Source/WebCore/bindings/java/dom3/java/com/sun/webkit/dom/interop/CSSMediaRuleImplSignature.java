package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSMediaRuleImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_media_rule_api", includes = { "<stdint.h>" })
public enum CSSMediaRuleImplSignature implements NativeSignatureEntry {
    GET_MEDIA("jfxpanama_dom_CSSMediaRule_getMedia",
            Signature.of(DomKind.MEDIA_LIST, DomKind.CSS_MEDIA_RULE)),
    GET_CSS_RULES("jfxpanama_dom_CSSMediaRule_getCssRules",
            Signature.of(DomKind.CSS_RULE_LIST, DomKind.CSS_MEDIA_RULE)),
    INSERT_RULE("jfxpanama_dom_CSSMediaRule_insertRule",
            Signature.of(PrimitiveKind.INT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_MEDIA_RULE, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.INT)),
    DELETE_RULE("jfxpanama_dom_CSSMediaRule_deleteRule",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_MEDIA_RULE, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    CSSMediaRuleImplSignature(String symbol, Signature signature) {
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
