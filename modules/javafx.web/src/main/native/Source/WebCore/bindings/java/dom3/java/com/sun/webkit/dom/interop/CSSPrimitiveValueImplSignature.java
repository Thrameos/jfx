package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSPrimitiveValueImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_primitive_value_api", includes = { "<stdint.h>" })
public enum CSSPrimitiveValueImplSignature implements NativeSignatureEntry {
    GET_PRIMITIVE_TYPE("jfxpanama_dom_CSSPrimitiveValue_getPrimitiveType",
            Signature.of(PrimitiveKind.SHORT, DomKind.CSS_PRIMITIVE_VALUE)),
    SET_FLOAT_VALUE("jfxpanama_dom_CSSPrimitiveValue_setFloatValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE, PrimitiveKind.SHORT, PrimitiveKind.FLOAT)),
    GET_FLOAT_VALUE("jfxpanama_dom_CSSPrimitiveValue_getFloatValue",
            Signature.of(PrimitiveKind.FLOAT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE, PrimitiveKind.SHORT)),
    SET_STRING_VALUE("jfxpanama_dom_CSSPrimitiveValue_setStringValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE, PrimitiveKind.SHORT, PrimitiveKind.UTF8_CSTRING)),
    GET_STRING_VALUE("jfxpanama_dom_CSSPrimitiveValue_getStringValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_PRIMITIVE_VALUE)),
    GET_COUNTER_VALUE("jfxpanama_dom_CSSPrimitiveValue_getCounterValue",
            Signature.of(DomKind.COUNTER, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE)),
    GET_RECT_VALUE("jfxpanama_dom_CSSPrimitiveValue_getRectValue",
            Signature.of(DomKind.RECT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE)),
    GET_RGB_COLOR_VALUE("jfxpanama_dom_CSSPrimitiveValue_getRGBColorValue",
            Signature.of(DomKind.RGB_COLOR, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_PRIMITIVE_VALUE));

    private final String symbol;
    private final Signature signature;

    CSSPrimitiveValueImplSignature(String symbol, Signature signature) {
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
