package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLIFrameElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_htmli_frame_element_api", includes = { "<stdint.h>" })
public enum HTMLIFrameElementImplSignature implements NativeSignatureEntry {
    GET_ALIGN("jfxpanama_dom_HTMLIFrameElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLIFrameElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_FRAME_BORDER("jfxpanama_dom_HTMLIFrameElement_getFrameBorder",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_FRAME_BORDER("jfxpanama_dom_HTMLIFrameElement_setFrameBorder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HEIGHT("jfxpanama_dom_HTMLIFrameElement_getHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_HEIGHT("jfxpanama_dom_HTMLIFrameElement_setHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_LONG_DESC("jfxpanama_dom_HTMLIFrameElement_getLongDesc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_LONG_DESC("jfxpanama_dom_HTMLIFrameElement_setLongDesc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_MARGIN_HEIGHT("jfxpanama_dom_HTMLIFrameElement_getMarginHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_MARGIN_HEIGHT("jfxpanama_dom_HTMLIFrameElement_setMarginHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_MARGIN_WIDTH("jfxpanama_dom_HTMLIFrameElement_getMarginWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_MARGIN_WIDTH("jfxpanama_dom_HTMLIFrameElement_setMarginWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLIFrameElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLIFrameElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SCROLLING("jfxpanama_dom_HTMLIFrameElement_getScrolling",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_SCROLLING("jfxpanama_dom_HTMLIFrameElement_setScrolling",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SRC("jfxpanama_dom_HTMLIFrameElement_getSrc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_SRC("jfxpanama_dom_HTMLIFrameElement_setSrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SRCDOC("jfxpanama_dom_HTMLIFrameElement_getSrcdoc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_SRCDOC("jfxpanama_dom_HTMLIFrameElement_setSrcdoc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLIFrameElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_IFRAME_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLIFrameElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IFRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CONTENT_DOCUMENT("jfxpanama_dom_HTMLIFrameElement_getContentDocument",
            Signature.of(DomKind.DOCUMENT, DomKind.HTML_IFRAME_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLIFrameElementImplSignature(String symbol, Signature signature) {
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
