package org.openjfx.interop;

import org.openjfx.interop.annotations.NativeKindSet;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.List;

/**
 * {@link Char16StringExchange}'s {@code Kind} -- deliberately its own struct
 * type, not a reuse of {@link ByteExchangeKind}, even though the wire shape
 * (reserve/throwFn/data/closure) is identical. Same rationale
 * {@code DomKind}'s class doc gives for spelling {@code Element*} instead of a
 * generic {@code void*}: a generated header naming the real, narrower type
 * ({@code Char16StringExchange*}, meaning "this downcall's reserve buffer is
 * UTF-16 text") lets the C++ compiler catch a String-return shim accidentally
 * wired to a differently-shaped exchange, instead of both silently compiling
 * against the same generic struct name. Distinct {@code ReserveFn}/
 * {@code ThrowFn} typedef names (not {@code ByteExchangeKind}'s) avoid a
 * duplicate-typedef clash on the rare header that ends up using both kinds.
 */
@NativeKindSet
public enum Char16StringExchangeKind implements Kind {
    EXCHANGE;

    private static final Layout.Struct C_LAYOUT = new Layout.Struct(
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

    @Override
    public Layout cLayout() {
        return C_LAYOUT;
    }
}
