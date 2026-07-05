// Panama downcall targets for WebCore::DeprecatedCSSOMValue (the peer type
// old JNI actually used for CSSValueImpl -- see dom_css_primitive_value.cpp's
// header comment for why the DOM-facing "CSSValue" class is the deprecated
// CSSOM wrapper, not the internal WebCore::CSSValue). dispose() is
// deliberately left as plain JNI, same rationale as dom_css_rule.cpp's
// header comment.
//
// dom_css_value_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSValueImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/DeprecatedCSSOMValue.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_value_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

// cssText() never throws.
void jfxpanama_dom_CSSValue_getCssText(Char16StringExchange* exchange, DeprecatedCSSOMValue* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->cssText(), exchange);
}

// setCssText() is a permanent no-op stub ("Will never implement.") that
// always returns an empty ExceptionOr<void> -- forwardIfException still
// applies for uniformity with every other setCssText downcall (CSSRuleImpl/
// CSSStyleDeclarationImpl), even though this one can never actually throw.
void jfxpanama_dom_CSSValue_setCssText(Exchange* exchange, DeprecatedCSSOMValue* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setCssText(String::fromUTF8(value)), exchange);
}

short jfxpanama_dom_CSSValue_getCssValueType(DeprecatedCSSOMValue* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<short>(peer->cssValueType());
}

}
