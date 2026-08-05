package com.sun.webkit.dom.interop;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.RangeImpl}.
 *
 * <p>Speculative first pass (plans/patterns/README.md shapes only -- primitive
 * /String/object-handle returns, plain or exception-forwarding): every entry
 * here still needs its matching Binding + native shim written and built before
 * it does anything. EventListener-typed methods and any return type without an
 * existing DomKind mapping (e.g. AbstractView) are deliberately left as plain
 * {@code native static} declarations in the Impl class, not guessed here.
 */
@NativeHeader(value = "dom_range_api", includes = { "<stdint.h>" })
public enum RangeImplSignature implements NativeSignatureEntry {
    DISPOSE("jfxpanama_dom_Range_dispose",
            Signature.of(PrimitiveKind.VOID, DomKind.RANGE)),
    GET_START_CONTAINER("jfxpanama_dom_Range_getStartContainer",
            Signature.of(DomKind.NODE, DomKind.RANGE)),
    GET_START_OFFSET("jfxpanama_dom_Range_getStartOffset",
            Signature.of(PrimitiveKind.INT, DomKind.RANGE)),
    GET_END_CONTAINER("jfxpanama_dom_Range_getEndContainer",
            Signature.of(DomKind.NODE, DomKind.RANGE)),
    GET_END_OFFSET("jfxpanama_dom_Range_getEndOffset",
            Signature.of(PrimitiveKind.INT, DomKind.RANGE)),
    GET_COLLAPSED("jfxpanama_dom_Range_getCollapsed",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.RANGE)),
    GET_COMMON_ANCESTOR_CONTAINER("jfxpanama_dom_Range_getCommonAncestorContainer",
            Signature.of(DomKind.NODE, DomKind.RANGE)),
    GET_TEXT("jfxpanama_dom_Range_getText",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.RANGE)),
    SET_START("jfxpanama_dom_Range_setStart",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE, PrimitiveKind.INT)),
    SET_END("jfxpanama_dom_Range_setEnd",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE, PrimitiveKind.INT)),
    SET_START_BEFORE("jfxpanama_dom_Range_setStartBefore",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    SET_START_AFTER("jfxpanama_dom_Range_setStartAfter",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    SET_END_BEFORE("jfxpanama_dom_Range_setEndBefore",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    SET_END_AFTER("jfxpanama_dom_Range_setEndAfter",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    COLLAPSE("jfxpanama_dom_Range_collapse",
            Signature.of(PrimitiveKind.VOID, DomKind.RANGE, PrimitiveKind.BOOLEAN)),
    SELECT_NODE("jfxpanama_dom_Range_selectNode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    SELECT_NODE_CONTENTS("jfxpanama_dom_Range_selectNodeContents",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    COMPARE_BOUNDARY_POINTS("jfxpanama_dom_Range_compareBoundaryPoints",
            Signature.of(PrimitiveKind.SHORT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, PrimitiveKind.SHORT, DomKind.RANGE)),
    DELETE_CONTENTS("jfxpanama_dom_Range_deleteContents",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE)),
    EXTRACT_CONTENTS("jfxpanama_dom_Range_extractContents",
            Signature.of(DomKind.DOCUMENT_FRAGMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE)),
    CLONE_CONTENTS("jfxpanama_dom_Range_cloneContents",
            Signature.of(DomKind.DOCUMENT_FRAGMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE)),
    INSERT_NODE("jfxpanama_dom_Range_insertNode",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    SURROUND_CONTENTS("jfxpanama_dom_Range_surroundContents",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    CLONE_RANGE("jfxpanama_dom_Range_cloneRange",
            Signature.of(DomKind.RANGE, DomKind.RANGE)),
    TO_STRING("jfxpanama_dom_Range_toString",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.RANGE)),
    DETACH("jfxpanama_dom_Range_detach",
            Signature.of(PrimitiveKind.VOID, DomKind.RANGE)),
    CREATE_CONTEXTUAL_FRAGMENT("jfxpanama_dom_Range_createContextualFragment",
            Signature.of(DomKind.DOCUMENT_FRAGMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, PrimitiveKind.UTF8_CSTRING)),
    COMPARE_NODE("jfxpanama_dom_Range_compareNode",
            Signature.of(PrimitiveKind.SHORT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    COMPARE_POINT("jfxpanama_dom_Range_comparePoint",
            Signature.of(PrimitiveKind.SHORT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE, PrimitiveKind.INT)),
    INTERSECTS_NODE("jfxpanama_dom_Range_intersectsNode",
            Signature.of(PrimitiveKind.BOOLEAN, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE)),
    IS_POINT_IN_RANGE("jfxpanama_dom_Range_isPointInRange",
            Signature.of(PrimitiveKind.BOOLEAN, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, DomKind.NODE, PrimitiveKind.INT)),
    EXPAND("jfxpanama_dom_Range_expand",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.RANGE, PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    RangeImplSignature(String symbol, Signature signature) {
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
