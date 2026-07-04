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
#include "char16_string_exchange_support.h"

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

void jfxpanama_dom_HTMLBodyElement_getALink(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::alinkAttr), exchange);
}

void jfxpanama_dom_HTMLBodyElement_getBackground(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::backgroundAttr), exchange);
}

void jfxpanama_dom_HTMLBodyElement_getBgColor(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::bgcolorAttr), exchange);
}

void jfxpanama_dom_HTMLBodyElement_getLink(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::linkAttr), exchange);
}

void jfxpanama_dom_HTMLBodyElement_getText(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::textAttr), exchange);
}

void jfxpanama_dom_HTMLBodyElement_getVLink(Char16StringExchange* exchange, HTMLBodyElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::vlinkAttr), exchange);
}

}
