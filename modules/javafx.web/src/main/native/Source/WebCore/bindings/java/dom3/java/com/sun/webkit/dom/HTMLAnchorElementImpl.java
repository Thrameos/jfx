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
import org.w3c.dom.html.HTMLAnchorElement;
import com.sun.webkit.dom.interop.HTMLAnchorElementImplBinding;

public class HTMLAnchorElementImpl extends HTMLElementImpl implements HTMLAnchorElement {
    HTMLAnchorElementImpl(long peer) {
        super(peer);
    }

    static HTMLAnchorElement getImpl(long peer) {
        return (HTMLAnchorElement)create(peer);
    }


// Attributes
    @Override
    public String getCharset() {
        return HTMLAnchorElementImplBinding.getCharset(getPeer());
    }
    native static String getCharsetImpl(long peer);

    @Override
    public void setCharset(String value) {
        HTMLAnchorElementImplBinding.setCharset(getPeer(), value);
    }
    native static void setCharsetImpl(long peer, String value);

    @Override
    public String getCoords() {
        return HTMLAnchorElementImplBinding.getCoords(getPeer());
    }
    native static String getCoordsImpl(long peer);

    @Override
    public void setCoords(String value) {
        HTMLAnchorElementImplBinding.setCoords(getPeer(), value);
    }
    native static void setCoordsImpl(long peer, String value);

    @Override
    public String getHreflang() {
        return HTMLAnchorElementImplBinding.getHreflang(getPeer());
    }
    native static String getHreflangImpl(long peer);

    @Override
    public void setHreflang(String value) {
        HTMLAnchorElementImplBinding.setHreflang(getPeer(), value);
    }
    native static void setHreflangImpl(long peer, String value);

    @Override
    public String getName() {
        return HTMLAnchorElementImplBinding.getName(getPeer());
    }
    native static String getNameImpl(long peer);

    @Override
    public void setName(String value) {
        HTMLAnchorElementImplBinding.setName(getPeer(), value);
    }
    native static void setNameImpl(long peer, String value);

    public String getPing() {
        return HTMLAnchorElementImplBinding.getPing(getPeer());
    }
    native static String getPingImpl(long peer);

    public void setPing(String value) {
        HTMLAnchorElementImplBinding.setPing(getPeer(), value);
    }
    native static void setPingImpl(long peer, String value);

    @Override
    public String getRel() {
        return HTMLAnchorElementImplBinding.getRel(getPeer());
    }
    native static String getRelImpl(long peer);

    @Override
    public void setRel(String value) {
        HTMLAnchorElementImplBinding.setRel(getPeer(), value);
    }
    native static void setRelImpl(long peer, String value);

    @Override
    public String getRev() {
        return HTMLAnchorElementImplBinding.getRev(getPeer());
    }
    native static String getRevImpl(long peer);

    @Override
    public void setRev(String value) {
        HTMLAnchorElementImplBinding.setRev(getPeer(), value);
    }
    native static void setRevImpl(long peer, String value);

    @Override
    public String getShape() {
        return HTMLAnchorElementImplBinding.getShape(getPeer());
    }
    native static String getShapeImpl(long peer);

    @Override
    public void setShape(String value) {
        HTMLAnchorElementImplBinding.setShape(getPeer(), value);
    }
    native static void setShapeImpl(long peer, String value);

    @Override
    public String getTarget() {
        return HTMLAnchorElementImplBinding.getTarget(getPeer());
    }
    native static String getTargetImpl(long peer);

    @Override
    public void setTarget(String value) {
        HTMLAnchorElementImplBinding.setTarget(getPeer(), value);
    }
    native static void setTargetImpl(long peer, String value);

    @Override
    public String getType() {
        return HTMLAnchorElementImplBinding.getType(getPeer());
    }
    native static String getTypeImpl(long peer);

    @Override
    public void setType(String value) {
        HTMLAnchorElementImplBinding.setType(getPeer(), value);
    }
    native static void setTypeImpl(long peer, String value);

    public String getText() {
        return HTMLAnchorElementImplBinding.getText(getPeer());
    }
    native static String getTextImpl(long peer);

    public void setText(String value) throws DOMException {
        HTMLAnchorElementImplBinding.setText(getPeer(), value);
    }
    native static void setTextImpl(long peer, String value);

    @Override
    public String getHref() {
        return HTMLAnchorElementImplBinding.getHref(getPeer());
    }
    native static String getHrefImpl(long peer);

    @Override
    public void setHref(String value) {
        HTMLAnchorElementImplBinding.setHref(getPeer(), value);
    }
    native static void setHrefImpl(long peer, String value);

    public String getOrigin() {
        return HTMLAnchorElementImplBinding.getOrigin(getPeer());
    }
    native static String getOriginImpl(long peer);

    public String getProtocol() {
        return HTMLAnchorElementImplBinding.getProtocol(getPeer());
    }
    native static String getProtocolImpl(long peer);

    public void setProtocol(String value) {
        HTMLAnchorElementImplBinding.setProtocol(getPeer(), value);
    }
    native static void setProtocolImpl(long peer, String value);

    public String getUsername() {
        return HTMLAnchorElementImplBinding.getUsername(getPeer());
    }
    native static String getUsernameImpl(long peer);

    public void setUsername(String value) {
        HTMLAnchorElementImplBinding.setUsername(getPeer(), value);
    }
    native static void setUsernameImpl(long peer, String value);

    public String getPassword() {
        return HTMLAnchorElementImplBinding.getPassword(getPeer());
    }
    native static String getPasswordImpl(long peer);

    public void setPassword(String value) {
        HTMLAnchorElementImplBinding.setPassword(getPeer(), value);
    }
    native static void setPasswordImpl(long peer, String value);

    public String getHost() {
        return HTMLAnchorElementImplBinding.getHost(getPeer());
    }
    native static String getHostImpl(long peer);

    public void setHost(String value) {
        HTMLAnchorElementImplBinding.setHost(getPeer(), value);
    }
    native static void setHostImpl(long peer, String value);

    public String getHostname() {
        return HTMLAnchorElementImplBinding.getHostname(getPeer());
    }
    native static String getHostnameImpl(long peer);

    public void setHostname(String value) {
        HTMLAnchorElementImplBinding.setHostname(getPeer(), value);
    }
    native static void setHostnameImpl(long peer, String value);

    public String getPort() {
        return HTMLAnchorElementImplBinding.getPort(getPeer());
    }
    native static String getPortImpl(long peer);

    public void setPort(String value) {
        HTMLAnchorElementImplBinding.setPort(getPeer(), value);
    }
    native static void setPortImpl(long peer, String value);

    public String getPathname() {
        return HTMLAnchorElementImplBinding.getPathname(getPeer());
    }
    native static String getPathnameImpl(long peer);

    public void setPathname(String value) {
        HTMLAnchorElementImplBinding.setPathname(getPeer(), value);
    }
    native static void setPathnameImpl(long peer, String value);

    public String getSearch() {
        return HTMLAnchorElementImplBinding.getSearch(getPeer());
    }
    native static String getSearchImpl(long peer);

    public void setSearch(String value) {
        HTMLAnchorElementImplBinding.setSearch(getPeer(), value);
    }
    native static void setSearchImpl(long peer, String value);

    public String getHash() {
        return HTMLAnchorElementImplBinding.getHash(getPeer());
    }
    native static String getHashImpl(long peer);

    public void setHash(String value) {
        HTMLAnchorElementImplBinding.setHash(getPeer(), value);
    }
    native static void setHashImpl(long peer, String value);

}

