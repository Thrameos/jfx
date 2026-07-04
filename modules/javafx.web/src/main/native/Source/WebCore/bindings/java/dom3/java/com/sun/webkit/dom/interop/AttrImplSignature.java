package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.AttrImpl}.
 */
@NativeHeader(value = "dom_attr_api", includes = { "<stdint.h>" })
public enum AttrImplSignature implements NativeSignatureEntry {
    GET_SPECIFIED("jfxpanama_dom_Attr_getSpecified",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.ATTR)),
    IS_ID("jfxpanama_dom_Attr_isId",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.ATTR)),
    SET_VALUE("jfxpanama_dom_Attr_setValue",
            Signature.of(PrimitiveKind.VOID, DomKind.ATTR, PrimitiveKind.UTF8_CSTRING)),
    GET_OWNER_ELEMENT("jfxpanama_dom_Attr_getOwnerElement",
            Signature.of(DomKind.ELEMENT, DomKind.ATTR));

    private final String symbol;
    private final Signature signature;

    AttrImplSignature(String symbol, Signature signature) {
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
