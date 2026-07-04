package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DocumentImpl}. Same
 * split rationale as {@link ElementImplSignature} -- no {@code Binder}/
 * library-loading reference anywhere in this class, see
 * {@link DocumentImplBinding} for that.
 */
@NativeHeader(value = "dom_document_api", includes = { "<stdint.h>" })
public enum DocumentImplSignature implements NativeSignatureEntry {
    // Primitive getter/setter (plans/patterns/pattern-primitive-getter-setter.md):
    // no-arg getter or setter, PrimitiveKind return/params only.
    IS_HTML_DOCUMENT("jfxpanama_dom_Document_isHTMLDocument",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOCUMENT)),
    GET_XML_STANDALONE("jfxpanama_dom_Document_getXmlStandalone",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOCUMENT)),
    SET_XML_STANDALONE("jfxpanama_dom_Document_setXmlStandalone",
            Signature.of(PrimitiveKind.VOID, DomKind.DOCUMENT, PrimitiveKind.BOOLEAN)),
    GET_HIDDEN("jfxpanama_dom_Document_getHidden",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOCUMENT)),
    // NOTE: HAS_FOCUS/GET_CHILD_ELEMENT_COUNT are NOT here -- reverted, no
    // working JNI implementation existed to preserve behavior from
    // (confirmed via `nm -D` on the built .so during integration).

    // Input-only string argument (plans/patterns/pattern-input-only-string.md):
    // UTF-8 input string params, void or primitive return, no exception.
    SET_DOCUMENT_URI("jfxpanama_dom_Document_setDocumentURI",
            Signature.of(PrimitiveKind.VOID, DomKind.DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_TITLE("jfxpanama_dom_Document_setTitle",
            Signature.of(PrimitiveKind.VOID, DomKind.DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SELECTED_STYLESHEET_SET("jfxpanama_dom_Document_setSelectedStylesheetSet",
            Signature.of(PrimitiveKind.VOID, DomKind.DOCUMENT, PrimitiveKind.UTF8_CSTRING)),

    // String returns (plans/patterns/pattern-string-return.md): void downcall,
    // exchange param leads (returnExchange, ...parameters).
    GET_INPUT_ENCODING("jfxpanama_dom_Document_getInputEncoding",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_XML_ENCODING("jfxpanama_dom_Document_getXmlEncoding",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_XML_VERSION("jfxpanama_dom_Document_getXmlVersion",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_DOCUMENT_URI("jfxpanama_dom_Document_getDocumentURI",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_CONTENT_TYPE("jfxpanama_dom_Document_getContentType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_TITLE("jfxpanama_dom_Document_getTitle",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_REFERRER("jfxpanama_dom_Document_getReferrer",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_DOMAIN("jfxpanama_dom_Document_getDomain",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_URL("jfxpanama_dom_Document_getURL",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_LAST_MODIFIED("jfxpanama_dom_Document_getLastModified",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_CHARSET("jfxpanama_dom_Document_getCharset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_DEFAULT_CHARSET("jfxpanama_dom_Document_getDefaultCharset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_READY_STATE("jfxpanama_dom_Document_getReadyState",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_CHARACTER_SET("jfxpanama_dom_Document_getCharacterSet",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_PREFERRED_STYLESHEET_SET("jfxpanama_dom_Document_getPreferredStylesheetSet",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_SELECTED_STYLESHEET_SET("jfxpanama_dom_Document_getSelectedStylesheetSet",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_COMPAT_MODE("jfxpanama_dom_Document_getCompatMode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_VISIBILITY_STATE("jfxpanama_dom_Document_getVisibilityState",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),
    GET_ORIGIN("jfxpanama_dom_Document_getOrigin",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),

    // Object-handle returns (plans/patterns/pattern-object-handle-return.md):
    // the native shim mints a fresh ref every call, same as the old JNI
    // JavaReturn<T>. GET_HEAD's C-side pointee is HTMLElement* (the real
    // WebCore return, Document::head(), is HTMLHeadElement*, which upcasts
    // cleanly) -- the Java side still routes the returned peer through
    // HTMLHeadElementImpl.getImpl(...), which dispatches to the correct
    // wrapper type by the peer's real runtime type, not by this Kind.
    GET_DOCUMENT_ELEMENT("jfxpanama_dom_Document_getDocumentElement",
            Signature.of(DomKind.ELEMENT, DomKind.DOCUMENT)),
    GET_BODY("jfxpanama_dom_Document_getBody",
            Signature.of(DomKind.HTML_ELEMENT, DomKind.DOCUMENT)),
    GET_HEAD("jfxpanama_dom_Document_getHead",
            Signature.of(DomKind.HTML_ELEMENT, DomKind.DOCUMENT)),
    // NOTE: GET_ACTIVE_ELEMENT/GET_SCROLLING_ELEMENT/GET_FIRST_ELEMENT_CHILD/
    // GET_LAST_ELEMENT_CHILD are NOT here -- reverted, no working JNI
    // implementation existed to preserve behavior from (confirmed via
    // `nm -D` on the built .so during integration -- the identically-named
    // ElementImpl symbols exist, but not the DocumentImpl ones).

    // Combined string-return + exception-forwarding (plans/patterns/
    // pattern-string-return.md's "Watch out for" section, exactly like
    // CharacterDataImplSignature.SUBSTRING_DATA): Document::cookie() is
    // ExceptionOr<String> -- one Char16StringExchange instance exercises
    // both halves of the exchange struct on the same call.
    GET_COOKIE("jfxpanama_dom_Document_getCookie",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT)),

    // Exception forwarding (plans/patterns/pattern-exception-forwarding.md):
    // Document::setCookie(const String&)/setXMLVersion(const String&) are
    // both ExceptionOr<void> -- exchange param leads, the shim never
    // reserve()s, only throwFn() on failure.
    SET_COOKIE("jfxpanama_dom_Document_setCookie",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    SET_XML_VERSION("jfxpanama_dom_Document_setXmlVersion",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT,
                    PrimitiveKind.UTF8_CSTRING)),

    // Exception forwarding with an object-handle argument instead of a
    // string one -- same mechanical shape as ElementImplSignature.
    // SET_ATTRIBUTE, but Document::setBodyOrFrameset(RefPtr<HTMLElement>&&)
    // takes a node handle, not a string.
    SET_BODY("jfxpanama_dom_Document_setBody",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT,
                    DomKind.HTML_ELEMENT));

    private final String symbol;
    private final Signature signature;

    DocumentImplSignature(String symbol, Signature signature) {
        this.symbol = symbol;
        this.signature = signature;
    }

    @Override
    public String symbol() {
        return symbol;
    }

    @Override
    public Signature signature() {
        return signature;
    }
}
