// Panama downcall targets for WebCore::NamedNodeMap -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_named_node_map_api.hj is GENERATED (com.sun.webkit.dom.interop.
// NamedNodeMapImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/Attr.h>
#include <WebCore/JSExecState.h>
#include <WebCore/NamedNodeMap.h>

using namespace WebCore;

#include "dom_named_node_map_api.hj"

extern "C" {

int32_t jfxpanama_dom_NamedNodeMap_getLength(NamedNodeMap* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->length();
}

// Collection/index-style object return (plans/patterns/pattern-collection-
// item.md): self + int index -> object handle, same fresh-ref-per-call
// shape as every other object-handle return (pattern-object-handle-
// return.md) -- item()'s RefPtr<Attr> is already null for an out-of-range
// index, round-tripping as a null MemorySegment/Java null for free, no
// special-casing needed. NodeImpl.getCachedImpl's existing dispose-on-
// cache-hit path balances the ref exactly like it does for every other
// Node-returning downcall.
Attr* jfxpanama_dom_NamedNodeMap_item(NamedNodeMap* peer, int32_t index)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Attr> { peer->item(static_cast<unsigned>(index)) }.leakRef();
}

}
