// Panama downcall targets for WebCore::CSSRuleList -- see dom_element.cpp's
// header comment for the general shape. dispose() is deliberately left as
// plain JNI, same rationale as dom_css_rule.cpp's header comment.
//
// dom_css_rule_list_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSRuleListImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSRule.h>
#include <WebCore/CSSRuleList.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_rule_list_api.hj"

extern "C" {

int jfxpanama_dom_CSSRuleList_getLength(CSSRuleList* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<int>(peer->length());
}

// item() is a nullable raw pointer (RefPtr{nullptr}.leakRef() passes nullptr
// through unchanged, same as CSSMediaRule::getMedia).
CSSRule* jfxpanama_dom_CSSRuleList_item(CSSRuleList* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSRule> { peer->item(static_cast<unsigned>(index)) }.leakRef();
}

}
