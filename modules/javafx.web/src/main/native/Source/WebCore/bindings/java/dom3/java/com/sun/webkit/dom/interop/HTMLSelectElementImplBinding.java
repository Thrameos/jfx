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
 * Real {@link Binder}-bound {@link MethodHandle}s for {@link HTMLSelectElementImplSignature}'s
 * entries -- same split rationale as {@link ElementImplBinding}.
 */
public final class HTMLSelectElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_AUTOFOCUS = bind(HTMLSelectElementImplSignature.GET_AUTOFOCUS);
    private static final MethodHandle SET_AUTOFOCUS = bind(HTMLSelectElementImplSignature.SET_AUTOFOCUS);
    private static final MethodHandle GET_DISABLED = bind(HTMLSelectElementImplSignature.GET_DISABLED);
    private static final MethodHandle SET_DISABLED = bind(HTMLSelectElementImplSignature.SET_DISABLED);
    private static final MethodHandle GET_MULTIPLE = bind(HTMLSelectElementImplSignature.GET_MULTIPLE);
    private static final MethodHandle SET_MULTIPLE = bind(HTMLSelectElementImplSignature.SET_MULTIPLE);
    private static final MethodHandle GET_REQUIRED = bind(HTMLSelectElementImplSignature.GET_REQUIRED);
    private static final MethodHandle SET_REQUIRED = bind(HTMLSelectElementImplSignature.SET_REQUIRED);
    private static final MethodHandle GET_SIZE = bind(HTMLSelectElementImplSignature.GET_SIZE);
    private static final MethodHandle SET_SIZE = bind(HTMLSelectElementImplSignature.SET_SIZE);
    private static final MethodHandle GET_LENGTH = bind(HTMLSelectElementImplSignature.GET_LENGTH);
    private static final MethodHandle GET_SELECTED_INDEX = bind(HTMLSelectElementImplSignature.GET_SELECTED_INDEX);
    private static final MethodHandle SET_SELECTED_INDEX = bind(HTMLSelectElementImplSignature.SET_SELECTED_INDEX);
    private static final MethodHandle GET_WILL_VALIDATE = bind(HTMLSelectElementImplSignature.GET_WILL_VALIDATE);
    private static final MethodHandle CHECK_VALIDITY = bind(HTMLSelectElementImplSignature.CHECK_VALIDITY);
    private static final MethodHandle REMOVE = bind(HTMLSelectElementImplSignature.REMOVE);
    private static final MethodHandle SET_NAME = bind(HTMLSelectElementImplSignature.SET_NAME);
    private static final MethodHandle SET_VALUE = bind(HTMLSelectElementImplSignature.SET_VALUE);
    private static final MethodHandle SET_CUSTOM_VALIDITY = bind(HTMLSelectElementImplSignature.SET_CUSTOM_VALIDITY);
    private static final MethodHandle GET_FORM = bind(HTMLSelectElementImplSignature.GET_FORM);

    private HTMLSelectElementImplBinding() {
    }

    private static MethodHandle bind(HTMLSelectElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    private static void invokeSetter(MethodHandle handle, String symbol, long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            handle.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(symbol, t);
        }
    }

    public static boolean getAutofocus(long peer) {
        try {
            return (boolean) GET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_AUTOFOCUS.symbol(), t);
        }
    }

    public static void setAutofocus(long peer, boolean value) {
        try {
            SET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_AUTOFOCUS.symbol(), t);
        }
    }

    public static boolean getDisabled(long peer) {
        try {
            return (boolean) GET_DISABLED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_DISABLED.symbol(), t);
        }
    }

    public static void setDisabled(long peer, boolean value) {
        try {
            SET_DISABLED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_DISABLED.symbol(), t);
        }
    }

    public static boolean getMultiple(long peer) {
        try {
            return (boolean) GET_MULTIPLE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_MULTIPLE.symbol(), t);
        }
    }

    public static void setMultiple(long peer, boolean value) {
        try {
            SET_MULTIPLE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_MULTIPLE.symbol(), t);
        }
    }

    public static boolean getRequired(long peer) {
        try {
            return (boolean) GET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_REQUIRED.symbol(), t);
        }
    }

    public static void setRequired(long peer, boolean value) {
        try {
            SET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_REQUIRED.symbol(), t);
        }
    }

    public static int getSize(long peer) {
        try {
            return (int) GET_SIZE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_SIZE.symbol(), t);
        }
    }

    public static void setSize(long peer, int value) {
        try {
            SET_SIZE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_SIZE.symbol(), t);
        }
    }

    public static int getLength(long peer) {
        try {
            return (int) GET_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_LENGTH.symbol(), t);
        }
    }

    public static int getSelectedIndex(long peer) {
        try {
            return (int) GET_SELECTED_INDEX.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_SELECTED_INDEX.symbol(), t);
        }
    }

    public static void setSelectedIndex(long peer, int value) {
        try {
            SET_SELECTED_INDEX.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.SET_SELECTED_INDEX.symbol(), t);
        }
    }

    public static boolean getWillValidate(long peer) {
        try {
            return (boolean) GET_WILL_VALIDATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_WILL_VALIDATE.symbol(), t);
        }
    }

    public static boolean checkValidity(long peer) {
        try {
            return (boolean) CHECK_VALIDITY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.CHECK_VALIDITY.symbol(), t);
        }
    }

    public static void remove(long peer, int index) {
        try {
            REMOVE.invokeExact(MemorySegment.ofAddress(peer), index);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.REMOVE.symbol(), t);
        }
    }

    public static void setName(long peer, String value) {
        invokeSetter(SET_NAME, HTMLSelectElementImplSignature.SET_NAME.symbol(), peer, value);
    }

    public static void setValue(long peer, String value) {
        invokeSetter(SET_VALUE, HTMLSelectElementImplSignature.SET_VALUE.symbol(), peer, value);
    }

    public static void setCustomValidity(long peer, String error) {
        invokeSetter(SET_CUSTOM_VALIDITY, HTMLSelectElementImplSignature.SET_CUSTOM_VALIDITY.symbol(), peer, error);
    }

    public static long getForm(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FORM.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLSelectElementImplSignature.GET_FORM.symbol(), t);
        }
    }
}
