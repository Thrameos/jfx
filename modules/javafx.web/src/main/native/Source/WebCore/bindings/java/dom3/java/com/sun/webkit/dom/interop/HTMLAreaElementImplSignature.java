package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLAreaElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_area_element_api", includes = { "<stdint.h>" })
public enum HTMLAreaElementImplSignature implements NativeSignatureEntry {
    GET_ALT("jfxpanama_dom_HTMLAreaElement_getAlt",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_ALT("jfxpanama_dom_HTMLAreaElement_setAlt",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_COORDS("jfxpanama_dom_HTMLAreaElement_getCoords",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_COORDS("jfxpanama_dom_HTMLAreaElement_setCoords",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NO_HREF("jfxpanama_dom_HTMLAreaElement_getNoHref",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_AREA_ELEMENT)),
    SET_NO_HREF("jfxpanama_dom_HTMLAreaElement_setNoHref",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_PING("jfxpanama_dom_HTMLAreaElement_getPing",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_PING("jfxpanama_dom_HTMLAreaElement_setPing",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SHAPE("jfxpanama_dom_HTMLAreaElement_getShape",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_SHAPE("jfxpanama_dom_HTMLAreaElement_setShape",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TARGET("jfxpanama_dom_HTMLAreaElement_getTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_TARGET("jfxpanama_dom_HTMLAreaElement_setTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HREF("jfxpanama_dom_HTMLAreaElement_getHref",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    SET_HREF("jfxpanama_dom_HTMLAreaElement_setHref",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_AREA_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_PROTOCOL("jfxpanama_dom_HTMLAreaElement_getProtocol",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_HOST("jfxpanama_dom_HTMLAreaElement_getHost",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_HOSTNAME("jfxpanama_dom_HTMLAreaElement_getHostname",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_PORT("jfxpanama_dom_HTMLAreaElement_getPort",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_PATHNAME("jfxpanama_dom_HTMLAreaElement_getPathname",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_SEARCH("jfxpanama_dom_HTMLAreaElement_getSearch",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT)),
    GET_HASH("jfxpanama_dom_HTMLAreaElement_getHash",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_AREA_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLAreaElementImplSignature(String symbol, Signature signature) {
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
