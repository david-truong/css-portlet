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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * This class is used by
 * {@link com.liferay.portlet.css.service.http.CSSEntryServiceSoap}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portlet.css.service.http.CSSEntryServiceSoap
 * @generated
 */
public class CSSEntrySoap implements Serializable {
	public static CSSEntrySoap toSoapModel(CSSEntry model) {
		CSSEntrySoap soapModel = new CSSEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCssEntryId(model.getCssEntryId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCss(model.getCss());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setVersion(model.getVersion());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static CSSEntrySoap[] toSoapModels(CSSEntry[] models) {
		CSSEntrySoap[] soapModels = new CSSEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CSSEntrySoap[][] toSoapModels(CSSEntry[][] models) {
		CSSEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CSSEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CSSEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CSSEntrySoap[] toSoapModels(List<CSSEntry> models) {
		List<CSSEntrySoap> soapModels = new ArrayList<CSSEntrySoap>(models.size());

		for (CSSEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CSSEntrySoap[soapModels.size()]);
	}

	public CSSEntrySoap() {
	}

	public long getPrimaryKey() {
		return _cssEntryId;
	}

	public void setPrimaryKey(long pk) {
		setCssEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCssEntryId() {
		return _cssEntryId;
	}

	public void setCssEntryId(long cssEntryId) {
		_cssEntryId = cssEntryId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCss() {
		return _css;
	}

	public void setCss(String css) {
		_css = css;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		_version = version;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private String _uuid;
	private long _cssEntryId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _css;
	private long _classNameId;
	private long _classPK;
	private long _groupId;
	private double _version;
	private int _status;
	private Date _statusDate;
}