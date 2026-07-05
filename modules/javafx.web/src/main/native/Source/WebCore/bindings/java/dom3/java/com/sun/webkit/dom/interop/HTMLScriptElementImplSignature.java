package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLScriptElementImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_html_script_element_api", includes = { "<stdint.h>" })
public enum HTMLScriptElementImplSignature implements NativeSignatureEntry {
    GET_TEXT("jfxpanama_dom_HTMLScriptElement_getText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_TEXT("jfxpanama_dom_HTMLScriptElement_setText",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_HTML_FOR("jfxpanama_dom_HTMLScriptElement_getHtmlFor",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_HTML_FOR("jfxpanama_dom_HTMLScriptElement_setHtmlFor",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_EVENT("jfxpanama_dom_HTMLScriptElement_getEvent",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_EVENT("jfxpanama_dom_HTMLScriptElement_setEvent",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CHARSET("jfxpanama_dom_HTMLScriptElement_getCharset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_CHARSET("jfxpanama_dom_HTMLScriptElement_setCharset",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ASYNC("jfxpanama_dom_HTMLScriptElement_getAsync",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_ASYNC("jfxpanama_dom_HTMLScriptElement_setAsync",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DEFER("jfxpanama_dom_HTMLScriptElement_getDefer",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_DEFER("jfxpanama_dom_HTMLScriptElement_setDefer",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_SRC("jfxpanama_dom_HTMLScriptElement_getSrc",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_SRC("jfxpanama_dom_HTMLScriptElement_setSrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_TYPE("jfxpanama_dom_HTMLScriptElement_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT)),
    SET_TYPE("jfxpanama_dom_HTMLScriptElement_setType",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_SCRIPT_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_CROSS_ORIGIN("jfxpanama_dom_HTMLScriptElement_getCrossOrigin",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.HTML_SCRIPT_ELEMENT));

    private final String symbol;
    private final Signature signature;

    HTMLScriptElementImplSignature(String symbol, Signature signature) {
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
