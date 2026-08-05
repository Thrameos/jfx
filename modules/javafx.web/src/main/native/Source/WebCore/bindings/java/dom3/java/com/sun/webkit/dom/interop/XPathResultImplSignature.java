package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.XPathResultImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_x_path_result_api", includes = { "<stdint.h>" })
public enum XPathResultImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_XPathResult_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.X_PATH_RESULT)),
    GET_RESULT_TYPE("jfxpanama_dom_XPathResult_getResultType",
            Signature.of(PrimitiveKind.SHORT, DomKind.X_PATH_RESULT)),
    GET_NUMBER_VALUE("jfxpanama_dom_XPathResult_getNumberValue",
            Signature.of(PrimitiveKind.DOUBLE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT)),
    GET_STRING_VALUE("jfxpanama_dom_XPathResult_getStringValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.X_PATH_RESULT)),
    GET_BOOLEAN_VALUE("jfxpanama_dom_XPathResult_getBooleanValue",
            Signature.of(PrimitiveKind.BOOLEAN, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT)),
    GET_SINGLE_NODE_VALUE("jfxpanama_dom_XPathResult_getSingleNodeValue",
            Signature.of(DomKind.NODE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT)),
    GET_INVALID_ITERATOR_STATE("jfxpanama_dom_XPathResult_getInvalidIteratorState",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.X_PATH_RESULT)),
    GET_SNAPSHOT_LENGTH("jfxpanama_dom_XPathResult_getSnapshotLength",
            Signature.of(PrimitiveKind.INT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT)),
    ITERATE_NEXT("jfxpanama_dom_XPathResult_iterateNext",
            Signature.of(DomKind.NODE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT)),
    SNAPSHOT_ITEM("jfxpanama_dom_XPathResult_snapshotItem",
            Signature.of(DomKind.NODE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.X_PATH_RESULT, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    XPathResultImplSignature(String symbol, Signature signature) {
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
