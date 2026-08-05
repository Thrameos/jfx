package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLHRElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_htmlhr_element_api", includes = { "<stdint.h>" })
public enum HTMLHRElementImplSignature implements NativeSignatureEntry {
    GET_ALIGN("jfxpanama_dom_HTMLHRElement_getAlign",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_HR_ELEMENT)),
    SET_ALIGN("jfxpanama_dom_HTMLHRElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_HR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_NO_SHADE("jfxpanama_dom_HTMLHRElement_getNoShade",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_HR_ELEMENT)),
    SET_NO_SHADE("jfxpanama_dom_HTMLHRElement_setNoShade",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_HR_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_SIZE("jfxpanama_dom_HTMLHRElement_getSize",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_HR_ELEMENT)),
    SET_SIZE("jfxpanama_dom_HTMLHRElement_setSize",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_HR_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_WIDTH("jfxpanama_dom_HTMLHRElement_getWidth",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_HR_ELEMENT)),
    SET_WIDTH("jfxpanama_dom_HTMLHRElement_setWidth",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_HR_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLHRElementImplSignature(String symbol, Signature signature) {
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
