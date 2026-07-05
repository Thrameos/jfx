// Panama downcall targets for WebCore::CSSStyleDeclaration -- see
// dom_element.cpp's header comment for the general shape. dispose() is
// deliberately left as plain JNI, same rationale as dom_css_rule.cpp's
// header comment.
//
// dom_css_style_declaration_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSStyleDeclarationImplSignature is the source of truth) -- never
// hand-edit it.
#include <WebCore/CSSRule.h>
#include <WebCore/CSSStyleDeclaration.h>
#include <WebCore/DeprecatedCSSOMValue.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_style_declaration_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

void jfxpanama_dom_CSSStyleDeclaration_getCssText(Char16StringExchange* exchange, CSSStyleDeclaration* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->cssText(), exchange);
}

// Void + exception forwarding: setCssText returns ExceptionOr<void>. The old
// JNI shim (setCssTextImpl) calls IMPL->setCssText(...) and drops the
// result, same gap as CSSRuleImpl.setCssText's old JNI shim.
void jfxpanama_dom_CSSStyleDeclaration_setCssText(Exchange* exchange, CSSStyleDeclaration* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setCssText(String::fromUTF8(value)), exchange);
}

int jfxpanama_dom_CSSStyleDeclaration_getLength(CSSStyleDeclaration* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<int>(peer->length());
}

// parentRule() is a nullable raw pointer (RefPtr{nullptr}.leakRef() passes
// nullptr through unchanged, same as CSSRule::parentRule).
CSSRule* jfxpanama_dom_CSSStyleDeclaration_getParentRule(CSSStyleDeclaration* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRule> { peer->parentRule() }.leakRef();
}

void jfxpanama_dom_CSSStyleDeclaration_getPropertyValue(Char16StringExchange* exchange, CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getPropertyValue(String::fromUTF8(propertyName)), exchange);
}

// getPropertyCSSValue() already returns RefPtr<DeprecatedCSSOMValue> (nullable),
// so leakRef() applies directly -- no RefPtr{...} rewrap needed.
DeprecatedCSSOMValue* jfxpanama_dom_CSSStyleDeclaration_getPropertyCSSValue(CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    return peer->getPropertyCSSValue(String::fromUTF8(propertyName)).leakRef();
}

// String return + exception forwarding, same combined shape as
// CSSPrimitiveValue::getStringValue: removeProperty returns ExceptionOr<String>.
void jfxpanama_dom_CSSStyleDeclaration_removeProperty(Char16StringExchange* exchange, CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->removeProperty(String::fromUTF8(propertyName));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return;
    }
    writeChar16String(result.releaseReturnValue(), exchange);
}

void jfxpanama_dom_CSSStyleDeclaration_getPropertyPriority(Char16StringExchange* exchange, CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getPropertyPriority(String::fromUTF8(propertyName)), exchange);
}

// Void + exception forwarding: setProperty returns ExceptionOr<void>.
void jfxpanama_dom_CSSStyleDeclaration_setProperty(Exchange* exchange, CSSStyleDeclaration* peer, const char* propertyName, const char* value, const char* priority)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setProperty(String::fromUTF8(propertyName), String::fromUTF8(value), String::fromUTF8(priority)), exchange);
}

void jfxpanama_dom_CSSStyleDeclaration_item(Char16StringExchange* exchange, CSSStyleDeclaration* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->item(static_cast<unsigned>(index)), exchange);
}

void jfxpanama_dom_CSSStyleDeclaration_getPropertyShorthand(Char16StringExchange* exchange, CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getPropertyShorthand(String::fromUTF8(propertyName)), exchange);
}

bool jfxpanama_dom_CSSStyleDeclaration_isPropertyImplicit(CSSStyleDeclaration* peer, const char* propertyName)
{
    WebCore::JSMainThreadNullState state;
    return peer->isPropertyImplicit(String::fromUTF8(propertyName));
}

}
