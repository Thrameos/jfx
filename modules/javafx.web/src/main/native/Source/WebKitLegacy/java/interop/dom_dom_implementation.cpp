// Panama downcall targets for WebCore::DOMImplementation -- see
// dom_element.cpp's header comment for the general shape. dispose() and
// hasFeature() are deliberately left as plain JNI/untouched -- hasFeature()
// isn't even in the speculative signature (real WebCore::hasFeature() takes
// no arguments and unconditionally returns true; it's out of scope for this
// migration and pre-dates it).
//
// dom_dom_implementation_api.hj is GENERATED (com.sun.webkit.dom.interop.
// DOMImplementationImplSignature is the source of truth) -- never hand-edit
// it. Note CREATE_CSS_STYLE_SHEET's signature was corrected during this
// migration (see that entry's comment) -- the speculative first pass had
// guessed an exception path that DOMImplementation::createCSSStyleSheet
// doesn't actually have.
#include <WebCore/CSSStyleSheet.h>
#include <WebCore/DOMImplementation.h>
#include <WebCore/Document.h>
#include <WebCore/DocumentType.h>
#include <WebCore/HTMLDocument.h>
#include <WebCore/JSExecState.h>
#include <WebCore/XMLDocument.h>

using namespace WebCore;

#include "dom_dom_implementation_api.hj"
#include "dom_exception_exchange_support.h"

extern "C" {

// createDocumentType() returns ExceptionOr<Ref<DocumentType>>.
DocumentType* jfxpanama_dom_DOMImplementation_createDocumentType(Exchange* exchange, DOMImplementation* peer,
        const char* qualifiedName, const char* publicId, const char* systemId)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->createDocumentType(AtomString { String::fromUTF8(qualifiedName) },
            String::fromUTF8(publicId), String::fromUTF8(systemId));
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return nullptr;
    }
    return RefPtr<DocumentType> { result.releaseReturnValue() }.leakRef();
}

// createDocument() returns ExceptionOr<Ref<XMLDocument>>, which upcasts
// cleanly to the generic Document* this signature spells (same trick as
// CSSStyleRuleImplSignature.GET_STYLE's CSSStyleProperties&->CSSStyleDeclaration*).
Document* jfxpanama_dom_DOMImplementation_createDocument(Exchange* exchange, DOMImplementation* peer,
        const char* namespaceURI, const char* qualifiedName, DocumentType* doctype)
{
    WebCore::JSMainThreadNullState state;
    auto result = peer->createDocument(AtomString { String::fromUTF8(namespaceURI) },
            AtomString { String::fromUTF8(qualifiedName) }, doctype);
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return nullptr;
    }
    return RefPtr<Document> { result.releaseReturnValue() }.leakRef();
}

// createCSSStyleSheet() returns a plain Ref<CSSStyleSheet>, never throws --
// see the DOMImplementationImplSignature.CREATE_CSS_STYLE_SHEET comment.
CSSStyleSheet* jfxpanama_dom_DOMImplementation_createCSSStyleSheet(DOMImplementation*, const char* title, const char* media)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleSheet> { DOMImplementation::createCSSStyleSheet(String::fromUTF8(title), String::fromUTF8(media)) }.leakRef();
}

// createHTMLDocument() returns a plain Ref<HTMLDocument>, never throws.
HTMLDocument* jfxpanama_dom_DOMImplementation_createHTMLDocument(DOMImplementation* peer, const char* title)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<HTMLDocument> { peer->createHTMLDocument(String::fromUTF8(title)) }.leakRef();
}

}
