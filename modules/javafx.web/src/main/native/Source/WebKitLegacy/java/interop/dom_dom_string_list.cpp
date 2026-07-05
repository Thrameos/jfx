// Panama downcall targets for WebCore::DOMStringList -- see dom_element.cpp's
// header comment for the general shape. dispose() is deliberately left as
// plain JNI, same rationale as dom_css_rule.cpp's header comment.
//
// dom_dom_string_list_api.hj is GENERATED (com.sun.webkit.dom.interop.
// DOMStringListImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/DOMStringList.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_dom_string_list_api.hj"
#include "char16_string_exchange_support.h"

extern "C" {

int jfxpanama_dom_DOMStringList_getLength(DOMStringList* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<int>(peer->length());
}

// item() never throws -- out-of-range yields an empty String (DOMStringList.cpp).
void jfxpanama_dom_DOMStringList_item(Char16StringExchange* exchange, DOMStringList* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->item(static_cast<unsigned>(index)), exchange);
}

bool jfxpanama_dom_DOMStringList_contains(DOMStringList* peer, const char* string)
{
    WebCore::JSMainThreadNullState state;
    return peer->contains(AtomString { String::fromUTF8(string) });
}

}
