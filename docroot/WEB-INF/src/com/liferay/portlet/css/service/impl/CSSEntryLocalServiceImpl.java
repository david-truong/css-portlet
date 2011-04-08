/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.css.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.base.CSSEntryLocalServiceBaseImpl;
import com.liferay.portlet.css.util.CSSUtil;
import com.liferay.portlet.css.util.VersionComparator;

/**
 * The implementation of the c s s entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.css.service.CSSEntryLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.portlet.css.service.CSSEntryLocalServiceUtil} to access the c s s entry local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.css.service.base.CSSEntryLocalServiceBaseImpl
 * @see com.liferay.portlet.css.service.CSSEntryLocalServiceUtil
 */
public class CSSEntryLocalServiceImpl extends CSSEntryLocalServiceBaseImpl {

	public CSSEntry addEntry(long classNameId, long classPK, 
			String css, ServiceContext serviceContext)
		throws SystemException  {

		return addEntry(classNameId, classPK, CSSUtil.NEW_VERSION, css, 
			serviceContext);
	}
	
	public CSSEntry addEntry(long classNameId, long classPK, double version,
			String css, ServiceContext serviceContext)
		throws SystemException  {

		Date now = new Date();

		CSSEntry cssEntry = cssEntryPersistence.create(
				counterLocalService.increment());

		cssEntry.setCreateDate(serviceContext.getCreateDate(now));
		cssEntry.setUuid(serviceContext.getUuid());
		cssEntry.setModifiedDate(serviceContext.getModifiedDate(now));
		cssEntry.setClassNameId(classNameId);
		cssEntry.setClassPK(classPK);
		cssEntry.setVersion(version);
		if (classNameId != PortalUtil.getClassNameId(Company.class)) {
			cssEntry.setGroupId(serviceContext.getScopeGroupId());
		}
		cssEntry.setCss(css);
		cssEntry.setStatus(WorkflowConstants.STATUS_APPROVED);
		cssEntry.setStatusDate(serviceContext.getModifiedDate(now));
		cssEntry.setExpandoBridgeAttributes(serviceContext);

		return cssEntryPersistence.update(cssEntry, false);
	}

	public void deleteCSSEntry(long cssEntryId)
		throws SystemException, PortalException {

		cssEntryPersistence.remove(cssEntryId);
	}

	public void deleteCSSEntryByGroupId(long groupId)
		throws SystemException, PortalException {

		cssEntryPersistence.removeByGroupId(groupId);
	}

	public void deleteCSSEntry(long classNameId, long classPK)
		throws SystemException, PortalException {
	
		cssEntryPersistence.removeByClassNameId_ClassPK(classNameId, classPK);
	}
	
	public void deleteCSSEntry(long classNameId, long classPK, double version)
		throws SystemException, PortalException {

		cssEntryPersistence.removeByClassNameId_ClassPK_Version(
			classNameId, classPK, version);
	}

	public List<CSSEntry> getCSSEntry(long classNameId, long classPK)
		throws SystemException {

		return cssEntryPersistence.findByClassNameId_ClassPK(
			classNameId, classPK);
	}

	public CSSEntry getCSSEntry(long classNameId, long classPK, double version)
		throws SystemException, PortalException {

		return cssEntryPersistence.findByClassNameId_ClassPK_Version(
			classNameId, classPK, version);
	}

	public CSSEntry getLatestCSSEntry(long classNameId, long classPK)
		throws SystemException, PortalException {

		return cssEntryPersistence.findByClassNameId_ClassPK_First(
			classNameId, classPK, new VersionComparator());
	}

	public CSSEntry updateEntry(long classNameId, long classPK, double version,
			String css, ServiceContext serviceContext)
		throws SystemException, PortalException {

		return updateEntry(classNameId, classPK, version, css,
			WorkflowConstants.STATUS_APPROVED, serviceContext);
	}

	public CSSEntry updateEntry(long classNameId, long classPK, double version,
			String css, int status, ServiceContext serviceContext)
		throws SystemException, PortalException {

		CSSEntry cssEntry =
			cssEntryPersistence.findByClassNameId_ClassPK_Version(
				classNameId, classPK, version);

		Date now = new Date();

		cssEntry.setModifiedDate(serviceContext.getModifiedDate(now));
		cssEntry.setCss(css);
		cssEntry.setStatus(status);
		cssEntry.setStatusDate(serviceContext.getModifiedDate(now));
		cssEntry.setExpandoBridgeAttributes(serviceContext);

		return cssEntryPersistence.update(cssEntry, false);
	}
}