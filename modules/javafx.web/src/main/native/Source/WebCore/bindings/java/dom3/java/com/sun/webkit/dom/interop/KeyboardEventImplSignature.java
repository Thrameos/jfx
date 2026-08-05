package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.KeyboardEventImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_keyboard_event_api", includes = { "<stdint.h>" })
public enum KeyboardEventImplSignature implements NativeSignatureEntry {
    GET_KEY_IDENTIFIER("jfxpanama_dom_KeyboardEvent_getKeyIdentifier",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.KEYBOARD_EVENT)),
    GET_KEY_LOCATION("jfxpanama_dom_KeyboardEvent_getKeyLocation",
            Signature.of(PrimitiveKind.INT, DomKind.KEYBOARD_EVENT)),
    GET_CTRL_KEY("jfxpanama_dom_KeyboardEvent_getCtrlKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.KEYBOARD_EVENT)),
    GET_SHIFT_KEY("jfxpanama_dom_KeyboardEvent_getShiftKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.KEYBOARD_EVENT)),
    GET_ALT_KEY("jfxpanama_dom_KeyboardEvent_getAltKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.KEYBOARD_EVENT)),
    GET_META_KEY("jfxpanama_dom_KeyboardEvent_getMetaKey",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.KEYBOARD_EVENT)),
    GET_KEY_CODE("jfxpanama_dom_KeyboardEvent_getKeyCode",
            Signature.of(PrimitiveKind.INT, DomKind.KEYBOARD_EVENT)),
    GET_CHAR_CODE("jfxpanama_dom_KeyboardEvent_getCharCode",
            Signature.of(PrimitiveKind.INT, DomKind.KEYBOARD_EVENT)),
    GET_MODIFIER_STATE("jfxpanama_dom_KeyboardEvent_getModifierState",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.KEYBOARD_EVENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    KeyboardEventImplSignature(String symbol, Signature signature) {
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
