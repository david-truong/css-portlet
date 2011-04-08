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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.service.base.CSSEntryServiceBaseImpl;

/**
 * The implementation of the c s s entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.css.service.CSSEntryService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.liferay.portlet.css.service.CSSEntryServiceUtil} to access the c s s entry remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.css.service.base.CSSEntryServiceBaseImpl
 * @see com.liferay.portlet.css.service.CSSEntryServiceUtil
 */
public class CSSEntryServiceImpl extends CSSEntryServiceBaseImpl {

	public CSSEntry getCSSEntry(long classNameId, long classPK, double version)
		throws SystemException, PortalException {

		return cssEntryLocalService.getCSSEntry(classNameId, classPK, version);

	}
}