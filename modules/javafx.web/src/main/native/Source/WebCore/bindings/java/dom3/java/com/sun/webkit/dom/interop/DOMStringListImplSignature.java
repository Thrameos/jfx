package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DOMStringListImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_dom_string_list_api", includes = { "<stdint.h>" })
public enum DOMStringListImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_DOMStringList_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_STRING_LIST)),
    GET_LENGTH("jfxpanama_dom_DOMStringList_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_STRING_LIST)),
    ITEM("jfxpanama_dom_DOMStringList_item",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_STRING_LIST, PrimitiveKind.INT)),
    CONTAINS("jfxpanama_dom_DOMStringList_contains",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOM_STRING_LIST, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    DOMStringListImplSignature(String symbol, Signature signature) {
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
