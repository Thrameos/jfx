package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSValueImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_value_api", includes = { "<stdint.h>" })
public enum CSSValueImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_CSSValue_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.CSS_VALUE)),
    GET_CSS_TEXT("jfxpanama_dom_CSSValue_getCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_VALUE)),
    SET_CSS_TEXT("jfxpanama_dom_CSSValue_setCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_VALUE, PrimitiveKind.UTF8_CSTRING)),
    GET_CSS_VALUE_TYPE("jfxpanama_dom_CSSValue_getCssValueType",
            Signature.of(PrimitiveKind.SHORT, DomKind.CSS_VALUE));

    private final String symbol;
    private final Signature signature;

    CSSValueImplSignature(String symbol, Signature signature) {
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
