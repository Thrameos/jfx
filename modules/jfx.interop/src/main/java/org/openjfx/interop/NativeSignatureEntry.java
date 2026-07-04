package org.openjfx.interop;

/**
 * One native entry point: a symbol name paired with the real {@link Signature} used
 * to bind it. A per-subsystem {@code enum} implements this -- one constant per entry
 * point -- so the generator can read every entry via {@code Class.getEnumConstants()}
 * with no per-field annotation needed; the enum constant itself carries the pairing.
 * The enclosing enum type carries {@code @NativeHeader} to name the generated file.
 */
public interface NativeSignatureEntry {
    String symbol();
    Signature signature();
}
