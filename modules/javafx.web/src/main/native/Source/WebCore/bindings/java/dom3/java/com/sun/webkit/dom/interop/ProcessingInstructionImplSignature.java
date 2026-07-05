package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.ProcessingInstructionImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_processing_instruction_api", includes = { "<stdint.h>" })
public enum ProcessingInstructionImplSignature implements NativeSignatureEntry {
    GET_TARGET("jfxpanama_dom_ProcessingInstruction_getTarget",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.PROCESSING_INSTRUCTION)),
    GET_SHEET("jfxpanama_dom_ProcessingInstruction_getSheet",
            Signature.of(DomKind.STYLE_SHEET, DomKind.PROCESSING_INSTRUCTION));

    private final String symbol;
    private final Signature signature;

    ProcessingInstructionImplSignature(String symbol, Signature signature) {
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
