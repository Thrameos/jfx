package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DOMWindowImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_dom_window_api", includes = { "<stdint.h>" })
public enum DOMWindowImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_DOMWindow_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    GET_FRAME_ELEMENT("jfxpanama_dom_DOMWindow_getFrameElement",
            Signature.of(DomKind.ELEMENT, DomKind.DOM_WINDOW)),
    GET_OFFSCREEN_BUFFERING("jfxpanama_dom_DOMWindow_getOffscreenBuffering",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOM_WINDOW)),
    GET_OUTER_HEIGHT("jfxpanama_dom_DOMWindow_getOuterHeight",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_OUTER_WIDTH("jfxpanama_dom_DOMWindow_getOuterWidth",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_INNER_HEIGHT("jfxpanama_dom_DOMWindow_getInnerHeight",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_INNER_WIDTH("jfxpanama_dom_DOMWindow_getInnerWidth",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCREEN_X("jfxpanama_dom_DOMWindow_getScreenX",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCREEN_Y("jfxpanama_dom_DOMWindow_getScreenY",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCREEN_LEFT("jfxpanama_dom_DOMWindow_getScreenLeft",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCREEN_TOP("jfxpanama_dom_DOMWindow_getScreenTop",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCROLL_X("jfxpanama_dom_DOMWindow_getScrollX",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_SCROLL_Y("jfxpanama_dom_DOMWindow_getScrollY",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_PAGE_X_OFFSET("jfxpanama_dom_DOMWindow_getPageXOffset",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_PAGE_Y_OFFSET("jfxpanama_dom_DOMWindow_getPageYOffset",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_CLOSED("jfxpanama_dom_DOMWindow_getClosed",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOM_WINDOW)),
    GET_LENGTH("jfxpanama_dom_DOMWindow_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.DOM_WINDOW)),
    GET_NAME("jfxpanama_dom_DOMWindow_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW)),
    SET_NAME("jfxpanama_dom_DOMWindow_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    GET_STATUS("jfxpanama_dom_DOMWindow_getStatus",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW)),
    SET_STATUS("jfxpanama_dom_DOMWindow_setStatus",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    GET_DEFAULT_STATUS("jfxpanama_dom_DOMWindow_getDefaultStatus",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW)),
    SET_DEFAULT_STATUS("jfxpanama_dom_DOMWindow_setDefaultStatus",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    GET_DOCUMENT_EX("jfxpanama_dom_DOMWindow_getDocumentEx",
            Signature.of(DomKind.DOCUMENT, DomKind.DOM_WINDOW)),
    GET_DEVICE_PIXEL_RATIO("jfxpanama_dom_DOMWindow_getDevicePixelRatio",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.DOM_WINDOW)),
    GET_SELECTION("jfxpanama_dom_DOMWindow_getSelection",
            Signature.of(DomKind.DOM_SELECTION, DomKind.DOM_WINDOW)),
    FOCUS("jfxpanama_dom_DOMWindow_focus",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    BLUR("jfxpanama_dom_DOMWindow_blur",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    CLOSE("jfxpanama_dom_DOMWindow_close",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    PRINT("jfxpanama_dom_DOMWindow_print",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    STOP("jfxpanama_dom_DOMWindow_stop",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    ALERT("jfxpanama_dom_DOMWindow_alert",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    CONFIRM("jfxpanama_dom_DOMWindow_confirm",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    PROMPT("jfxpanama_dom_DOMWindow_prompt",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),
    FIND("jfxpanama_dom_DOMWindow_find",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN)),
    SCROLL_BY("jfxpanama_dom_DOMWindow_scrollBy",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.INT, PrimitiveKind.INT)),
    SCROLL_TO("jfxpanama_dom_DOMWindow_scrollTo",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.INT, PrimitiveKind.INT)),
    SCROLL("jfxpanama_dom_DOMWindow_scroll",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.INT, PrimitiveKind.INT)),
    MOVE_BY("jfxpanama_dom_DOMWindow_moveBy",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.FLOAT, PrimitiveKind.FLOAT)),
    MOVE_TO("jfxpanama_dom_DOMWindow_moveTo",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.FLOAT, PrimitiveKind.FLOAT)),
    RESIZE_BY("jfxpanama_dom_DOMWindow_resizeBy",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.FLOAT, PrimitiveKind.FLOAT)),
    RESIZE_TO("jfxpanama_dom_DOMWindow_resizeTo",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.FLOAT, PrimitiveKind.FLOAT)),
    GET_COMPUTED_STYLE("jfxpanama_dom_DOMWindow_getComputedStyle",
            Signature.of(DomKind.CSS_STYLE_DECLARATION, DomKind.DOM_WINDOW, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    CAPTURE_EVENTS("jfxpanama_dom_DOMWindow_captureEvents",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    RELEASE_EVENTS("jfxpanama_dom_DOMWindow_releaseEvents",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW)),
    DISPATCH_EVENT("jfxpanama_dom_DOMWindow_dispatchEvent",
            Signature.of(PrimitiveKind.BOOLEAN, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOM_WINDOW, DomKind.EVENT)),
    ATOB("jfxpanama_dom_DOMWindow_atob",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    BTOA("jfxpanama_dom_DOMWindow_btoa",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOM_WINDOW, PrimitiveKind.UTF8_CSTRING)),
    CLEAR_TIMEOUT("jfxpanama_dom_DOMWindow_clearTimeout",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.INT)),
    CLEAR_INTERVAL("jfxpanama_dom_DOMWindow_clearInterval",
            Signature.of(PrimitiveKind.VOID, DomKind.DOM_WINDOW, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    DOMWindowImplSignature(String symbol, Signature signature) {
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
