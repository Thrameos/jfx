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
    HTML_TEXT_AREA_ELEMENT("HTMLTextAreaElement*"),
    NAMED_NODE_MAP("NamedNodeMap*"),
    NODE_LIST("NodeList*"),
    CSS_FONT_FACE_RULE("CSSFontFaceRule*"),
    CSS_STYLE_DECLARATION("CSSStyleDeclaration*"),

    // Remaining dom/ peer types, filled in ahead of the per-class
    // Signature/Binding/native-shim work so the alphabetical sweep doesn't
    // re-derive the same WebCore header/JNI-cast lookups file by file.
    // Real C++ type names taken from each old JNI shim's
    // "#define IMPL (static_cast<T*>(jlong_to_ptr(peer)))" macro, not
    // guessed from the Java class name -- several diverge from it
    // (CSSPrimitiveValue/CSSValue/CSSValueList/Counter/RGBColor/Rect all
    // route through WebCore's "DeprecatedCSSOM*" types; HTMLBaseFontElement
    // routes through HTMLUnknownElement). CSSCharsetRuleImpl and EntityImpl
    // are deliberately omitted here: both are fully phantom (no real
    // WebCore type backs them at all -- see CSSCharsetRuleImpl's pure-Java
    // stub conversion), so there is no real pointer type to spell.
    CSS_IMPORT_RULE("CSSImportRule*"),
    CSS_MEDIA_RULE("CSSMediaRule*"),
    CSS_PAGE_RULE("CSSPageRule*"),
    CSS_PRIMITIVE_VALUE("DeprecatedCSSOMPrimitiveValue*"),
    CSS_RULE("CSSRule*"),
    CSS_RULE_LIST("CSSRuleList*"),
    CSS_STYLE_RULE("CSSStyleRule*"),
    CSS_STYLE_SHEET("CSSStyleSheet*"),
    CSS_UNKNOWN_RULE("CSSUnknownRule*"),
    CSS_VALUE("DeprecatedCSSOMValue*"),
    CSS_VALUE_LIST("DeprecatedCSSOMValueList*"),
    COMMENT("Comment*"),
    COUNTER("DeprecatedCSSOMCounter*"),
    DOM_IMPLEMENTATION("DOMImplementation*"),
    DOM_SELECTION("DOMSelection*"),
    DOM_STRING_LIST("DOMStringList*"),
    DOM_WINDOW("DOMWindow*"),
    DOCUMENT_FRAGMENT("DocumentFragment*"),
    DOCUMENT_TYPE("DocumentType*"),
    ENTITY_REFERENCE("EntityReference*"),
    EVENT("Event*"),
    EVENT_TARGET("EventTarget*"),
    EVENT_LISTENER("EventListener*"),
    HTML_APPLET_ELEMENT("HTMLAppletElement*"),
    HTML_AREA_ELEMENT("HTMLAreaElement*"),
    HTML_BR_ELEMENT("HTMLBRElement*"),
    HTML_BASE_ELEMENT("HTMLBaseElement*"),
    HTML_BASE_FONT_ELEMENT("HTMLUnknownElement*"),
    HTML_BUTTON_ELEMENT("HTMLButtonElement*"),
    HTML_COLLECTION("HTMLCollection*"),
    HTML_D_LIST_ELEMENT("HTMLDListElement*"),
    HTML_DIRECTORY_ELEMENT("HTMLDirectoryElement*"),
    HTML_DIV_ELEMENT("HTMLDivElement*"),
    HTML_DOCUMENT("HTMLDocument*"),
    HTML_FIELD_SET_ELEMENT("HTMLFieldSetElement*"),
    HTML_FONT_ELEMENT("HTMLFontElement*"),
    HTML_FRAME_ELEMENT("HTMLFrameElement*"),
    HTML_FRAME_SET_ELEMENT("HTMLFrameSetElement*"),
    HTML_HR_ELEMENT("HTMLHRElement*"),
    HTML_HEAD_ELEMENT("HTMLHeadElement*"),
    HTML_HEADING_ELEMENT("HTMLHeadingElement*"),
    HTML_HTML_ELEMENT("HTMLHtmlElement*"),
    HTML_IFRAME_ELEMENT("HTMLIFrameElement*"),
    HTML_LI_ELEMENT("HTMLLIElement*"),
    HTML_LABEL_ELEMENT("HTMLLabelElement*"),
    HTML_LEGEND_ELEMENT("HTMLLegendElement*"),
    HTML_LINK_ELEMENT("HTMLLinkElement*"),
    HTML_MAP_ELEMENT("HTMLMapElement*"),
    HTML_MENU_ELEMENT("HTMLMenuElement*"),
    HTML_META_ELEMENT("HTMLMetaElement*"),
    HTML_MOD_ELEMENT("HTMLModElement*"),
    HTML_O_LIST_ELEMENT("HTMLOListElement*"),
    HTML_OBJECT_ELEMENT("HTMLObjectElement*"),
    HTML_OPT_GROUP_ELEMENT("HTMLOptGroupElement*"),
    HTML_OPTION_ELEMENT("HTMLOptionElement*"),
    HTML_OPTIONS_COLLECTION("HTMLOptionsCollection*"),
    HTML_PARAGRAPH_ELEMENT("HTMLParagraphElement*"),
    HTML_PARAM_ELEMENT("HTMLParamElement*"),
    HTML_PRE_ELEMENT("HTMLPreElement*"),
    HTML_QUOTE_ELEMENT("HTMLQuoteElement*"),
    HTML_SCRIPT_ELEMENT("HTMLScriptElement*"),
    HTML_STYLE_ELEMENT("HTMLStyleElement*"),
    HTML_TABLE_CAPTION_ELEMENT("HTMLTableCaptionElement*"),
    HTML_TABLE_CELL_ELEMENT("HTMLTableCellElement*"),
    HTML_TABLE_COL_ELEMENT("HTMLTableColElement*"),
    HTML_TABLE_ROW_ELEMENT("HTMLTableRowElement*"),
    HTML_TABLE_SECTION_ELEMENT("HTMLTableSectionElement*"),
    HTML_TITLE_ELEMENT("HTMLTitleElement*"),
    HTML_U_LIST_ELEMENT("HTMLUListElement*"),
    KEYBOARD_EVENT("KeyboardEvent*"),
    MEDIA_LIST("MediaList*"),
    MOUSE_EVENT("MouseEvent*"),
    MUTATION_EVENT("MutationEvent*"),
    NODE_FILTER("NodeFilter*"),
    NODE_ITERATOR("NodeIterator*"),
    PROCESSING_INSTRUCTION("ProcessingInstruction*"),
    RGB_COLOR("DeprecatedCSSOMRGBColor*"),
    RANGE("Range*"),
    RECT("DeprecatedCSSOMRect*"),
    STYLE_SHEET("StyleSheet*"),
    STYLE_SHEET_LIST("StyleSheetList*"),
    TEXT("Text*"),
    TREE_WALKER("TreeWalker*"),
    UI_EVENT("UIEvent*"),
    WHEEL_EVENT("WheelEvent*"),
    X_PATH_EXPRESSION("XPathExpression*"),
    X_PATH_NS_RESOLVER("XPathNSResolver*"),
    X_PATH_RESULT("XPathResult*");

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
