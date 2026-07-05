package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSValueListImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_value_list_api", includes = { "<stdint.h>" })
public enum CSSValueListImplSignature implements NativeSignatureEntry {
    GET_LENGTH("jfxpanama_dom_CSSValueList_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.CSS_VALUE_LIST)),
    ITEM("jfxpanama_dom_CSSValueList_item",
            Signature.of(DomKind.CSS_VALUE, DomKind.CSS_VALUE_LIST, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    CSSValueListImplSignature(String symbol, Signature signature) {
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
