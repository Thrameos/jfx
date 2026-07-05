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
#include "char16_string_exchange_support.h"

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

// String returns (plans/patterns/pattern-string-return.md).
void jfxpanama_dom_HTMLAnchorElement_getCharset(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::charsetAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getCoords(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::coordsAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getHreflang(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::hreflangAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getName(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getNameAttribute(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getPing(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::pingAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getRel(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::relAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getRev(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::revAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getShape(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::shapeAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getTarget(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::targetAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getType(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::typeAttr), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getText(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->text(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getHref(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getURLAttribute(WebCore::HTMLNames::hrefAttr).string(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getOrigin(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->origin(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getProtocol(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->protocol(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getUsername(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->username(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getPassword(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->password(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getHost(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->host(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getHostname(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->hostname(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getPort(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->port(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getPathname(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->pathname(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getSearch(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->search(), exchange);
}

void jfxpanama_dom_HTMLAnchorElement_getHash(Char16StringExchange* exchange, HTMLAnchorElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->hash(), exchange);
}

}
