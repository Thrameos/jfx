// Hand-written (not generated) helper shared by every String-return shim --
// plans/patterns/pattern-string-return.md. Include *after* whichever
// generated dom_*_api.hj the .cpp file already needs (it defines the real
// Char16StringExchange struct layout via com.sun.webkit.dom.interop.
// ReturnExchangeKind.CHAR16_STRING; this header only uses that name, never defines
// it, so any one dom_*_api.hj that references ReturnExchangeKind.CHAR16_STRING is
// enough).
#pragma once

#include <wtf/text/WTFString.h>
#include <cstring>

// A null WTF::String round-trips as Java null (Char16StringExchange.value()
// returns null when reserve() was never called) by simply skipping reserve()
// entirely -- exactly the old JavaReturn<String>'s null-jstring behavior.
inline void writeChar16String(const WTF::String& value, Char16StringExchange* exchange)
{
    if (value.isNull()) {
        return;
    }
    unsigned length = value.length();
    long byteSize = static_cast<long>(length) * static_cast<long>(sizeof(uint16_t));
    void* buffer = exchange->reserve(exchange->closure, byteSize);
    if (length == 0) {
        return;
    }
    if (value.is8Bit()) {
        auto src = value.span8();
        uint16_t* dst = static_cast<uint16_t*>(buffer);
        for (unsigned i = 0; i < length; ++i) {
            dst[i] = src[i];
        }
    } else {
        memcpy(buffer, value.span16().data(), byteSize);
    }
}
