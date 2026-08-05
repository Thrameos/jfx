package org.openjfx.interop;

import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.util.Optional;

/**
 * Resolves a symbol against a loaded native library and binds it to a
 * {@link Signature}, producing a downcall {@link MethodHandle} -- the Panama
 * replacement for JNI's implicit "native static ..." method resolution. One Binder
 * per loaded library; every tier's *Impl class holds exactly one of these instead of
 * a per-method JNI native-method declaration.
 */
public final class Binder {

    private final SymbolLookup lookup;
    private final Linker linker = Linker.nativeLinker();

    public Binder(SymbolLookup lookup) {
        this.lookup = lookup;
    }

    public static Binder forLibrary(String libraryName) {
        System.loadLibrary(libraryName);
        return new Binder(SymbolLookup.loaderLookup());
    }

    public MethodHandle downcall(String symbol, Signature signature) {
        Optional<java.lang.foreign.MemorySegment> address = lookup.find(symbol);
        if (address.isEmpty()) {
            throw new IllegalStateException("Native symbol not found: " + symbol);
        }
        return linker.downcallHandle(address.get(), signature.descriptor());
    }

    public Linker linker() {
        return linker;
    }
}
