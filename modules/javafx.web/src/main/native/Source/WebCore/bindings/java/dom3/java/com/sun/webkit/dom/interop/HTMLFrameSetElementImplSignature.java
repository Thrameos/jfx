package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLFrameSetElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_frame_set_element_api", includes = { "<stdint.h>" })
public enum HTMLFrameSetElementImplSignature implements NativeSignatureEntry {
    GET_COLS("jfxpanama_dom_HTMLFrameSetElement_getCols",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_SET_ELEMENT)),
    SET_COLS("jfxpanama_dom_HTMLFrameSetElement_setCols",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_SET_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ROWS("jfxpanama_dom_HTMLFrameSetElement_getRows",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_FRAME_SET_ELEMENT)),
    SET_ROWS("jfxpanama_dom_HTMLFrameSetElement_setRows",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_FRAME_SET_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLFrameSetElementImplSignature(String symbol, Signature signature) {
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
