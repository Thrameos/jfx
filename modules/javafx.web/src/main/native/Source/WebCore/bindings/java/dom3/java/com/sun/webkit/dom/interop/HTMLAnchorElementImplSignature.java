package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLAnchorElementImpl}.
 * Extremely homogeneous class -- every setter is a plain String setter and
 * every getter a plain String return, no exception forwarding anywhere in
 * the JNI body (grepped, zero raiseOnDOMError/raiseTypeErrorException matches
 * in JavaHTMLAnchorElement.cpp). The 21 setters were migrated first (10-class
 * batch, before the CHAR16_STRING string-return shape existed); the 21
 * getters below were added once that shape was proven by HTMLInputElement.
 */
@NativeHeader(value = "dom_html_anchor_element_api", includes = { "<stdint.h>" })
public enum HTMLAnchorElementImplSignature implements NativeSignatureEntry {
    SET_CHARSET("jfxpanama_dom_HTMLAnchorElement_setCharset",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_COORDS("jfxpanama_dom_HTMLAnchorElement_setCoords",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HREFLANG("jfxpanama_dom_HTMLAnchorElement_setHreflang",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_NAME("jfxpanama_dom_HTMLAnchorElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PING("jfxpanama_dom_HTMLAnchorElement_setPing",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_REL("jfxpanama_dom_HTMLAnchorElement_setRel",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_REV("jfxpanama_dom_HTMLAnchorElement_setRev",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SHAPE("jfxpanama_dom_HTMLAnchorElement_setShape",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_TARGET("jfxpanama_dom_HTMLAnchorElement_setTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_TYPE("jfxpanama_dom_HTMLAnchorElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_TEXT("jfxpanama_dom_HTMLAnchorElement_setText",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HREF("jfxpanama_dom_HTMLAnchorElement_setHref",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PROTOCOL("jfxpanama_dom_HTMLAnchorElement_setProtocol",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_USERNAME("jfxpanama_dom_HTMLAnchorElement_setUsername",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PASSWORD("jfxpanama_dom_HTMLAnchorElement_setPassword",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HOST("jfxpanama_dom_HTMLAnchorElement_setHost",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HOSTNAME("jfxpanama_dom_HTMLAnchorElement_setHostname",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PORT("jfxpanama_dom_HTMLAnchorElement_setPort",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_PATHNAME("jfxpanama_dom_HTMLAnchorElement_setPathname",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SEARCH("jfxpanama_dom_HTMLAnchorElement_setSearch",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_HASH("jfxpanama_dom_HTMLAnchorElement_setHash",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ANCHOR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    // String returns.
    GET_CHARSET("jfxpanama_dom_HTMLAnchorElement_getCharset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_COORDS("jfxpanama_dom_HTMLAnchorElement_getCoords",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_HREFLANG("jfxpanama_dom_HTMLAnchorElement_getHreflang",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_NAME("jfxpanama_dom_HTMLAnchorElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_PING("jfxpanama_dom_HTMLAnchorElement_getPing",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_REL("jfxpanama_dom_HTMLAnchorElement_getRel",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_REV("jfxpanama_dom_HTMLAnchorElement_getRev",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_SHAPE("jfxpanama_dom_HTMLAnchorElement_getShape",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_TARGET("jfxpanama_dom_HTMLAnchorElement_getTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_TYPE("jfxpanama_dom_HTMLAnchorElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_TEXT("jfxpanama_dom_HTMLAnchorElement_getText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_HREF("jfxpanama_dom_HTMLAnchorElement_getHref",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_ORIGIN("jfxpanama_dom_HTMLAnchorElement_getOrigin",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_PROTOCOL("jfxpanama_dom_HTMLAnchorElement_getProtocol",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_USERNAME("jfxpanama_dom_HTMLAnchorElement_getUsername",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_PASSWORD("jfxpanama_dom_HTMLAnchorElement_getPassword",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_HOST("jfxpanama_dom_HTMLAnchorElement_getHost",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_HOSTNAME("jfxpanama_dom_HTMLAnchorElement_getHostname",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_PORT("jfxpanama_dom_HTMLAnchorElement_getPort",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_PATHNAME("jfxpanama_dom_HTMLAnchorElement_getPathname",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_SEARCH("jfxpanama_dom_HTMLAnchorElement_getSearch",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT)),
    GET_HASH("jfxpanama_dom_HTMLAnchorElement_getHash",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_ANCHOR_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLAnchorElementImplSignature(String symbol, Signature signature) {
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
