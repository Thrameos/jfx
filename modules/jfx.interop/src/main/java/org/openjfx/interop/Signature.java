package org.openjfx.interop;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryLayout;
import java.lang.invoke.MethodType;

/**
 * A native function's shape: one return Kind plus a fixed list of parameter Kinds.
 * Builds the {@link FunctionDescriptor} and {@link MethodType} Binder/Upcall need,
 * so no tier hand-rolls its own descriptor construction.
 */
public record Signature(Kind returnKind, Kind... paramKinds) {

    public static Signature of(Kind returnKind, Kind... paramKinds) {
        return new Signature(returnKind, paramKinds);
    }

    public FunctionDescriptor descriptor() {
        MemoryLayout[] paramLayouts = new MemoryLayout[paramKinds.length];
        for (int i = 0; i < paramKinds.length; i++) {
            paramLayouts[i] = paramKinds[i].layout();
        }
        return returnKind == Kind.VOID
                ? FunctionDescriptor.ofVoid(paramLayouts)
                : FunctionDescriptor.of(returnKind.layout(), paramLayouts);
    }

    public MethodType methodType() {
        Class<?>[] paramCarriers = new Class<?>[paramKinds.length];
        for (int i = 0; i < paramKinds.length; i++) {
            paramCarriers[i] = paramKinds[i].carrier();
        }
        return MethodType.methodType(returnKind.carrier(), paramCarriers);
    }
}
