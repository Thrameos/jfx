package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLLIElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_htmlli_element_api", includes = { "<stdint.h>" })
public enum HTMLLIElementImplSignature implements NativeSignatureEntry {
    GET_TYPE("jfxpanama_dom_HTMLLIElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_LI_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLLIElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LI_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_VALUE("jfxpanama_dom_HTMLLIElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_LI_ELEMENT, PrimitiveKind.INT));

    private final String symbol;
    private final Signature signature;

    HTMLLIElementImplSignature(String symbol, Signature signature) {
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
