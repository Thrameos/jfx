// Panama downcall targets for WebCore::HTMLSelectElement -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_select_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLSelectElementImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/Element.h>
#include <WebCore/HTMLFormElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/HTMLSelectElement.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_select_element_api.hj"

extern "C" {

bool jfxpanama_dom_HTMLSelectElement_getAutofocus(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::autofocusAttr);
}

void jfxpanama_dom_HTMLSelectElement_setAutofocus(HTMLSelectElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::autofocusAttr, value);
}

bool jfxpanama_dom_HTMLSelectElement_getDisabled(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::disabledAttr);
}

void jfxpanama_dom_HTMLSelectElement_setDisabled(HTMLSelectElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::disabledAttr, value);
}

bool jfxpanama_dom_HTMLSelectElement_getMultiple(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->multiple();
}

void jfxpanama_dom_HTMLSelectElement_setMultiple(HTMLSelectElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setMultiple(value);
}

bool jfxpanama_dom_HTMLSelectElement_getRequired(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::requiredAttr);
}

void jfxpanama_dom_HTMLSelectElement_setRequired(HTMLSelectElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::requiredAttr, value);
}

int32_t jfxpanama_dom_HTMLSelectElement_getSize(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->size();
}

void jfxpanama_dom_HTMLSelectElement_setSize(HTMLSelectElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSize(value);
}

int32_t jfxpanama_dom_HTMLSelectElement_getLength(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->length();
}

int32_t jfxpanama_dom_HTMLSelectElement_getSelectedIndex(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->selectedIndex();
}

void jfxpanama_dom_HTMLSelectElement_setSelectedIndex(HTMLSelectElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectedIndex(value);
}

bool jfxpanama_dom_HTMLSelectElement_getWillValidate(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->willValidate();
}

bool jfxpanama_dom_HTMLSelectElement_checkValidity(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->checkValidity();
}

void jfxpanama_dom_HTMLSelectElement_remove(HTMLSelectElement* peer, int32_t index)
{
    WebCore::JSMainThreadNullState state;
    peer->remove(index);
}

void jfxpanama_dom_HTMLSelectElement_setName(HTMLSelectElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLSelectElement_setValue(HTMLSelectElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setValue(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLSelectElement_setCustomValidity(HTMLSelectElement* peer, const char* error)
{
    WebCore::JSMainThreadNullState state;
    peer->setCustomValidity(AtomString { String::fromUTF8(error) });
}

// Object-handle return (plans/patterns/pattern-object-handle-return.md): one
// fresh ref handed to Java per call, same as the old JNI JavaReturn<T>.
Element* jfxpanama_dom_HTMLSelectElement_getForm(HTMLSelectElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->form() }.leakRef();
}

}
