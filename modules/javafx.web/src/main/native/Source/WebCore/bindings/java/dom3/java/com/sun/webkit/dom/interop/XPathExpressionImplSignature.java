package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.XPathExpressionImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_x_path_expression_api", includes = { "<stdint.h>" })
public enum XPathExpressionImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_XPathExpression_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.X_PATH_EXPRESSION)),
    EVALUATE("jfxpanama_dom_XPathExpression_evaluate",
            Signature.of(DomKind.X_PATH_RESULT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_EXPRESSION, DomKind.NODE, PrimitiveKind.SHORT, DomKind.X_PATH_RESULT));

    private final String symbol;
    private final Signature signature;

    XPathExpressionImplSignature(String symbol, Signature signature) {
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
