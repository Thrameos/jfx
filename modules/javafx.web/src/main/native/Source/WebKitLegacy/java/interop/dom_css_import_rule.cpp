// Panama downcall targets for WebCore::CSSImportRule -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_css_import_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSImportRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSImportRule.h>
#include <WebCore/CSSStyleSheet.h>
#include <WebCore/MediaList.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_import_rule_api.hj"
#include "char16_string_exchange_support.h"

extern "C" {

// String return (plans/patterns/pattern-string-return.md).
void jfxpanama_dom_CSSImportRule_getHref(Char16StringExchange* exchange, CSSImportRule* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->href(), exchange);
}

// Object-handle return (plans/patterns/pattern-object-handle-return.md):
// media() returns a MediaList& (never null), same fresh-ref-per-call shape
// as the old JNI JavaReturn<MediaList>.
MediaList* jfxpanama_dom_CSSImportRule_getMedia(CSSImportRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<MediaList> { &peer->media() }.leakRef();
}

// styleSheet() is a raw CSSStyleSheet* and can be null (RefPtr{nullptr}.leakRef()
// returns nullptr, matching the old JNI WTF::getPtr(...) passthrough).
CSSStyleSheet* jfxpanama_dom_CSSImportRule_getStyleSheet(CSSImportRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleSheet> { peer->styleSheet() }.leakRef();
}

}
