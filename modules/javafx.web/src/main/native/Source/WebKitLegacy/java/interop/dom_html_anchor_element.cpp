// Panama downcall targets for WebCore::HTMLAnchorElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_anchor_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLAnchorElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/HTMLAnchorElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_anchor_element_api.hj"

extern "C" {

void jfxpanama_dom_HTMLAnchorElement_setCharset(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::charsetAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setCoords(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::coordsAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setHreflang(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::hreflangAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setName(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setPing(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::pingAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setRel(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::relAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setRev(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::revAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setShape(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::shapeAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setTarget(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::targetAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setType(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::typeAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setText(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setText(String::fromUTF8(value));
}

void jfxpanama_dom_HTMLAnchorElement_setHref(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::hrefAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setProtocol(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setProtocol(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setUsername(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setUsername(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setPassword(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setPassword(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setHost(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setHost(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setHostname(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setHostname(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setPort(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setPort(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setPathname(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setPathname(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setSearch(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSearch(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLAnchorElement_setHash(HTMLAnchorElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setHash(AtomString { String::fromUTF8(value) });
}

}
