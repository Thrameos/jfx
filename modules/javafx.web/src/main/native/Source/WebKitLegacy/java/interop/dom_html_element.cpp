// Panama downcall targets for WebCore::HTMLElement -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_html_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLElementImplSignature is the source of truth) -- never hand-edit it.
//
// getTabIndex/setTabIndex are deliberately not present here -- see
// HTMLElementImplSignature's class doc.
#include <WebCore/HTMLElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_element_api.hj"

extern "C" {

bool jfxpanama_dom_HTMLElement_getTranslate(HTMLElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->translate();
}

void jfxpanama_dom_HTMLElement_setTranslate(HTMLElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setTranslate(value);
}

bool jfxpanama_dom_HTMLElement_getDraggable(HTMLElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->draggable();
}

void jfxpanama_dom_HTMLElement_setDraggable(HTMLElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setDraggable(value);
}

bool jfxpanama_dom_HTMLElement_getHidden(HTMLElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::hiddenAttr);
}

void jfxpanama_dom_HTMLElement_setHidden(HTMLElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::hiddenAttr, value);
}

bool jfxpanama_dom_HTMLElement_getIsContentEditable(HTMLElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->isContentEditable();
}

bool jfxpanama_dom_HTMLElement_getSpellcheck(HTMLElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->spellcheck();
}

void jfxpanama_dom_HTMLElement_setSpellcheck(HTMLElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSpellcheck(value);
}

void jfxpanama_dom_HTMLElement_setId(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::idAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLElement_setTitle(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::titleAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLElement_setLang(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::langAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLElement_setWebkitdropzone(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::webkitdropzoneAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLElement_setAccessKey(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::accesskeyAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLElement_setInnerText(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setInnerText(String::fromUTF8(value));
}

void jfxpanama_dom_HTMLElement_setOuterText(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setOuterText(String::fromUTF8(value));
}

void jfxpanama_dom_HTMLElement_setContentEditable(HTMLElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setContentEditable(String::fromUTF8(value));
}

}
