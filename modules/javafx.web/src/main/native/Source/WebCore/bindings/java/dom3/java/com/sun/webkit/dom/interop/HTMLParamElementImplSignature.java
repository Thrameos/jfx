package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLParamElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_param_element_api", includes = { "<stdint.h>" })
public enum HTMLParamElementImplSignature implements NativeSignatureEntry {
    GET_NAME("jfxpanama_dom_HTMLParamElement_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_PARAM_ELEMENT)),
    SET_NAME("jfxpanama_dom_HTMLParamElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_PARAM_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLParamElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_PARAM_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLParamElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_PARAM_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_VALUE("jfxpanama_dom_HTMLParamElement_getValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_PARAM_ELEMENT)),
    SET_VALUE("jfxpanama_dom_HTMLParamElement_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_PARAM_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_VALUE_TYPE("jfxpanama_dom_HTMLParamElement_getValueType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_PARAM_ELEMENT)),
    SET_VALUE_TYPE("jfxpanama_dom_HTMLParamElement_setValueType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_PARAM_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLParamElementImplSignature(String symbol, Signature signature) {
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
