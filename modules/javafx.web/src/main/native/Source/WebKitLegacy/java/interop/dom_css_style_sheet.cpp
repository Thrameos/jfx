// Panama downcall targets for WebCore::CSSStyleSheet -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_css_style_sheet_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSStyleSheetImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSImportRule.h>
#include <WebCore/CSSRule.h>
#include <WebCore/CSSRuleList.h>
#include <WebCore/CSSStyleSheet.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_style_sheet_api.hj"
#include "dom_exception_exchange_support.h"

extern "C" {

// ownerRule() returns a nullable CSSImportRule*, which upcasts cleanly to
// the generic CSSRule* this signature spells (same trick as
// CSSStyleRuleImplSignature.GET_STYLE, just downward through RefPtr instead
// of a reference).
CSSRule* jfxpanama_dom_CSSStyleSheet_getOwnerRule(CSSStyleSheet* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRule> { peer->ownerRule() }.leakRef();
}

// Old JNI used the plain, non-throwing CSSStyleSheet::cssRules() (nullable
// RefPtr<CSSRuleList>) for both getCssRules and getRules, not the IDL's
// [ImplementedAs=cssRulesForBindings] ExceptionOr<Ref<CSSRuleList>> variant
// that actually backs the "cssRules" attribute per spec (which raises
// SecurityError for a cross-origin sheet). Preserved as-is here -- the
// speculative signature has no exception exchange for either entry, and
// this is a real, still-exported, non-throwing WebCore method being called
// deliberately, not a discarded ExceptionOr like the setCssText bug fixed
// in CSSRuleImpl/CSSStyleDeclarationImpl.
CSSRuleList* jfxpanama_dom_CSSStyleSheet_getCssRules(CSSStyleSheet* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRuleList> { peer->cssRules() }.leakRef();
}

CSSRuleList* jfxpanama_dom_CSSStyleSheet_getRules(CSSStyleSheet* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRuleList> { peer->cssRules() }.leakRef();
}

// Primitive return + exception forwarding (plans/patterns/pattern-exception-
// forwarding.md), same shape as CSSMediaRule::insertRule.
int jfxpanama_dom_CSSStyleSheet_insertRule(Exchange* exchange, CSSStyleSheet* peer, const char* rule, int index)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->insertRule(String::fromUTF8(rule), static_cast<unsigned>(index));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return 0;
    }
    return static_cast<int>(result.releaseReturnValue());
}

// Void + exception forwarding, same shape as CSSMediaRule::deleteRule.
void jfxpanama_dom_CSSStyleSheet_deleteRule(Exchange* exchange, CSSStyleSheet* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->deleteRule(static_cast<unsigned>(index)), exchange);
}

// addRule() is non-standard, returns ExceptionOr<int> directly (not
// unsigned), same unwrap-by-hand shape as insertRule.
int jfxpanama_dom_CSSStyleSheet_addRule(Exchange* exchange, CSSStyleSheet* peer, const char* selector, const char* style, int index)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->addRule(String::fromUTF8(selector), String::fromUTF8(style), static_cast<unsigned>(index));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return 0;
    }
    return result.releaseReturnValue();
}

// removeRule() is non-standard, ExceptionOr<void> that just forwards to
// deleteRule() (CSSStyleSheet.h: removeRule(index) { return deleteRule(index); }).
void jfxpanama_dom_CSSStyleSheet_removeRule(Exchange* exchange, CSSStyleSheet* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->removeRule(static_cast<unsigned>(index)), exchange);
}

}
