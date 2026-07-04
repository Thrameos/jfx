package org.openjfx.interop;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * A recyclable native buffer, ported from {@code j2ni-remote}'s
 * {@code org.j2ni.remote.wire.Transfer} (the wire-framing fields -- magic/words/
 * opcode/sentinel -- are dropped here; this is the pure allocation-reuse half of
 * that class, not the network protocol half). Exists because Panama's
 * {@code Arena.allocate}/{@code Arena.close()} is a real malloc/free underneath:
 * an {@link Exchange} that mints and frees a fresh confined arena on every one of
 * the ~473 real DOM downcalls fragments the native heap exactly the way a
 * high-frequency malloc/free churn always does. {@link TransferPool} hands out
 * same-sized segments from a small set of size buckets and takes them back on
 * {@link #close()} instead of freeing them, so steady-state DOM traffic settles
 * into reusing a fixed set of blocks rather than growing/shrinking the heap per call.
 */
public class Transfer implements AutoCloseable {

    final TransferPool owner;
    Transfer next;
    private final MemorySegment segment;

    public int elements;
    public int elementSize;

    /** The pool's direct-index slot this block is currently checked out under -- see
     *  {@link TransferPool#resolve(int)}. -1 whenever the block is idle (not between
     *  an {@code allocate}/{@code close} pair). */
    int slot = -1;

    private Object attachment;
    private Transfer linked;

    Transfer(TransferPool owner, Arena arena, long byteSize, int elements, int elementSize) {
        this.owner = owner;
        this.segment = arena.allocate(byteSize);
        repurpose(elements, elementSize);
    }

    final void repurpose(int elements, int elementSize) {
        if ((long) elements * elementSize > segment.byteSize()) {
            throw new IllegalArgumentException(
                    "requested " + elements + "*" + elementSize + " exceeds block size " + segment.byteSize());
        }
        this.elements = elements;
        this.elementSize = elementSize;
        this.next = null;
        this.attachment = null;
        this.linked = null;
        segment.fill((byte) 0);
    }

    /** The block's address -- pass this (or a slice of it) as a downcall argument. */
    public MemorySegment segment() {
        return segment;
    }

    /** This block's current in-flight slot -- e.g. usable as (part of) a closure
     *  token an upcall hands back, resolved via {@link TransferPool#resolve(int)}
     *  without a hashmap or generation check (see the class doc). */
    public int slot() {
        return slot;
    }

    /** Associates an arbitrary Java-side owner with this block (e.g. the
     *  {@code Exchange} a "down" transfer was allocated for), retrievable by whoever
     *  resolves this block back from its {@link #slot()}. */
    public void attach(Object attachment) {
        this.attachment = attachment;
    }

    public Object attachment() {
        return attachment;
    }

    /**
     * Chains a dependent block's lifetime to this one: closing this block also
     * closes {@code dependent} first. For the common case where a "down" transfer
     * (e.g. an {@code Exchange} struct passed into a downcall) triggers an
     * upcall that only then discovers it needs a second, "up" transfer (e.g.
     * {@code reserve}'s variable-sized output buffer, sized only once native is
     * already inside the call) -- the caller only ever holds the primary transfer in
     * a try-with-resources, and both get recycled together.
     */
    public void link(Transfer dependent) {
        if (this.linked != null) {
            throw new IllegalStateException("transfer already has a linked dependent");
        }
        this.linked = dependent;
    }

    /**
     * Returns this block to its owning pool for reuse. Unlike a raw
     * {@code Arena.close()}, the underlying native memory is not freed -- the pool
     * hands the same block back out on a future {@link TransferPool#allocate}.
     * Closes any block chained on via {@link #link} first.
     */
    @Override
    public void close() {
        if (linked != null) {
            Transfer dependent = linked;
            linked = null;
            dependent.close();
        }
        owner.recycle(this);
    }
}
