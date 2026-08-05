package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLOListElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_htmlo_list_element_api", includes = { "<stdint.h>" })
public enum HTMLOListElementImplSignature implements NativeSignatureEntry {
    GET_COMPACT("jfxpanama_dom_HTMLOListElement_getCompact",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_O_LIST_ELEMENT)),
    SET_COMPACT("jfxpanama_dom_HTMLOListElement_setCompact",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_O_LIST_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_START("jfxpanama_dom_HTMLOListElement_getStart",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_O_LIST_ELEMENT)),
    GET_REVERSED("jfxpanama_dom_HTMLOListElement_getReversed",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_O_LIST_ELEMENT)),
    SET_REVERSED("jfxpanama_dom_HTMLOListElement_setReversed",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_O_LIST_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_TYPE("jfxpanama_dom_HTMLOListElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_O_LIST_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLOListElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_O_LIST_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLOListElementImplSignature(String symbol, Signature signature) {
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
