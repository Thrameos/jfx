package org.openjfx.interop;

import java.lang.foreign.MemorySegment;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Resource-handle-lifetime pool for native objects that are independently
 * ref-counted on the C side (WebCore's {@code RefPtr<Node>} being the motivating
 * case -- see plans/roadmap-phase1.md's tier4/tier7 writeups). Deliberately does
 * <b>not</b> replicate the legacy JNI behavior found in the real
 * {@code JavaDOMUtils.h}'s {@code JavaReturn<T>} (which mints a brand new ref, and
 * therefore a brand new Java-side handle, every single time an object is returned --
 * even for an object Java already holds a handle to). Instead: one
 * {@link MemorySegment} handle per live native address, reused on every subsequent
 * exposure of the same address, with an explicit Java-side refcount so the native
 * {@code deref} only fires once the last Java-side holder disposes.
 */
public final class NativeHandlePool {

    private static final Logger LOGGER = Logger.getLogger(NativeHandlePool.class.getName());

    private static final class Entry {
        final MemorySegment handle;
        int refCount;

        Entry(MemorySegment handle) {
            this.handle = handle;
        }
    }

    private final Map<Long, Entry> byAddress = new HashMap<>();

    public NativeHandlePool() {
        PoolRegistry.register(this);
    }

    /**
     * Called whenever native code hands back a pointer to an object it has already
     * (or is about to have) ref-counted on its own side. Returns the same
     * MemorySegment every time for the same address, incrementing the Java-side
     * refcount rather than minting a new handle.
     */
    public synchronized MemorySegment acquire(MemorySegment nativeAddress) {
        long addr = nativeAddress.address();
        Entry entry = byAddress.get(addr);
        if (entry == null) {
            entry = new Entry(nativeAddress);
            byAddress.put(addr, entry);
        }
        entry.refCount++;
        return entry.handle;
    }

    /**
     * Called when a Java-side holder is done with a handle. Returns true exactly
     * once, on the call that drops the last reference -- the caller uses that as the
     * signal to actually invoke the native {@code deref}/free downcall.
     */
    public synchronized boolean release(MemorySegment handle) {
        long addr = handle.address();
        Entry entry = byAddress.get(addr);
        if (entry == null) {
            LOGGER.log(Level.WARNING, "Release of untracked handle (double-release, or a handle this pool "
                    + "never acquired): {0}", Long.toHexString(addr));
            throw new IllegalStateException("Release of untracked handle: " + Long.toHexString(addr));
        }
        entry.refCount--;
        if (entry.refCount <= 0) {
            byAddress.remove(addr);
            return true;
        }
        return false;
    }

    public synchronized int refCount(MemorySegment handle) {
        Entry entry = byAddress.get(handle.address());
        return entry == null ? 0 : entry.refCount;
    }

    public synchronized int size() {
        return byAddress.size();
    }

    /** Non-throwing probe for {@link PoolRegistry#resolve} -- {@code null} if this address isn't tracked. */
    synchronized MemorySegment peek(long token) {
        Entry entry = byAddress.get(token);
        return entry == null ? null : entry.handle;
    }

    @Override
    public synchronized String toString() {
        return "NativeHandlePool[liveHandles=" + byAddress.size() + "]";
    }
}
