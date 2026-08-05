package org.openjfx.interop;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * The general exchange-struct pattern resolved in plans/roadmap-foundations.md's
 * "Exception propagation across the downcall boundary" section: a struct carrying a
 * {@code reserve} upcall (native asks Java to allocate an exact-sized output buffer),
 * a {@code throw} upcall (native reports a failure instead), a {@code data} field,
 * and a {@code closure} routing token. Covers every one of the 473 real DOM native
 * methods (tier3/tier7 shape) that can throw and/or return a variable-length value --
 * see the census table in roadmap-foundations.md. AutoCloseable: recycles the
 * struct's own block deterministically.
 *
 * <p>Named {@code ByteExchange}, not {@code Exchange}, on purpose: the reserved
 * buffer {@code reserve} hands back is a raw, variable-length run of bytes -- that is
 * the one thing this class actually specializes in. Nothing about {@code reserve}/
 * {@code throw}/{@code data}/{@code closure} or the pooling/trampoline/slot-resolution
 * machinery below is DOM-specific -- {@code faultproof} and {@code domexceptions}
 * both already use this class directly with no dependency on the {@code demo} (DOM)
 * module at all. {@link #readUtf16String()} is a convenience interpretation of those
 * raw bytes as WTF::String-shaped UTF-16, not a DOM dependency baked into the
 * struct's shape -- callers that need a different interpretation read
 * {@link #reservedBuffer()} directly. If a genuinely different exchange shape is ever
 * needed (e.g. one that reserves a fixed-layout struct array instead of an
 * arbitrary byte run), that is a sibling class in core, not a reason to rename this
 * one again.
 *
 * <p>Both the struct itself (a "down" transfer -- its address is what gets passed
 * into the downcall) and the variable-sized {@code reserve} buffer (an "up"
 * transfer -- native decides its size only once already inside the call, so it
 * cannot be allocated up front alongside the struct) come from the shared
 * {@link TransferPool} ({@link TransferPool#SHARED}) rather than a fresh
 * {@code Arena.allocate}/{@code close()} per call -- exactly the malloc/free churn
 * that would otherwise happen on every one of the 473 real DOM methods this covers.
 * The two are chained with {@link Transfer#link}: {@link #close()} only ever closes
 * the struct's own transfer, which cascades into recycling the reserve buffer too
 * (if {@code reserve} was ever called) -- the caller's try-with-resources never
 * needs to know a second block came into existence partway through the call.
 *
 * <p>The struct's {@code closure} field -- the token native hands back to the
 * {@code reserve}/{@code throw} upcalls -- is simply the struct transfer's
 * {@link Transfer#slot()}: {@link TransferPool#resolve} finds it, and
 * {@link Transfer#attachment()} (set to {@code this} in the constructor) recovers
 * the owning {@code ByteExchange} in one array read, no separate registry.
 */
public final class ByteExchange implements AutoCloseable {

    public static final MemoryLayout LAYOUT = MemoryLayout.structLayout(
            ValueLayout.ADDRESS.withName("reserve"),
            ValueLayout.ADDRESS.withName("throwFn"),
            ValueLayout.ADDRESS.withName("data"),
            ValueLayout.JAVA_LONG.withName("closure"));

    private static final long OFFSET_RESERVE = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserve"));
    private static final long OFFSET_THROW = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("throwFn"));
    private static final long OFFSET_DATA = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("data"));
    private static final long OFFSET_CLOSURE = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("closure"));

    private static final Signature RESERVE_SIGNATURE = Signature.of(Kind.HANDLE, Kind.LONG, Kind.LONG);
    private static final Signature THROW_SIGNATURE = Signature.of(Kind.VOID, Kind.LONG, Kind.INT, Kind.HANDLE);

    private static final MethodHandle RESERVE_TRAMPOLINE;
    private static final MethodHandle THROW_TRAMPOLINE;

    static {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            RESERVE_TRAMPOLINE = lookup.findStatic(
                    ByteExchange.class, "reserveTrampoline", RESERVE_SIGNATURE.methodType());
            THROW_TRAMPOLINE = lookup.findStatic(
                    ByteExchange.class, "throwTrampoline", THROW_SIGNATURE.methodType());
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // Real upcall-stub trampoline memory (executable, managed by the linker) --
    // stays a genuine per-instance Arena, unlike the struct/reserve-buffer data
    // blocks; there is nothing to pool here since Linker.upcallStub itself owns the
    // allocation strategy.
    private final Arena stubArena;

    private final Transfer transfer;
    private final MemorySegment struct;
    private final long token;

    private MemorySegment reservedBuffer;
    private boolean threw;
    private int errorCode;
    private String errorMessage;

    public ByteExchange() {
        this.transfer = TransferPool.SHARED.allocate(1, (int) LAYOUT.byteSize());
        this.transfer.attach(this);
        this.struct = transfer.segment();
        this.token = transfer.slot();

        this.stubArena = Arena.ofConfined();
        MemorySegment reserveStub = Upcall.stub(RESERVE_TRAMPOLINE, RESERVE_SIGNATURE, stubArena);
        MemorySegment throwStub = Upcall.stub(THROW_TRAMPOLINE, THROW_SIGNATURE, stubArena);

        struct.set(ValueLayout.ADDRESS, OFFSET_RESERVE, reserveStub);
        struct.set(ValueLayout.ADDRESS, OFFSET_THROW, throwStub);
        struct.set(ValueLayout.ADDRESS, OFFSET_DATA, MemorySegment.NULL);
        struct.set(ValueLayout.JAVA_LONG, OFFSET_CLOSURE, token);
    }

    /** The struct's address -- pass this as the exchange argument to the downcall. */
    public MemorySegment segment() {
        return struct;
    }

    public boolean threw() {
        return threw;
    }

    public int errorCode() {
        return errorCode;
    }

    public String errorMessage() {
        return errorMessage;
    }

    /** Reads the reserved buffer as UTF-16 code units (WTF::String's native form). */
    public String readUtf16String() {
        if (reservedBuffer == null) {
            return null;
        }
        long charLength = reservedBuffer.byteSize() / 2;
        char[] chars = new char[(int) charLength];
        for (int i = 0; i < charLength; i++) {
            chars[i] = reservedBuffer.getAtIndex(ValueLayout.JAVA_CHAR, i);
        }
        return new String(chars);
    }

    /** Direct access for exchanges reserving raw POD (e.g. an array of primitives), not text. */
    public MemorySegment reservedBuffer() {
        return reservedBuffer;
    }

    @Override
    public void close() {
        // Recycles the struct's block -- cascading, via the link() reserveTrampoline
        // set up if reserve() was ever called, into recycling that buffer too.
        transfer.close();
        stubArena.close();
    }

    // --- upcall trampolines: static, resolve the owning instance from the closure
    // token via TransferPool's direct-index slot table (see the class doc) ---

    private static MemorySegment reserveTrampoline(long closure, long size) {
        Transfer structTransfer = TransferPool.SHARED.resolve((int) closure);
        ByteExchange exchange = (ByteExchange) structTransfer.attachment();

        Transfer reserved = TransferPool.SHARED.allocate((int) size, 1);
        structTransfer.link(reserved); // exchange.close() -> transfer.close() cascades here

        MemorySegment buffer = reserved.segment().asSlice(0, size);
        exchange.reservedBuffer = buffer;
        exchange.struct.set(ValueLayout.ADDRESS, OFFSET_DATA, buffer);
        return buffer;
    }

    private static void throwTrampoline(long closure, int code, MemorySegment message) {
        ByteExchange exchange = (ByteExchange) TransferPool.SHARED.resolve((int) closure).attachment();
        exchange.threw = true;
        exchange.errorCode = code;
        exchange.errorMessage = message.equals(MemorySegment.NULL)
                ? null
                : message.reinterpret(4096).getString(0);
    }
}
