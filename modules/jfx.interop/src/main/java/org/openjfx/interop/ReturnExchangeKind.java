package org.openjfx.interop;

import org.openjfx.interop.annotations.NativeKindSet;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.List;

/**
 * The {@code Kind}s for every exchange struct a downcall can use to carry a
 * {@code reserve}/{@code throw}/{@code data}/{@code closure} return channel back from
 * native, per plans/roadmap-foundations.md's "Exception propagation across the
 * downcall boundary" section. Named {@code Return}Exchange, not just {@code Exchange},
 * to distinguish this family from a future Args Exchange -- a Java-handed-down handle
 * acting like an array accessor for native to repeatedly push/pull ranges of values,
 * a cursor/iterator shape rather than this family's one-shot write-once buffer.
 *
 * <p>{@link #BYTE_EXCHANGE} and {@link #CHAR16_STRING} share the exact same wire shape
 * (reserve/throwFn/data/closure) but stay distinct enum values -- and distinct
 * generated C struct/typedef names -- on purpose: a generated header naming the real,
 * narrower type ({@code Char16StringExchange*}, meaning "this downcall's reserve
 * buffer is UTF-16 text") lets the C++ compiler catch a String-return shim
 * accidentally wired to a differently-shaped exchange, instead of both silently
 * compiling against the same generic struct name. Distinct {@code ReserveFn}/
 * {@code ThrowFn} typedef names per value avoid a duplicate-typedef clash on the rare
 * header that ends up using both.
 */
@NativeKindSet
public enum ReturnExchangeKind implements Kind {

    /**
     * {@link ByteExchange}'s Kind: a raw, variable-length run of bytes. The one
     * non-primitive Kind this project needed first -- demonstrates a module adding
     * its own {@link Kind} rather than {@link Kind} needing to anticipate every
     * struct shape up front. The generated C struct name stays {@code Exchange} (not
     * {@code ByteExchange}) -- every mock {@code .c} file across
     * demo/faultproof/domexceptions already spells it that way; the Java-side name is
     * about naming what the value specializes in, not renaming the wire shape.
     */
    BYTE_EXCHANGE {
        @Override
        public Layout cLayout() {
            return BYTE_LAYOUT;
        }
    },

    /**
     * {@link Char16StringExchange}'s Kind -- deliberately its own struct type, not a
     * reuse of {@link #BYTE_EXCHANGE}, even though the wire shape is identical. Same
     * rationale {@code DomKind}'s class doc gives for spelling {@code Element*}
     * instead of a generic {@code void*}: see the class doc above.
     */
    CHAR16_STRING {
        @Override
        public Layout cLayout() {
            return CHAR16_STRING_LAYOUT;
        }
    };

    private static final Layout.Struct BYTE_LAYOUT = new Layout.Struct(
            "Exchange",
            List.of(
                    new Layout.Field("reserve", "ReserveFn", ValueLayout.ADDRESS),
                    new Layout.Field("throwFn", "ThrowFn", ValueLayout.ADDRESS),
                    new Layout.Field("data", "void*", ValueLayout.ADDRESS),
                    new Layout.Field("closure", "long", ValueLayout.JAVA_LONG)),
            List.of(
                    "typedef void* (*ReserveFn)(long closure, long size);",
                    "typedef void  (*ThrowFn)(long closure, int code, const char* message);"));

    private static final Layout.Struct CHAR16_STRING_LAYOUT = new Layout.Struct(
            "Char16StringExchange",
            List.of(
                    new Layout.Field("reserve", "Char16ReserveFn", ValueLayout.ADDRESS),
                    new Layout.Field("throwFn", "Char16ThrowFn", ValueLayout.ADDRESS),
                    new Layout.Field("data", "void*", ValueLayout.ADDRESS),
                    new Layout.Field("closure", "long", ValueLayout.JAVA_LONG)),
            List.of(
                    "typedef void* (*Char16ReserveFn)(long closure, long size);",
                    "typedef void  (*Char16ThrowFn)(long closure, int code, const char* message);"));

    @Override
    public ValueLayout layout() {
        // Exchange crosses the boundary by pointer, not by value.
        return ValueLayout.ADDRESS;
    }

    @Override
    public Class<?> carrier() {
        return MemorySegment.class;
    }
}
