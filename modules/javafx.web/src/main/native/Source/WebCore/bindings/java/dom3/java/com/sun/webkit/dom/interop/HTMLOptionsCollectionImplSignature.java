package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLOptionsCollectionImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_options_collection_api", includes = { "<stdint.h>" })
public enum HTMLOptionsCollectionImplSignature implements NativeSignatureEntry {
    GET_SELECTED_INDEX("jfxpanama_dom_HTMLOptionsCollection_getSelectedIndex",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_OPTIONS_COLLECTION)),
    SET_SELECTED_INDEX("jfxpanama_dom_HTMLOptionsCollection_setSelectedIndex",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPTIONS_COLLECTION, PrimitiveKind.INT)),
    GET_LENGTH("jfxpanama_dom_HTMLOptionsCollection_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_OPTIONS_COLLECTION)),
    SET_LENGTH("jfxpanama_dom_HTMLOptionsCollection_setLength",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.HTML_OPTIONS_COLLECTION, PrimitiveKind.INT)),
    NAMED_ITEM("jfxpanama_dom_HTMLOptionsCollection_namedItem",
            Signature.of(DomKind.NODE, DomKind.HTML_OPTIONS_COLLECTION, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLOptionsCollectionImplSignature(String symbol, Signature signature) {
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
