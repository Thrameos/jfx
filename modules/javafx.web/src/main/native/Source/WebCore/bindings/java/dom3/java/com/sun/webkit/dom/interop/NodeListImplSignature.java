package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.NodeListImpl}.
 *
 * <p>Confirms {@code plans/unresolve.md}'s open item: {@code NodeList.item(index)}
 * is structurally identical to {@code NamedNodeMapImplSignature.ITEM} (self +
 * {@code int index} -> object handle, out-of-range returns null) -- the only
 * new thing needed was {@link DomKind#NODE_LIST} itself, not a new shape.
 */
@NativeHeader(value = "dom_node_list_api", includes = { "<stdint.h>" })
public enum NodeListImplSignature implements NativeSignatureEntry {
    GET_LENGTH("jfxpanama_dom_NodeList_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.NODE_LIST)),
    ITEM("jfxpanama_dom_NodeList_item",
            Signature.of(DomKind.NODE, DomKind.NODE_LIST, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    NodeListImplSignature(String symbol, Signature signature) {
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
