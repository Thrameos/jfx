package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.CharacterDataImpl}.
 */
@NativeHeader(value = "dom_character_data_api", includes = { "<stdint.h>" })
public enum CharacterDataImplSignature implements NativeSignatureEntry {
    GET_LENGTH("jfxpanama_dom_CharacterData_getLength",
            Signature.of(PrimitiveKind.INT, DomKind.CHARACTER_DATA)),
    GET_DATA("jfxpanama_dom_CharacterData_getData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CHARACTER_DATA)),
    SET_DATA("jfxpanama_dom_CharacterData_setData",
            Signature.of(PrimitiveKind.VOID, DomKind.CHARACTER_DATA, PrimitiveKind.UTF8_CSTRING)),
    APPEND_DATA("jfxpanama_dom_CharacterData_appendData",
            Signature.of(PrimitiveKind.VOID, DomKind.CHARACTER_DATA, PrimitiveKind.UTF8_CSTRING)),
    GET_PREVIOUS_ELEMENT_SIBLING("jfxpanama_dom_CharacterData_getPreviousElementSibling",
            Signature.of(DomKind.ELEMENT, DomKind.CHARACTER_DATA)),
    GET_NEXT_ELEMENT_SIBLING("jfxpanama_dom_CharacterData_getNextElementSibling",
            Signature.of(DomKind.ELEMENT, DomKind.CHARACTER_DATA)),
    SUBSTRING_DATA("jfxpanama_dom_CharacterData_substringData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.CHARACTER_DATA,
                    PrimitiveKind.INT, PrimitiveKind.INT)),

    // Exception forwarding (plans/patterns/pattern-exception-forwarding.md):
    // same (returnExchange, ...parameters) shape as SUBSTRING_DATA above, but
    // the shim never reserve()s a value -- only throwFn() on failure, exactly
    // like ElementImplSignature.SET_ATTRIBUTE.
    INSERT_DATA("jfxpanama_dom_CharacterData_insertData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CHARACTER_DATA,
                    PrimitiveKind.INT, PrimitiveKind.UTF8_CSTRING)),
    DELETE_DATA("jfxpanama_dom_CharacterData_deleteData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CHARACTER_DATA,
                    PrimitiveKind.INT, PrimitiveKind.INT)),
    REPLACE_DATA("jfxpanama_dom_CharacterData_replaceData",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CHARACTER_DATA,
                    PrimitiveKind.INT, PrimitiveKind.INT, PrimitiveKind.UTF8_CSTRING)),
    REMOVE("jfxpanama_dom_CharacterData_remove",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.CHARACTER_DATA));

    private final String symbol;
    private final Signature signature;

    CharacterDataImplSignature(String symbol, Signature signature) {
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
