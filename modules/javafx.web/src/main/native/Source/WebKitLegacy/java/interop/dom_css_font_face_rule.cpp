// Panama downcall targets for WebCore::CSSFontFaceRule -- see dom_element.cpp's
// header comment for the general shape. First touch of the CSS domain.
//
// dom_css_font_face_rule_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSFontFaceRuleImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/CSSFontFaceDescriptors.h>
#include <WebCore/CSSFontFaceRule.h>
#include <WebCore/CSSStyleDeclaration.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_font_face_rule_api.hj"

extern "C" {

// Object-handle return (plans/patterns/pattern-object-handle-return.md):
// fresh ref minted per call, same as the old JNI JavaReturn<CSSFontFaceDescriptors>.
// CSSFontFaceDescriptors upcasts cleanly to the generic CSSStyleDeclaration*
// this signature spells (same base-pointer-return trick as
// DocumentImplSignature.GET_HEAD).
CSSStyleDeclaration* jfxpanama_dom_CSSFontFaceRule_getStyle(CSSFontFaceRule* peer)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<CSSStyleDeclaration> { &peer->style() }.leakRef();
}

}
