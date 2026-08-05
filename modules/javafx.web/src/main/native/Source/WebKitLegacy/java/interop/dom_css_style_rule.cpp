// Panama downcall targets for WebCore::CSSStyleRule -- see dom_element.cpp's
// header comment for the general shape. Same shape as dom_css_page_rule.cpp
// (getSelectorText/setSelectorText/getStyle), just a different owning class.
//
// dom_css_style_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSStyleRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSStyleDeclaration.h>
#include <WebCore/CSSStyleProperties.h>
#include <WebCore/CSSStyleRule.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_style_rule_api.hj"
#include "char16_string_exchange_support.h"

extern "C" {

void jfxpanama_dom_CSSStyleRule_getSelectorText(Char16StringExchange* exchange, CSSStyleRule* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->selectorText(), exchange);
}

void jfxpanama_dom_CSSStyleRule_setSelectorText(CSSStyleRule* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectorText(String::fromUTF8(value));
}

// style() returns CSSStyleProperties&, never null. CSSStyleProperties
// upcasts cleanly to the generic CSSStyleDeclaration* this signature spells,
// same trick as CSSFontFaceRuleImplSignature.GET_STYLE / CSSPageRuleImplSignature.GET_STYLE.
CSSStyleDeclaration* jfxpanama_dom_CSSStyleRule_getStyle(CSSStyleRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleDeclaration> { &peer->style() }.leakRef();
}

}
