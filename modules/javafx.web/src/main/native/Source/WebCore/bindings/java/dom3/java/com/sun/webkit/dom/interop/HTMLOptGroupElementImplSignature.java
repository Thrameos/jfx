package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLOptGroupElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_opt_group_element_api", includes = { "<stdint.h>" })
public enum HTMLOptGroupElementImplSignature implements NativeSignatureEntry {
    GET_DISABLED("jfxpanama_dom_HTMLOptGroupElement_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_OPT_GROUP_ELEMENT)),
    SET_DISABLED("jfxpanama_dom_HTMLOptGroupElement_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPT_GROUP_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_LABEL("jfxpanama_dom_HTMLOptGroupElement_getLabel",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_OPT_GROUP_ELEMENT)),
    SET_LABEL("jfxpanama_dom_HTMLOptGroupElement_setLabel",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_OPT_GROUP_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLOptGroupElementImplSignature(String symbol, Signature signature) {
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
