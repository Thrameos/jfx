// Panama downcall targets for WebCore::HTMLTableElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_table_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLTableElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/HTMLElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/HTMLTableCaptionElement.h>
#include <WebCore/HTMLTableElement.h>
#include <WebCore/HTMLTableSectionElement.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_table_element_api.hj"

extern "C" {

// Object-handle returns (plans/patterns/pattern-object-handle-return.md):
// one fresh ref handed to Java per call, same as the old JNI
// JavaReturn<T>. Repeat addresses are deduped entirely on the Java side by
// the existing NodeImpl.getCachedImpl()/dispose-on-cache-hit path.
Element* jfxpanama_dom_HTMLTableElement_getCaption(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->caption() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_getTHead(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->tHead() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_getTFoot(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->tFoot() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_createTHead(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->createTHead() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_createTFoot(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->createTFoot() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_createTBody(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->createTBody() }.leakRef();
}

Element* jfxpanama_dom_HTMLTableElement_createCaption(HTMLTableElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->createCaption() }.leakRef();
}

void jfxpanama_dom_HTMLTableElement_setAlign(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::alignAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setBgColor(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::bgcolorAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setBorder(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::borderAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setCellPadding(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::cellpaddingAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setCellSpacing(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::cellspacingAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setFrame(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::frameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setRules(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::rulesAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setSummary(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::summaryAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTableElement_setWidth(HTMLTableElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::widthAttr, AtomString { String::fromUTF8(value) });
}

}
