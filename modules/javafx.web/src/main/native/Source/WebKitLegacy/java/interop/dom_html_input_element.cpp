// Panama downcall targets for WebCore::HTMLInputElement -- plain C ABI, no
// JNIEnv/jclass, no JNI machinery. peer is a real HTMLInputElement* (com.sun.
// webkit.dom.interop.DomKind.HTML_INPUT_ELEMENT) -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_html_input_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// HTMLInputElementImplSignature is the source of truth) -- never hand-edit
// it, see plans/patterns/pattern-interop-binding-generation.md.
//
// NOTE: getIncremental/setIncremental and getDefaultValue/setDefaultValue
// have no shim here -- confirmed via `nm -D` on the built .so to have no
// working JNI implementation at all, so migrating them would be new
// functionality, not a migration (same reasoning as the 10 phantom methods
// reverted in ElementImpl/DocumentImpl). getValueAsDate/setValueAsDate also
// have no shim here -- deferred, not phantom: the old JNI implementation is
// real but round-trips a WallTime through
// `approximateMonotonicTime().get_time_value()`, a time-representation shape
// with no proven Panama pattern yet.
#include <WebCore/HTMLFormElement.h>
#include <WebCore/HTMLInputElement.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <WebCore/NodeList.h>
#include <wtf/text/StringToIntegerConversion.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_html_input_element_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

// Primitive getter/setter (plans/patterns/pattern-primitive-getter-setter.md).
bool jfxpanama_dom_HTMLInputElement_getAutofocus(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::autofocusAttr);
}

void jfxpanama_dom_HTMLInputElement_setAutofocus(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::autofocusAttr, value);
}

bool jfxpanama_dom_HTMLInputElement_getDefaultChecked(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::checkedAttr);
}

void jfxpanama_dom_HTMLInputElement_setDefaultChecked(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::checkedAttr, value);
}

bool jfxpanama_dom_HTMLInputElement_getChecked(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->checked();
}

void jfxpanama_dom_HTMLInputElement_setChecked(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setChecked(value);
}

bool jfxpanama_dom_HTMLInputElement_getDisabled(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::disabledAttr);
}

void jfxpanama_dom_HTMLInputElement_setDisabled(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::disabledAttr, value);
}

bool jfxpanama_dom_HTMLInputElement_getFormNoValidate(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::formnovalidateAttr);
}

void jfxpanama_dom_HTMLInputElement_setFormNoValidate(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::formnovalidateAttr, value);
}

int32_t jfxpanama_dom_HTMLInputElement_getHeight(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->height();
}

bool jfxpanama_dom_HTMLInputElement_getIndeterminate(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->indeterminate();
}

void jfxpanama_dom_HTMLInputElement_setIndeterminate(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setIndeterminate(value);
}

int32_t jfxpanama_dom_HTMLInputElement_getMaxLength(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->maxLength();
}

// Old JNI never checked setMaxLengthImpl's ExceptionOr<void> -- preserved
// as-is (discarded) rather than newly wired up during migration.
void jfxpanama_dom_HTMLInputElement_setMaxLength(HTMLInputElement* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setMaxLength(value);
}

bool jfxpanama_dom_HTMLInputElement_getMultiple(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::multipleAttr);
}

void jfxpanama_dom_HTMLInputElement_setMultiple(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::multipleAttr, value);
}

bool jfxpanama_dom_HTMLInputElement_getReadOnly(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::readonlyAttr);
}

void jfxpanama_dom_HTMLInputElement_setReadOnly(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::readonlyAttr, value);
}

bool jfxpanama_dom_HTMLInputElement_getRequired(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(WebCore::HTMLNames::requiredAttr);
}

void jfxpanama_dom_HTMLInputElement_setRequired(HTMLInputElement* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setBooleanAttribute(WebCore::HTMLNames::requiredAttr, value);
}

double jfxpanama_dom_HTMLInputElement_getValueAsNumber(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->valueAsNumber();
}

// Old JNI never checked setValueAsNumberImpl's ExceptionOr<void> either --
// same discard-on-purpose rationale as setMaxLength above.
void jfxpanama_dom_HTMLInputElement_setValueAsNumber(HTMLInputElement* peer, double value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setValueAsNumber(value);
}

int32_t jfxpanama_dom_HTMLInputElement_getWidth(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->width();
}

bool jfxpanama_dom_HTMLInputElement_getWillValidate(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->willValidate();
}

bool jfxpanama_dom_HTMLInputElement_checkValidity(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->checkValidity();
}

void jfxpanama_dom_HTMLInputElement_select(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    peer->select();
}

void jfxpanama_dom_HTMLInputElement_click(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    peer->click();
}

// Input-only string args (plans/patterns/pattern-input-only-string.md).
void jfxpanama_dom_HTMLInputElement_setAccept(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::acceptAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setAlt(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::altAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setDirName(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::dirnameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setFormTarget(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::formtargetAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setMax(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::maxAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setMin(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::minAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setName(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::nameAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setPattern(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::patternAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setPlaceholder(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::placeholderAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setSrc(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::srcAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setStep(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::stepAttr, AtomString { String::fromUTF8(value) });
}

// Old JNI never checked setValueImpl's ExceptionOr<void> -- preserved as-is.
void jfxpanama_dom_HTMLInputElement_setValue(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setValue(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setAlign(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::alignAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setUseMap(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::usemapAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setAccessKey(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(WebCore::HTMLNames::accesskeyAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_HTMLInputElement_setCustomValidity(HTMLInputElement* peer, const char* error)
{
    WebCore::JSMainThreadNullState state;
    peer->setCustomValidity(AtomString { String::fromUTF8(error) });
}

void jfxpanama_dom_HTMLInputElement_setValueForUser(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setValueForUser(AtomString { String::fromUTF8(value) });
}

// Old JNI parses the string to an int before calling WebCore's setSize(int)
// (an ExceptionOr<void> it also never checked) -- same shape preserved here.
void jfxpanama_dom_HTMLInputElement_setSize(HTMLInputElement* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    (void) peer->setSize(parseIntegerAllowingTrailingJunk<int>(StringView(String::fromUTF8(value))).value());
}

// String returns (plans/patterns/pattern-string-return.md).
void jfxpanama_dom_HTMLInputElement_getAccept(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::acceptAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getAlt(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::altAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getAutocomplete(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->autocomplete(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getDirName(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::dirnameAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getFormAction(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->formAction(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getFormEnctype(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->formEnctype(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getFormMethod(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->formMethod(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getFormTarget(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::formtargetAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getMax(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::maxAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getMin(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::minAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getName(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getNameAttribute(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getPattern(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::patternAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getPlaceholder(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::placeholderAttr), exchange);
}

// Old JNI's getSizeImpl returns String::number(IMPL->size()) -- the native
// shim keeps doing the int->string conversion, not Java.
void jfxpanama_dom_HTMLInputElement_getSize(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(String::number(peer->size()), exchange);
}

void jfxpanama_dom_HTMLInputElement_getSrc(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getURLAttribute(WebCore::HTMLNames::srcAttr).string(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getStep(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::stepAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getType(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->type(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getValue(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->value(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getValidationMessage(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->validationMessage(), exchange);
}

void jfxpanama_dom_HTMLInputElement_getAlign(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::alignAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getUseMap(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::usemapAttr), exchange);
}

void jfxpanama_dom_HTMLInputElement_getAccessKey(Char16StringExchange* exchange, HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getAttribute(WebCore::HTMLNames::accesskeyAttr), exchange);
}

// Object-handle returns (plans/patterns/pattern-object-handle-return.md).
HTMLFormElement* jfxpanama_dom_HTMLInputElement_getForm(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<HTMLFormElement> { peer->form() }.leakRef();
}

NodeList* jfxpanama_dom_HTMLInputElement_getLabels(HTMLInputElement* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<NodeList> { peer->labels() }.leakRef();
}

// Exception forwarding (plans/patterns/pattern-exception-forwarding.md).
void jfxpanama_dom_HTMLInputElement_stepUp(Exchange* exchange, HTMLInputElement* peer, int32_t n)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->stepUp(n), exchange);
}

void jfxpanama_dom_HTMLInputElement_stepDown(Exchange* exchange, HTMLInputElement* peer, int32_t n)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->stepDown(n), exchange);
}

void jfxpanama_dom_HTMLInputElement_setRangeText(Exchange* exchange, HTMLInputElement* peer, const char* replacement)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setRangeText(StringView(String::fromUTF8(replacement))), exchange);
}

void jfxpanama_dom_HTMLInputElement_setRangeTextEx(Exchange* exchange, HTMLInputElement* peer,
        const char* replacement, int32_t start, int32_t end, const char* selectionMode)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setRangeText(StringView(String::fromUTF8(replacement)), start, end,
            String::fromUTF8(selectionMode)), exchange);
}

}
