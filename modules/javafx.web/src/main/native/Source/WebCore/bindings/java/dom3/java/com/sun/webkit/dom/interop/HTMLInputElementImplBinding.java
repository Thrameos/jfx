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
 * {@link HTMLInputElementImplSignature}'s entries -- see
 * {@link ElementImplBinding}'s class doc for why this is a separate class
 * from the pure-metadata signature enum.
 */
public final class HTMLInputElementImplBinding {

    private static final Binder BINDER = new Binder(SymbolLookup.loaderLookup());

    private static final MethodHandle GET_AUTOFOCUS = bind(HTMLInputElementImplSignature.GET_AUTOFOCUS);
    private static final MethodHandle SET_AUTOFOCUS = bind(HTMLInputElementImplSignature.SET_AUTOFOCUS);
    private static final MethodHandle GET_DEFAULT_CHECKED = bind(HTMLInputElementImplSignature.GET_DEFAULT_CHECKED);
    private static final MethodHandle SET_DEFAULT_CHECKED = bind(HTMLInputElementImplSignature.SET_DEFAULT_CHECKED);
    private static final MethodHandle GET_CHECKED = bind(HTMLInputElementImplSignature.GET_CHECKED);
    private static final MethodHandle SET_CHECKED = bind(HTMLInputElementImplSignature.SET_CHECKED);
    private static final MethodHandle GET_DISABLED = bind(HTMLInputElementImplSignature.GET_DISABLED);
    private static final MethodHandle SET_DISABLED = bind(HTMLInputElementImplSignature.SET_DISABLED);
    private static final MethodHandle GET_FORM_NO_VALIDATE = bind(HTMLInputElementImplSignature.GET_FORM_NO_VALIDATE);
    private static final MethodHandle SET_FORM_NO_VALIDATE = bind(HTMLInputElementImplSignature.SET_FORM_NO_VALIDATE);
    private static final MethodHandle GET_HEIGHT = bind(HTMLInputElementImplSignature.GET_HEIGHT);
    private static final MethodHandle GET_INDETERMINATE = bind(HTMLInputElementImplSignature.GET_INDETERMINATE);
    private static final MethodHandle SET_INDETERMINATE = bind(HTMLInputElementImplSignature.SET_INDETERMINATE);
    private static final MethodHandle GET_MAX_LENGTH = bind(HTMLInputElementImplSignature.GET_MAX_LENGTH);
    private static final MethodHandle SET_MAX_LENGTH = bind(HTMLInputElementImplSignature.SET_MAX_LENGTH);
    private static final MethodHandle GET_MULTIPLE = bind(HTMLInputElementImplSignature.GET_MULTIPLE);
    private static final MethodHandle SET_MULTIPLE = bind(HTMLInputElementImplSignature.SET_MULTIPLE);
    private static final MethodHandle GET_READ_ONLY = bind(HTMLInputElementImplSignature.GET_READ_ONLY);
    private static final MethodHandle SET_READ_ONLY = bind(HTMLInputElementImplSignature.SET_READ_ONLY);
    private static final MethodHandle GET_REQUIRED = bind(HTMLInputElementImplSignature.GET_REQUIRED);
    private static final MethodHandle SET_REQUIRED = bind(HTMLInputElementImplSignature.SET_REQUIRED);
    private static final MethodHandle GET_VALUE_AS_NUMBER = bind(HTMLInputElementImplSignature.GET_VALUE_AS_NUMBER);
    private static final MethodHandle SET_VALUE_AS_NUMBER = bind(HTMLInputElementImplSignature.SET_VALUE_AS_NUMBER);
    private static final MethodHandle GET_WIDTH = bind(HTMLInputElementImplSignature.GET_WIDTH);
    private static final MethodHandle GET_WILL_VALIDATE = bind(HTMLInputElementImplSignature.GET_WILL_VALIDATE);
    private static final MethodHandle CHECK_VALIDITY = bind(HTMLInputElementImplSignature.CHECK_VALIDITY);
    private static final MethodHandle SELECT = bind(HTMLInputElementImplSignature.SELECT);
    private static final MethodHandle CLICK = bind(HTMLInputElementImplSignature.CLICK);

    private static final MethodHandle SET_ACCEPT = bind(HTMLInputElementImplSignature.SET_ACCEPT);
    private static final MethodHandle SET_ALT = bind(HTMLInputElementImplSignature.SET_ALT);
    private static final MethodHandle SET_DIR_NAME = bind(HTMLInputElementImplSignature.SET_DIR_NAME);
    private static final MethodHandle SET_FORM_TARGET = bind(HTMLInputElementImplSignature.SET_FORM_TARGET);
    private static final MethodHandle SET_MAX = bind(HTMLInputElementImplSignature.SET_MAX);
    private static final MethodHandle SET_MIN = bind(HTMLInputElementImplSignature.SET_MIN);
    private static final MethodHandle SET_NAME = bind(HTMLInputElementImplSignature.SET_NAME);
    private static final MethodHandle SET_PATTERN = bind(HTMLInputElementImplSignature.SET_PATTERN);
    private static final MethodHandle SET_PLACEHOLDER = bind(HTMLInputElementImplSignature.SET_PLACEHOLDER);
    private static final MethodHandle SET_SRC = bind(HTMLInputElementImplSignature.SET_SRC);
    private static final MethodHandle SET_STEP = bind(HTMLInputElementImplSignature.SET_STEP);
    private static final MethodHandle SET_VALUE = bind(HTMLInputElementImplSignature.SET_VALUE);
    private static final MethodHandle SET_ALIGN = bind(HTMLInputElementImplSignature.SET_ALIGN);
    private static final MethodHandle SET_USE_MAP = bind(HTMLInputElementImplSignature.SET_USE_MAP);
    private static final MethodHandle SET_ACCESS_KEY = bind(HTMLInputElementImplSignature.SET_ACCESS_KEY);
    private static final MethodHandle SET_CUSTOM_VALIDITY = bind(HTMLInputElementImplSignature.SET_CUSTOM_VALIDITY);
    private static final MethodHandle SET_VALUE_FOR_USER = bind(HTMLInputElementImplSignature.SET_VALUE_FOR_USER);
    private static final MethodHandle SET_SIZE = bind(HTMLInputElementImplSignature.SET_SIZE);

    private static final MethodHandle GET_ACCEPT = bind(HTMLInputElementImplSignature.GET_ACCEPT);
    private static final MethodHandle GET_ALT = bind(HTMLInputElementImplSignature.GET_ALT);
    private static final MethodHandle GET_AUTOCOMPLETE = bind(HTMLInputElementImplSignature.GET_AUTOCOMPLETE);
    private static final MethodHandle GET_DIR_NAME = bind(HTMLInputElementImplSignature.GET_DIR_NAME);
    private static final MethodHandle GET_FORM_ACTION = bind(HTMLInputElementImplSignature.GET_FORM_ACTION);
    private static final MethodHandle GET_FORM_ENCTYPE = bind(HTMLInputElementImplSignature.GET_FORM_ENCTYPE);
    private static final MethodHandle GET_FORM_METHOD = bind(HTMLInputElementImplSignature.GET_FORM_METHOD);
    private static final MethodHandle GET_FORM_TARGET = bind(HTMLInputElementImplSignature.GET_FORM_TARGET);
    private static final MethodHandle GET_MAX = bind(HTMLInputElementImplSignature.GET_MAX);
    private static final MethodHandle GET_MIN = bind(HTMLInputElementImplSignature.GET_MIN);
    private static final MethodHandle GET_NAME = bind(HTMLInputElementImplSignature.GET_NAME);
    private static final MethodHandle GET_PATTERN = bind(HTMLInputElementImplSignature.GET_PATTERN);
    private static final MethodHandle GET_PLACEHOLDER = bind(HTMLInputElementImplSignature.GET_PLACEHOLDER);
    private static final MethodHandle GET_SIZE = bind(HTMLInputElementImplSignature.GET_SIZE);
    private static final MethodHandle GET_SRC = bind(HTMLInputElementImplSignature.GET_SRC);
    private static final MethodHandle GET_STEP = bind(HTMLInputElementImplSignature.GET_STEP);
    private static final MethodHandle GET_TYPE = bind(HTMLInputElementImplSignature.GET_TYPE);
    private static final MethodHandle GET_VALUE = bind(HTMLInputElementImplSignature.GET_VALUE);
    private static final MethodHandle GET_VALIDATION_MESSAGE = bind(HTMLInputElementImplSignature.GET_VALIDATION_MESSAGE);
    private static final MethodHandle GET_ALIGN = bind(HTMLInputElementImplSignature.GET_ALIGN);
    private static final MethodHandle GET_USE_MAP = bind(HTMLInputElementImplSignature.GET_USE_MAP);
    private static final MethodHandle GET_ACCESS_KEY = bind(HTMLInputElementImplSignature.GET_ACCESS_KEY);

    private static final MethodHandle GET_FORM = bind(HTMLInputElementImplSignature.GET_FORM);
    private static final MethodHandle GET_LABELS = bind(HTMLInputElementImplSignature.GET_LABELS);

    private static final MethodHandle STEP_UP = bind(HTMLInputElementImplSignature.STEP_UP);
    private static final MethodHandle STEP_DOWN = bind(HTMLInputElementImplSignature.STEP_DOWN);
    private static final MethodHandle SET_RANGE_TEXT = bind(HTMLInputElementImplSignature.SET_RANGE_TEXT);
    private static final MethodHandle SET_RANGE_TEXT_EX = bind(HTMLInputElementImplSignature.SET_RANGE_TEXT_EX);

    private HTMLInputElementImplBinding() {
    }

    private static MethodHandle bind(HTMLInputElementImplSignature entry) {
        return BINDER.downcall(entry.symbol(), entry.signature());
    }

    public static boolean getAutofocus(long peer) {
        try {
            return (boolean) GET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_AUTOFOCUS.symbol(), t);
        }
    }

    public static void setAutofocus(long peer, boolean value) {
        try {
            SET_AUTOFOCUS.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_AUTOFOCUS.symbol(), t);
        }
    }

    public static boolean getDefaultChecked(long peer) {
        try {
            return (boolean) GET_DEFAULT_CHECKED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_DEFAULT_CHECKED.symbol(), t);
        }
    }

    public static void setDefaultChecked(long peer, boolean value) {
        try {
            SET_DEFAULT_CHECKED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_DEFAULT_CHECKED.symbol(), t);
        }
    }

    public static boolean getChecked(long peer) {
        try {
            return (boolean) GET_CHECKED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_CHECKED.symbol(), t);
        }
    }

    public static void setChecked(long peer, boolean value) {
        try {
            SET_CHECKED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_CHECKED.symbol(), t);
        }
    }

    public static boolean getDisabled(long peer) {
        try {
            return (boolean) GET_DISABLED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_DISABLED.symbol(), t);
        }
    }

    public static void setDisabled(long peer, boolean value) {
        try {
            SET_DISABLED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_DISABLED.symbol(), t);
        }
    }

    public static boolean getFormNoValidate(long peer) {
        try {
            return (boolean) GET_FORM_NO_VALIDATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM_NO_VALIDATE.symbol(), t);
        }
    }

    public static void setFormNoValidate(long peer, boolean value) {
        try {
            SET_FORM_NO_VALIDATE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_FORM_NO_VALIDATE.symbol(), t);
        }
    }

    public static int getHeight(long peer) {
        try {
            return (int) GET_HEIGHT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_HEIGHT.symbol(), t);
        }
    }

    public static boolean getIndeterminate(long peer) {
        try {
            return (boolean) GET_INDETERMINATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_INDETERMINATE.symbol(), t);
        }
    }

    public static void setIndeterminate(long peer, boolean value) {
        try {
            SET_INDETERMINATE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_INDETERMINATE.symbol(), t);
        }
    }

    public static int getMaxLength(long peer) {
        try {
            return (int) GET_MAX_LENGTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_MAX_LENGTH.symbol(), t);
        }
    }

    public static void setMaxLength(long peer, int value) {
        try {
            SET_MAX_LENGTH.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_MAX_LENGTH.symbol(), t);
        }
    }

    public static boolean getMultiple(long peer) {
        try {
            return (boolean) GET_MULTIPLE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_MULTIPLE.symbol(), t);
        }
    }

    public static void setMultiple(long peer, boolean value) {
        try {
            SET_MULTIPLE.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_MULTIPLE.symbol(), t);
        }
    }

    public static boolean getReadOnly(long peer) {
        try {
            return (boolean) GET_READ_ONLY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_READ_ONLY.symbol(), t);
        }
    }

    public static void setReadOnly(long peer, boolean value) {
        try {
            SET_READ_ONLY.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_READ_ONLY.symbol(), t);
        }
    }

    public static boolean getRequired(long peer) {
        try {
            return (boolean) GET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_REQUIRED.symbol(), t);
        }
    }

    public static void setRequired(long peer, boolean value) {
        try {
            SET_REQUIRED.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_REQUIRED.symbol(), t);
        }
    }

    public static double getValueAsNumber(long peer) {
        try {
            return (double) GET_VALUE_AS_NUMBER.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_VALUE_AS_NUMBER.symbol(), t);
        }
    }

    public static void setValueAsNumber(long peer, double value) {
        try {
            SET_VALUE_AS_NUMBER.invokeExact(MemorySegment.ofAddress(peer), value);
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_VALUE_AS_NUMBER.symbol(), t);
        }
    }

    public static int getWidth(long peer) {
        try {
            return (int) GET_WIDTH.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_WIDTH.symbol(), t);
        }
    }

    public static boolean getWillValidate(long peer) {
        try {
            return (boolean) GET_WILL_VALIDATE.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_WILL_VALIDATE.symbol(), t);
        }
    }

    public static boolean checkValidity(long peer) {
        try {
            return (boolean) CHECK_VALIDITY.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.CHECK_VALIDITY.symbol(), t);
        }
    }

    public static void select(long peer) {
        try {
            SELECT.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SELECT.symbol(), t);
        }
    }

    public static void click(long peer) {
        try {
            CLICK.invokeExact(MemorySegment.ofAddress(peer));
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.CLICK.symbol(), t);
        }
    }

    public static void setAccept(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ACCEPT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_ACCEPT.symbol(), t);
        }
    }

    public static void setAlt(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ALT.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_ALT.symbol(), t);
        }
    }

    public static void setDirName(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_DIR_NAME.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_DIR_NAME.symbol(), t);
        }
    }

    public static void setFormTarget(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_FORM_TARGET.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_FORM_TARGET.symbol(), t);
        }
    }

    public static void setMax(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_MAX.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_MAX.symbol(), t);
        }
    }

    public static void setMin(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_MIN.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_MIN.symbol(), t);
        }
    }

    public static void setName(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_NAME.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_NAME.symbol(), t);
        }
    }

    public static void setPattern(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_PATTERN.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_PATTERN.symbol(), t);
        }
    }

    public static void setPlaceholder(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_PLACEHOLDER.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_PLACEHOLDER.symbol(), t);
        }
    }

    public static void setSrc(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_SRC.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_SRC.symbol(), t);
        }
    }

    public static void setStep(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_STEP.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_STEP.symbol(), t);
        }
    }

    public static void setValue(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_VALUE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_VALUE.symbol(), t);
        }
    }

    public static void setAlign(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ALIGN.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_ALIGN.symbol(), t);
        }
    }

    public static void setUseMap(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_USE_MAP.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_USE_MAP.symbol(), t);
        }
    }

    public static void setAccessKey(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_ACCESS_KEY.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_ACCESS_KEY.symbol(), t);
        }
    }

    public static void setCustomValidity(long peer, String error) {
        try (Transfer utf8 = CString8.of(error, TransferPool.SHARED)) {
            SET_CUSTOM_VALIDITY.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_CUSTOM_VALIDITY.symbol(), t);
        }
    }

    public static void setValueForUser(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_VALUE_FOR_USER.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_VALUE_FOR_USER.symbol(), t);
        }
    }

    public static void setSize(long peer, String value) {
        try (Transfer utf8 = CString8.of(value, TransferPool.SHARED)) {
            SET_SIZE.invokeExact(MemorySegment.ofAddress(peer), utf8.segment());
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.SET_SIZE.symbol(), t);
        }
    }

    public static String getAccept(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ACCEPT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_ACCEPT.symbol(), t);
        }
    }

    public static String getAlt(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ALT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_ALT.symbol(), t);
        }
    }

    public static String getAutocomplete(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_AUTOCOMPLETE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_AUTOCOMPLETE.symbol(), t);
        }
    }

    public static String getDirName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_DIR_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_DIR_NAME.symbol(), t);
        }
    }

    public static String getFormAction(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_FORM_ACTION.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM_ACTION.symbol(), t);
        }
    }

    public static String getFormEnctype(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_FORM_ENCTYPE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM_ENCTYPE.symbol(), t);
        }
    }

    public static String getFormMethod(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_FORM_METHOD.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM_METHOD.symbol(), t);
        }
    }

    public static String getFormTarget(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_FORM_TARGET.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM_TARGET.symbol(), t);
        }
    }

    public static String getMax(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_MAX.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_MAX.symbol(), t);
        }
    }

    public static String getMin(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_MIN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_MIN.symbol(), t);
        }
    }

    public static String getName(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_NAME.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_NAME.symbol(), t);
        }
    }

    public static String getPattern(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PATTERN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_PATTERN.symbol(), t);
        }
    }

    public static String getPlaceholder(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_PLACEHOLDER.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_PLACEHOLDER.symbol(), t);
        }
    }

    public static String getSize(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SIZE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_SIZE.symbol(), t);
        }
    }

    public static String getSrc(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_SRC.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_SRC.symbol(), t);
        }
    }

    public static String getStep(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_STEP.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_STEP.symbol(), t);
        }
    }

    public static String getType(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_TYPE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_TYPE.symbol(), t);
        }
    }

    public static String getValue(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_VALUE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_VALUE.symbol(), t);
        }
    }

    public static String getValidationMessage(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_VALIDATION_MESSAGE.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_VALIDATION_MESSAGE.symbol(), t);
        }
    }

    public static String getAlign(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ALIGN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_ALIGN.symbol(), t);
        }
    }

    public static String getUseMap(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_USE_MAP.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_USE_MAP.symbol(), t);
        }
    }

    public static String getAccessKey(long peer) {
        try (Char16StringExchange exchange = new Char16StringExchange()) {
            GET_ACCESS_KEY.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer));
            return exchange.value();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_ACCESS_KEY.symbol(), t);
        }
    }

    public static long getForm(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_FORM.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_FORM.symbol(), t);
        }
    }

    public static long getLabels(long peer) {
        try {
            MemorySegment result = (MemorySegment) GET_LABELS.invokeExact(MemorySegment.ofAddress(peer));
            return result.address();
        } catch (Throwable t) {
            throw Downcall.failed(HTMLInputElementImplSignature.GET_LABELS.symbol(), t);
        }
    }

    public static void stepUp(long peer, int n) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                STEP_UP.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), n);
            } catch (Throwable t) {
                throw Downcall.failed(HTMLInputElementImplSignature.STEP_UP.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void stepDown(long peer, int n) {
        try (ByteExchange exchange = new ByteExchange()) {
            try {
                STEP_DOWN.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), n);
            } catch (Throwable t) {
                throw Downcall.failed(HTMLInputElementImplSignature.STEP_DOWN.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }

    public static void setRangeText(long peer, String replacement) {
        try (Transfer replacementUtf8 = CString8.of(replacement, TransferPool.SHARED);
                ByteExchange exchange = new ByteExchange()) {
            try {
                SET_RANGE_TEXT.invokeExact(exchange.segment(), MemorySegment.ofAddress(peer), replacementUtf8.segment());
            } catch (Throwable t) {
                throw Downcall.failed(HTMLInputElementImplSignature.SET_RANGE_TEXT.symbol(), t);
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
                throw Downcall.failed(HTMLInputElementImplSignature.SET_RANGE_TEXT_EX.symbol(), t);
            }
            if (exchange.threw()) {
                throw new DOMException((short) exchange.errorCode(), exchange.errorMessage());
            }
        }
    }
}
