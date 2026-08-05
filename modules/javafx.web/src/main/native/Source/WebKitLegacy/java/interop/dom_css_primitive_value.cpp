// Panama downcall targets for WebCore::DeprecatedCSSOMPrimitiveValue (the
// real peer type behind com.sun.webkit.dom.CSSPrimitiveValueImpl, same as
// the old JNI shim's IMPL macro) -- see dom_element.cpp's header comment
// for the general shape.
//
// dom_css_primitive_value_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSPrimitiveValueImplSignature is the source of truth) -- never
// hand-edit it.
#include <WebCore/DeprecatedCSSOMCounter.h>
#include <WebCore/DeprecatedCSSOMPrimitiveValue.h>
#include <WebCore/DeprecatedCSSOMRGBColor.h>
#include <WebCore/DeprecatedCSSOMRect.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_primitive_value_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

short jfxpanama_dom_CSSPrimitiveValue_getPrimitiveType(DeprecatedCSSOMPrimitiveValue* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<short>(peer->primitiveType());
}

// setFloatValue/setStringValue are `static` on DeprecatedCSSOMPrimitiveValue
// and always return Exception{NoModificationAllowedError} (deprecated
// CSSOM values are read-only) -- calling through the instance pointer is
// legal C++ and matches the old JNI shim's IMPL->setFloatValue(...) exactly.
void jfxpanama_dom_CSSPrimitiveValue_setFloatValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer, short unitType, float floatValue)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setFloatValue(static_cast<unsigned short>(unitType), floatValue), exchange);
}

// Primitive return + exception forwarding (plans/patterns/pattern-exception-
// forwarding.md): getFloatValue returns ExceptionOr<float>, no single helper
// covers non-void ExceptionOr, so unwrap by hand (same shape as
// CSSMediaRule::insertRule).
float jfxpanama_dom_CSSPrimitiveValue_getFloatValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer, short unitType)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->getFloatValue(static_cast<unsigned short>(unitType));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return 0.0f;
    }
    return result.releaseReturnValue();
}

void jfxpanama_dom_CSSPrimitiveValue_setStringValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer, short stringType, const char* stringValue)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setStringValue(static_cast<unsigned short>(stringType), String::fromUTF8(stringValue)), exchange);
}

// String return + exception forwarding, same combined shape as
// CharacterData::substringData: getStringValue returns ExceptionOr<String>.
void jfxpanama_dom_CSSPrimitiveValue_getStringValue(Char16StringExchange* exchange, DeprecatedCSSOMPrimitiveValue* peer)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->getStringValue();
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return;
    }
    writeChar16String(result.releaseReturnValue(), exchange);
}

// Object-handle return + exception forwarding: getCounterValue/getRectValue/
// getRGBColorValue return ExceptionOr<Ref<T>> (never null on success, unlike
// the RefPtr-wrapping object-handle-return shims elsewhere) -- releaseReturnValue()
// yields a Ref<T> already holding the one ref this call mints, so leakRef()
// (not RefPtr{...}.leakRef()) hands that same ref to the Java side to dispose.
DeprecatedCSSOMCounter* jfxpanama_dom_CSSPrimitiveValue_getCounterValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->getCounterValue();
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return nullptr;
    }
    return &result.releaseReturnValue().leakRef();
}

DeprecatedCSSOMRect* jfxpanama_dom_CSSPrimitiveValue_getRectValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->getRectValue();
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return nullptr;
    }
    return &result.releaseReturnValue().leakRef();
}

DeprecatedCSSOMRGBColor* jfxpanama_dom_CSSPrimitiveValue_getRGBColorValue(Exchange* exchange, DeprecatedCSSOMPrimitiveValue* peer)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->getRGBColorValue();
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return nullptr;
    }
    return &result.releaseReturnValue().leakRef();
}

}
