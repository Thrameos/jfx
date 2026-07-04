// Panama downcall targets for WebCore::NodeList -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_node_list_api.hj is GENERATED (com.sun.webkit.dom.interop.
// NodeListImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/JSExecState.h>
#include <WebCore/Node.h>
#include <WebCore/NodeList.h>

using namespace WebCore;

#include "dom_node_list_api.hj"

extern "C" {

int32_t jfxpanama_dom_NodeList_getLength(NodeList* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->length();
}

// Collection/index-style object return (plans/patterns/pattern-collection-
// item.md), confirmed identical to NamedNodeMap.item's shape -- self + int
// index -> object handle, out-of-range index round-trips as null for free
// (RefPtr<Node>'s existing null case).
Node* jfxpanama_dom_NodeList_item(NodeList* peer, int32_t index)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Node> { peer->item(static_cast<unsigned>(index)) }.leakRef();
}

}
