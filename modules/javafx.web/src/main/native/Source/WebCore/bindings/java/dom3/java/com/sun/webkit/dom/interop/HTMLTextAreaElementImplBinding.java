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
 * Real {@link Binder}-bound {@link MethodHandle}s for
 * {@link HTMLTextAreaElementImplSignature}'s entries -- see
 * {@link ElementImplBinding}'s class doc for why this is a separate class
 * from the pure-metadata signature enum.
 */
public final class HTMLTextAreaElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_AUTOFOCUS = bind(HTMLTextAreaElementImplSignature.GET_AUTOFOCUS);
    private static final MethodHandle SET_AUTOFOCUS = bind(HTMLTextAreaElementImplSignature.SET_AUTOFOCUS);
    private static final MethodHandle GET_DISABLED = bind(HTMLTextAreaElementImplSignature.GET_DISABLED);
    private static final MethodHandle SET_DISABLED = bind(HTMLTextAreaElementImplSignature.SET_DISABLED);
    private static final MethodHandle GET_MAX_LENGTH = bind(HTMLTextAreaElementImplSignature.GET_MAX_LENGTH);
    private static final MethodHandle SET_MAX_LENGTH = bind(HTMLTextAreaElementImplSignature.SET_MAX_LENGTH);
    private static final MethodHandle GET_READ_ONLY = bind(HTMLTextAreaElementImplSignature.GET_READ_ONLY);
    private static final MethodHandle SET_READ_ONLY = bind(HTMLTextAreaElementImplSignature.SET_READ_ONLY);
    private static final MethodHandle GET_REQUIRED = bind(HTMLTextAreaElementImplSignature.GET_REQUIRED);
    private static final MethodHandle SET_REQUIRED = bind(HTMLTextAreaElementImplSignature.SET_REQUIRED);
    private static final MethodHandle GET_ROWS = bind(HTMLTextAreaElementImplSignature.GET_ROWS);
    private static final MethodHandle SET_ROWS = bind(HTMLTextAreaElementImplSignature.SET_ROWS);
    private static final MethodHandle GET_COLS = bind(HTMLTextAreaElementImplSignature.GET_COLS);
    private static final MethodHandle SET_COLS = bind(HTMLTextAreaElementImplSignature.SET_COLS);
    private static final MethodHandle GET_TEXT_LENGTH = bind(HTMLTextAreaElementImplSignature.GET_TEXT_LENGTH);
    private static final MethodHandle GET_WILL_VALIDATE = bind(HTMLTextAreaElementImplSignature.GET_WILL_VALIDATE);
    private static final MethodHandle GET_SELECTION_START = bind(HTMLTextAreaElementImplSignature.GET_SELECTION_START);
    private static final MethodHandle SET_SELECTION_START = bind(HTMLTextAreaElementImplSignature.SET_SELECTION_START);
    private static final MethodHandle GET_SELECTION_END = bind(HTMLTextAreaElementImplSignature.GET_SELECTION_END);
    private static final MethodHandle SET_SELECTION_END = bind(HTMLTextAreaElementImplSignature.SET_SELECTION_END);
    private static final MethodHandle CHECK_VALIDITY = bind(HTMLTextAreaElementImplSignature.CHECK_VALIDITY);
    private static final MethodHandle SELECT = bind(HTMLTextAreaElementImplSignature.SELECT);

    private static final MethodHandle SET_DIR_NAME = bind(HTMLTextAreaElementImplSignature.SET_DIR_NAME);
    private static final MethodHandle SET_NAME = bind(HTMLTextAreaElementImplSignature.SET_NAME);
    private static final MethodHandle SET_PLACEHOLDER = bind(HTMLTextAreaElementImplSignature.SET_PLACEHOLDER);
    private static final MethodHandle SET_WRAP = bind(HTMLTextAreaElementImplSignature.SET_WRAP);
    private static final MethodHandle SET_DEFAULT_VALUE = bind(HTMLTextAreaElementImplSignature.SET_DEFAULT_VALUE);
    private static final MethodHandle SET_VALUE = bind(HTMLTextAreaElementImplSignature.SET_VALUE);
    private static final MethodHandle SET_SELECTION_DIRECTION =
            bind(HTMLTextAreaElementImplSignature.SET_SELECTION_DIRECTION);
    private static final MethodHandle SET_ACCESS_KEY = bind(HTMLTextAreaElementImplSignature.SET_ACCESS_KEY);
    private static final MethodHandle SET_CUSTOM_VALIDITY = bind(HTMLTextAreaElementImplSignature.SET_CUSTOM_VALIDITY);
    private static final MethodHandle SET_SELECTION_RANGE = bind(HTMLTextAreaElementImplSignature.SET_SELECTION_RANGE);

    private static final MethodHandle GET_DIR_NAME = bind(HTMLTextAreaElementImplSignature.GET_DIR_NAME);
    private static final MethodHandle GET_NAME = bind(HTMLTextAreaElementImplSignature.GET_NAME);
    private static final MethodHandle GET_PLACEHOLDER = bind(HTMLTextAreaElementImplSignature.GET_PLACEHOLDER);
    private static final MethodHandle GET_WRAP = bind(HTMLTextAreaElementImplSignature.GET_WRAP);
    private static final MethodHandle GET_TYPE = bind(HTMLTextAreaElementImplSignature.GET_TYPE);
    private static final MethodHandle GET_DEFAULT_VALUE = bind(HTMLTextAreaElementImplSignature.GET_DEFAULT_VALUE);
    private static final MethodHandle GET_VALUE = bind(HTMLTextAreaElementImplSignature.GET_VALUE);
    private static final MethodHandle GET_VALIDATION_MESSAGE =
            bind(HTMLTextAreaElementImplSignature.GET_VALIDATION_MESSAGE);
    private static final MethodHandle GET_SELECTION_DIRECTION =
            bind(HTMLTextAreaElementImplSignature.GET_SELECTION_DIRECTION);
    private static final MethodHandle GET_ACCESS_KEY = bind(HTMLTextAreaElementImplSignature.GET_ACCESS_KEY);
    private static final MethodHandle GET_AUTOCOMPLETE = bind(HTMLTextAreaElementImplSignature.GET_AUTOCOMPLETE);

    private static final MethodHandle GET_FORM = bind(HTMLTextAreaElementImplSignature.GET_FORM);
    private static final MethodHandle GET_LABELS = bind(HTMLTextAreaElementImplSignature.GET_LABELS);

    private static final MethodHandle SET_RANGE_TEXT = bind(HTMLTextAreaElementImplSignature.SET_RANGE_TEXT);
    private static final MethodHandle SET_RANGE_TEXT_EX = bind(HTMLTextAreaElementImplSignature.SET_RANGE_TEXT_EX);

    private HTMLTextAreaElementImplBinding() {
    }

    private static MethodHandle bind(HTMLTextAreaElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static boolean getAutofocus(long peer) {
        try {
            return (boolean) GET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_AUTOFOCUS.symbol(), t);
        }
    }

    public static void setAutofocus(long peer, boolean value) {
        try {
            SET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_AUTOFOCUS.symbol(), t);
        }
    }

    public static boolean getDisabled(long peer) {
        try {
            return (boolean) GET_DISABLED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_DISABLED.symbol(), t);
        }
    }

    public static void setDisabled(long peer, boolean value) {
        try {
            SET_DISABLED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_DISABLED.symbol(), t);
        }
    }

    public static int getMaxLength(long peer) {
        try {
            return (int) GET_MAX_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_MAX_LENGTH.symbol(), t);
        }
    }

    public static void setMaxLength(long peer, int value) {
        try {
            SET_MAX_LENGTH.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_MAX_LENGTH.symbol(), t);
        }
    }

    public static boolean getReadOnly(long peer) {
        try {
            return (boolean) GET_READ_ONLY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_READ_ONLY.symbol(), t);
        }
    }

    public static void setReadOnly(long peer, boolean value) {
        try {
            SET_READ_ONLY.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_READ_ONLY.symbol(), t);
        }
    }

    public static boolean getRequired(long peer) {
        try {
            return (boolean) GET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_REQUIRED.symbol(), t);
        }
    }

    public static void setRequired(long peer, boolean value) {
        try {
            SET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_REQUIRED.symbol(), t);
        }
    }

    public static int getRows(long peer) {
        try {
            return (int) GET_ROWS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_ROWS.symbol(), t);
        }
    }

    public static void setRows(long peer, int value) {
        try {
            SET_ROWS.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_ROWS.symbol(), t);
        }
    }

    public static int getCols(long peer) {
        try {
            return (int) GET_COLS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_COLS.symbol(), t);
        }
    }

    public static void setCols(long peer, int value) {
        try {
            SET_COLS.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_COLS.symbol(), t);
        }
    }

    public static int getTextLength(long peer) {
        try {
            return (int) GET_TEXT_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_TEXT_LENGTH.symbol(), t);
        }
    }

    public static boolean getWillValidate(long peer) {
        try {
            return (boolean) GET_WILL_VALIDATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_WILL_VALIDATE.symbol(), t);
        }
    }

    public static int getSelectionStart(long peer) {
        try {
            return (int) GET_SELECTION_START.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_SELECTION_START.symbol(), t);
        }
    }

    public static void setSelectionStart(long peer, int value) {
        try {
            SET_SELECTION_START.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_SELECTION_START.symbol(), t);
        }
    }

    public static int getSelectionEnd(long peer) {
        try {
            return (int) GET_SELECTION_END.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_SELECTION_END.symbol(), t);
        }
    }

    public static void setSelectionEnd(long peer, int value) {
        try {
            SET_SELECTION_END.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_SELECTION_END.symbol(), t);
        }
    }

    public static boolean checkValidity(long peer) {
        try {
            return (boolean) CHECK_VALIDITY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.CHECK_VALIDITY.symbol(), t);
        }
    }

    public static void select(long peer) {
        try {
            SELECT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SELECT.symbol(), t);
        }
    }

    public static void setDirName(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_DIR_NAME.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_DIR_NAME.symbol(), t);
        }
    }

    public static void setName(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_NAME.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_NAME.symbol(), t);
        }
    }

    public static void setPlaceholder(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_PLACEHOLDER.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_PLACEHOLDER.symbol(), t);
        }
    }

    public static void setWrap(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_WRAP.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_WRAP.symbol(), t);
        }
    }

    public static void setDefaultValue(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_DEFAULT_VALUE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_DEFAULT_VALUE.symbol(), t);
        }
    }

    public static void setValue(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_VALUE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_VALUE.symbol(), t);
        }
    }

    public static void setSelectionDirection(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_SELECTION_DIRECTION.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_SELECTION_DIRECTION.symbol(), t);
        }
    }

    public static void setAccessKey(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ACCESS_KEY.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_ACCESS_KEY.symbol(), t);
        }
    }

    public static void setCustomValidity(long peer, String error) {
        try (Transfer utf8 = CString8.of(error, TransferPool.SHARED)) {
            SET_CUSTOM_VALIDITY.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_CUSTOM_VALIDITY.symbol(), t);
        }
    }

    public static void setSelectionRange(long peer, int start, int end, String direction) {
        try (Transfer directionUtf8 = CString8.of(direction, TransferPool.SHARED)) {
            SET_SELECTION_RANGE.invokeExact(MemorySegment.ofAddress(peer), start, end, directionUtf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_SELECTION_RANGE.symbol(), t);
        }
    }

    public static String getDirName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DIR_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_DIR_NAME.symbol(), t);
        }
    }

    public static String getName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_NAME.symbol(), t);
        }
    }

    public static String getPlaceholder(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PLACEHOLDER.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_PLACEHOLDER.symbol(), t);
        }
    }

    public static String getWrap(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_WRAP.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_WRAP.symbol(), t);
        }
    }

    public static String getType(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_TYPE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_TYPE.symbol(), t);
        }
    }

    public static String getDefaultValue(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DEFAULT_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_DEFAULT_VALUE.symbol(), t);
        }
    }

    public static String getValue(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_VALUE.symbol(), t);
        }
    }

    public static String getValidationMessage(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_VALIDATION_MESSAGE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_VALIDATION_MESSAGE.symbol(), t);
        }
    }

    public static String getSelectionDirection(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SELECTION_DIRECTION.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_SELECTION_DIRECTION.symbol(), t);
        }
    }

    public static String getAccessKey(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ACCESS_KEY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_ACCESS_KEY.symbol(), t);
        }
    }

    public static String getAutocomplete(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_AUTOCOMPLETE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_AUTOCOMPLETE.symbol(), t);
        }
    }

    public static long getForm(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FORM.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_FORM.symbol(), t);
        }
    }

    public static long getLabels(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_LABELS.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLTextAreaElementImplSignature.GET_LABELS.symbol(), t);
        }
    }

    public static void setRangeText(long peer, String replacement) {
        try (Transfer replacementUtf8 = CString8.of(replacement, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_RANGE_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), replacementUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_RANGE_TEXT.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void setRangeTextEx(long peer, String replacement, int start, int end, String selectionMode) {
        try (Transfer replacementUtf8 = CString8.of(replacement, TransferPool.SHARED);
                Transfer selectionModeUtf8 = CString8.of(selectionMode, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_RANGE_TEXT_EX.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer),
                        replacementUtf8.segment(), start, end, selectionModeUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(HTMLTextAreaElementImplSignature.SET_RANGE_TEXT_EX.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
