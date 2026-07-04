/*
 * Copyright (c) 2013, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.sun.webkit.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLTextAreaElement;

import com.sun.webkit.dom.interop.HTMLTextAreaElementImplBinding;

public class HTMLTextAreaElementImpl extends HTMLElementImpl implements HTMLTextAreaElement {
    HTMLTextAreaElementImpl(long peer) {
        super(peer);
    }

    static HTMLTextAreaElement getImpl(long peer) {
        return (HTMLTextAreaElement)create(peer);
    }


// Attributes
    public boolean getAutofocus() {
        return HTMLTextAreaElementImplBinding.getAutofocus(getPeer());
    }
    native static boolean getAutofocusImpl(long peer);

    public void setAutofocus(boolean value) {
        HTMLTextAreaElementImplBinding.setAutofocus(getPeer(), value);
    }
    native static void setAutofocusImpl(long peer, boolean value);

    public String getDirName() {
        return HTMLTextAreaElementImplBinding.getDirName(getPeer());
    }
    native static String getDirNameImpl(long peer);

    public void setDirName(String value) {
        HTMLTextAreaElementImplBinding.setDirName(getPeer(), value);
    }
    native static void setDirNameImpl(long peer, String value);

    @Override
    public boolean getDisabled() {
        return HTMLTextAreaElementImplBinding.getDisabled(getPeer());
    }
    native static boolean getDisabledImpl(long peer);

    @Override
    public void setDisabled(boolean value) {
        HTMLTextAreaElementImplBinding.setDisabled(getPeer(), value);
    }
    native static void setDisabledImpl(long peer, boolean value);

    @Override
    public HTMLFormElement getForm() {
        return HTMLFormElementImpl.getImpl(HTMLTextAreaElementImplBinding.getForm(getPeer()));
    }
    native static long getFormImpl(long peer);

    public int getMaxLength() {
        return HTMLTextAreaElementImplBinding.getMaxLength(getPeer());
    }
    native static int getMaxLengthImpl(long peer);

    public void setMaxLength(int value) throws DOMException {
        HTMLTextAreaElementImplBinding.setMaxLength(getPeer(), value);
    }
    native static void setMaxLengthImpl(long peer, int value);

    @Override
    public String getName() {
        return HTMLTextAreaElementImplBinding.getName(getPeer());
    }
    native static String getNameImpl(long peer);

    @Override
    public void setName(String value) {
        HTMLTextAreaElementImplBinding.setName(getPeer(), value);
    }
    native static void setNameImpl(long peer, String value);

    public String getPlaceholder() {
        return HTMLTextAreaElementImplBinding.getPlaceholder(getPeer());
    }
    native static String getPlaceholderImpl(long peer);

    public void setPlaceholder(String value) {
        HTMLTextAreaElementImplBinding.setPlaceholder(getPeer(), value);
    }
    native static void setPlaceholderImpl(long peer, String value);

    @Override
    public boolean getReadOnly() {
        return HTMLTextAreaElementImplBinding.getReadOnly(getPeer());
    }
    native static boolean getReadOnlyImpl(long peer);

    @Override
    public void setReadOnly(boolean value) {
        HTMLTextAreaElementImplBinding.setReadOnly(getPeer(), value);
    }
    native static void setReadOnlyImpl(long peer, boolean value);

    public boolean getRequired() {
        return HTMLTextAreaElementImplBinding.getRequired(getPeer());
    }
    native static boolean getRequiredImpl(long peer);

    public void setRequired(boolean value) {
        HTMLTextAreaElementImplBinding.setRequired(getPeer(), value);
    }
    native static void setRequiredImpl(long peer, boolean value);

    @Override
    public int getRows() {
        return HTMLTextAreaElementImplBinding.getRows(getPeer());
    }
    native static int getRowsImpl(long peer);

    @Override
    public void setRows(int value) {
        HTMLTextAreaElementImplBinding.setRows(getPeer(), value);
    }
    native static void setRowsImpl(long peer, int value);

    @Override
    public int getCols() {
        return HTMLTextAreaElementImplBinding.getCols(getPeer());
    }
    native static int getColsImpl(long peer);

    @Override
    public void setCols(int value) {
        HTMLTextAreaElementImplBinding.setCols(getPeer(), value);
    }
    native static void setColsImpl(long peer, int value);

    public String getWrap() {
        return HTMLTextAreaElementImplBinding.getWrap(getPeer());
    }
    native static String getWrapImpl(long peer);

    public void setWrap(String value) {
        HTMLTextAreaElementImplBinding.setWrap(getPeer(), value);
    }
    native static void setWrapImpl(long peer, String value);

    @Override
    public String getType() {
        return HTMLTextAreaElementImplBinding.getType(getPeer());
    }
    native static String getTypeImpl(long peer);

    @Override
    public String getDefaultValue() {
        return HTMLTextAreaElementImplBinding.getDefaultValue(getPeer());
    }
    native static String getDefaultValueImpl(long peer);

    @Override
    public void setDefaultValue(String value) {
        HTMLTextAreaElementImplBinding.setDefaultValue(getPeer(), value);
    }
    native static void setDefaultValueImpl(long peer, String value);

    @Override
    public String getValue() {
        return HTMLTextAreaElementImplBinding.getValue(getPeer());
    }
    native static String getValueImpl(long peer);

    @Override
    public void setValue(String value) {
        HTMLTextAreaElementImplBinding.setValue(getPeer(), value);
    }
    native static void setValueImpl(long peer, String value);

    public int getTextLength() {
        return HTMLTextAreaElementImplBinding.getTextLength(getPeer());
    }
    native static int getTextLengthImpl(long peer);

    public boolean getWillValidate() {
        return HTMLTextAreaElementImplBinding.getWillValidate(getPeer());
    }
    native static boolean getWillValidateImpl(long peer);

    public String getValidationMessage() {
        return HTMLTextAreaElementImplBinding.getValidationMessage(getPeer());
    }
    native static String getValidationMessageImpl(long peer);

    public NodeList getLabels() {
        return NodeListImpl.getImpl(HTMLTextAreaElementImplBinding.getLabels(getPeer()));
    }
    native static long getLabelsImpl(long peer);

    public int getSelectionStart() {
        return HTMLTextAreaElementImplBinding.getSelectionStart(getPeer());
    }
    native static int getSelectionStartImpl(long peer);

    public void setSelectionStart(int value) {
        HTMLTextAreaElementImplBinding.setSelectionStart(getPeer(), value);
    }
    native static void setSelectionStartImpl(long peer, int value);

    public int getSelectionEnd() {
        return HTMLTextAreaElementImplBinding.getSelectionEnd(getPeer());
    }
    native static int getSelectionEndImpl(long peer);

    public void setSelectionEnd(int value) {
        HTMLTextAreaElementImplBinding.setSelectionEnd(getPeer(), value);
    }
    native static void setSelectionEndImpl(long peer, int value);

    public String getSelectionDirection() {
        return HTMLTextAreaElementImplBinding.getSelectionDirection(getPeer());
    }
    native static String getSelectionDirectionImpl(long peer);

    public void setSelectionDirection(String value) {
        HTMLTextAreaElementImplBinding.setSelectionDirection(getPeer(), value);
    }
    native static void setSelectionDirectionImpl(long peer, String value);

    @Override
    public String getAccessKey() {
        return HTMLTextAreaElementImplBinding.getAccessKey(getPeer());
    }
    native static String getAccessKeyImpl(long peer);

    @Override
    public void setAccessKey(String value) {
        HTMLTextAreaElementImplBinding.setAccessKey(getPeer(), value);
    }
    native static void setAccessKeyImpl(long peer, String value);

    public String getAutocomplete() {
        return HTMLTextAreaElementImplBinding.getAutocomplete(getPeer());
    }
    native static String getAutocompleteImpl(long peer);

    // setAutocomplete is NOT migrated -- no working JNI implementation exists
    // (confirmed via `nm -D`), so this stays on the old dead-code path rather
    // than gaining new functionality during migration.
    public void setAutocomplete(String value) {
        setAutocompleteImpl(getPeer(), value);
    }
    native static void setAutocompleteImpl(long peer, String value);


// Functions
    public boolean checkValidity()
    {
        return HTMLTextAreaElementImplBinding.checkValidity(getPeer());
    }
    native static boolean checkValidityImpl(long peer);


    public void setCustomValidity(String error)
    {
        HTMLTextAreaElementImplBinding.setCustomValidity(getPeer(), error);
    }
    native static void setCustomValidityImpl(long peer
        , String error);


    @Override
    public void select()
    {
        HTMLTextAreaElementImplBinding.select(getPeer());
    }
    native static void selectImpl(long peer);


    public void setRangeText(String replacement) throws DOMException
    {
        HTMLTextAreaElementImplBinding.setRangeText(getPeer(), replacement);
    }
    native static void setRangeTextImpl(long peer
        , String replacement);


    public void setRangeTextEx(String replacement
        , int start
        , int end
        , String selectionMode) throws DOMException
    {
        HTMLTextAreaElementImplBinding.setRangeTextEx(getPeer(), replacement, start, end, selectionMode);
    }
    native static void setRangeTextExImpl(long peer
        , String replacement
        , int start
        , int end
        , String selectionMode);


    public void setSelectionRange(int start
        , int end
        , String direction)
    {
        HTMLTextAreaElementImplBinding.setSelectionRange(getPeer(), start, end, direction);
    }
    native static void setSelectionRangeImpl(long peer
        , int start
        , int end
        , String direction);


}
