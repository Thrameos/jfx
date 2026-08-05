package org.openjfx.interop;

import java.lang.foreign.Arena;

/**
 * A {@link Transfer} too large for {@link TransferPool}'s bucket range, ported from
 * {@code j2ni-remote}'s {@code org.j2ni.remote.wire.Dedicated}. Owns its own
 * {@link Arena} rather than sharing the pool's, since it was never carved out of a
 * pool bucket in the first place; {@link TransferPool#recycle} recognizes this type
 * and closes (frees) that arena outright instead of returning the block to a bucket.
 */
final class Dedicated extends Transfer {

    private final Arena arena;

    Dedicated(TransferPool owner, Arena arena, long byteSize, int elements, int elementSize) {
        super(owner, arena, byteSize, elements, elementSize);
        this.arena = arena;
    }

    Arena arena() {
        return arena;
    }
}
