package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.MutationEventImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_mutation_event_api", includes = { "<stdint.h>" })
public enum MutationEventImplSignature implements NativeSignatureEntry {
    GET_RELATED_NODE("jfxpanama_dom_MutationEvent_getRelatedNode",
            Signature.of(DomKind.NODE, DomKind.MUTATION_EVENT)),
    GET_PREV_VALUE("jfxpanama_dom_MutationEvent_getPrevValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.MUTATION_EVENT)),
    GET_NEW_VALUE("jfxpanama_dom_MutationEvent_getNewValue",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.MUTATION_EVENT)),
    GET_ATTR_NAME("jfxpanama_dom_MutationEvent_getAttrName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.MUTATION_EVENT)),
    GET_ATTR_CHANGE("jfxpanama_dom_MutationEvent_getAttrChange",
            Signature.of(PrimitiveKind.SHORT, DomKind.MUTATION_EVENT)),
    INIT_MUTATION_EVENT("jfxpanama_dom_MutationEvent_initMutationEvent",
            Signature.of(PrimitiveKind.VOID, DomKind.MUTATION_EVENT, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.BOOLEAN, PrimitiveKind.BOOLEAN, DomKind.NODE, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.SHORT));

    private final String symbol;
    private final Signature signature;

    MutationEventImplSignature(String symbol, Signature signature) {
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
