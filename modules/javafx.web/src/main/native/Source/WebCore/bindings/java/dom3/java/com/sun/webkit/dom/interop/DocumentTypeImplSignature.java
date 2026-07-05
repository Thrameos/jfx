package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DocumentTypeImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_document_type_api", includes = { "<stdint.h>" })
public enum DocumentTypeImplSignature implements NativeSignatureEntry {
    GET_NAME("jfxpanama_dom_DocumentType_getName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT_TYPE)),
    GET_ENTITIES("jfxpanama_dom_DocumentType_getEntities",
            Signature.of(DomKind.NAMED_NODE_MAP, DomKind.DOCUMENT_TYPE)),
    GET_NOTATIONS("jfxpanama_dom_DocumentType_getNotations",
            Signature.of(DomKind.NAMED_NODE_MAP, DomKind.DOCUMENT_TYPE)),
    GET_PUBLIC_ID("jfxpanama_dom_DocumentType_getPublicId",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT_TYPE)),
    GET_SYSTEM_ID("jfxpanama_dom_DocumentType_getSystemId",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT_TYPE)),
    GET_INTERNAL_SUBSET("jfxpanama_dom_DocumentType_getInternalSubset",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.DOCUMENT_TYPE)),
    REMOVE("jfxpanama_dom_DocumentType_remove",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT_TYPE));

    private final String symbol;
    private final Signature signature;

    DocumentTypeImplSignature(String symbol, Signature signature) {
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
