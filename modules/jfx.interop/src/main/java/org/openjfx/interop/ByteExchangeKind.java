package org.openjfx.interop;

import org.openjfx.interop.annotations.NativeKindSet;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.List;

/**
 * {@link ByteExchange}'s Kind: a pointer to the {@code reserve}/{@code throw}/
 * {@code data}/{@code closure} struct every throwing or variable-length-returning
 * downcall takes, per plans/roadmap-foundations.md's "Exception propagation across
 * the downcall boundary" section. The one non-primitive Kind this project needs so
 * far -- demonstrates a module adding its own {@link Kind} rather than {@link Kind}
 * needing to anticipate every struct shape up front. The generated C struct name
 * stays {@code Exchange} (not {@code ByteExchange}) -- every mock {@code .c} file
 * across demo/faultproof/domexceptions already spells it that way; the Java-side
 * rename is about naming what the class specializes in, not renaming the wire shape.
 */
@NativeKindSet
public enum ByteExchangeKind implements Kind {
    EXCHANGE;

    private static final Layout.Struct C_LAYOUT = new Layout.Struct(
            "Exchange",
            List.of(
                    new Layout.Field("reserve", "ReserveFn", ValueLayout.ADDRESS),
                    new Layout.Field("throwFn", "ThrowFn", ValueLayout.ADDRESS),
                    new Layout.Field("data", "void*", ValueLayout.ADDRESS),
                    new Layout.Field("closure", "long", ValueLayout.JAVA_LONG)),
            List.of(
                    "typedef void* (*ReserveFn)(long closure, long size);",
                    "typedef void  (*ThrowFn)(long closure, int code, const char* message);"));

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
