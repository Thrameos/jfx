// Panama downcall targets for WebCore::HTMLFormElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_form_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLFormElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/HTMLFormElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_form_element_api.hj"

extern "C" {

bool jfxpanama_dom_HTMLFormElement_getNoValidate(HTMLFormElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::novalidateAttr);
}

void jfxpanama_dom_HTMLFormElement_setNoValidate(HTMLFormElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::novalidateAttr, value);
}

int32_t jfxpanama_dom_HTMLFormElement_getLength(HTMLFormElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->length();
}

bool jfxpanama_dom_HTMLFormElement_checkValidity(HTMLFormElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->checkValidity();
}

void jfxpanama_dom_HTMLFormElement_setAcceptCharset(HTMLFormElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::accept_charsetAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLFormElement_setAction(HTMLFormElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::actionAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLFormElement_setName(HTMLFormElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLFormElement_setTarget(HTMLFormElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::targetAttr, AtomString { String::fromUTF8(value) });
}

}
