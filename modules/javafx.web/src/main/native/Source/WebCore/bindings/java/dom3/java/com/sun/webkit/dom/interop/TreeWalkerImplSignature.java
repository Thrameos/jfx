package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.TreeWalkerImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_tree_walker_api", includes = { "<stdint.h>" })
public enum TreeWalkerImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_TreeWalker_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.TREE_WALKER)),
    GET_ROOT("jfxpanama_dom_TreeWalker_getRoot",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    GET_WHAT_TO_SHOW("jfxpanama_dom_TreeWalker_getWhatToShow",
            Signature.of(PrimitiveKind.INT, DomKind.TREE_WALKER)),
    GET_FILTER("jfxpanama_dom_TreeWalker_getFilter",
            Signature.of(DomKind.NODE_FILTER, DomKind.TREE_WALKER)),
    GET_EXPAND_ENTITY_REFERENCES("jfxpanama_dom_TreeWalker_getExpandEntityReferences",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.TREE_WALKER)),
    GET_CURRENT_NODE("jfxpanama_dom_TreeWalker_getCurrentNode",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    SET_CURRENT_NODE("jfxpanama_dom_TreeWalker_setCurrentNode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.TREE_WALKER, DomKind.NODE)),
    PARENT_NODE("jfxpanama_dom_TreeWalker_parentNode",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    FIRST_CHILD("jfxpanama_dom_TreeWalker_firstChild",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    LAST_CHILD("jfxpanama_dom_TreeWalker_lastChild",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    PREVIOUS_SIBLING("jfxpanama_dom_TreeWalker_previousSibling",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    NEXT_SIBLING("jfxpanama_dom_TreeWalker_nextSibling",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    PREVIOUS_NODE("jfxpanama_dom_TreeWalker_previousNode",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER)),
    NEXT_NODE("jfxpanama_dom_TreeWalker_nextNode",
            Signature.of(DomKind.NODE, DomKind.TREE_WALKER));

    private final String symbol;
    private final Signature signature;

    TreeWalkerImplSignature(String symbol, Signature signature) {
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
