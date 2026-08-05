package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.ByteExchange;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;
import org.w3c.dom.DOMException;

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
    private static final MethodHandle APPEND_CHILD = bind(NodeImplSignature.APPEND_CHILD);
    private static final MethodHandle INSERT_BEFORE = bind(NodeImplSignature.INSERT_BEFORE);
    private static final MethodHandle REPLACE_CHILD = bind(NodeImplSignature.REPLACE_CHILD);
    private static final MethodHandle REMOVE_CHILD = bind(NodeImplSignature.REMOVE_CHILD);

    private static final MethodHandle GET_NODE_TYPE = bind(NodeImplSignature.GET_NODE_TYPE);
    private static final MethodHandle HAS_CHILD_NODES = bind(NodeImplSignature.HAS_CHILD_NODES);
    private static final MethodHandle HAS_ATTRIBUTES = bind(NodeImplSignature.HAS_ATTRIBUTES);
    private static final MethodHandle NORMALIZE = bind(NodeImplSignature.NORMALIZE);

    private static final MethodHandle GET_NODE_VALUE = bind(NodeImplSignature.GET_NODE_VALUE);
    private static final MethodHandle GET_NAMESPACE_URI = bind(NodeImplSignature.GET_NAMESPACE_URI);
    private static final MethodHandle GET_LOCAL_NAME = bind(NodeImplSignature.GET_LOCAL_NAME);
    private static final MethodHandle GET_BASE_URI = bind(NodeImplSignature.GET_BASE_URI);
    private static final MethodHandle GET_TEXT_CONTENT = bind(NodeImplSignature.GET_TEXT_CONTENT);
    private static final MethodHandle LOOKUP_PREFIX = bind(NodeImplSignature.LOOKUP_PREFIX);
    private static final MethodHandle LOOKUP_NAMESPACE_URI = bind(NodeImplSignature.LOOKUP_NAMESPACE_URI);

    private static final MethodHandle GET_ATTRIBUTES = bind(NodeImplSignature.GET_ATTRIBUTES);

    private static final MethodHandle IS_SAME_NODE = bind(NodeImplSignature.IS_SAME_NODE);
    private static final MethodHandle IS_EQUAL_NODE = bind(NodeImplSignature.IS_EQUAL_NODE);
    private static final MethodHandle COMPARE_DOCUMENT_POSITION = bind(NodeImplSignature.COMPARE_DOCUMENT_POSITION);
    private static final MethodHandle CONTAINS = bind(NodeImplSignature.CONTAINS);

    private static final MethodHandle CLONE_NODE = bind(NodeImplSignature.CLONE_NODE);

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

    // Object-handle return + exception-forwarding combined
    // (plans/patterns/pattern-node-mutation.md): on success there is no
    // fresh handle to read back from the exchange -- the answer is always
    // one of the peers the caller already passed in, exactly the old JNI
    // shim's `return JavaReturn<Node>(env, pnewChild)`/`pnewChild`/
    // `poldChild` behavior.
    public static long appendChild(long peer, long newChild) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                APPEND_CHILD.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), MemorySegment.ofAddress(newChild));
            } catch (Throwable t) {
                throw Downcall.failed(NodeImplSignature.APPEND_CHILD.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return newChild;
        }
    }

    public static long insertBefore(long peer, long newChild, long refChild) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                INSERT_BEFORE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        MemorySegment.ofAddress(newChild), MemorySegment.ofAddress(refChild));
            } catch (Throwable t) {
                throw Downcall.failed(NodeImplSignature.INSERT_BEFORE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return newChild;
        }
    }

    public static long replaceChild(long peer, long newChild, long oldChild) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                REPLACE_CHILD.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        MemorySegment.ofAddress(newChild), MemorySegment.ofAddress(oldChild));
            } catch (Throwable t) {
                throw Downcall.failed(NodeImplSignature.REPLACE_CHILD.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return oldChild;
        }
    }

    public static long removeChild(long peer, long oldChild) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                REMOVE_CHILD.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), MemorySegment.ofAddress(oldChild));
            } catch (Throwable t) {
                throw Downcall.failed(NodeImplSignature.REMOVE_CHILD.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return oldChild;
        }
    }

    public static short getNodeType(long peer) {
        try {
            return (short) GET_NODE_TYPE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_NODE_TYPE.symbol(), t);
        }
    }

    public static boolean hasChildNodes(long peer) {
        try {
            return (boolean) HAS_CHILD_NODES.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.HAS_CHILD_NODES.symbol(), t);
        }
    }

    public static boolean hasAttributes(long peer) {
        try {
            return (boolean) HAS_ATTRIBUTES.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.HAS_ATTRIBUTES.symbol(), t);
        }
    }

    public static void normalize(long peer) {
        try {
            NORMALIZE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.NORMALIZE.symbol(), t);
        }
    }

    public static String getNodeValue(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_NODE_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_NODE_VALUE.symbol(), t);
        }
    }

    public static String getNamespaceURI(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_NAMESPACE_URI.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_NAMESPACE_URI.symbol(), t);
        }
    }

    public static String getLocalName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_LOCAL_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_LOCAL_NAME.symbol(), t);
        }
    }

    public static String getBaseURI(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_BASE_URI.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_BASE_URI.symbol(), t);
        }
    }

    public static String getTextContent(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_TEXT_CONTENT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_TEXT_CONTENT.symbol(), t);
        }
    }

    public static String lookupPrefix(long peer, String namespaceURI) {
        try (Transfer utf8 = CString8.of(namespaceURI, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            LOOKUP_PREFIX.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.LOOKUP_PREFIX.symbol(), t);
        }
    }

    public static String lookupNamespaceURI(long peer, String prefix) {
        try (Transfer utf8 = CString8.of(prefix, TransferPool.SHARED);
                Char16StringExchange exchange = new Char16StringExchange()) {
            LOOKUP_NAMESPACE_URI.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), utf8.segment());
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.LOOKUP_NAMESPACE_URI.symbol(), t);
        }
    }

    public static long getAttributes(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_ATTRIBUTES.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.GET_ATTRIBUTES.symbol(), t);
        }
    }

    public static boolean isSameNode(long peer, long other) {
        try {
            return (boolean) IS_SAME_NODE.invokeExact(MemorySegment.ofAddress(peer), MemorySegment.ofAddress(other));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.IS_SAME_NODE.symbol(), t);
        }
    }

    public static boolean isEqualNode(long peer, long other) {
        try {
            return (boolean) IS_EQUAL_NODE.invokeExact(MemorySegment.ofAddress(peer), MemorySegment.ofAddress(other));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.IS_EQUAL_NODE.symbol(), t);
        }
    }

    public static short compareDocumentPosition(long peer, long other) {
        try {
            return (short) COMPARE_DOCUMENT_POSITION.invokeExact(
                    MemorySegment.ofAddress(peer), MemorySegment.ofAddress(other));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.COMPARE_DOCUMENT_POSITION.symbol(), t);
        }
    }

    public static boolean contains(long peer, long other) {
        try {
            return (boolean) CONTAINS.invokeExact(MemorySegment.ofAddress(peer), MemorySegment.ofAddress(other));
        } catch (Throwable t) {
            throw Downcall.failed(NodeImplSignature.CONTAINS.symbol(), t);
        }
    }

    // Object-handle return + exception-forwarding combined: unlike
    // appendChild/insertBefore/replaceChild/removeChild above, the downcall's
    // own return IS a fresh Node* handle on success -- the exchange only
    // ever carries error info, it never reserve()s anything.
    public static long cloneNode(long peer, boolean deep) {
        try (ByteExchange exchange = new ByteExchange()) {
            MemorySegment result;
            try {
                result = (MemorySegment) CLONE_NODE.invokeExact(
                        exchange.segment(), MemorySegment.ofAddress(peer), deep);
            } catch (Throwable t) {
                throw Downcall.failed(NodeImplSignature.CLONE_NODE.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
            return result.address();
        }
    }
}
