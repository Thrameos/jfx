package org.openjfx.interop;

/**
 * The C&harr;Java type atom for every downcall/upcall parameter and return, and for
 * every struct field a generated header declares. An interface, not a fixed enum, so
 * each module can add its own {@code Kind} implementations for the DTO/struct types
 * it introduces (e.g. {@link ExchangeKind}) without touching this file -- the same
 * shape as {@code radixllm-java}'s {@code Signature.Kind}, resolved in
 * {@code plans/roadmap.md} to allow per-entry, not just shared-{@code ADDRESS}, layouts.
 *
 * <p>{@link #layout()} is the FFI calling-convention layout ({@link Signature}/
 * {@link java.lang.foreign.FunctionDescriptor} use this directly) -- for a Kind that
 * represents a pointer to a struct, this is {@code ValueLayout.ADDRESS}, not the
 * struct's own layout, since the struct crosses the boundary by pointer. {@link #cLayout()}
 * is the separate, generator-facing C type/struct shape that layout() alone can't express.
 */
public interface Kind {

    java.lang.foreign.MemoryLayout layout();

    Class<?> carrier();

    Layout cLayout();

    Kind VOID = PrimitiveKind.VOID;
    Kind HANDLE = PrimitiveKind.HANDLE;
    Kind INT = PrimitiveKind.INT;
    Kind LONG = PrimitiveKind.LONG;
    Kind SHORT = PrimitiveKind.SHORT;
    Kind BOOLEAN = PrimitiveKind.BOOLEAN;
    Kind FLOAT = PrimitiveKind.FLOAT;
    Kind DOUBLE = PrimitiveKind.DOUBLE;
}
