package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLImageElementImpl}.
 * setCrossOrigin is deliberately NOT migrated here -- no JNI implementation
 * exists for it (grepped, zero matches), so there is no working baseline
 * behavior to preserve. getHeight/setHeight/getHspace/setHspace/getVspace/
 * setVspace/getWidth/setWidth are also excluded -- they're String-typed in
 * the DOM API but backed by native int storage with parseInt/concatenation
 * at the Java boundary, not a plain String passthrough.
 */
@NativeHeader(value = "dom_html_image_element_api", includes = { "<stdint.h>" })
public enum HTMLImageElementImplSignature implements NativeSignatureEntry {
    GET_IS_MAP("jfxpanama_dom_HTMLImageElement_getIsMap",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_IMAGE_ELEMENT)),
    SET_IS_MAP("jfxpanama_dom_HTMLImageElement_setIsMap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_COMPLETE("jfxpanama_dom_HTMLImageElement_getComplete",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_IMAGE_ELEMENT)),
    GET_NATURAL_HEIGHT("jfxpanama_dom_HTMLImageElement_getNaturalHeight",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_IMAGE_ELEMENT)),
    GET_NATURAL_WIDTH("jfxpanama_dom_HTMLImageElement_getNaturalWidth",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_IMAGE_ELEMENT)),
    GET_X("jfxpanama_dom_HTMLImageElement_getX",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_IMAGE_ELEMENT)),
    GET_Y("jfxpanama_dom_HTMLImageElement_getY",
            Signature.of(PrimitiveKind.INT, DomKind.HTML_IMAGE_ELEMENT)),

    SET_NAME("jfxpanama_dom_HTMLImageElement_setName",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ALIGN("jfxpanama_dom_HTMLImageElement_setAlign",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_ALT("jfxpanama_dom_HTMLImageElement_setAlt",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_BORDER("jfxpanama_dom_HTMLImageElement_setBorder",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_LONG_DESC("jfxpanama_dom_HTMLImageElement_setLongDesc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SRC("jfxpanama_dom_HTMLImageElement_setSrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SRCSET("jfxpanama_dom_HTMLImageElement_setSrcset",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_SIZES("jfxpanama_dom_HTMLImageElement_setSizes",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_USE_MAP("jfxpanama_dom_HTMLImageElement_setUseMap",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_LOWSRC("jfxpanama_dom_HTMLImageElement_setLowsrc",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_IMAGE_ELEMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    HTMLImageElementImplSignature(String symbol, Signature signature) {
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
