package org.openjfx.interop;

import org.openjfx.interop.annotations.NativeKindSet;

import java.lang.foreign.ValueLayout;

/**
 * The value shapes every DOM-binding native method's non-struct parameters and
 * returns reduce to, across all 1832 methods surveyed in
 * plans/roadmap-foundations.md's census. The default {@link Kind} implementation --
 * modules that need struct-carrying Kinds (e.g. {@link ExchangeKind}) add their own
 * enum implementing {@link Kind} instead of extending this one.
 *
 * <p>{@code HANDLE} and {@code UTF8_CSTRING} share one FFI layout (ADDRESS/
 * MemorySegment -- Panama doesn't care) but spell different C types ({@code void*}
 * vs {@code const char*}), the same one-layout/several-Kinds shape
 * {@code radixllm-java}'s {@code Layout.Kind} uses (its {@code POINTER}/
 * {@code STRING}/{@code MODEL}/... all share {@code C_POINTER}). Distinguishing
 * them here is what lets the generator emit a header that exactly matches a
 * hand-written {@code const char*} parameter instead of a generic {@code void*}
 * that would conflict with it at C-compile time.
 *
 * <p>Named {@code UTF8_CSTRING}, not {@code STRING} -- a bare "string" Kind is
 * exactly the ambiguity {@link Kind} exists to rule out: this project alone
 * has three incompatible on-the-wire string shapes (this one, input-only
 * NUL-terminated UTF-8 via {@link CString8}; {@link ReturnExchangeKind#CHAR16_STRING},
 * output-only length-prefixed UTF-16 matching {@code WTF::String}'s native
 * form; and whatever a future UTF-32 or raw-bytes need turns out to require).
 * A generic {@code STRING} constant would silently invite exactly the
 * void*-for-Element* style mistake {@code DomKind}'s class doc warns about,
 * just one level up -- at the "which string encoding" level instead of "which
 * pointee type." Every {@code Kind} name states its exact wire shape, no
 * exceptions.
 */
@NativeKindSet
public enum PrimitiveKind implements Kind {
    VOID(null, void.class, "void"),
    HANDLE(ValueLayout.ADDRESS, java.lang.foreign.MemorySegment.class, "void*"),
    UTF8_CSTRING(ValueLayout.ADDRESS, java.lang.foreign.MemorySegment.class, "const char*"),
    INT(ValueLayout.JAVA_INT, int.class, "int32_t"),
    LONG(ValueLayout.JAVA_LONG, long.class, "int64_t"),
    SHORT(ValueLayout.JAVA_SHORT, short.class, "int16_t"),
    BOOLEAN(ValueLayout.JAVA_BOOLEAN, boolean.class, "bool"),
    FLOAT(ValueLayout.JAVA_FLOAT, float.class, "float"),
    DOUBLE(ValueLayout.JAVA_DOUBLE, double.class, "double");

    private final ValueLayout layout;
    private final Class<?> carrier;
    private final Layout.Primitive cLayout;

    PrimitiveKind(ValueLayout layout, Class<?> carrier, String cType) {
        this.layout = layout;
        this.carrier = carrier;
        this.cLayout = new Layout.Primitive(cType);
    }

    @Override
    public ValueLayout layout() {
        if (layout == null) {
            throw new IllegalStateException("VOID has no value layout");
        }
        return layout;
    }

    @Override
    public Class<?> carrier() {
        return carrier;
    }

    @Override
    public Layout cLayout() {
        return cLayout;
    }
}
