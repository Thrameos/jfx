package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLAppletElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_applet_element_api", includes = { "<stdint.h>" })
public enum HTMLAppletElementImplSignature implements NativeSignatureEntry {
    GET_ALIGN("jfxpanama_dom_HTMLAppletElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLAppletElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ALT("jfxpanama_dom_HTMLAppletElement_getAlt",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_ALT("jfxpanama_dom_HTMLAppletElement_setAlt",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ARCHIVE("jfxpanama_dom_HTMLAppletElement_getArchive",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_ARCHIVE("jfxpanama_dom_HTMLAppletElement_setArchive",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CODE("jfxpanama_dom_HTMLAppletElement_getCode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_CODE("jfxpanama_dom_HTMLAppletElement_setCode",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CODE_BASE("jfxpanama_dom_HTMLAppletElement_getCodeBase",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_CODE_BASE("jfxpanama_dom_HTMLAppletElement_setCodeBase",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HEIGHT("jfxpanama_dom_HTMLAppletElement_getHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_HEIGHT("jfxpanama_dom_HTMLAppletElement_setHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HSPACE("jfxpanama_dom_HTMLAppletElement_getHspace",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_HSPACE("jfxpanama_dom_HTMLAppletElement_setHspace",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLAppletElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLAppletElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_OBJECT("jfxpanama_dom_HTMLAppletElement_getObject",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_OBJECT("jfxpanama_dom_HTMLAppletElement_setObject",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_VSPACE("jfxpanama_dom_HTMLAppletElement_getVspace",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_VSPACE("jfxpanama_dom_HTMLAppletElement_setVspace",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLAppletElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_APPLET_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLAppletElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_APPLET_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLAppletElementImplSignature(String symbol, Signature signature) {
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
