package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.NodeIteratorImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_node_iterator_api", includes = { "<stdint.h>" })
public enum NodeIteratorImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_NodeIterator_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE_ITERATOR)),
    GET_ROOT("jfxpanama_dom_NodeIterator_getRoot",
            Signature.of(DomKind.NODE, DomKind.NODE_ITERATOR)),
    GET_WHAT_TO_SHOW("jfxpanama_dom_NodeIterator_getWhatToShow",
            Signature.of(PrimitiveKind.INT, DomKind.NODE_ITERATOR)),
    GET_FILTER("jfxpanama_dom_NodeIterator_getFilter",
            Signature.of(DomKind.NODE_FILTER, DomKind.NODE_ITERATOR)),
    GET_EXPAND_ENTITY_REFERENCES("jfxpanama_dom_NodeIterator_getExpandEntityReferences",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE_ITERATOR)),
    GET_REFERENCE_NODE("jfxpanama_dom_NodeIterator_getReferenceNode",
            Signature.of(DomKind.NODE, DomKind.NODE_ITERATOR)),
    GET_POINTER_BEFORE_REFERENCE_NODE("jfxpanama_dom_NodeIterator_getPointerBeforeReferenceNode",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE_ITERATOR)),
    NEXT_NODE("jfxpanama_dom_NodeIterator_nextNode",
            Signature.of(DomKind.NODE, DomKind.NODE_ITERATOR)),
    PREVIOUS_NODE("jfxpanama_dom_NodeIterator_previousNode",
            Signature.of(DomKind.NODE, DomKind.NODE_ITERATOR)),
    DETACH("jfxpanama_dom_NodeIterator_detach",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE_ITERATOR));

    private final String symbol;
    private final Signature signature;

    NodeIteratorImplSignature(String symbol, Signature signature) {
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
