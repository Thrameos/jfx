package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLBodyElementImpl}.
 * All onXXX event-handler get/set pairs are deliberately excluded --
 * persistent-closure shape, not proven against a real DOM binding yet.
 */
@NativeHeader(value = "dom_html_body_element_api", includes = { "<stdint.h>" })
public enum HTMLBodyElementImplSignature implements NativeSignatureEntry {
    SET_ALINK("jfxpanama_dom_HTMLBodyElement_setALink",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_BACKGROUND("jfxpanama_dom_HTMLBodyElement_setBackground",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_BGCOLOR("jfxpanama_dom_HTMLBodyElement_setBgColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_LINK("jfxpanama_dom_HTMLBodyElement_setLink",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_TEXT("jfxpanama_dom_HTMLBodyElement_setText",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VLINK("jfxpanama_dom_HTMLBodyElement_setVLink",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_BODY_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ALINK("jfxpanama_dom_HTMLBodyElement_getALink",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT)),
    GET_BACKGROUND("jfxpanama_dom_HTMLBodyElement_getBackground",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT)),
    GET_BGCOLOR("jfxpanama_dom_HTMLBodyElement_getBgColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT)),
    GET_LINK("jfxpanama_dom_HTMLBodyElement_getLink",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT)),
    GET_TEXT("jfxpanama_dom_HTMLBodyElement_getText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT)),
    GET_VLINK("jfxpanama_dom_HTMLBodyElement_getVLink",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_BODY_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLBodyElementImplSignature(String symbol, Signature signature) {
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
