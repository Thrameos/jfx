package com.sun.webkit.dom.interop;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import org.openjfx.interop.Binder;
import org.openjfx.interop.Char16StringExchange;
import org.openjfx.interop.Downcall;

/**
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link CounterImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 *
 * <p>DISPOSE is deliberately not bound here -- dispose() retirement across
 * every migrated CSS OM class is a separate, dedicated pass, not something
 * to bundle into one class's attribute migration (see dom_css_rule.cpp's
 * header comment).
 */
public final class CounterImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_IDENTIFIER = bind(CounterImplSignature.GET_IDENTIFIER);
    private static final MethodHandle GET_LIST_STYLE = bind(CounterImplSignature.GET_LIST_STYLE);
    private static final MethodHandle GET_SEPARATOR = bind(CounterImplSignature.GET_SEPARATOR);

    private CounterImplBinding() {
    }

    private static MethodHandle bind(CounterImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static String getIdentifier(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_IDENTIFIER.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CounterImplSignature.GET_IDENTIFIER.symbol(), t);
        }
    }

    public static String getListStyle(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_LIST_STYLE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CounterImplSignature.GET_LIST_STYLE.symbol(), t);
        }
    }

    public static String getSeparator(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SEPARATOR.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(CounterImplSignature.GET_SEPARATOR.symbol(), t);
        }
    }
}
