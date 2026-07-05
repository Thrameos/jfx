package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLFrameElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_frame_element_api", includes = { "<stdint.h>" })
public enum HTMLFrameElementImplSignature implements NativeSignatureEntry {
    GET_FRAME_BORDER("jfxpanama_dom_HTMLFrameElement_getFrameBorder",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_FRAME_BORDER("jfxpanama_dom_HTMLFrameElement_setFrameBorder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_LONG_DESC("jfxpanama_dom_HTMLFrameElement_getLongDesc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_LONG_DESC("jfxpanama_dom_HTMLFrameElement_setLongDesc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_MARGIN_HEIGHT("jfxpanama_dom_HTMLFrameElement_getMarginHeight",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_MARGIN_HEIGHT("jfxpanama_dom_HTMLFrameElement_setMarginHeight",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_MARGIN_WIDTH("jfxpanama_dom_HTMLFrameElement_getMarginWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_MARGIN_WIDTH("jfxpanama_dom_HTMLFrameElement_setMarginWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NAME("jfxpanama_dom_HTMLFrameElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLFrameElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NO_RESIZE("jfxpanama_dom_HTMLFrameElement_getNoResize",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_FRAME_ELEMENT)),
    SET_NO_RESIZE("jfxpanama_dom_HTMLFrameElement_setNoResize",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_SCROLLING("jfxpanama_dom_HTMLFrameElement_getScrolling",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_SCROLLING("jfxpanama_dom_HTMLFrameElement_setScrolling",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_SRC("jfxpanama_dom_HTMLFrameElement_getSrc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_SRC("jfxpanama_dom_HTMLFrameElement_setSrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CONTENT_DOCUMENT("jfxpanama_dom_HTMLFrameElement_getContentDocument",
            Signature.of(DomKind.DOCUMENT, DomKind.HTML_FRAME_ELEMENT)),
    GET_LOCATION("jfxpanama_dom_HTMLFrameElement_getLocation",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_ELEMENT)),
    SET_LOCATION("jfxpanama_dom_HTMLFrameElement_setLocation",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLFrameElement_getWidth",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_FRAME_ELEMENT)),
    GET_HEIGHT("jfxpanama_dom_HTMLFrameElement_getHeight",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_FRAME_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLFrameElementImplSignature(String symbol, Signature signature) {
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
