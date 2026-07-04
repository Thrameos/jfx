package org.openjfx.interop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Names the generated {@code .h} file a {@code NativeSignatureEntry} enum's constants
 * are collected into, e.g. {@code @NativeHeader("tier0_interop")} emits
 * {@code tier0_interop.h}. RUNTIME retention -- read by the reflective generator
 * after compilation.
 *
 * <p>{@code includes} declares any {@code #include} lines the generated header
 * itself needs to be self-contained (e.g. {@code "<stdint.h>"} for a header using
 * {@code int32_t}/{@code int64_t}) -- declared here, at the one place that actually
 * knows what a given header's entries need, rather than the generator guessing or
 * unconditionally emitting includes every header may not require.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NativeHeader {
    String value();
    String[] includes() default {};
}
