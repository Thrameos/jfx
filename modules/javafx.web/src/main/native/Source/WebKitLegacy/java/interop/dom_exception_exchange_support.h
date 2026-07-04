// Hand-written (not generated) helper shared by every exception-forwarding
// shim -- plans/patterns/pattern-exception-forwarding.md. WebCore::
// ExceptionOr/DOMException knowledge stays here, on the native/DOM-specific
// side of the boundary -- org.openjfx.interop's ByteExchange only ever
// carries a generic (int code, const char* message) pair, exactly the same
// domain-agnostic-core-vs-DOM-specific-Kind split DomKind and
// Char16StringExchangeKind already keep. Include after whichever generated
// dom_*_api.hj the .cpp file needs (it defines the real Exchange struct
// layout via com.sun.webkit.dom.interop.ByteExchangeKind).
#pragma once

#include <WebCore/DOMException.h>
#include <WebCore/ExceptionOr.h>

// Mirrors JavaDOMUtils.h's raiseDOMErrorException exactly: only the
// ExceptionCode's *generic* description (legacyCode + stock message) crosses
// the boundary, never Exception::message() -- the old JNI path drops the
// custom per-call message too (raiseDOMErrorException(JNIEnv*, Exception&&)
// only reads ec.code()), so this preserves that behavior rather than
// "improving" it into a mismatch with JNI's fallback path.
inline void throwDOMException(WebCore::ExceptionCode code, Exchange* exchange)
{
    auto& description = WebCore::DOMException::description(code);
    exchange->throwFn(exchange->closure, description.legacyCode, description.message.characters());
}

// Returns true if an exception was forwarded (caller should stop -- there is
// no meaningful return value left to produce), false on success.
inline bool forwardIfException(const WebCore::ExceptionOr<void>& result, Exchange* exchange)
{
    if (result.hasException()) {
        throwDOMException(result.exception().code(), exchange);
        return true;
    }
    return false;
}
