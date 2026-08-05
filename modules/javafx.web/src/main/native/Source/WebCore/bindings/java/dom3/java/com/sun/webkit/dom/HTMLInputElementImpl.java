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
import org.w3c.dom.html.HTMLInputElement;

import com.sun.webkit.dom.interop.HTMLInputElementImplBinding;

public class HTMLInputElementImpl extends HTMLElementImpl implements HTMLInputElement {
    HTMLInputElementImpl(long peer) {
        super(peer);
    }

    static HTMLInputElement getImpl(long peer) {
        return (HTMLInputElement)create(peer);
    }


// Attributes
    @Override
    public String getAccept() {
        return HTMLInputElementImplBinding.getAccept(getPeer());
    }
    native static String getAcceptImpl(long peer);

    @Override
    public void setAccept(String value) {
        HTMLInputElementImplBinding.setAccept(getPeer(), value);
    }
    native static void setAcceptImpl(long peer, String value);

    @Override
    public String getAlt() {
        return HTMLInputElementImplBinding.getAlt(getPeer());
    }
    native static String getAltImpl(long peer);

    @Override
    public void setAlt(String value) {
        HTMLInputElementImplBinding.setAlt(getPeer(), value);
    }
    native static void setAltImpl(long peer, String value);

    public String getAutocomplete() {
        return HTMLInputElementImplBinding.getAutocomplete(getPeer());
    }
    native static String getAutocompleteImpl(long peer);

    // NOTE: setAutocomplete still routes through the old JNI Impl -- no
    // native symbol was ever implemented for it (confirmed via `nm -D` on
    // the built .so), so migrating it would be new functionality, not a
    // migration (same reasoning as the phantom methods reverted in
    // ElementImpl/DocumentImpl).
    public void setAutocomplete(String value) {
        setAutocompleteImpl(getPeer(), value);
    }
    native static void setAutocompleteImpl(long peer, String value);

    public boolean getAutofocus() {
        return HTMLInputElementImplBinding.getAutofocus(getPeer());
    }
    native static boolean getAutofocusImpl(long peer);

    public void setAutofocus(boolean value) {
        HTMLInputElementImplBinding.setAutofocus(getPeer(), value);
    }
    native static void setAutofocusImpl(long peer, boolean value);

    @Override
    public boolean getDefaultChecked() {
        return HTMLInputElementImplBinding.getDefaultChecked(getPeer());
    }
    native static boolean getDefaultCheckedImpl(long peer);

    @Override
    public void setDefaultChecked(boolean value) {
        HTMLInputElementImplBinding.setDefaultChecked(getPeer(), value);
    }
    native static void setDefaultCheckedImpl(long peer, boolean value);

    @Override
    public boolean getChecked() {
        return HTMLInputElementImplBinding.getChecked(getPeer());
    }
    native static boolean getCheckedImpl(long peer);

    @Override
    public void setChecked(boolean value) {
        HTMLInputElementImplBinding.setChecked(getPeer(), value);
    }
    native static void setCheckedImpl(long peer, boolean value);

    public String getDirName() {
        return HTMLInputElementImplBinding.getDirName(getPeer());
    }
    native static String getDirNameImpl(long peer);

    public void setDirName(String value) {
        HTMLInputElementImplBinding.setDirName(getPeer(), value);
    }
    native static void setDirNameImpl(long peer, String value);

    @Override
    public boolean getDisabled() {
        return HTMLInputElementImplBinding.getDisabled(getPeer());
    }
    native static boolean getDisabledImpl(long peer);

    @Override
    public void setDisabled(boolean value) {
        HTMLInputElementImplBinding.setDisabled(getPeer(), value);
    }
    native static void setDisabledImpl(long peer, boolean value);

    @Override
    public HTMLFormElement getForm() {
        return HTMLFormElementImpl.getImpl(HTMLInputElementImplBinding.getForm(getPeer()));
    }
    native static long getFormImpl(long peer);

    // NOTE: setFormAction/setFormEnctype/setFormMethod/setType below still
    // route through the old JNI Impl -- no native symbol was ever
    // implemented for any of them (confirmed via `nm -D`), so migrating
    // them would be new functionality, not a migration.
    public String getFormAction() {
        return HTMLInputElementImplBinding.getFormAction(getPeer());
    }
    native static String getFormActionImpl(long peer);

    public void setFormAction(String value) {
        setFormActionImpl(getPeer(), value);
    }
    native static void setFormActionImpl(long peer, String value);

    public String getFormEnctype() {
        return HTMLInputElementImplBinding.getFormEnctype(getPeer());
    }
    native static String getFormEnctypeImpl(long peer);

    public void setFormEnctype(String value) {
        setFormEnctypeImpl(getPeer(), value);
    }
    native static void setFormEnctypeImpl(long peer, String value);

    public String getFormMethod() {
        return HTMLInputElementImplBinding.getFormMethod(getPeer());
    }
    native static String getFormMethodImpl(long peer);

    public void setFormMethod(String value) {
        setFormMethodImpl(getPeer(), value);
    }
    native static void setFormMethodImpl(long peer, String value);

    public boolean getFormNoValidate() {
        return HTMLInputElementImplBinding.getFormNoValidate(getPeer());
    }
    native static boolean getFormNoValidateImpl(long peer);

    public void setFormNoValidate(boolean value) {
        HTMLInputElementImplBinding.setFormNoValidate(getPeer(), value);
    }
    native static void setFormNoValidateImpl(long peer, boolean value);

    public String getFormTarget() {
        return HTMLInputElementImplBinding.getFormTarget(getPeer());
    }
    native static String getFormTargetImpl(long peer);

    public void setFormTarget(String value) {
        HTMLInputElementImplBinding.setFormTarget(getPeer(), value);
    }
    native static void setFormTargetImpl(long peer, String value);

    public int getHeight() {
        return HTMLInputElementImplBinding.getHeight(getPeer());
    }
    native static int getHeightImpl(long peer);

    // NOTE: setHeight/setWidth still route through the old JNI Impl -- no
    // native symbol was ever implemented for either (confirmed via `nm -D`).
    public void setHeight(int value) {
        setHeightImpl(getPeer(), value);
    }
    native static void setHeightImpl(long peer, int value);

    public boolean getIndeterminate() {
        return HTMLInputElementImplBinding.getIndeterminate(getPeer());
    }
    native static boolean getIndeterminateImpl(long peer);

    public void setIndeterminate(boolean value) {
        HTMLInputElementImplBinding.setIndeterminate(getPeer(), value);
    }
    native static void setIndeterminateImpl(long peer, boolean value);

    public String getMax() {
        return HTMLInputElementImplBinding.getMax(getPeer());
    }
    native static String getMaxImpl(long peer);

    public void setMax(String value) {
        HTMLInputElementImplBinding.setMax(getPeer(), value);
    }
    native static void setMaxImpl(long peer, String value);

    @Override
    public int getMaxLength() {
        return HTMLInputElementImplBinding.getMaxLength(getPeer());
    }
    native static int getMaxLengthImpl(long peer);

    @Override
    public void setMaxLength(int value) throws DOMException {
        HTMLInputElementImplBinding.setMaxLength(getPeer(), value);
    }
    native static void setMaxLengthImpl(long peer, int value);

    public String getMin() {
        return HTMLInputElementImplBinding.getMin(getPeer());
    }
    native static String getMinImpl(long peer);

    public void setMin(String value) {
        HTMLInputElementImplBinding.setMin(getPeer(), value);
    }
    native static void setMinImpl(long peer, String value);

    public boolean getMultiple() {
        return HTMLInputElementImplBinding.getMultiple(getPeer());
    }
    native static boolean getMultipleImpl(long peer);

    public void setMultiple(boolean value) {
        HTMLInputElementImplBinding.setMultiple(getPeer(), value);
    }
    native static void setMultipleImpl(long peer, boolean value);

    @Override
    public String getName() {
        return HTMLInputElementImplBinding.getName(getPeer());
    }
    native static String getNameImpl(long peer);

    @Override
    public void setName(String value) {
        HTMLInputElementImplBinding.setName(getPeer(), value);
    }
    native static void setNameImpl(long peer, String value);

    public String getPattern() {
        return HTMLInputElementImplBinding.getPattern(getPeer());
    }
    native static String getPatternImpl(long peer);

    public void setPattern(String value) {
        HTMLInputElementImplBinding.setPattern(getPeer(), value);
    }
    native static void setPatternImpl(long peer, String value);

    public String getPlaceholder() {
        return HTMLInputElementImplBinding.getPlaceholder(getPeer());
    }
    native static String getPlaceholderImpl(long peer);

    public void setPlaceholder(String value) {
        HTMLInputElementImplBinding.setPlaceholder(getPeer(), value);
    }
    native static void setPlaceholderImpl(long peer, String value);

    @Override
    public boolean getReadOnly() {
        return HTMLInputElementImplBinding.getReadOnly(getPeer());
    }
    native static boolean getReadOnlyImpl(long peer);

    @Override
    public void setReadOnly(boolean value) {
        HTMLInputElementImplBinding.setReadOnly(getPeer(), value);
    }
    native static void setReadOnlyImpl(long peer, boolean value);

    public boolean getRequired() {
        return HTMLInputElementImplBinding.getRequired(getPeer());
    }
    native static boolean getRequiredImpl(long peer);

    public void setRequired(boolean value) {
        HTMLInputElementImplBinding.setRequired(getPeer(), value);
    }
    native static void setRequiredImpl(long peer, boolean value);

    @Override
    public String getSize() {
        return HTMLInputElementImplBinding.getSize(getPeer())+"";
    }
    native static String getSizeImpl(long peer);

    @Override
    public void setSize(String value) {
        HTMLInputElementImplBinding.setSize(getPeer(), value);
    }
    native static void setSizeImpl(long peer, String value);

    @Override
    public String getSrc() {
        return HTMLInputElementImplBinding.getSrc(getPeer());
    }
    native static String getSrcImpl(long peer);

    @Override
    public void setSrc(String value) {
        HTMLInputElementImplBinding.setSrc(getPeer(), value);
    }
    native static void setSrcImpl(long peer, String value);

    public String getStep() {
        return HTMLInputElementImplBinding.getStep(getPeer());
    }
    native static String getStepImpl(long peer);

    public void setStep(String value) {
        HTMLInputElementImplBinding.setStep(getPeer(), value);
    }
    native static void setStepImpl(long peer, String value);

    @Override
    public String getType() {
        return HTMLInputElementImplBinding.getType(getPeer());
    }
    native static String getTypeImpl(long peer);

    public void setType(String value) {
        setTypeImpl(getPeer(), value);
    }
    native static void setTypeImpl(long peer, String value);

    // NOTE: getDefaultValue/setDefaultValue and getValueAsDate/
    // setValueAsDate below still route through the old JNI Impl.
    // getDefaultValue/setDefaultValue: no native symbol was ever
    // implemented (confirmed via `nm -D`), so migrating would be new
    // functionality. getValueAsDate/setValueAsDate: the old JNI symbol IS
    // real, but it round-trips a WallTime through
    // `approximateMonotonicTime().get_time_value()`, a time-representation
    // shape with no proven Panama pattern yet -- deferred, not phantom.
    @Override
    public String getDefaultValue() {
        return getDefaultValueImpl(getPeer());
    }
    native static String getDefaultValueImpl(long peer);

    @Override
    public void setDefaultValue(String value) {
        setDefaultValueImpl(getPeer(), value);
    }
    native static void setDefaultValueImpl(long peer, String value);

    @Override
    public String getValue() {
        return HTMLInputElementImplBinding.getValue(getPeer());
    }
    native static String getValueImpl(long peer);

    @Override
    public void setValue(String value) {
        HTMLInputElementImplBinding.setValue(getPeer(), value);
    }
    native static void setValueImpl(long peer, String value);

    public long getValueAsDate() {
        return getValueAsDateImpl(getPeer());
    }
    native static long getValueAsDateImpl(long peer);

    public void setValueAsDate(long value) throws DOMException {
        setValueAsDateImpl(getPeer(), value);
    }
    native static void setValueAsDateImpl(long peer, long value);

    public double getValueAsNumber() {
        return HTMLInputElementImplBinding.getValueAsNumber(getPeer());
    }
    native static double getValueAsNumberImpl(long peer);

    public void setValueAsNumber(double value) throws DOMException {
        HTMLInputElementImplBinding.setValueAsNumber(getPeer(), value);
    }
    native static void setValueAsNumberImpl(long peer, double value);

    public int getWidth() {
        return HTMLInputElementImplBinding.getWidth(getPeer());
    }
    native static int getWidthImpl(long peer);

    public void setWidth(int value) {
        setWidthImpl(getPeer(), value);
    }
    native static void setWidthImpl(long peer, int value);

    public boolean getWillValidate() {
        return HTMLInputElementImplBinding.getWillValidate(getPeer());
    }
    native static boolean getWillValidateImpl(long peer);

    public String getValidationMessage() {
        return HTMLInputElementImplBinding.getValidationMessage(getPeer());
    }
    native static String getValidationMessageImpl(long peer);

    public NodeList getLabels() {
        return NodeListImpl.getImpl(HTMLInputElementImplBinding.getLabels(getPeer()));
    }
    native static long getLabelsImpl(long peer);

    @Override
    public String getAlign() {
        return HTMLInputElementImplBinding.getAlign(getPeer());
    }
    native static String getAlignImpl(long peer);

    @Override
    public void setAlign(String value) {
        HTMLInputElementImplBinding.setAlign(getPeer(), value);
    }
    native static void setAlignImpl(long peer, String value);

    @Override
    public String getUseMap() {
        return HTMLInputElementImplBinding.getUseMap(getPeer());
    }
    native static String getUseMapImpl(long peer);

    @Override
    public void setUseMap(String value) {
        HTMLInputElementImplBinding.setUseMap(getPeer(), value);
    }
    native static void setUseMapImpl(long peer, String value);

    // NOTE: getIncremental/setIncremental still route through the old JNI
    // Impl -- no native symbol was ever implemented for either (confirmed
    // via `nm -D`), so migrating them would be new functionality, not a
    // migration. Also not part of org.w3c.dom.html.HTMLInputElement, a
    // JavaFX-only extension.
    public boolean getIncremental() {
        return getIncrementalImpl(getPeer());
    }
    native static boolean getIncrementalImpl(long peer);

    public void setIncremental(boolean value) {
        setIncrementalImpl(getPeer(), value);
    }
    native static void setIncrementalImpl(long peer, boolean value);

    @Override
    public String getAccessKey() {
        return HTMLInputElementImplBinding.getAccessKey(getPeer());
    }
    native static String getAccessKeyImpl(long peer);

    @Override
    public void setAccessKey(String value) {
        HTMLInputElementImplBinding.setAccessKey(getPeer(), value);
    }
    native static void setAccessKeyImpl(long peer, String value);


// Functions
    public void stepUp(int n) throws DOMException
    {
        HTMLInputElementImplBinding.stepUp(getPeer(), n);
    }
    native static void stepUpImpl(long peer
        , int n);


    public void stepDown(int n) throws DOMException
    {
        HTMLInputElementImplBinding.stepDown(getPeer(), n);
    }
    native static void stepDownImpl(long peer
        , int n);


    public boolean checkValidity()
    {
        return HTMLInputElementImplBinding.checkValidity(getPeer());
    }
    native static boolean checkValidityImpl(long peer);


    public void setCustomValidity(String error)
    {
        HTMLInputElementImplBinding.setCustomValidity(getPeer(), error);
    }
    native static void setCustomValidityImpl(long peer
        , String error);


    @Override
    public void select()
    {
        HTMLInputElementImplBinding.select(getPeer());
    }
    native static void selectImpl(long peer);


    public void setRangeText(String replacement) throws DOMException
    {
        HTMLInputElementImplBinding.setRangeText(getPeer(), replacement);
    }
    native static void setRangeTextImpl(long peer
        , String replacement);


    public void setRangeTextEx(String replacement
        , int start
        , int end
        , String selectionMode) throws DOMException
    {
        HTMLInputElementImplBinding.setRangeTextEx(getPeer(), replacement, start, end, selectionMode);
    }
    native static void setRangeTextExImpl(long peer
        , String replacement
        , int start
        , int end
        , String selectionMode);


    @Override
    public void click()
    {
        HTMLInputElementImplBinding.click(getPeer());
    }
    native static void clickImpl(long peer);


    public void setValueForUser(String value)
    {
        HTMLInputElementImplBinding.setValueForUser(getPeer(), value);
    }
    native static void setValueForUserImpl(long peer
        , String value);


}

