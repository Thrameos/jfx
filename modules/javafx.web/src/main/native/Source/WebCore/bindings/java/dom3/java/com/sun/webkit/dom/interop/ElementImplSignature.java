package com.sun.webkit.dom.interop;

import org.openjfx.interop.ReturnExchangeKind;
import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.PrimitiveKind;
import org.openjfx.interop.Signature;
import org.openjfx.interop.annotations.NativeHeader;

/**
 * Pure metadata: symbol name + {@link Signature} pairs for every Panama
 * downcall target backing {@code com.sun.webkit.dom.ElementImpl}. No
 * {@code Binder}/library-loading reference anywhere in this class or its
 * constructor -- see {@link ElementImplBinding} for that -- so the {@code .hj}
 * generator can reflectively read these constants any time after compile,
 * without risking a {@code System.loadLibrary} of a {@code .so} the native
 * build hasn't produced yet (it's building *from* the header this class
 * produces).
 */
@NativeHeader(value = "dom_element_api", includes = { "<stdint.h>" })
public enum ElementImplSignature implements NativeSignatureEntry {
    GET_CHILD_ELEMENT_COUNT("jfxpanama_dom_Element_getChildElementCount",
            Signature.of(PrimitiveKind.INT, DomKind.ELEMENT)),

    // Object-handle return (plans/patterns/pattern-object-handle-return.md):
    // the native shim mints a fresh ref every call, same as the old JNI
    // JavaReturn<Element>. Dedup against a wrapper Java already holds for
    // this address happens entirely on the Java side, in the existing
    // NodeImpl.getCachedImpl()/dispose-on-cache-hit path -- no native-side
    // pooling needed for DOM object returns.
    GET_FIRST_ELEMENT_CHILD("jfxpanama_dom_Element_getFirstElementChild",
            Signature.of(DomKind.ELEMENT, DomKind.ELEMENT)),
    GET_PREVIOUS_ELEMENT_SIBLING("jfxpanama_dom_Element_getPreviousElementSibling",
            Signature.of(DomKind.ELEMENT, DomKind.ELEMENT)),
    GET_NEXT_ELEMENT_SIBLING("jfxpanama_dom_Element_getNextElementSibling",
            Signature.of(DomKind.ELEMENT, DomKind.ELEMENT)),
    GET_LAST_ELEMENT_CHILD("jfxpanama_dom_Element_getLastElementChild",
            Signature.of(DomKind.ELEMENT, DomKind.ELEMENT)),

    // Tier-1 batch (plans/roadmap-foundations.md's "Pilot execution log"):
    // primitive-returning no-arg getters, primitive setters, and void/
    // boolean methods taking only input strings with no exception-
    // forwarding in their JNI equivalents.
    GET_OFFSET_LEFT("jfxpanama_dom_Element_getOffsetLeft",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_OFFSET_TOP("jfxpanama_dom_Element_getOffsetTop",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_OFFSET_WIDTH("jfxpanama_dom_Element_getOffsetWidth",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_OFFSET_HEIGHT("jfxpanama_dom_Element_getOffsetHeight",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_CLIENT_LEFT("jfxpanama_dom_Element_getClientLeft",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_CLIENT_TOP("jfxpanama_dom_Element_getClientTop",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_CLIENT_WIDTH("jfxpanama_dom_Element_getClientWidth",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),
    GET_CLIENT_HEIGHT("jfxpanama_dom_Element_getClientHeight",
            Signature.of(PrimitiveKind.DOUBLE, DomKind.ELEMENT)),

    GET_SCROLL_LEFT("jfxpanama_dom_Element_getScrollLeft",
            Signature.of(PrimitiveKind.INT, DomKind.ELEMENT)),
    SET_SCROLL_LEFT("jfxpanama_dom_Element_setScrollLeft",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.INT)),
    GET_SCROLL_TOP("jfxpanama_dom_Element_getScrollTop",
            Signature.of(PrimitiveKind.INT, DomKind.ELEMENT)),
    SET_SCROLL_TOP("jfxpanama_dom_Element_setScrollTop",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.INT)),
    GET_SCROLL_WIDTH("jfxpanama_dom_Element_getScrollWidth",
            Signature.of(PrimitiveKind.INT, DomKind.ELEMENT)),
    GET_SCROLL_HEIGHT("jfxpanama_dom_Element_getScrollHeight",
            Signature.of(PrimitiveKind.INT, DomKind.ELEMENT)),

    HAS_ATTRIBUTES("jfxpanama_dom_Element_hasAttributes",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.ELEMENT)),
    HAS_ATTRIBUTE("jfxpanama_dom_Element_hasAttribute",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    REMOVE_ATTRIBUTE("jfxpanama_dom_Element_removeAttribute",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    SET_ID("jfxpanama_dom_Element_setId",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_CLASS_NAME("jfxpanama_dom_Element_setClassName",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_INNER_HTML("jfxpanama_dom_Element_setInnerHTML",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    SET_OUTER_HTML("jfxpanama_dom_Element_setOuterHTML",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),

    // String returns (plans/patterns/pattern-string-return.md): void downcall,
    // exchange param leads (returnExchange, ...parameters) -- native reserve()s
    // a UTF-16 buffer sized to the WTF::String's own length (or never reserves
    // at all, for a null String) rather than returning a value directly.
    GET_TAG_NAME("jfxpanama_dom_Element_getTagName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.ELEMENT)),
    GET_ID("jfxpanama_dom_Element_getId",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.ELEMENT)),

    // Exception forwarding (plans/patterns/pattern-exception-forwarding.md):
    // same (returnExchange, ...parameters) shape as the String returns above,
    // but the shim never reserve()s -- only throwFn() on failure, nothing to
    // hand back on success.
    SET_ATTRIBUTE("jfxpanama_dom_Element_setAttribute",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),

    // Re-sweep pass additions below -- same shapes as above, just applied to
    // the rest of ElementImpl's still-JNI methods that fit them.

    // Object-handle returns (shape 3): self ELEMENT, return an existing
    // DomKind value, fresh ref minted per call.
    GET_ATTRIBUTES("jfxpanama_dom_Element_getAttributes",
            Signature.of(DomKind.NAMED_NODE_MAP, DomKind.ELEMENT)),
    GET_OFFSET_PARENT("jfxpanama_dom_Element_getOffsetParent",
            Signature.of(DomKind.ELEMENT, DomKind.ELEMENT)),

    // Object-handle return + input string arg (shape 3 + shape 2 composition).
    GET_ATTRIBUTE_NODE("jfxpanama_dom_Element_getAttributeNode",
            Signature.of(DomKind.ATTR, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING)),
    GET_ATTRIBUTE_NODE_NS("jfxpanama_dom_Element_getAttributeNodeNS",
            Signature.of(DomKind.ATTR, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),

    // String returns (shape 4), some combined with input string args (shape 2).
    // NOTE: getInnerHTML/getOuterHTML are NOT here -- reverted, no working
    // JNI implementation existed to preserve behavior from (confirmed via
    // `nm -D` on the built .so during integration).
    GET_CLASS_NAME("jfxpanama_dom_Element_getClassName",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.ELEMENT)),
    GET_ATTRIBUTE("jfxpanama_dom_Element_getAttribute",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    GET_ATTRIBUTE_NS("jfxpanama_dom_Element_getAttributeNS",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.CHAR16_STRING, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),

    // Input-only string args (shape 2), void, no exception forwarding.
    REMOVE_ATTRIBUTE_NS("jfxpanama_dom_Element_removeAttributeNS",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),

    // Primitive getter/setter (shape 1), including no-arg void methods and
    // ones taking only PrimitiveKind params.
    HAS_ATTRIBUTE_NS("jfxpanama_dom_Element_hasAttributeNS",
            Signature.of(PrimitiveKind.BOOLEAN, DomKind.ELEMENT, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),
    FOCUS("jfxpanama_dom_Element_focus",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT)),
    BLUR("jfxpanama_dom_Element_blur",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT)),
    SCROLL_INTO_VIEW("jfxpanama_dom_Element_scrollIntoView",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.BOOLEAN)),
    SCROLL_INTO_VIEW_IF_NEEDED("jfxpanama_dom_Element_scrollIntoViewIfNeeded",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.BOOLEAN)),
    WEBKIT_REQUEST_FULL_SCREEN("jfxpanama_dom_Element_webkitRequestFullScreen",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT, PrimitiveKind.SHORT)),
    WEBKIT_REQUEST_FULLSCREEN("jfxpanama_dom_Element_webkitRequestFullscreen",
            Signature.of(PrimitiveKind.VOID, DomKind.ELEMENT)),

    // Exception forwarding (shape 5), void.
    REMOVE("jfxpanama_dom_Element_remove",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT)),
    SET_ATTRIBUTE_NS("jfxpanama_dom_Element_setAttributeNS",
            Signature.of(PrimitiveKind.VOID, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING, PrimitiveKind.UTF8_CSTRING)),

    // Primitive/object-handle return + exception forwarding combined (shape 7):
    // the downcall's own non-VOID return is unaffected by the exchange, which
    // only ever carries error info via throwFn().
    // NOTE: matches/closest are NOT here -- reverted, no working JNI
    // implementation existed to preserve behavior from (confirmed via `nm -D`
    // on the built .so during integration). webkitMatchesSelector's JNI
    // implementation DOES exist and was verified working, so it stayed.
    WEBKIT_MATCHES_SELECTOR("jfxpanama_dom_Element_webkitMatchesSelector",
            Signature.of(PrimitiveKind.BOOLEAN, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    QUERY_SELECTOR("jfxpanama_dom_Element_querySelector",
            Signature.of(DomKind.ELEMENT, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING)),
    QUERY_SELECTOR_ALL("jfxpanama_dom_Element_querySelectorAll",
            Signature.of(DomKind.NODE_LIST, ReturnExchangeKind.BYTE_EXCHANGE, DomKind.ELEMENT,
                    PrimitiveKind.UTF8_CSTRING));

    private final String symbol;
    private final Signature signature;

    ElementImplSignature(String symbol, Signature signature) {
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
