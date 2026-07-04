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

// String return (plans/patterns/pattern-string-return.md): plain data()
// getter never throws, so only reserve() is ever exercised on this
// exchange -- same shape as ElementImpl's getTagName/getId.
void jfxpanama_dom_CharacterData_getData(Char16StringExchange* exchange, CharacterData* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->data(), exchange);
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

// Exception forwarding (plans/patterns/pattern-exception-forwarding.md):
// same (returnExchange, ...parameters) shape as substringData above, but the
// shim never reserve()s a value -- only throwFn() on failure, same as
// ElementImpl's setAttribute.
void jfxpanama_dom_CharacterData_insertData(Exchange* exchange, CharacterData* peer, int32_t offset, const char* data)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->insertData(offset, String::fromUTF8(data)), exchange);
}

void jfxpanama_dom_CharacterData_deleteData(Exchange* exchange, CharacterData* peer, int32_t offset, int32_t count)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->deleteData(offset, count), exchange);
}

void jfxpanama_dom_CharacterData_replaceData(Exchange* exchange, CharacterData* peer, int32_t offset, int32_t count, const char* data)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->replaceData(offset, count, String::fromUTF8(data)), exchange);
}

void jfxpanama_dom_CharacterData_remove(Exchange* exchange, CharacterData* peer)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->remove(), exchange);
}

}
