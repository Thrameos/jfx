// Panama downcall targets for WebCore::DeprecatedCSSOMValueList (the peer
// type old JNI actually used for CSSValueListImpl -- same deprecated-CSSOM-
// wrapper situation as dom_css_value.cpp/dom_css_primitive_value.cpp).
//
// dom_css_value_list_api.hj is GENERATED (com.sun.webkit.dom.interop.
// CSSValueListImplSignature is the source of truth) -- never hand-edit it.
#include <WebCore/DeprecatedCSSOMValue.h>
#include <WebCore/DeprecatedCSSOMValueList.h>
#include <WebCore/JSExecState.h>

using namespace WebCore;

#include "dom_css_value_list_api.hj"

extern "C" {

int jfxpanama_dom_CSSValueList_getLength(DeprecatedCSSOMValueList* peer)
{
    WebCore::JSMainThreadNullState state;
    return static_cast<int>(peer->length());
}

// item() is a nullable raw pointer into the list's already-constructed
// Vector<Ref<DeprecatedCSSOMValue>> -- a stable, non-fresh wrapper per index
// (out-of-range yields nullptr), unlike CSSPrimitiveValueImpl's
// getRectValue/getRGBColorValue which mint a new wrapper every call.
DeprecatedCSSOMValue* jfxpanama_dom_CSSValueList_item(DeprecatedCSSOMValueList* peer, int index)
{
    WebCore::JSMainThreadNullState state;
    return RefPtr<DeprecatedCSSOMValue> { peer->item(static_cast<size_t>(index)) }.leakRef();
}

}
