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

package com.liferay.portlet.css.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.CSSEntryLocalService;
import com.liferay.portlet.css.service.CSSEntryService;
import com.liferay.portlet.css.service.persistence.CSSEntryFinder;
import com.liferay.portlet.css.service.persistence.CSSEntryPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the c s s entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.css.service.impl.CSSEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.css.service.impl.CSSEntryLocalServiceImpl
 * @see com.liferay.portlet.css.service.CSSEntryLocalServiceUtil
 * @generated
 */
public abstract class CSSEntryLocalServiceBaseImpl
	implements CSSEntryLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.css.service.CSSEntryLocalServiceUtil} to access the c s s entry local service.
	 */

	/**
	 * Adds the c s s entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntry the c s s entry to add
	 * @return the c s s entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry addCSSEntry(CSSEntry cssEntry) throws SystemException {
		cssEntry.setNew(true);

		return cssEntryPersistence.update(cssEntry, false);
	}

	/**
	 * Creates a new c s s entry with the primary key. Does not add the c s s entry to the database.
	 *
	 * @param cssEntryId the primary key for the new c s s entry
	 * @return the new c s s entry
	 */
	public CSSEntry createCSSEntry(long cssEntryId) {
		return cssEntryPersistence.create(cssEntryId);
	}

	/**
	 * Deletes the c s s entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntryId the primary key of the c s s entry to delete
	 * @throws PortalException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteCSSEntry(long cssEntryId)
		throws PortalException, SystemException {
		cssEntryPersistence.remove(cssEntryId);
	}

	/**
	 * Deletes the c s s entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntry the c s s entry to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteCSSEntry(CSSEntry cssEntry) throws SystemException {
		cssEntryPersistence.remove(cssEntry);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return cssEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return cssEntryPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return cssEntryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return cssEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the c s s entry with the primary key.
	 *
	 * @param cssEntryId the primary key of the c s s entry to get
	 * @return the c s s entry
	 * @throws PortalException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry getCSSEntry(long cssEntryId)
		throws PortalException, SystemException {
		return cssEntryPersistence.findByPrimaryKey(cssEntryId);
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
	public CSSEntry getCSSEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return cssEntryPersistence.findByUUID_G(uuid, groupId);
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
	public List<CSSEntry> getCSSEntries(int start, int end)
		throws SystemException {
		return cssEntryPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of c s s entries.
	 *
	 * @return the number of c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getCSSEntriesCount() throws SystemException {
		return cssEntryPersistence.countAll();
	}

	/**
	 * Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntry the c s s entry to update
	 * @return the c s s entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry updateCSSEntry(CSSEntry cssEntry) throws SystemException {
		cssEntry.setNew(false);

		return cssEntryPersistence.update(cssEntry, true);
	}

	/**
	 * Updates the c s s entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntry the c s s entry to update
	 * @param merge whether to merge the c s s entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the c s s entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry updateCSSEntry(CSSEntry cssEntry, boolean merge)
		throws SystemException {
		cssEntry.setNew(false);

		return cssEntryPersistence.update(cssEntry, merge);
	}

	/**
	 * Gets the c s s entry local service.
	 *
	 * @return the c s s entry local service
	 */
	public CSSEntryLocalService getCSSEntryLocalService() {
		return cssEntryLocalService;
	}

	/**
	 * Sets the c s s entry local service.
	 *
	 * @param cssEntryLocalService the c s s entry local service
	 */
	public void setCSSEntryLocalService(
		CSSEntryLocalService cssEntryLocalService) {
		this.cssEntryLocalService = cssEntryLocalService;
	}

	/**
	 * Gets the c s s entry remote service.
	 *
	 * @return the c s s entry remote service
	 */
	public CSSEntryService getCSSEntryService() {
		return cssEntryService;
	}

	/**
	 * Sets the c s s entry remote service.
	 *
	 * @param cssEntryService the c s s entry remote service
	 */
	public void setCSSEntryService(CSSEntryService cssEntryService) {
		this.cssEntryService = cssEntryService;
	}

	/**
	 * Gets the c s s entry persistence.
	 *
	 * @return the c s s entry persistence
	 */
	public CSSEntryPersistence getCSSEntryPersistence() {
		return cssEntryPersistence;
	}

	/**
	 * Sets the c s s entry persistence.
	 *
	 * @param cssEntryPersistence the c s s entry persistence
	 */
	public void setCSSEntryPersistence(CSSEntryPersistence cssEntryPersistence) {
		this.cssEntryPersistence = cssEntryPersistence;
	}

	/**
	 * Gets the c s s entry finder.
	 *
	 * @return the c s s entry finder
	 */
	public CSSEntryFinder getCSSEntryFinder() {
		return cssEntryFinder;
	}

	/**
	 * Sets the c s s entry finder.
	 *
	 * @param cssEntryFinder the c s s entry finder
	 */
	public void setCSSEntryFinder(CSSEntryFinder cssEntryFinder) {
		this.cssEntryFinder = cssEntryFinder;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cssEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CSSEntryLocalService.class)
	protected CSSEntryLocalService cssEntryLocalService;
	@BeanReference(type = CSSEntryService.class)
	protected CSSEntryService cssEntryService;
	@BeanReference(type = CSSEntryPersistence.class)
	protected CSSEntryPersistence cssEntryPersistence;
	@BeanReference(type = CSSEntryFinder.class)
	protected CSSEntryFinder cssEntryFinder;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}