package org.openjfx.interop;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

/**
 * Builds a native-callable function pointer (an upcall stub) from a Java
 * {@link MethodHandle} and a {@link Signature} -- the Panama replacement for JNI's
 * implicit "native calls back into whatever Java method name it's told" upcall
 * convention (env-&gt;CallVoidMethod/CallStaticVoidMethod). Used both by the transient
 * Exchange struct (reserve/throw) and by tier6's persistent EventListener closure.
 */
public final class Upcall {

    private Upcall() {
    }

    public static MemorySegment stub(MethodHandle target, Signature signature, Arena arena) {
        return Linker.nativeLinker().upcallStub(target, signature.descriptor(), arena);
    }
}
