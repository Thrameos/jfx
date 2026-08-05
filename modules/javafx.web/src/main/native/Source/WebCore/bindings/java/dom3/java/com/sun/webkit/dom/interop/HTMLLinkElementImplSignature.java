package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLLinkElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_link_element_api", includes = { "<stdint.h>" })
public enum HTMLLinkElementImplSignature implements NativeSignatureEntry {
    GET_DISABLED("jfxpanama_dom_HTMLLinkElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_LINK_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLLinkElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_CHARSET("jfxpanama_dom_HTMLLinkElement_getCharset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_CHARSET("jfxpanama_dom_HTMLLinkElement_setCharset",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HREF("jfxpanama_dom_HTMLLinkElement_getHref",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_HREF("jfxpanama_dom_HTMLLinkElement_setHref",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HREFLANG("jfxpanama_dom_HTMLLinkElement_getHreflang",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_HREFLANG("jfxpanama_dom_HTMLLinkElement_setHreflang",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_MEDIA("jfxpanama_dom_HTMLLinkElement_getMedia",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_MEDIA("jfxpanama_dom_HTMLLinkElement_setMedia",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_REL("jfxpanama_dom_HTMLLinkElement_getRel",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_REL("jfxpanama_dom_HTMLLinkElement_setRel",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_REV("jfxpanama_dom_HTMLLinkElement_getRev",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_REV("jfxpanama_dom_HTMLLinkElement_setRev",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TARGET("jfxpanama_dom_HTMLLinkElement_getTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_TARGET("jfxpanama_dom_HTMLLinkElement_setTarget",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLLinkElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LINK_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLLinkElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LINK_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SHEET("jfxpanama_dom_HTMLLinkElement_getSheet",
            Signature.of(DomKind.STYLE_SHEET, DomKind.HTML_LINK_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLLinkElementImplSignature(String symbol, Signature signature) {
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
