package org.openjfx.interop;

/**
 * {@link ByteExchange} typed for the one interpretation every {@code WTF::String}
 * return uses: UTF-16 code units. Wraps rather than extends ({@link ByteExchange}
 * is {@code final} on purpose -- the raw reserve/throw/data struct stays a single,
 * un-subclassed wire shape) so call sites read {@code exchange.value()} /
 * {@code exchange.threw()} instead of every {@code *ImplBinding} repeating
 * {@code readUtf16String()} and the raw-bytes vocabulary that word implies.
 *
 * <p>Same wire shape as {@link ByteExchange} ({@link ReturnExchangeKind#BYTE_EXCHANGE} is
 * still the {@code Kind} a {@code Signature} declares -- there is nothing
 * Char16-specific for the generated header to know about), purely a Java-side
 * naming/typing convenience. A future exchange shape with a genuinely different
 * interpretation (e.g. a fixed-layout struct array) is a sibling class here, not a
 * reason to make this one generic again.
 */
public final class Char16StringExchange implements AutoCloseable {

    private final ByteExchange exchange = new ByteExchange();

    public Char16StringExchange() {
    }

    /** The struct's address -- pass this as the exchange argument to the downcall. */
    public java.lang.foreign.MemorySegment segment() {
        return exchange.segment();
    }

    public boolean threw() {
        return exchange.threw();
    }

    public int errorCode() {
        return exchange.errorCode();
    }

    public String errorMessage() {
        return exchange.errorMessage();
    }

    /** The returned {@code WTF::String}, or {@code null} if native never reserved (a null String). */
    public String value() {
        return exchange.readUtf16String();
    }

    @Override
    public void close() {
        exchange.close();
    }
}
