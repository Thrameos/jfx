package org.openjfx.interop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a {@code Kind}-implementing enum as vetted for the generator to consume --
 * the {@code Kind} counterpart to {@link NativeHeader} marking a {@code Signature}
 * enum. Not just symmetry: the generator checks every {@code Kind} it encounters
 * (via a {@code org.openjfx.interop.NativeSignatureEntry}'s {@code Signature})
 * came from a class carrying
 * this annotation, and fails loudly otherwise -- so an ad hoc, un-vetted
 * {@code org.openjfx.interop.Kind} can't silently make it into a generated header.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NativeKindSet {
}
