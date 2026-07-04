package org.openjfx.interop;

import java.lang.foreign.MemoryLayout;
import java.util.List;

/**
 * The C-side type/struct shape a {@link Kind} carries, alongside its FFI
 * {@code MemoryLayout} -- what the {@code .hj} generator needs to spell out that
 * Kind's declaration in the header, which {@link Kind#layout()} alone (an FFI
 * calling-convention layout, e.g. {@code ADDRESS} for any pointer) can't express.
 */
public sealed interface Layout {

    /** A plain scalar/pointer C type with no struct body of its own, e.g. {@code int32_t}, {@code void*}. */
    record Primitive(String cType) implements Layout {}

    /**
     * A named C struct this Kind is a pointer to. {@code fields} drives the generated
     * {@code typedef struct { ... } name;} body; {@code typedefs} are any auxiliary
     * {@code typedef}s the field types depend on (e.g. function-pointer typedefs),
     * emitted once, before the struct body, by the generator.
     */
    record Struct(String cTypeName, List<Field> fields, List<String> typedefs) implements Layout {
        public Struct(String cTypeName, List<Field> fields) {
            this(cTypeName, fields, List.of());
        }
    }

    /** One member of a generated struct: its name, its C type spelling, and its FFI layout. */
    record Field(String name, String cType, MemoryLayout layout) {}

    /**
     * A named C function-pointer type this Kind represents -- e.g. a persistent
     * upcall closure parameter. Generates {@code typedef returnCType (*typedefName)
     * (paramCTypes...);} once, and uses {@code typedefName} as the C type wherever
     * this Kind appears -- the function-pointer counterpart to {@link Struct}: a
     * {@code void*} generic pointer gives no compile-time guarantee the C side
     * expects *this* callback shape specifically; a named typedef does.
     */
    record FunctionPointer(String typedefName, String cReturnType, List<String> paramCTypes) implements Layout {}
}
