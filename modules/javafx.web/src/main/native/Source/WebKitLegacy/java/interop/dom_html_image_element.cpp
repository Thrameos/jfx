// Panama downcall targets for WebCore::HTMLImageElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_image_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLImageElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/HTMLImageElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_image_element_api.hj"

extern "C" {

bool jfxpanama_dom_HTMLImageElement_getIsMap(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::ismapAttr);
}

void jfxpanama_dom_HTMLImageElement_setIsMap(HTMLImageElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::ismapAttr, value);
}

bool jfxpanama_dom_HTMLImageElement_getComplete(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->complete();
}

int32_t jfxpanama_dom_HTMLImageElement_getNaturalHeight(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->naturalHeight();
}

int32_t jfxpanama_dom_HTMLImageElement_getNaturalWidth(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->naturalWidth();
}

int32_t jfxpanama_dom_HTMLImageElement_getX(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->x();
}

int32_t jfxpanama_dom_HTMLImageElement_getY(HTMLImageElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->y();
}

void jfxpanama_dom_HTMLImageElement_setName(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setAlign(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::alignAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setAlt(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::altAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setBorder(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::borderAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setLongDesc(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::longdescAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setSrc(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::srcAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setSrcset(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::srcsetAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setSizes(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::sizesAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setUseMap(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::usemapAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLImageElement_setLowsrc(HTMLImageElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::lowsrcAttr, AtomString { String::fromUTF8(value) });
}

}
