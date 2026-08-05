// Panama downcall targets for WebCore::DeprecatedCSSOMCounter (the peer type
// old JNI actually used for CounterImpl -- getCounterValue() on
// CSSPrimitiveValueImpl is what mints these). dispose() is deliberately
// left as plain JNI, same rationale as dom_css_rule.cpp's header comment.
//
// dom_counter_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CounterImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/DeprecatedCSSOMCounter.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_counter_api.hj"
#include "char16_string_exchange_support.h"

extern "C" {

// identifier()/separator()/listStyle() are plain String getters, never throw.
void jfxpanama_dom_Counter_getIdentifier(Char16StringExchange* exchange, DeprecatedCSSOMCounter* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->identifier(), exchange);
}

void jfxpanama_dom_Counter_getListStyle(Char16StringExchange* exchange, DeprecatedCSSOMCounter* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->listStyle(), exchange);
}

void jfxpanama_dom_Counter_getSeparator(Char16StringExchange* exchange, DeprecatedCSSOMCounter* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->separator(), exchange);
}

}
