package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.NamedNodeMapImpl}.
 *
 * <p>{@code ITEM} is the collection/index-style object return (plans/
 * patterns/pattern-collection-item.md): self + {@code int index} -> object
 * handle, out-of-range returns null. Structurally identical to every other
 * proven object-handle-return shape (e.g. {@code ElementImplSignature.
 * GET_FIRST_ELEMENT_CHILD}) -- the extra {@code int} parameter isn't new,
 * and the returned {@code Attr*} routes through {@code NodeImpl.getImpl}'s
 * existing dispose-on-cache-hit machinery exactly like every other
 * Node-returning downcall. No new Kind or exchange shape needed.
 */
@NativeHeader(value = "dom_named_node_map_api", includes = { "<stdint.h>" })
public enum NamedNodeMapImplSignature implements NativeSignatureEntry {
    GET_LENGTH("jfxpanama_dom_NamedNodeMap_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.NAMED_NODE_MAP)),
    ITEM("jfxpanama_dom_NamedNodeMap_item",
            Signature.of(DomKind.ATTR, DomKind.NAMED_NODE_MAP, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    NamedNodeMapImplSignature(String symbol, Signature signature) {
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
