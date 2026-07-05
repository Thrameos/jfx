package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.EventImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_event_api", includes = { "<stdint.h>" })
public enum EventImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_Event_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT)),
    GET_CPP_TYPE_IMPL("jfxpanama_dom_Event_getCPPTypeImpl",
            Signature.of(PrimitiveKind.INT, DomKind.EVENT)),
    GET_TYPE("jfxpanama_dom_Event_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.EVENT)),
    GET_TARGET("jfxpanama_dom_Event_getTarget",
            Signature.of(DomKind.EVENT_TARGET, DomKind.EVENT)),
    GET_CURRENT_TARGET("jfxpanama_dom_Event_getCurrentTarget",
            Signature.of(DomKind.EVENT_TARGET, DomKind.EVENT)),
    GET_EVENT_PHASE("jfxpanama_dom_Event_getEventPhase",
            Signature.of(PrimitiveKind.SHORT, DomKind.EVENT)),
    GET_BUBBLES("jfxpanama_dom_Event_getBubbles",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.EVENT)),
    GET_CANCELABLE("jfxpanama_dom_Event_getCancelable",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.EVENT)),
    GET_TIME_STAMP("jfxpanama_dom_Event_getTimeStamp",
            Signature.of(PrimitiveKind.LONG, DomKind.EVENT)),
    GET_DEFAULT_PREVENTED("jfxpanama_dom_Event_getDefaultPrevented",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.EVENT)),
    GET_SRC_ELEMENT("jfxpanama_dom_Event_getSrcElement",
            Signature.of(DomKind.EVENT_TARGET, DomKind.EVENT)),
    GET_RETURN_VALUE("jfxpanama_dom_Event_getReturnValue",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.EVENT)),
    SET_RETURN_VALUE("jfxpanama_dom_Event_setReturnValue",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT, PrimitiveKind.BOOLEAN)),
    GET_CANCEL_BUBBLE("jfxpanama_dom_Event_getCancelBubble",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.EVENT)),
    SET_CANCEL_BUBBLE("jfxpanama_dom_Event_setCancelBubble",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT, PrimitiveKind.BOOLEAN)),
    STOP_PROPAGATION("jfxpanama_dom_Event_stopPropagation",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT)),
    PREVENT_DEFAULT("jfxpanama_dom_Event_preventDefault",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT)),
    INIT_EVENT("jfxpanama_dom_Event_initEvent",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN)),
    STOP_IMMEDIATE_PROPAGATION("jfxpanama_dom_Event_stopImmediatePropagation",
            Signature.of(PrimitiveKind.VOID, DomKind.EVENT));

    private final String symbol;
    private final Signature signature;

    EventImplSignature(String symbol, Signature signature) {
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
