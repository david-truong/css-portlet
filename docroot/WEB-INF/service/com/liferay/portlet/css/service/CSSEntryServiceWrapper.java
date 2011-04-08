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
 * This class is a wrapper for {@link CSSEntryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CSSEntryService
 * @generated
 */
public class CSSEntryServiceWrapper implements CSSEntryService {
	public CSSEntryServiceWrapper(CSSEntryService cssEntryService) {
		_cssEntryService = cssEntryService;
	}

	public com.liferay.portlet.css.model.CSSEntry getCSSEntry(
		long classNameId, long classPK, double version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cssEntryService.getCSSEntry(classNameId, classPK, version);
	}

	public CSSEntryService getWrappedCSSEntryService() {
		return _cssEntryService;
	}

	public void setWrappedCSSEntryService(CSSEntryService cssEntryService) {
		_cssEntryService = cssEntryService;
	}

	private CSSEntryService _cssEntryService;
}