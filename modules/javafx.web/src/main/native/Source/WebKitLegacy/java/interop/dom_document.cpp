// Panama downcall targets for WebCore::Document -- plain C ABI, no JNIEnv/
// jclass, no JNI machinery. peer is a real Document* (com.sun.webkit.dom.
// interop.DomKind.DOCUMENT, not the generic PrimitiveKind.HANDLE void*) --
// see dom_element.cpp's header comment for the general shape.
//
// dom_document_api.hj is GENERATED (com.sun.webkit.dom.interop.
// DocumentImplSignature is the source of truth) -- never hand-edit it, see
// plans/patterns/pattern-interop-binding-generation.md. Included after
// WebCore/Document.h and the `using namespace WebCore` below, deliberately:
// the generated prototypes spell the real pointee type bare (`Document*`,
// via DomKind.DOCUMENT), so the real declaration must already be visible.
#include <WebCore/Document.h>
#include "DocumentInlines.h"
#include <WebCore/Element.h>
#include <WebCore/HTMLElement.h>
#include <WebCore/HTMLHeadElement.h>
#include <WebCore/JSExecState.h>
#include <WebCore/SecurityOrigin.h>
#include <WebCore/VisibilityState.h>
#include <wtf/text/WTFString.h>

using namespace WebCore;

#include "dom_document_api.hj"
#include "char16_string_exchange_support.h"
#include "dom_exception_exchange_support.h"

extern "C" {

// Primitive getter/setter (plans/patterns/pattern-primitive-getter-setter.md):
bool jfxpanama_dom_Document_isHTMLDocument(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->isHTMLDocument() || peer->isXHTMLDocument();
}

bool jfxpanama_dom_Document_getXmlStandalone(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->xmlStandalone();
}

void jfxpanama_dom_Document_setXmlStandalone(Document* peer, bool value)
{
    WebCore::JSMainThreadNullState state;
    peer->setXMLStandalone(value);
}

bool jfxpanama_dom_Document_getHidden(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hidden();
}

bool jfxpanama_dom_Document_hasFocus(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->hasFocus();
}

int32_t jfxpanama_dom_Document_getChildElementCount(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return peer->childElementCount();
}

// Input-only string argument (plans/patterns/pattern-input-only-string.md):
void jfxpanama_dom_Document_setDocumentURI(Document* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setDocumentURI(AtomString { String::fromUTF8(value) });
}

void jfxpanama_dom_Document_setTitle(Document* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    peer->setTitle(String::fromUTF8(value));
}

// Matches the pre-existing JNI stub exactly (WebKitLegacy/java/DOM/
// JavaDocument.cpp's setSelectedStylesheetSetImpl): a no-op, since there is
// no current WebCore selected-stylesheet-set API wired up here.
void jfxpanama_dom_Document_setSelectedStylesheetSet(Document*, const char*)
{
}

// String returns (plans/patterns/pattern-string-return.md): void downcall,
// value handed back through exchange->reserve()'s UTF-16 buffer.
void jfxpanama_dom_Document_getInputEncoding(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->characterSetWithUTF8Fallback(), exchange);
}

void jfxpanama_dom_Document_getXmlEncoding(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->xmlEncoding(), exchange);
}

void jfxpanama_dom_Document_getXmlVersion(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->xmlVersion(), exchange);
}

void jfxpanama_dom_Document_getDocumentURI(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->documentURI(), exchange);
}

void jfxpanama_dom_Document_getContentType(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->contentType(), exchange);
}

void jfxpanama_dom_Document_getTitle(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->title(), exchange);
}

void jfxpanama_dom_Document_getReferrer(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->referrer(), exchange);
}

void jfxpanama_dom_Document_getDomain(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->domain(), exchange);
}

void jfxpanama_dom_Document_getURL(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->urlForBindings().string(), exchange);
}

void jfxpanama_dom_Document_getLastModified(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->lastModified(), exchange);
}

void jfxpanama_dom_Document_getCharset(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->characterSetWithUTF8Fallback(), exchange);
}

void jfxpanama_dom_Document_getDefaultCharset(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->defaultCharsetForLegacyBindings(), exchange);
}

void jfxpanama_dom_Document_getReadyState(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    const char* readyStateStr { };
    switch (peer->readyState()) {
    case WebCore::Document::ReadyState::Loading:
        readyStateStr = "loading";
        break;
    case WebCore::Document::ReadyState::Interactive:
        readyStateStr = "interactive";
        break;
    case WebCore::Document::ReadyState::Complete:
        readyStateStr = "complete";
        break;
    default:
        ASSERT_NOT_REACHED();
    }
    writeChar16String(String::fromLatin1(readyStateStr), exchange);
}

void jfxpanama_dom_Document_getCharacterSet(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->characterSetWithUTF8Fallback(), exchange);
}

// Matches the pre-existing JNI stubs exactly (WebKitLegacy/java/DOM/
// JavaDocument.cpp's getPreferredStylesheetSetImpl/getSelectedStylesheetSetImpl):
// always null, since there is no current WebCore preferred/selected
// stylesheet-set API wired up here. writeChar16String() never calls
// reserve() for a null String, so this round-trips as Java null.
void jfxpanama_dom_Document_getPreferredStylesheetSet(Char16StringExchange* exchange, Document*)
{
    writeChar16String(String(), exchange);
}

void jfxpanama_dom_Document_getSelectedStylesheetSet(Char16StringExchange* exchange, Document*)
{
    writeChar16String(String(), exchange);
}

void jfxpanama_dom_Document_getCompatMode(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->compatMode(), exchange);
}

void jfxpanama_dom_Document_getVisibilityState(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    const char* visibility { };
    switch (peer->visibilityState()) {
    case WebCore::VisibilityState::Hidden:
        visibility = "hidden";
        break;
    case WebCore::VisibilityState::Visible:
        visibility = "visible";
        break;
    }
    writeChar16String(String::fromLatin1(visibility), exchange);
}

void jfxpanama_dom_Document_getOrigin(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    writeChar16String(peer->securityOrigin().toString(), exchange);
}

// Object-handle returns (plans/patterns/pattern-object-handle-return.md):
// one fresh ref handed to Java per call, same as the old JNI
// JavaReturn<T>. NodeImpl.getCachedImpl()'s existing dispose-on-cache-hit
// path (Java side) balances the redundant ref when an address repeats.
Element* jfxpanama_dom_Document_getDocumentElement(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->documentElement() }.leakRef();
}

HTMLElement* jfxpanama_dom_Document_getBody(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<HTMLElement> { peer->bodyOrFrameset() }.leakRef();
}

// The real WebCore return (Document::head()) is HTMLHeadElement*, which
// upcasts cleanly to the HTMLElement* this shim declares -- the Java side
// still routes the returned peer through HTMLHeadElementImpl.getImpl(...),
// which dispatches to the correct wrapper type by the peer's real runtime
// type, not by this shim's declared C pointee type.
HTMLElement* jfxpanama_dom_Document_getHead(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<HTMLHeadElement> { peer->head() }.leakRef();
}

Element* jfxpanama_dom_Document_getActiveElement(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->activeElement() }.leakRef();
}

Element* jfxpanama_dom_Document_getScrollingElement(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->scrollingElementForAPI() }.leakRef();
}

Element* jfxpanama_dom_Document_getFirstElementChild(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->firstElementChild() }.leakRef();
}

Element* jfxpanama_dom_Document_getLastElementChild(Document* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<Element> { peer->lastElementChild() }.leakRef();
}

// Combined string-return + exception-forwarding (plans/patterns/
// pattern-string-return.md's "Watch out for" section): one
// Char16StringExchange instance exercises both halves of the exchange
// struct on the same call -- reserve() on success, throwFn() on failure,
// never both. Document::cookie() is ExceptionOr<String>.
void jfxpanama_dom_Document_getCookie(Char16StringExchange* exchange, Document* peer)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->cookie();
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return;
    }
    writeChar16String(result.releaseReturnValue(), exchange);
}

// Exception forwarding (plans/patterns/pattern-exception-forwarding.md):
// void downcall, exchange param leads (returnExchange, ...parameters) --
// the shim never reserve()s, only throwFn() on failure. Document::
// setCookie(const String&)/setXMLVersion(const String&) are both
// ExceptionOr<void>.
void jfxpanama_dom_Document_setCookie(Exchange* exchange, Document* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setCookie(AtomString { String::fromUTF8(value) }), exchange);
}

void jfxpanama_dom_Document_setXmlVersion(Exchange* exchange, Document* peer, const char* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setXMLVersion(AtomString { String::fromUTF8(value) }), exchange);
}

// Exception forwarding with an object-handle argument instead of a string
// one -- same mechanical shape as jfxpanama_dom_Element_setAttribute, but
// Document::setBodyOrFrameset(RefPtr<HTMLElement>&&) takes a node handle.
void jfxpanama_dom_Document_setBody(Exchange* exchange, Document* peer, HTMLElement* value)
{
    WebCore::JSMainThreadNullState state;
    forwardIfException(peer->setBodyOrFrameset(RefPtr<HTMLElement> { value }), exchange);
}

}
