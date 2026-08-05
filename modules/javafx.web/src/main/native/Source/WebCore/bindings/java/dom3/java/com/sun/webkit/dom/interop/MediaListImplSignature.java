package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.MediaListImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_media_list_api", includes = { "<stdint.h>" })
public enum MediaListImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_MediaList_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.MEDIA_LIST)),
    GET_MEDIA_TEXT("jfxpanama_dom_MediaList_getMediaText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.MEDIA_LIST)),
    SET_MEDIA_TEXT("jfxpanama_dom_MediaList_setMediaText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.MEDIA_LIST, PrimitiveKind.UTF8_CSTRING)),
    GET_LENGTH("jfxpanama_dom_MediaList_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.MEDIA_LIST)),
    ITEM("jfxpanama_dom_MediaList_item",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.MEDIA_LIST, PrimitiveKind.INT)),
    DELETE_MEDIUM("jfxpanama_dom_MediaList_deleteMedium",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.MEDIA_LIST, PrimitiveKind.UTF8_CSTRING)),
    APPEND_MEDIUM("jfxpanama_dom_MediaList_appendMedium",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.MEDIA_LIST, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    MediaListImplSignature(String symbol, Signature signature) {
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
