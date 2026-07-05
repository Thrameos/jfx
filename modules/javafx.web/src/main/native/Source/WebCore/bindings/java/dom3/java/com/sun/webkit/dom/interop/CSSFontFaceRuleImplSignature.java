package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CSSFontFaceRuleImpl}.
 * First touch of the CSS domain -- CSSFontFaceRule::style() returns a
 * CSSFontFaceDescriptors&, which upcasts cleanly to the generic
 * CSSStyleDeclaration* this Kind spells, same "return a base pointer, let
 * the Java-side getImpl dispatch by runtime type" trick already proven by
 * DocumentImplSignature.GET_HEAD.
 */
@NativeHeader(value = "dom_css_font_face_rule_api", includes = { "<stdint.h>" })
public enum CSSFontFaceRuleImplSignature implements NativeSignatureEntry {
    // Object-handle return (plans/patterns/pattern-object-handle-return.md):
    // fresh ref minted per call, same as the old JNI JavaReturn<T>.
    GET_STYLE("jfxpanama_dom_CSSFontFaceRule_getStyle",
            Signature.of(DomKind.CSS_STYLE_DECLARATION, DomKind.CSS_FONT_FACE_RULE));

    private final String symbol;
    private final Signature signature;

    CSSFontFaceRuleImplSignature(String symbol, Signature signature) {
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
