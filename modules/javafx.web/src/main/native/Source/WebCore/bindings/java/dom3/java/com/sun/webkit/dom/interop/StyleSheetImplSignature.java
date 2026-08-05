package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.StyleSheetImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_style_sheet_api", includes = { "<stdint.h>" })
public enum StyleSheetImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_StyleSheet_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.STYLE_SHEET)),
    GET_CPP_TYPE_IMPL("jfxpanama_dom_StyleSheet_getCPPTypeImpl",
            Signature.of(PrimitiveKind.INT, DomKind.STYLE_SHEET)),
    GET_TYPE("jfxpanama_dom_StyleSheet_getType",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.STYLE_SHEET)),
    GET_DISABLED("jfxpanama_dom_StyleSheet_getDisabled",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.STYLE_SHEET)),
    SET_DISABLED("jfxpanama_dom_StyleSheet_setDisabled",
            Signature.of(PrimitiveKind.VOID, DomKind.STYLE_SHEET, PrimitiveKind.BOOLEAN)),
    GET_OWNER_NODE("jfxpanama_dom_StyleSheet_getOwnerNode",
            Signature.of(DomKind.NODE, DomKind.STYLE_SHEET)),
    GET_PARENT_STYLE_SHEET("jfxpanama_dom_StyleSheet_getParentStyleSheet",
            Signature.of(DomKind.STYLE_SHEET, DomKind.STYLE_SHEET)),
    GET_HREF("jfxpanama_dom_StyleSheet_getHref",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.STYLE_SHEET)),
    GET_TITLE("jfxpanama_dom_StyleSheet_getTitle",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.STYLE_SHEET)),
    GET_MEDIA("jfxpanama_dom_StyleSheet_getMedia",
            Signature.of(DomKind.MEDIA_LIST, DomKind.STYLE_SHEET));

    private final String symbol;
    private final Signature signature;

    StyleSheetImplSignature(String symbol, Signature signature) {
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
