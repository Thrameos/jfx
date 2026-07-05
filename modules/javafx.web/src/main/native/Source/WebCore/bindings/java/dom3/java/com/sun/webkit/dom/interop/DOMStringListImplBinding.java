package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.CString8;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;
import org.openjfx.interop.Transfer;
import org.openjfx.interop.TransferPool;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link DOMStringListImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 *
 * <p>DISPOSE is deliberately not bound here -- dispose() retirement across
 * every migrated CSS OM class is a separate, dedicated pass, not something
 * to bundle into one class's attribute migration (see dom_css_rule.cpp's
 * header comment).
 */
public final class DOMStringListImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_LENGTH = bind(DOMStringListImplSignature.GET_LENGTH);
    private static final MethodHandle ITEM = bind(DOMStringListImplSignature.ITEM);
    private static final MethodHandle CONTAINS = bind(DOMStringListImplSignature.CONTAINS);

    private DOMStringListImplBinding() {
    }

    private static MethodHandle bind(DOMStringListImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(DOMStringListImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static String item(long peer, int index) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            ITEM.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), index);
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(DOMStringListImplSignature.ITEM.symbol(), t);
        }
    }

    public static boolean contains(long peer, String string) {
        try (Transfer utf8 = CString8.of(string, TransferPool.SHARED)) {
            return (boolean) CONTAINS.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(DOMStringListImplSignature.CONTAINS.symbol(), t);
        }
    }
}
