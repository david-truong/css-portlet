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

package com.liferay.portlet.css.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class CSSEntryFinderUtil {
	public static void removeByPrimaryKeys(long[] cssEntryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().removeByPrimaryKeys(cssEntryIds);
	}

	public static CSSEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (CSSEntryFinder)PortletBeanLocatorUtil.locate(com.liferay.portlet.css.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					CSSEntryFinder.class.getName());

			ReferenceRegistry.registerReference(CSSEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CSSEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CSSEntryFinderUtil.class, "_finder");
	}

	private static CSSEntryFinder _finder;
}