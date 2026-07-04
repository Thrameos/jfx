package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.NodeImpl}. Same split as
 * {@link ElementImplSignature} -- see that class's doc for why the
 * {@code Binder}-bound {@code MethodHandle}s live in {@link NodeImplBinding}
 * instead of here.
 */
@NativeHeader(value = "dom_node_api", includes = { "<stdint.h>" })
public enum NodeImplSignature implements NativeSignatureEntry {
    GET_PARENT_ELEMENT("jfxpanama_dom_Node_getParentElement",
            Signature.of(DomKind.ELEMENT, DomKind.NODE)),

    GET_PARENT_NODE("jfxpanama_dom_Node_getParentNode",
            Signature.of(DomKind.NODE, DomKind.NODE)),
    GET_FIRST_CHILD("jfxpanama_dom_Node_getFirstChild",
            Signature.of(DomKind.NODE, DomKind.NODE)),
    GET_LAST_CHILD("jfxpanama_dom_Node_getLastChild",
            Signature.of(DomKind.NODE, DomKind.NODE)),
    GET_PREVIOUS_SIBLING("jfxpanama_dom_Node_getPreviousSibling",
            Signature.of(DomKind.NODE, DomKind.NODE)),
    GET_NEXT_SIBLING("jfxpanama_dom_Node_getNextSibling",
            Signature.of(DomKind.NODE, DomKind.NODE)),
    GET_OWNER_DOCUMENT("jfxpanama_dom_Node_getOwnerDocument",
            Signature.of(DomKind.DOCUMENT, DomKind.NODE)),

    SET_NODE_VALUE("jfxpanama_dom_Node_setNodeValue",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.STRING)),
    SET_PREFIX("jfxpanama_dom_Node_setPrefix",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.STRING)),
    SET_TEXT_CONTENT("jfxpanama_dom_Node_setTextContent",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.STRING)),
    IS_DEFAULT_NAMESPACE("jfxpanama_dom_Node_isDefaultNamespace",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE, PrimitiveKind.STRING));

    private final String symbol;
    private final Signature signature;

    NodeImplSignature(String symbol, Signature signature) {
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
