package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.TextImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_text_api", includes = { "<stdint.h>" })
public enum TextImplSignature implements NativeSignatureEntry {
    GET_WHOLE_TEXT("jfxpanama_dom_Text_getWholeText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.TEXT)),
    SPLIT_TEXT("jfxpanama_dom_Text_splitText",
            Signature.of(DomKind.TEXT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.TEXT, PrimitiveKind.INT)),
    REPLACE_WHOLE_TEXT("jfxpanama_dom_Text_replaceWholeText",
            Signature.of(DomKind.TEXT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.TEXT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    TextImplSignature(String symbol, Signature signature) {
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
