package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSImportRuleImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_import_rule_api", includes = { "<stdint.h>" })
public enum CSSImportRuleImplSignature implements NativeSignatureEntry {
    GET_HREF("jfxpanama_dom_CSSImportRule_getHref",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_IMPORT_RULE)),
    GET_MEDIA("jfxpanama_dom_CSSImportRule_getMedia",
            Signature.of(DomKind.MEDIA_LIST, DomKind.CSS_IMPORT_RULE)),
    GET_STYLE_SHEET("jfxpanama_dom_CSSImportRule_getStyleSheet",
            Signature.of(DomKind.CSS_STYLE_SHEET, DomKind.CSS_IMPORT_RULE));

    private final String symbol;
    private final Signature signature;

    CSSImportRuleImplSignature(String symbol, Signature signature) {
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
