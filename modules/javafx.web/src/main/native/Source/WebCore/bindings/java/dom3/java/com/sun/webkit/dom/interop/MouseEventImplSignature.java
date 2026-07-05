package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.MouseEventImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_mouse_event_api", includes = { "<stdint.h>" })
public enum MouseEventImplSignature implements NativeSignatureEntry {
    GET_SCREEN_X("jfxpanama_dom_MouseEvent_getScreenX",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_SCREEN_Y("jfxpanama_dom_MouseEvent_getScreenY",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_CLIENT_X("jfxpanama_dom_MouseEvent_getClientX",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_CLIENT_Y("jfxpanama_dom_MouseEvent_getClientY",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_CTRL_KEY("jfxpanama_dom_MouseEvent_getCtrlKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.MOUSE_EVENT)),
    GET_SHIFT_KEY("jfxpanama_dom_MouseEvent_getShiftKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.MOUSE_EVENT)),
    GET_ALT_KEY("jfxpanama_dom_MouseEvent_getAltKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.MOUSE_EVENT)),
    GET_META_KEY("jfxpanama_dom_MouseEvent_getMetaKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.MOUSE_EVENT)),
    GET_BUTTON("jfxpanama_dom_MouseEvent_getButton",
            Signature.of(PrimitiveKind.SHORT, DomKind.MOUSE_EVENT)),
    GET_RELATED_TARGET("jfxpanama_dom_MouseEvent_getRelatedTarget",
            Signature.of(DomKind.EVENT_TARGET, DomKind.MOUSE_EVENT)),
    GET_OFFSET_X("jfxpanama_dom_MouseEvent_getOffsetX",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_OFFSET_Y("jfxpanama_dom_MouseEvent_getOffsetY",
            Signature.of(PrimitiveKind.INT, DomKind.MOUSE_EVENT)),
    GET_FROM_ELEMENT("jfxpanama_dom_MouseEvent_getFromElement",
            Signature.of(DomKind.NODE, DomKind.MOUSE_EVENT)),
    GET_TO_ELEMENT("jfxpanama_dom_MouseEvent_getToElement",
            Signature.of(DomKind.NODE, DomKind.MOUSE_EVENT));

    private final String symbol;
    private final Signature signature;

    MouseEventImplSignature(String symbol, Signature signature) {
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
