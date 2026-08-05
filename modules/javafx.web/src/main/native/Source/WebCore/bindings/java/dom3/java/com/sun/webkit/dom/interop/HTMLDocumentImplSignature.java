package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLDocumentImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_document_api", includes = { "<stdint.h>" })
public enum HTMLDocumentImplSignature implements NativeSignatureEntry {
    GET_EMBEDS("jfxpanama_dom_HTMLDocument_getEmbeds",
            Signature.of(DomKind.HTML_COLLECTION, DomKind.HTML_DOCUMENT)),
    GET_PLUGINS("jfxpanama_dom_HTMLDocument_getPlugins",
            Signature.of(DomKind.HTML_COLLECTION, DomKind.HTML_DOCUMENT)),
    GET_SCRIPTS("jfxpanama_dom_HTMLDocument_getScripts",
            Signature.of(DomKind.HTML_COLLECTION, DomKind.HTML_DOCUMENT)),
    GET_DIR("jfxpanama_dom_HTMLDocument_getDir",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_DIR("jfxpanama_dom_HTMLDocument_setDir",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_DESIGN_MODE("jfxpanama_dom_HTMLDocument_getDesignMode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_DESIGN_MODE("jfxpanama_dom_HTMLDocument_setDesignMode",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_COMPAT_MODE("jfxpanama_dom_HTMLDocument_getCompatMode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    GET_BG_COLOR("jfxpanama_dom_HTMLDocument_getBgColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_BG_COLOR("jfxpanama_dom_HTMLDocument_setBgColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_FG_COLOR("jfxpanama_dom_HTMLDocument_getFgColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_FG_COLOR("jfxpanama_dom_HTMLDocument_setFgColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ALINK_COLOR("jfxpanama_dom_HTMLDocument_getAlinkColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_ALINK_COLOR("jfxpanama_dom_HTMLDocument_setAlinkColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_LINK_COLOR("jfxpanama_dom_HTMLDocument_getLinkColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_LINK_COLOR("jfxpanama_dom_HTMLDocument_setLinkColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_VLINK_COLOR("jfxpanama_dom_HTMLDocument_getVlinkColor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_DOCUMENT)),
    SET_VLINK_COLOR("jfxpanama_dom_HTMLDocument_setVlinkColor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    OPEN("jfxpanama_dom_HTMLDocument_open",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT)),
    CLOSE("jfxpanama_dom_HTMLDocument_close",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT)),
    WRITE("jfxpanama_dom_HTMLDocument_write",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    WRITELN("jfxpanama_dom_HTMLDocument_writeln",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT, PrimitiveKind.UTF8_CSTRING)),
    CLEAR("jfxpanama_dom_HTMLDocument_clear",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT)),
    CAPTURE_EVENTS("jfxpanama_dom_HTMLDocument_captureEvents",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT)),
    RELEASE_EVENTS("jfxpanama_dom_HTMLDocument_releaseEvents",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_DOCUMENT));

    private final String symbol;
    private final Signature signature;

    HTMLDocumentImplSignature(String symbol, Signature signature) {
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
