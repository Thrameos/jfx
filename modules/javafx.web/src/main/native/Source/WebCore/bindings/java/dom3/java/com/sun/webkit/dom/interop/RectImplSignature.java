package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.RectImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_rect_api", includes = { "<stdint.h>" })
public enum RectImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_Rect_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.RECT)),
    GET_TOP("jfxpanama_dom_Rect_getTop",
            Signature.of(DomKind.CSS_PRIMITIVE_VALUE, DomKind.RECT)),
    GET_RIGHT("jfxpanama_dom_Rect_getRight",
            Signature.of(DomKind.CSS_PRIMITIVE_VALUE, DomKind.RECT)),
    GET_BOTTOM("jfxpanama_dom_Rect_getBottom",
            Signature.of(DomKind.CSS_PRIMITIVE_VALUE, DomKind.RECT)),
    GET_LEFT("jfxpanama_dom_Rect_getLeft",
            Signature.of(DomKind.CSS_PRIMITIVE_VALUE, DomKind.RECT));

    private final String symbol;
    private final Signature signature;

    RectImplSignature(String symbol, Signature signature) {
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
