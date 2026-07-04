package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import org.openjfx.interop.Kind;
import org.openjfx.interop.Layout;
import org.openjfx.interop.annotations.NativeKindSet;

/**
 * Opaque WebCore pointer kinds -- same {@code ADDRESS}/{@link MemorySegment} FFI
 * layout as {@code PrimitiveKind.HANDLE}, but each spells a real C++ pointer type
 * ({@code Element*}, not a generic {@code void*}) in the generated header.
 *
 * <p>A {@code void*} peer parameter compiles fine even if the wrong kind of
 * WebCore object is ever passed to it -- no compile-time signal at all that
 * a {@code Node*} was passed where an {@code Element*} was expected. Spelling
 * the real pointee type in the generated {@code .hj} header gives the C++
 * compiler a chance to catch exactly that mistake, at zero runtime cost --
 * the same principle
 * {@code plans/patterns/pattern-interop-binding-generation.md} already
 * applies to function-pointer kinds ({@code DispatchFn}, never a generic
 * {@code void*} callback pointer): whenever a real WebKit C type isn't a
 * plain scalar or opaque pointer, that's a new {@code Kind}, not a
 * "good enough" generic stand-in.
 *
 * <p>Domain-specific on purpose, living in {@code com.sun.webkit.dom.interop}
 * rather than the shared {@code org.openjfx.interop} core -- {@code Element}
 * is a WebCore type, not something the domain-agnostic core (designed for
 * reuse by future non-WebKit Panama consumers) should know about. Matches
 * {@code ExchangeKind}'s
 * precedent: modules add their own {@code Kind} implementations for the struct/
 * pointer types they introduce, without touching {@code core}.
 *
 * <p>The FFI-level shape ({@code ValueLayout.ADDRESS}, {@link MemorySegment}
 * carrier) is identical to {@code PrimitiveKind.HANDLE} -- this is purely a
 * generated-header/native-compile-time type-safety improvement. No Java-side
 * behavior changes: {@code MemorySegment.ofAddress(peer)} at each
 * {@code XBinding} call site is unaffected.
 */
@NativeKindSet
public enum DomKind implements Kind {
    ELEMENT("Element*"),
    NODE("Node*"),
    CHARACTER_DATA("CharacterData*"),
    ATTR("Attr*"),
    DOCUMENT("Document*"),
    HTML_ELEMENT("HTMLElement*"),
    HTML_ANCHOR_ELEMENT("HTMLAnchorElement*"),
    HTML_IMAGE_ELEMENT("HTMLImageElement*"),
    HTML_TABLE_ELEMENT("HTMLTableElement*"),
    HTML_SELECT_ELEMENT("HTMLSelectElement*"),
    HTML_FORM_ELEMENT("HTMLFormElement*"),
    HTML_BODY_ELEMENT("HTMLBodyElement*"),
    HTML_INPUT_ELEMENT("HTMLInputElement*"),
    NAMED_NODE_MAP("NamedNodeMap*");

    private final Layout.Primitive cLayout;

    DomKind(String cType) {
        this.cLayout = new Layout.Primitive(cType);
    }

    @Override
    public ValueLayout layout() {
        return ValueLayout.ADDRESS;
    }

    @Override
    public Class<?> carrier() {
        return MemorySegment.class;
    }

    @Override
    public Layout cLayout() {
        return cLayout;
    }
}
