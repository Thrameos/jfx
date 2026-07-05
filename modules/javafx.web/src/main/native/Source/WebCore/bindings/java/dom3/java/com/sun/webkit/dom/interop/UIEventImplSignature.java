package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.UIEventImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_ui_event_api", includes = { "<stdint.h>" })
public enum UIEventImplSignature implements NativeSignatureEntry {
    GET_DETAIL("jfxpanama_dom_UIEvent_getDetail",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_KEY_CODE("jfxpanama_dom_UIEvent_getKeyCode",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_CHAR_CODE("jfxpanama_dom_UIEvent_getCharCode",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_LAYER_X("jfxpanama_dom_UIEvent_getLayerX",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_LAYER_Y("jfxpanama_dom_UIEvent_getLayerY",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_PAGE_X("jfxpanama_dom_UIEvent_getPageX",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_PAGE_Y("jfxpanama_dom_UIEvent_getPageY",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT)),
    GET_WHICH("jfxpanama_dom_UIEvent_getWhich",
            Signature.of(PrimitiveKind.INT, DomKind.UI_EVENT));

    private final String symbol;
    private final Signature signature;

    UIEventImplSignature(String symbol, Signature signature) {
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
