// Panama downcall targets for WebCore::HTMLBodyElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_body_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLBodyElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/HTMLBodyElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_body_element_api.hj"

extern "C" {

void jfxpanama_dom_HTMLBodyElement_setALink(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::alinkAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLBodyElement_setBackground(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::backgroundAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLBodyElement_setBgColor(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::bgcolorAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLBodyElement_setLink(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::linkAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLBodyElement_setText(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::textAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLBodyElement_setVLink(HTMLBodyElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::vlinkAttr, AtomString { String::fromUTF8(value) });
}

}
