package org.openjfx.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.charset.StandardCharsets;

/**
 * A NUL-terminated UTF-8 {@code const char*} argument, backed by a pooled
 * {@link Transfer} instead of a fresh {@code Arena.allocate} per call -- the
 * downcall-side counterpart to {@link Exchange}'s pooled reserve buffer. Meant to be
 * used exactly like any other {@link Transfer}, in a try-with-resources scoped to
 * the single downcall the string is an argument to:
 *
 * <pre>{@code
 * try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
 *     someDowncall.invoke(peer, utf8.segment());
 * }
 * }</pre>
 *
 * <p>Named {@code CString8}, not {@code CString}, on purpose: every down-call string
 * argument derisked so far happens to be narrow UTF-8, but WebCore's real
 * {@code WTF::String} is natively UTF-16 (see {@link Exchange#readUtf16String()} on
 * the *return* side), so a {@code const UChar*} argument is a real future need, not
 * a hypothetical one -- {@code CString16} when that call site shows up, same shape,
 * {@code UTF_16} charset and a 2-byte NUL instead of 1. Don't let this class's name
 * silently claim to be the only C-string width there is.
 */
public final class CString8 {

    private CString8() {
    }

    public static Transfer of(String value, TransferPool pool) {
        byte[] utf8 = value.getBytes(StandardCharsets.UTF_8);
        // +1 for the NUL terminator; repurpose() already zero-filled the block, so
        // it is there without writing it explicitly.
        Transfer transfer = pool.allocate(utf8.length + 1, 1);
        MemorySegment.copy(utf8, 0, transfer.segment(), ValueLayout.JAVA_BYTE, 0, utf8.length);
        return transfer;
    }
}
