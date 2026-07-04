// Panama downcall targets for WebCore::Element -- plain C ABI, no JNIEnv/
// jclass, no JNI machinery. peer is a real Element* (com.sun.webkit.dom.
// interop.DomKind.ELEMENT, not the generic PrimitiveKind.HANDLE void*) --
// the generated header spells the real pointee type, so passing e.g. a
// Node* here is a compile error, not a silent runtime cast bug. String
// arguments are NUL-terminated UTF-8 (const char*), per
// org.openjfx.interop.CString8.
//
// dom_element_api.hj is GENERATED (com.sun.webkit.dom.interop.
// ElementImplSignature is the source of truth) -- never hand-edit it, see
// plans/patterns/pattern-interop-binding-generation.md. Included after
// WebCore/Element.h and the `using namespace WebCore` below, deliberately:
// the generated prototypes spell the real pointee type bare (`Element*`,
// via DomKind.ELEMENT), not a forward declaration the generator would need
// new machinery to emit, so the real declaration must already be visible.
#include <WebCore/Element.h>
#include <WebCore/ElementInlines.h>
#include <WebCore/HTMLNames.h>
#include <WebCore/JSExecState.h>
#include <WebCore/TrustedHTML.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_element_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

int32_t jfxpanama_dom_Element_getChildElementCount(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->childElementCount();
}

double jfxpanama_dom_Element_getOffsetLeft(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->offsetLeftForBindings();
}

double jfxpanama_dom_Element_getOffsetTop(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->offsetTopForBindings();
}

double jfxpanama_dom_Element_getOffsetWidth(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->offsetWidth();
}

double jfxpanama_dom_Element_getOffsetHeight(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->offsetHeight();
}

double jfxpanama_dom_Element_getClientLeft(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->clientLeft();
}

double jfxpanama_dom_Element_getClientTop(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->clientTop();
}

double jfxpanama_dom_Element_getClientWidth(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->clientWidth();
}

double jfxpanama_dom_Element_getClientHeight(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->clientHeight();
}

int32_t jfxpanama_dom_Element_getScrollLeft(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->scrollLeft();
}

void jfxpanama_dom_Element_setScrollLeft(Element* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setScrollLeft(value);
}

int32_t jfxpanama_dom_Element_getScrollTop(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->scrollTop();
}

void jfxpanama_dom_Element_setScrollTop(Element* peer, int32_t value)
{
    WebCore::JSMainThreadNullState state;
    peer->setScrollTop(value);
}

int32_t jfxpanama_dom_Element_getScrollWidth(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->scrollWidth();
}

int32_t jfxpanama_dom_Element_getScrollHeight(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->scrollHeight();
}

// Object-handle returns (plans/patterns/pattern-object-handle-return.md):
// one fresh ref handed to Java per call, same as the old JNI
// JavaReturn<Element>(env, WTF::getPtr(peer->xxx())) -- NodeImpl.
// getCachedImpl()'s existing dispose-on-cache-hit path (Java side) balances
// the redundant ref whenever an address is already wrapped, so no
// native-side dedup is needed here.
Element* jfxpanama_dom_Element_getFirstElementChild(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->firstElementChild() }.leakRef();
}

Element* jfxpanama_dom_Element_getPreviousElementSibling(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->previousElementSibling() }.leakRef();
}

Element* jfxpanama_dom_Element_getNextElementSibling(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->nextElementSibling() }.leakRef();
}

Element* jfxpanama_dom_Element_getLastElementChild(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->lastElementChild() }.leakRef();
}

bool jfxpanama_dom_Element_hasAttributes(Element* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttributes();
}

bool jfxpanama_dom_Element_hasAttribute(Element* peer, const char* name)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasAttribute(AtomString { String::fromUTF8(name) });
}

void jfxpanama_dom_Element_removeAttribute(Element* peer, const char* name)
{
    WebCore::JSMainThreadNullState state;
    peer->removeAttribute(AtomString { String::fromUTF8(name) });
}

// Exception forwarding (plans/patterns/pattern-exception-forwarding.md): void
// downcall, exchange param leads (returnExchange, ...parameters) -- same
// struct ReturnExchangeKind.BYTE_EXCHANGE already generates for String returns, but this
// shim never calls reserve() (there is no data to hand back on success),
// only throwFn() on failure.
void jfxpanama_dom_Element_setAttribute(Exchange* exchange, Element* peer, const char* name, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(
            peer->setAttribute(AtomString { String::fromUTF8(name) }, AtomString { String::fromUTF8(value) }),
            exchange);
}

void jfxpanama_dom_Element_setId(Element* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(
            WebCore::HTMLNames::idAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Element_setClassName(Element* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setAttributeWithoutSynchronization(
            WebCore::HTMLNames::classAttr, AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Element_setInnerHTML(Element* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setInnerHTML(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Element_setOuterHTML(Element* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setOuterHTML(AtomString { String::fromUTF8(value) });
}

// String returns (plans/patterns/pattern-string-return.md): void downcall,
// value handed back through exchange->reserve()'s UTF-16 buffer instead of a
// return value -- reserve() is only called at all when the WTF::String isn't
// null, so a null String (e.g. no id attribute set) round-trips as Java null
// exactly like the old JavaReturn<String>, since Char16StringExchange.value()
// returns null when reserve() was never invoked.
void jfxpanama_dom_Element_getTagName(Char16StringExchange* exchange, Element* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->tagName(), exchange);
}

void jfxpanama_dom_Element_getId(Char16StringExchange* exchange, Element* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->getIdAttribute(), exchange);
}

}
