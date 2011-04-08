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

package com.liferay.portlet.css.service;

/**
 * <p>
 * This class is a wrapper for {@link CSSEntryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CSSEntryLocalService
 * @generated
 */
public class CSSEntryLocalServiceWrapper implements CSSEntryLocalService {
	public CSSEntryLocalServiceWrapper(
		CSSEntryLocalService cssEntryLocalService) {
		_cssEntryLocalService = cssEntryLocalService;
	}

	/**
	* Adds the c s s entry to the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to add
	* @return the c s s entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.css.model.CSSEntry addCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.addCSSEntry(cssEntry);
	}

	/**
	* Creates a new c s s entry with the primary key. Does not add the c s s entry to the database.
	*
	* @param cssEntryId the primary key for the new c s s entry
	* @return the new c s s entry
	*/
	public com.liferay.portlet.css.model.CSSEntry createCSSEntry(
		long cssEntryId) {
		return _cssEntryLocalService.createCSSEntry(cssEntryId);
	}

	/**
	* Deletes the c s s entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntryId the primary key of the c s s entry to delete
	* @throws PortalException if a c s s entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCSSEntry(long cssEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cssEntryLocalService.deleteCSSEntry(cssEntryId);
	}

	/**
	* Deletes the c s s entry from the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCSSEntry(com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_cssEntryLocalService.deleteCSSEntry(cssEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the c s s entry with the primary key.
	*
	* @param cssEntryId the primary key of the c s s entry to get
	* @return the c s s entry
	* @throws PortalException if a c s s entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.css.model.CSSEntry getCSSEntry(long cssEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntry(cssEntryId);
	}

	/**
	* Gets the c s s entry with the UUID and group id.
	*
	* @param uuid the UUID of c s s entry to get
	* @param groupId the group id of the c s s entry to get
	* @return the c s s entry
	* @throws PortalException if a c s s entry with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.css.model.CSSEntry getCSSEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Gets a range of all the c s s entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of c s s entries to return
	* @param end the upper bound of the range of c s s entries to return (not inclusive)
	* @return the range of c s s entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.css.model.CSSEntry> getCSSEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntries(start, end);
	}

	/**
	* Gets the number of c s s entries.
	*
	* @return the number of c s s entries
	* @throws SystemException if a system exception occurred
	*/
	public int getCSSEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntriesCount();
	}

	/**
	* Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to update
	* @return the c s s entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.css.model.CSSEntry updateCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.updateCSSEntry(cssEntry);
	}

	/**
	* Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to update
	* @param merge whether to merge the c s s entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c s s entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.css.model.CSSEntry updateCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.updateCSSEntry(cssEntry, merge);
	}

	public com.liferay.portlet.css.model.CSSEntry addEntry(long classNameId,
		long classPK, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.addEntry(classNameId, classPK, css,
			serviceContext);
	}

	public com.liferay.portlet.css.model.CSSEntry addEntry(long classNameId,
		long classPK, double version, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.addEntry(classNameId, classPK, version,
			css, serviceContext);
	}

	public void deleteCSSEntryByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cssEntryLocalService.deleteCSSEntryByGroupId(groupId);
	}

	public void deleteCSSEntry(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cssEntryLocalService.deleteCSSEntry(classNameId, classPK);
	}

	public void deleteCSSEntry(long classNameId, long classPK, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cssEntryLocalService.deleteCSSEntry(classNameId, classPK, version);
	}

	public java.util.List<com.liferay.portlet.css.model.CSSEntry> getCSSEntry(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntry(classNameId, classPK);
	}

	public com.liferay.portlet.css.model.CSSEntry getCSSEntry(
		long classNameId, long classPK, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getCSSEntry(classNameId, classPK, version);
	}

	public com.liferay.portlet.css.model.CSSEntry getLatestCSSEntry(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.getLatestCSSEntry(classNameId, classPK);
	}

	public com.liferay.portlet.css.model.CSSEntry updateEntry(
		long classNameId, long classPK, double version, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.updateEntry(classNameId, classPK, version,
			css, serviceContext);
	}

	public com.liferay.portlet.css.model.CSSEntry updateEntry(
		long classNameId, long classPK, double version, java.lang.String css,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryLocalService.updateEntry(classNameId, classPK, version,
			css, status, serviceContext);
	}

	public CSSEntryLocalService getWrappedCSSEntryLocalService() {
		return _cssEntryLocalService;
	}

	public void setWrappedCSSEntryLocalService(
		CSSEntryLocalService cssEntryLocalService) {
		_cssEntryLocalService = cssEntryLocalService;
	}

	private CSSEntryLocalService _cssEntryLocalService;
}