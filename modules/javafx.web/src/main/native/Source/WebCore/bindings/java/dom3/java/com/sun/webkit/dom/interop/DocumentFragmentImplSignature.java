package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.DocumentFragmentImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_document_fragment_api", includes = { "<stdint.h>" })
public enum DocumentFragmentImplSignature implements NativeSignatureEntry {
    QUERY_SELECTOR("jfxpanama_dom_DocumentFragment_querySelector",
            Signature.of(DomKind.ELEMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT_FRAGMENT, PrimitiveKind.UTF8_CSTRING)),
    QUERY_SELECTOR_ALL("jfxpanama_dom_DocumentFragment_querySelectorAll",
            Signature.of(DomKind.NODE_LIST, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.DOCUMENT_FRAGMENT, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    DocumentFragmentImplSignature(String symbol, Signature signature) {
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
