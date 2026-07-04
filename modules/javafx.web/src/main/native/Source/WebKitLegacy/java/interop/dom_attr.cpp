// Panama downcall targets for WebCore::Attr -- see dom_element.cpp's header
// comment for the general shape.
//
// dom_attr_api.hj is GENERATED (com.sun.webkit.dom.interop.AttrImplSignature
// is the source of truth) -- never hand-edit it.
#include <WebCore/Attr.h>
#include <WebCore/Element.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_attr_api.hj"

extern "C" {

bool jfxpanama_dom_Attr_getSpecified(Attr* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->specified();
}

bool jfxpanama_dom_Attr_isId(Attr* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->qualifiedName().matches(WebCore::HTMLNames::idAttr);
}

void jfxpanama_dom_Attr_setValue(Attr* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setValue(AtomString { String::fromUTF8(value) });
}

// Object-handle return (plans/patterns/pattern-object-handle-return.md): one
// fresh ref handed to Java per call, same as the old JNI JavaReturn<Element>.
Element* jfxpanama_dom_Attr_getOwnerElement(Attr* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->ownerElement() }.leakRef();
}

}
