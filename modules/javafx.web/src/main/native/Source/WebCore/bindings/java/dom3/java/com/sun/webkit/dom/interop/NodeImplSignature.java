package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
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
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),
    SET_PREFIX("jfxpanama_dom_Node_setPrefix",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),
    SET_TEXT_CONTENT("jfxpanama_dom_Node_setTextContent",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),
    IS_DEFAULT_NAMESPACE("jfxpanama_dom_Node_isDefaultNamespace",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),

    // Object-handle return + exception-forwarding combined
    // (plans/patterns/pattern-node-mutation.md): the exchange param leads,
    // same as every other exchange-carrying signature, but there is no
    // reserve()-backed result -- native never mints or hands back a fresh
    // handle. On success the Java Binding returns the *same* newChild/
    // oldChild peer the caller already passed in, exactly mirroring the old
    // JNI shim's `return JavaReturn<Node>(env, pnewChild)`.
    APPEND_CHILD("jfxpanama_dom_Node_appendChild",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.NODE, DomKind.NODE)),
    INSERT_BEFORE("jfxpanama_dom_Node_insertBefore",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.NODE, DomKind.NODE, DomKind.NODE)),
    REPLACE_CHILD("jfxpanama_dom_Node_replaceChild",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.NODE, DomKind.NODE, DomKind.NODE)),
    REMOVE_CHILD("jfxpanama_dom_Node_removeChild",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.NODE, DomKind.NODE)),

    // Re-sweep additions below.

    // Primitive getter (shape 1): no-arg, PrimitiveKind return only.
    GET_NODE_TYPE("jfxpanama_dom_Node_getNodeType",
            Signature.of(PrimitiveKind.SHORT, DomKind.NODE)),
    HAS_CHILD_NODES("jfxpanama_dom_Node_hasChildNodes",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE)),
    HAS_ATTRIBUTES("jfxpanama_dom_Node_hasAttributes",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE)),
    // void, no-arg action -- same "primitive shape" family as the getters/
    // setters above, just with a VOID return and no extra parameter.
    NORMALIZE("jfxpanama_dom_Node_normalize",
            Signature.of(PrimitiveKind.VOID, DomKind.NODE)),

    // String returns (shape 5): void downcall, exchange param leads.
    GET_NODE_VALUE("jfxpanama_dom_Node_getNodeValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE)),
    GET_NAMESPACE_URI("jfxpanama_dom_Node_getNamespaceURI",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE)),
    GET_LOCAL_NAME("jfxpanama_dom_Node_getLocalName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE)),
    GET_BASE_URI("jfxpanama_dom_Node_getBaseURI",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE)),
    GET_TEXT_CONTENT("jfxpanama_dom_Node_getTextContent",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE)),
    // String return (shape 5) combined with a real input string param
    // (shape 2), same as pattern-string-return.md describes for
    // lookupPrefix/lookupNamespaceURI.
    LOOKUP_PREFIX("jfxpanama_dom_Node_lookupPrefix",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),
    LOOKUP_NAMESPACE_URI("jfxpanama_dom_Node_lookupNamespaceURI",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.NODE, PrimitiveKind.UTF8_CSTRING)),

    // Object-handle return (shape 3): NamedNodeMap is an existing DomKind.
    GET_ATTRIBUTES("jfxpanama_dom_Node_getAttributes",
            Signature.of(DomKind.NAMED_NODE_MAP, DomKind.NODE)),

    // Object handle passed as a plain argument (shape 4): another Node peer,
    // not the self param and not the return, no exchange/exception involved.
    IS_SAME_NODE("jfxpanama_dom_Node_isSameNode",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE, DomKind.NODE)),
    IS_EQUAL_NODE("jfxpanama_dom_Node_isEqualNode",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE, DomKind.NODE)),
    COMPARE_DOCUMENT_POSITION("jfxpanama_dom_Node_compareDocumentPosition",
            Signature.of(PrimitiveKind.SHORT, DomKind.NODE, DomKind.NODE)),
    CONTAINS("jfxpanama_dom_Node_contains",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.NODE, DomKind.NODE)),

    // Object-handle return + exception-forwarding combined (shape 7): unlike
    // APPEND_CHILD/etc above, the downcall's own return IS a fresh DomKind.NODE
    // handle -- the exchange only ever carries error info via throwFn(), it
    // never reserve()s anything.
    CLONE_NODE("jfxpanama_dom_Node_cloneNode",
            Signature.of(DomKind.NODE, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.NODE, PrimitiveKind.BOOLEAN));

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
