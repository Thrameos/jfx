package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.HTMLElementImpl}.
 *
 * getTabIndex/setTabIndex are deliberately NOT migrated here -- no JNI
 * implementation exists for them anywhere in WebKitLegacy/java/DOM (grepped,
 * zero matches), so there is no working baseline behavior to preserve.
 */
@NativeHeader(value = "dom_html_element_api", includes = { "<stdint.h>" })
public enum HTMLElementImplSignature implements NativeSignatureEntry {
    GET_TRANSLATE("jfxpanama_dom_HTMLElement_getTranslate",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_ELEMENT)),
    SET_TRANSLATE("jfxpanama_dom_HTMLElement_setTranslate",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_DRAGGABLE("jfxpanama_dom_HTMLElement_getDraggable",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_ELEMENT)),
    SET_DRAGGABLE("jfxpanama_dom_HTMLElement_setDraggable",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_HIDDEN("jfxpanama_dom_HTMLElement_getHidden",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_ELEMENT)),
    SET_HIDDEN("jfxpanama_dom_HTMLElement_setHidden",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.BOOLEAN)),
    GET_IS_CONTENT_EDITABLE("jfxpanama_dom_HTMLElement_getIsContentEditable",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_ELEMENT)),
    GET_SPELLCHECK("jfxpanama_dom_HTMLElement_getSpellcheck",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.HTML_ELEMENT)),
    SET_SPELLCHECK("jfxpanama_dom_HTMLElement_setSpellcheck",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.BOOLEAN)),

    SET_ID("jfxpanama_dom_HTMLElement_setId",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_TITLE("jfxpanama_dom_HTMLElement_setTitle",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_LANG("jfxpanama_dom_HTMLElement_setLang",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_WEBKITDROPZONE("jfxpanama_dom_HTMLElement_setWebkitdropzone",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_ACCESS_KEY("jfxpanama_dom_HTMLElement_setAccessKey",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_INNER_TEXT("jfxpanama_dom_HTMLElement_setInnerText",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_OUTER_TEXT("jfxpanama_dom_HTMLElement_setOuterText",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING)),
    SET_CONTENT_EDITABLE("jfxpanama_dom_HTMLElement_setContentEditable",
            Signature.of(PrimitiveKind.VOID, DomKind.HTML_ELEMENT, PrimitiveKind.STRING));

    private final String symbol;
    private final Signature signature;

    HTMLElementImplSignature(String symbol, Signature signature) {
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
