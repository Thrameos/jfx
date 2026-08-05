package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSStyleDeclarationImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_css_style_declaration_api", includes = { "<stdint.h>" })
public enum CSSStyleDeclarationImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_CSSStyleDeclaration_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.CSS_STYLE_DECLARATION)),
    GET_CSS_TEXT("jfxpanama_dom_CSSStyleDeclaration_getCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION)),
    SET_CSS_TEXT("jfxpanama_dom_CSSStyleDeclaration_setCssText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    GET_LENGTH("jfxpanama_dom_CSSStyleDeclaration_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.CSS_STYLE_DECLARATION)),
    GET_PARENT_RULE("jfxpanama_dom_CSSStyleDeclaration_getParentRule",
            Signature.of(DomKind.CSS_RULE, DomKind.CSS_STYLE_DECLARATION)),
    GET_PROPERTY_VALUE("jfxpanama_dom_CSSStyleDeclaration_getPropertyValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    GET_PROPERTY_CSS_VALUE("jfxpanama_dom_CSSStyleDeclaration_getPropertyCSSValue",
            Signature.of(DomKind.CSS_VALUE, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    REMOVE_PROPERTY("jfxpanama_dom_CSSStyleDeclaration_removeProperty",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    GET_PROPERTY_PRIORITY("jfxpanama_dom_CSSStyleDeclaration_getPropertyPriority",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    SET_PROPERTY("jfxpanama_dom_CSSStyleDeclaration_setProperty",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),
    ITEM("jfxpanama_dom_CSSStyleDeclaration_item",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.INT)),
    GET_PROPERTY_SHORTHAND("jfxpanama_dom_CSSStyleDeclaration_getPropertyShorthand",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING)),
    IS_PROPERTY_IMPLICIT("jfxpanama_dom_CSSStyleDeclaration_isPropertyImplicit",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.CSS_STYLE_DECLARATION, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    CSSStyleDeclarationImplSignature(String symbol, Signature signature) {
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
