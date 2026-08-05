// Panama downcall targets for WebCore::CSSMediaRule -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_css_media_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSMediaRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSGroupingRule.h>
#include <WebCore/CSSMediaRule.h>
#include <WebCore/CSSRuleList.h>
#include <WebCore/MediaList.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_media_rule_api.hj"
#include "dom_exception_exchange_support.h"

extern "C" {

// media() is a nullable raw MediaList* (RefPtr{nullptr}.leakRef() passes
// nullptr through unchanged, matching the old JNI WTF::getPtr(...) shim).
MediaList* jfxpanama_dom_CSSMediaRule_getMedia(CSSMediaRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<MediaList> { peer->media() }.leakRef();
}

// cssRules() (CSSGroupingRule::cssRules()) returns CSSRuleList&, never null.
CSSRuleList* jfxpanama_dom_CSSMediaRule_getCssRules(CSSMediaRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRuleList> { &peer->cssRules() }.leakRef();
}

// Primitive return + exception forwarding (plans/patterns/pattern-exception-
// forwarding.md), same shape as Element::webkitMatchesSelector: insertRule
// returns ExceptionOr<unsigned>, no single helper covers non-void
// ExceptionOr, so unwrap by hand.
int jfxpanama_dom_CSSMediaRule_insertRule(Exchange* exchange, CSSMediaRule* peer, const char* rule, int index)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->insertRule(String::fromUTF8(rule), static_cast<unsigned>(index));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return 0;
    }
    return static_cast<int>(result.releaseReturnValue());
}

// Void + exception forwarding (plans/patterns/pattern-exception-
// forwarding.md): deleteRule returns ExceptionOr<void>, forwardIfException
// covers it directly.
void jfxpanama_dom_CSSMediaRule_deleteRule(Exchange* exchange, CSSMediaRule* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->deleteRule(static_cast<unsigned>(index)), exchange);
}

}
