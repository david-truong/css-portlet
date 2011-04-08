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

package com.liferay.portlet.css.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.model.impl.CSSEntryImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * The persistence implementation for the c s s entry service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link CSSEntryUtil} to access the c s s entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CSSEntryPersistence
 * @see CSSEntryUtil
 * @generated
 */
public class CSSEntryFinderImpl
	extends BasePersistenceImpl<CSSEntry>
	implements CSSEntryFinder {

	public static String REMOVE_BY_PRIMARY_KEYS =
		CSSEntryFinder.class.getName() + ".removeByPrimaryKeys";

	public void removeByPrimaryKeys(long[] cssEntryIds) throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(REMOVE_BY_PRIMARY_KEYS);

			SQLQuery q = session.createSQLQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(cssEntryIds);

			q.addEntity("CE.*", CSSEntryImpl.class);

			q.executeUpdate();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}