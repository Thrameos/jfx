// Panama downcall targets for WebCore::Node -- see dom_element.cpp's header
// comment for the general shape (plain C ABI, real pointee types via
// DomKind, generated .hj header included after the real WebCore declaration
// is visible).
//
// dom_node_api.hj is GENERATED (com.sun.webkit.dom.interop.NodeImplSignature
// is the source of truth) -- never hand-edit it.
#include <WebCore/Document.h>
#include <WebCore/Element.h>
#include <WebCore/JSExecState.h>
#include <WebCore/Node.h>
#include <WebCore/NodeInlines.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_node_api.hj"

extern "C" {

// Object-handle return (plans/patterns/pattern-object-handle-return.md): one
// fresh ref handed to Java per call, same as the old JNI
// JavaReturn<Element>(env, WTF::getPtr(peer->parentElement())) --
// NodeImpl.getCachedImpl()'s existing dispose-on-cache-hit path (Java side)
// balances the redundant ref whenever this address is already wrapped.
Element* jfxpanama_dom_Node_getParentElement(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->parentElement() }.leakRef();
}

Node* jfxpanama_dom_Node_getParentNode(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->parentNode() }.leakRef();
}

Node* jfxpanama_dom_Node_getFirstChild(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->firstChild() }.leakRef();
}

Node* jfxpanama_dom_Node_getLastChild(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->lastChild() }.leakRef();
}

Node* jfxpanama_dom_Node_getPreviousSibling(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->previousSibling() }.leakRef();
}

Node* jfxpanama_dom_Node_getNextSibling(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->nextSibling() }.leakRef();
}

Document* jfxpanama_dom_Node_getOwnerDocument(Node* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Document> { peer->ownerDocument() }.leakRef();
}

void jfxpanama_dom_Node_setNodeValue(Node* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setNodeValue(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Node_setPrefix(Node* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setPrefix(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Node_setTextContent(Node* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setTextContent(String::fromUTF8(value));
}

bool jfxpanama_dom_Node_isDefaultNamespace(Node* peer, const char* namespaceURI)
{
    WebCore::JSMainThreadNullState state;
    return peer->isDefaultNamespace(AtomString { String::fromUTF8(namespaceURI) });
}

}
