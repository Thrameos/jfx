// Panama downcall targets for WebCore::HTMLTextAreaElement -- plain C ABI, no
// JNIEnv/jclass, no JNI machinery. peer is a real HTMLTextAreaElement* (com.
// sun.webkit.dom.interop.DomKind.HTML_TEXT_AREA_ELEMENT) -- see
// dom_element.cpp's header comment for the general shape.
//
// dom_html_text_area_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLTextAreaElementImplSignature is the source of truth) -- never hand-edit
// it, see plans/patterns/pattern-interop-binding-generation.md.
//
// NOTE: setAutocomplete has no shim here -- confirmed via `nm -D` on the
// built .so to have no working JNI implementation at all, so migrating it
// would be new functionality, not a migration (same reasoning as the phantom
// methods reverted in ElementImpl/DocumentImpl/HTMLInputElementImpl).
// getAutocomplete IS here -- its old JNI implementation is real.
#include <WebCore/HTMLFormElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/HTMLTextAreaElement.h>
#include <WebCore/JSExecState.h>
#include <WebCore/NodeList.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_text_area_element_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

// Primitive getter/setter (plans/patterns/pattern-primitive-getter-setter.md).
bool jfxpanama_dom_HTMLTextAreaElement_getAutofocus(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::autofocusAttr);
}

void jfxpanama_dom_HTMLTextAreaElement_setAutofocus(HTMLTextAreaElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::autofocusAttr, value);
}

bool jfxpanama_dom_HTMLTextAreaElement_getDisabled(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::disabledAttr);
}

void jfxpanama_dom_HTMLTextAreaElement_setDisabled(HTMLTextAreaElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::disabledAttr, value);
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getMaxLength(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->maxLength();
}

// Old JNI never checked setMaxLengthImpl's ExceptionOr<void> -- preserved
// as-is (discarded) rather than newly wired up during migration.
void jfxpanama_dom_HTMLTextAreaElement_setMaxLength(HTMLTextAreaElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setMaxLength(value);
}

bool jfxpanama_dom_HTMLTextAreaElement_getReadOnly(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::readonlyAttr);
}

void jfxpanama_dom_HTMLTextAreaElement_setReadOnly(HTMLTextAreaElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::readonlyAttr, value);
}

bool jfxpanama_dom_HTMLTextAreaElement_getRequired(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::requiredAttr);
}

void jfxpanama_dom_HTMLTextAreaElement_setRequired(HTMLTextAreaElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::requiredAttr, value);
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getRows(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->rows();
}

void jfxpanama_dom_HTMLTextAreaElement_setRows(HTMLTextAreaElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setRows(value);
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getCols(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->cols();
}

void jfxpanama_dom_HTMLTextAreaElement_setCols(HTMLTextAreaElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setCols(value);
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getTextLength(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->textLength();
}

bool jfxpanama_dom_HTMLTextAreaElement_getWillValidate(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->willValidate();
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getSelectionStart(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->selectionStart();
}

void jfxpanama_dom_HTMLTextAreaElement_setSelectionStart(HTMLTextAreaElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectionStart(value);
}

int32_t jfxpanama_dom_HTMLTextAreaElement_getSelectionEnd(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->selectionEnd();
}

void jfxpanama_dom_HTMLTextAreaElement_setSelectionEnd(HTMLTextAreaElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectionEnd(value);
}

bool jfxpanama_dom_HTMLTextAreaElement_checkValidity(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->checkValidity();
}

void jfxpanama_dom_HTMLTextAreaElement_select(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    peer->select();
}

// Input-only string args (plans/patterns/pattern-input-only-string.md).
void jfxpanama_dom_HTMLTextAreaElement_setDirName(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::dirnameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setName(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setPlaceholder(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::placeholderAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setWrap(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::wrapAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setDefaultValue(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setDefaultValue(String::fromUTF8(value));
}

// Old JNI never checked setValueImpl's ExceptionOr<void> -- preserved as-is.
void jfxpanama_dom_HTMLTextAreaElement_setValue(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setValue(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setSelectionDirection(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectionDirection(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setAccessKey(HTMLTextAreaElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::accesskeyAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLTextAreaElement_setCustomValidity(HTMLTextAreaElement* peer, const char* error)
{
    WebCore::JSMainThreadNullState state;
    peer->setCustomValidity(AtomString { String::fromUTF8(error) });
}

// Plain multi-arg (int, int, string), void, no exception forwarding -- old
// JNI's setSelectionRangeImpl never calls raiseOnDOMError, same discard-on-
// purpose rationale as setMaxLength/setValue above.
void jfxpanama_dom_HTMLTextAreaElement_setSelectionRange(HTMLTextAreaElement* peer, int32_t start, int32_t end,
        const char* direction)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectionRange(start, end, AtomString { String::fromUTF8(direction) });
}

// String returns (plans/patterns/pattern-string-return.md).
void jfxpanama_dom_HTMLTextAreaElement_getDirName(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::dirnameAttr), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getName(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getNameAttribute(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getPlaceholder(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::placeholderAttr), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getWrap(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::wrapAttr), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getType(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->type(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getDefaultValue(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->defaultValue(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getValue(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->value(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getValidationMessage(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->validationMessage(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getSelectionDirection(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->selectionDirection(), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getAccessKey(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::accesskeyAttr), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_getAutocomplete(Char16StringExchange* exchange, HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->autocomplete(), exchange);
}

// Object-handle returns (plans/patterns/pattern-object-handle-return.md).
HTMLFormElement* jfxpanama_dom_HTMLTextAreaElement_getForm(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<HTMLFormElement> { peer->form() }.leakRef();
}

NodeList* jfxpanama_dom_HTMLTextAreaElement_getLabels(HTMLTextAreaElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<NodeList> { peer->labels() }.leakRef();
}

// Exception forwarding (plans/patterns/pattern-exception-forwarding.md).
void jfxpanama_dom_HTMLTextAreaElement_setRangeText(Exchange* exchange, HTMLTextAreaElement* peer,
        const char* replacement)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setRangeText(StringView(String::fromUTF8(replacement))), exchange);
}

void jfxpanama_dom_HTMLTextAreaElement_setRangeTextEx(Exchange* exchange, HTMLTextAreaElement* peer,
        const char* replacement, int32_t start, int32_t end, const char* selectionMode)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setRangeText(StringView(String::fromUTF8(replacement)), start, end,
            String::fromUTF8(selectionMode)), exchange);
}

}
