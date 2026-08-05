// Panama downcall targets for WebCore::CSSPageRule -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_css_page_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSPageRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSPageDescriptors.h>
#include <WebCore/CSSPageRule.h>
#include <WebCore/CSSStyleDeclaration.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_page_rule_api.hj"
#include "char16_string_exchange_support.h"

extern "C" {

void jfxpanama_dom_CSSPageRule_getSelectorText(Char16StringExchange* exchange, CSSPageRule* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->selectorText(), exchange);
}

void jfxpanama_dom_CSSPageRule_setSelectorText(CSSPageRule* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setSelectorText(AtomString { String::fromUTF8(value) });
}

// style() returns CSSPageDescriptors&, never null. CSSPageDescriptors
// upcasts cleanly to the generic CSSStyleDeclaration* this signature spells,
// same trick as CSSFontFaceRuleImplSignature.GET_STYLE.
CSSStyleDeclaration* jfxpanama_dom_CSSPageRule_getStyle(CSSPageRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleDeclaration> { &peer->style() }.leakRef();
}

}
