// Panama downcall targets for WebCore::CSSRule -- see dom_element.cpp's
// header comment for the general shape. dispose() is deliberately left as
// plain JNI (native private static void dispose(long) in CSSRuleImpl.java):
// every migrated *Impl class's SelfDisposer still calls through the old JNI
// path project-wide, so retiring it is a separate, dedicated pass across all
// of them at once, not something to bundle into one class's attribute
// migration.
//
// dom_css_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSRule.h>
#include <WebCore/CSSStyleSheet.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_rule_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

short jfxpanama_dom_CSSRule_getType(CSSRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<short>(peer->typeForCSSOM());
}

void jfxpanama_dom_CSSRule_getCssText(Char16StringExchange* exchange, CSSRule* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->cssText(), exchange);
}

// Void + exception forwarding (plans/patterns/pattern-exception-forwarding.md):
// setCssText returns ExceptionOr<void>. The old JNI shim
// (Java_com_sun_webkit_dom_CSSRuleImpl_setCssTextImpl) calls IMPL->setCssText(...)
// and drops the result entirely, silently swallowing any exception -- a real
// gap in the old code, not a behavior this migration preserves.
void jfxpanama_dom_CSSRule_setCssText(Exchange* exchange, CSSRule* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setCssText(String::fromUTF8(value)), exchange);
}

// parentStyleSheet()/parentRule() are nullable raw pointers (RefPtr{nullptr}
// .leakRef() passes nullptr through unchanged, same as CSSMediaRule::getMedia).
CSSStyleSheet* jfxpanama_dom_CSSRule_getParentStyleSheet(CSSRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleSheet> { peer->parentStyleSheet() }.leakRef();
}

CSSRule* jfxpanama_dom_CSSRule_getParentRule(CSSRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRule> { peer->parentRule() }.leakRef();
}

}
