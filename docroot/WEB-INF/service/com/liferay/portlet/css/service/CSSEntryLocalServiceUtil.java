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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the c s s entry local service. This utility wraps {@link com.liferay.portlet.css.service.impl.CSSEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CSSEntryLocalService
 * @see com.liferay.portlet.css.service.base.CSSEntryLocalServiceBaseImpl
 * @see com.liferay.portlet.css.service.impl.CSSEntryLocalServiceImpl
 * @generated
 */
public class CSSEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.css.service.impl.CSSEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the c s s entry to the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to add
	* @return the c s s entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.css.model.CSSEntry addCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCSSEntry(cssEntry);
	}

	/**
	* Creates a new c s s entry with the primary key. Does not add the c s s entry to the database.
	*
	* @param cssEntryId the primary key for the new c s s entry
	* @return the new c s s entry
	*/
	public static com.liferay.portlet.css.model.CSSEntry createCSSEntry(
		long cssEntryId) {
		return getService().createCSSEntry(cssEntryId);
	}

	/**
	* Deletes the c s s entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntryId the primary key of the c s s entry to delete
	* @throws PortalException if a c s s entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCSSEntry(long cssEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSSEntry(cssEntryId);
	}

	/**
	* Deletes the c s s entry from the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSSEntry(cssEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the c s s entry with the primary key.
	*
	* @param cssEntryId the primary key of the c s s entry to get
	* @return the c s s entry
	* @throws PortalException if a c s s entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.css.model.CSSEntry getCSSEntry(
		long cssEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntry(cssEntryId);
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
	public static com.liferay.portlet.css.model.CSSEntry getCSSEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntryByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.liferay.portlet.css.model.CSSEntry> getCSSEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntries(start, end);
	}

	/**
	* Gets the number of c s s entries.
	*
	* @return the number of c s s entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getCSSEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntriesCount();
	}

	/**
	* Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to update
	* @return the c s s entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.css.model.CSSEntry updateCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCSSEntry(cssEntry);
	}

	/**
	* Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	*
	* @param cssEntry the c s s entry to update
	* @param merge whether to merge the c s s entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the c s s entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.css.model.CSSEntry updateCSSEntry(
		com.liferay.portlet.css.model.CSSEntry cssEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCSSEntry(cssEntry, merge);
	}

	public static com.liferay.portlet.css.model.CSSEntry addEntry(
		long classNameId, long classPK, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEntry(classNameId, classPK, css, serviceContext);
	}

	public static com.liferay.portlet.css.model.CSSEntry addEntry(
		long classNameId, long classPK, double version, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEntry(classNameId, classPK, version, css, serviceContext);
	}

	public static void deleteCSSEntryByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSSEntryByGroupId(groupId);
	}

	public static void deleteCSSEntry(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSSEntry(classNameId, classPK);
	}

	public static void deleteCSSEntry(long classNameId, long classPK,
		double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCSSEntry(classNameId, classPK, version);
	}

	public static java.util.List<com.liferay.portlet.css.model.CSSEntry> getCSSEntry(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntry(classNameId, classPK);
	}

	public static com.liferay.portlet.css.model.CSSEntry getCSSEntry(
		long classNameId, long classPK, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCSSEntry(classNameId, classPK, version);
	}

	public static com.liferay.portlet.css.model.CSSEntry getLatestCSSEntry(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLatestCSSEntry(classNameId, classPK);
	}

	public static com.liferay.portlet.css.model.CSSEntry updateEntry(
		long classNameId, long classPK, double version, java.lang.String css,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEntry(classNameId, classPK, version, css,
			serviceContext);
	}

	public static com.liferay.portlet.css.model.CSSEntry updateEntry(
		long classNameId, long classPK, double version, java.lang.String css,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEntry(classNameId, classPK, version, css, status,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static CSSEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					CSSEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CSSEntryLocalService.class.getName(), portletClassLoader);

			_service = new CSSEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CSSEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CSSEntryLocalService.class);
		}

		return _service;
	}

	public void setService(CSSEntryLocalService service) {
		MethodCache.remove(CSSEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CSSEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CSSEntryLocalService.class);
	}

	private static CSSEntryLocalService _service;
}