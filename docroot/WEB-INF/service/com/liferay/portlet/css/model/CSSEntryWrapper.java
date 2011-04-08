/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.css.model;

/**
 * <p>
 * This class is a wrapper for {@link CSSEntry}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CSSEntry
 * @generated
 */
public class CSSEntryWrapper implements CSSEntry {
	public CSSEntryWrapper(CSSEntry cssEntry) {
		_cssEntry = cssEntry;
	}

	/**
	* Gets the primary key of this c s s entry.
	*
	* @return the primary key of this c s s entry
	*/
	public long getPrimaryKey() {
		return _cssEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this c s s entry
	*
	* @param pk the primary key of this c s s entry
	*/
	public void setPrimaryKey(long pk) {
		_cssEntry.setPrimaryKey(pk);
	}

	/**
	* Gets the uuid of this c s s entry.
	*
	* @return the uuid of this c s s entry
	*/
	public java.lang.String getUuid() {
		return _cssEntry.getUuid();
	}

	/**
	* Sets the uuid of this c s s entry.
	*
	* @param uuid the uuid of this c s s entry
	*/
	public void setUuid(java.lang.String uuid) {
		_cssEntry.setUuid(uuid);
	}

	/**
	* Gets the css entry id of this c s s entry.
	*
	* @return the css entry id of this c s s entry
	*/
	public long getCssEntryId() {
		return _cssEntry.getCssEntryId();
	}

	/**
	* Sets the css entry id of this c s s entry.
	*
	* @param cssEntryId the css entry id of this c s s entry
	*/
	public void setCssEntryId(long cssEntryId) {
		_cssEntry.setCssEntryId(cssEntryId);
	}

	/**
	* Gets the create date of this c s s entry.
	*
	* @return the create date of this c s s entry
	*/
	public java.util.Date getCreateDate() {
		return _cssEntry.getCreateDate();
	}

	/**
	* Sets the create date of this c s s entry.
	*
	* @param createDate the create date of this c s s entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_cssEntry.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this c s s entry.
	*
	* @return the modified date of this c s s entry
	*/
	public java.util.Date getModifiedDate() {
		return _cssEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this c s s entry.
	*
	* @param modifiedDate the modified date of this c s s entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_cssEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the css of this c s s entry.
	*
	* @return the css of this c s s entry
	*/
	public java.lang.String getCss() {
		return _cssEntry.getCss();
	}

	/**
	* Sets the css of this c s s entry.
	*
	* @param css the css of this c s s entry
	*/
	public void setCss(java.lang.String css) {
		_cssEntry.setCss(css);
	}

	/**
	* Gets the class name of the model instance this c s s entry is polymorphically associated with.
	*
	* @return the class name of the model instance this c s s entry is polymorphically associated with
	*/
	public java.lang.String getClassName() {
		return _cssEntry.getClassName();
	}

	/**
	* Gets the class name id of this c s s entry.
	*
	* @return the class name id of this c s s entry
	*/
	public long getClassNameId() {
		return _cssEntry.getClassNameId();
	}

	/**
	* Sets the class name id of this c s s entry.
	*
	* @param classNameId the class name id of this c s s entry
	*/
	public void setClassNameId(long classNameId) {
		_cssEntry.setClassNameId(classNameId);
	}

	/**
	* Gets the class p k of this c s s entry.
	*
	* @return the class p k of this c s s entry
	*/
	public long getClassPK() {
		return _cssEntry.getClassPK();
	}

	/**
	* Sets the class p k of this c s s entry.
	*
	* @param classPK the class p k of this c s s entry
	*/
	public void setClassPK(long classPK) {
		_cssEntry.setClassPK(classPK);
	}

	/**
	* Gets the group id of this c s s entry.
	*
	* @return the group id of this c s s entry
	*/
	public long getGroupId() {
		return _cssEntry.getGroupId();
	}

	/**
	* Sets the group id of this c s s entry.
	*
	* @param groupId the group id of this c s s entry
	*/
	public void setGroupId(long groupId) {
		_cssEntry.setGroupId(groupId);
	}

	/**
	* Gets the version of this c s s entry.
	*
	* @return the version of this c s s entry
	*/
	public double getVersion() {
		return _cssEntry.getVersion();
	}

	/**
	* Sets the version of this c s s entry.
	*
	* @param version the version of this c s s entry
	*/
	public void setVersion(double version) {
		_cssEntry.setVersion(version);
	}

	/**
	* Gets the status of this c s s entry.
	*
	* @return the status of this c s s entry
	*/
	public int getStatus() {
		return _cssEntry.getStatus();
	}

	/**
	* Sets the status of this c s s entry.
	*
	* @param status the status of this c s s entry
	*/
	public void setStatus(int status) {
		_cssEntry.setStatus(status);
	}

	/**
	* Gets the status date of this c s s entry.
	*
	* @return the status date of this c s s entry
	*/
	public java.util.Date getStatusDate() {
		return _cssEntry.getStatusDate();
	}

	/**
	* Sets the status date of this c s s entry.
	*
	* @param statusDate the status date of this c s s entry
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_cssEntry.setStatusDate(statusDate);
	}

	public boolean isNew() {
		return _cssEntry.isNew();
	}

	public void setNew(boolean n) {
		_cssEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _cssEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cssEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cssEntry.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_cssEntry.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cssEntry.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cssEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cssEntry.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return new CSSEntryWrapper((CSSEntry)_cssEntry.clone());
	}

	public int compareTo(com.liferay.portlet.css.model.CSSEntry cssEntry) {
		return _cssEntry.compareTo(cssEntry);
	}

	public int hashCode() {
		return _cssEntry.hashCode();
	}

	public com.liferay.portlet.css.model.CSSEntry toEscapedModel() {
		return new CSSEntryWrapper(_cssEntry.toEscapedModel());
	}

	public java.lang.String toString() {
		return _cssEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _cssEntry.toXmlString();
	}

	public CSSEntry getWrappedCSSEntry() {
		return _cssEntry;
	}

	private CSSEntry _cssEntry;
}