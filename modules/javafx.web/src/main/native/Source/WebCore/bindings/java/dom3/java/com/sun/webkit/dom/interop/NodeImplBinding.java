package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link NodeImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class NodeImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_PARENT_ELEMENT = bind(NodeImplSignature.GET_PARENT_ELEMENT);
    private static final MethodHandle GET_PARENT_NODE = bind(NodeImplSignature.GET_PARENT_NODE);
    private static final MethodHandle GET_FIRST_CHILD = bind(NodeImplSignature.GET_FIRST_CHILD);
    private static final MethodHandle GET_LAST_CHILD = bind(NodeImplSignature.GET_LAST_CHILD);
    private static final MethodHandle GET_PREVIOUS_SIBLING = bind(NodeImplSignature.GET_PREVIOUS_SIBLING);
    private static final MethodHandle GET_NEXT_SIBLING = bind(NodeImplSignature.GET_NEXT_SIBLING);
    private static final MethodHandle GET_OWNER_DOCUMENT = bind(NodeImplSignature.GET_OWNER_DOCUMENT);
    private static final MethodHandle SET_NODE_VALUE = bind(NodeImplSignature.SET_NODE_VALUE);
    private static final MethodHandle SET_PREFIX = bind(NodeImplSignature.SET_PREFIX);
    private static final MethodHandle SET_TEXT_CONTENT = bind(NodeImplSignature.SET_TEXT_CONTENT);
    private static final MethodHandle IS_DEFAULT_NAMESPACE = bind(NodeImplSignature.IS_DEFAULT_NAMESPACE);

    private NodeImplBinding() {
    }

    private static MethodHandle bind(NodeImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static long getParentElement(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PARENT_ELEMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_PARENT_ELEMENT.symbol(), t);
        }
    }

    public static long getParentNode(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PARENT_NODE.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_PARENT_NODE.symbol(), t);
        }
    }

    public static long getFirstChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FIRST_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_FIRST_CHILD.symbol(), t);
        }
    }

    public static long getLastChild(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_LAST_CHILD.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_LAST_CHILD.symbol(), t);
        }
    }

    public static long getPreviousSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_PREVIOUS_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_PREVIOUS_SIBLING.symbol(), t);
        }
    }

    public static long getNextSibling(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_NEXT_SIBLING.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_NEXT_SIBLING.symbol(), t);
        }
    }

    public static long getOwnerDocument(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_OWNER_DOCUMENT.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_OWNER_DOCUMENT.symbol(), t);
        }
    }

    public static void setNodeValue(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_NODE_VALUE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.SET_NODE_VALUE.symbol(), t);
        }
    }

    public static void setPrefix(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_PREFIX.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.SET_PREFIX.symbol(), t);
        }
    }

    public static void setTextContent(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_TEXT_CONTENT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.SET_TEXT_CONTENT.symbol(), t);
        }
    }

    public static boolean isDefaultNamespace(long peer, String namespaceURI) {
        try (Transfer utf8 = CString8.of(namespaceURI, TransferPool.SHARED)) {
            return (boolean) IS_DEFAULT_NAMESPACE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.IS_DEFAULT_NAMESPACE.symbol(), t);
        }
    }
}
