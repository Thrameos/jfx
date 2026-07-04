// Panama downcall targets for WebCore::CharacterData -- see dom_element.cpp's
// header comment for the general shape.
//
// dom_character_data_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CharacterDataImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CharacterData.h>
#include <WebCore/Element.h>
#include <WebCore/JSExecState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_character_data_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

int32_t jfxpanama_dom_CharacterData_getLength(CharacterData* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->length();
}

void jfxpanama_dom_CharacterData_setData(CharacterData* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setData(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_CharacterData_appendData(CharacterData* peer, const char* data)
{
    WebCore::JSMainThreadNullState state;
    peer->appendData(AtomString { String::fromUTF8(data) });
}

// Object-handle returns (plans/patterns/pattern-object-handle-return.md):
// one fresh ref handed to Java per call, same as the old JNI
// JavaReturn<Element>. NodeImpl.getCachedImpl()'s existing dispose-on-cache-
// hit path (Java side) balances the redundant ref when an address repeats.
Element* jfxpanama_dom_CharacterData_getPreviousElementSibling(CharacterData* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->previousElementSibling() }.leakRef();
}

Element* jfxpanama_dom_CharacterData_getNextElementSibling(CharacterData* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->nextElementSibling() }.leakRef();
}

// Combined string-return + exception-forwarding (plans/patterns/
// pattern-string-return.md's "Watch out for" section): one Char16String
// Exchange instance exercises both halves of the exchange struct on the
// same call -- reserve() on success, throwFn() on failure, never both.
void jfxpanama_dom_CharacterData_substringData(Char16StringExchange* exchange, CharacterData* peer, int32_t offset, int32_t length)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->substringData(offset, length);
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return;
    }
    writeChar16String(result.releaseReturnValue(), exchange);
}

}
