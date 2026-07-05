package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLMetaElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_meta_element_api", includes = { "<stdint.h>" })
public enum HTMLMetaElementImplSignature implements NativeSignatureEntry {
    GET_CONTENT("jfxpanama_dom_HTMLMetaElement_getContent",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_META_ELEMENT)),
    SET_CONTENT("jfxpanama_dom_HTMLMetaElement_setContent",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_META_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HTTP_EQUIV("jfxpanama_dom_HTMLMetaElement_getHttpEquiv",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_META_ELEMENT)),
    SET_HTTP_EQUIV("jfxpanama_dom_HTMLMetaElement_setHttpEquiv",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_META_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLMetaElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_META_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLMetaElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_META_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SCHEME("jfxpanama_dom_HTMLMetaElement_getScheme",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_META_ELEMENT)),
    SET_SCHEME("jfxpanama_dom_HTMLMetaElement_setScheme",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_META_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLMetaElementImplSignature(String symbol, Signature signature) {
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
