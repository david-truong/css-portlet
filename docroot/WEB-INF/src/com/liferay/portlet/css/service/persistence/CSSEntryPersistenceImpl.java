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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.css.NoSuchEntryException;
import com.liferay.portlet.css.model.CSSEntry;
import com.liferay.portlet.css.model.impl.CSSEntryImpl;
import com.liferay.portlet.css.model.impl.CSSEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the c s s entry service.
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
public class CSSEntryPersistenceImpl extends BasePersistenceImpl<CSSEntry>
	implements CSSEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CSSEntryUtil} to access the c s s entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CSSEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUuid", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByGroupId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_CLASSNAMEID_CLASSPK = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByClassNameId_ClassPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByClassNameId_ClassPK",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION =
		new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByClassNameId_ClassPK_Version",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Double.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK_VERSION =
		new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByClassNameId_ClassPK_Version",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Double.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the c s s entry in the entity cache if it is enabled.
	 *
	 * @param cssEntry the c s s entry to cache
	 */
	public void cacheResult(CSSEntry cssEntry) {
		EntityCacheUtil.putResult(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryImpl.class, cssEntry.getPrimaryKey(), cssEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { cssEntry.getUuid(), new Long(cssEntry.getGroupId()) },
			cssEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
			new Object[] {
				new Long(cssEntry.getClassNameId()),
				new Long(cssEntry.getClassPK()),
				new Double(cssEntry.getVersion())
			}, cssEntry);
	}

	/**
	 * Caches the c s s entries in the entity cache if it is enabled.
	 *
	 * @param cssEntries the c s s entries to cache
	 */
	public void cacheResult(List<CSSEntry> cssEntries) {
		for (CSSEntry cssEntry : cssEntries) {
			if (EntityCacheUtil.getResult(
						CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
						CSSEntryImpl.class, cssEntry.getPrimaryKey(), this) == null) {
				cacheResult(cssEntry);
			}
		}
	}

	/**
	 * Clears the cache for all c s s entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(CSSEntryImpl.class.getName());
		EntityCacheUtil.clearCache(CSSEntryImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the c s s entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(CSSEntry cssEntry) {
		EntityCacheUtil.removeResult(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryImpl.class, cssEntry.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { cssEntry.getUuid(), new Long(cssEntry.getGroupId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
			new Object[] {
				new Long(cssEntry.getClassNameId()),
				new Long(cssEntry.getClassPK()),
				new Double(cssEntry.getVersion())
			});
	}

	/**
	 * Creates a new c s s entry with the primary key. Does not add the c s s entry to the database.
	 *
	 * @param cssEntryId the primary key for the new c s s entry
	 * @return the new c s s entry
	 */
	public CSSEntry create(long cssEntryId) {
		CSSEntry cssEntry = new CSSEntryImpl();

		cssEntry.setNew(true);
		cssEntry.setPrimaryKey(cssEntryId);

		String uuid = PortalUUIDUtil.generate();

		cssEntry.setUuid(uuid);

		return cssEntry;
	}

	/**
	 * Removes the c s s entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the c s s entry to remove
	 * @return the c s s entry that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the c s s entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cssEntryId the primary key of the c s s entry to remove
	 * @return the c s s entry that was removed
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry remove(long cssEntryId)
		throws NoSuchEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CSSEntry cssEntry = (CSSEntry)session.get(CSSEntryImpl.class,
					new Long(cssEntryId));

			if (cssEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cssEntryId);
				}

				throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					cssEntryId);
			}

			return remove(cssEntry);
		}
		catch (NoSuchEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSSEntry removeImpl(CSSEntry cssEntry) throws SystemException {
		cssEntry = toUnwrappedModel(cssEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cssEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		CSSEntryModelImpl cssEntryModelImpl = (CSSEntryModelImpl)cssEntry;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				cssEntryModelImpl.getOriginalUuid(),
				new Long(cssEntryModelImpl.getOriginalGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
			new Object[] {
				new Long(cssEntryModelImpl.getOriginalClassNameId()),
				new Long(cssEntryModelImpl.getOriginalClassPK()),
				new Double(cssEntryModelImpl.getOriginalVersion())
			});

		EntityCacheUtil.removeResult(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryImpl.class, cssEntry.getPrimaryKey());

		return cssEntry;
	}

	public CSSEntry updateImpl(
		com.liferay.portlet.css.model.CSSEntry cssEntry, boolean merge)
		throws SystemException {
		cssEntry = toUnwrappedModel(cssEntry);

		boolean isNew = cssEntry.isNew();

		CSSEntryModelImpl cssEntryModelImpl = (CSSEntryModelImpl)cssEntry;

		if (Validator.isNull(cssEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			cssEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cssEntry, merge);

			cssEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
			CSSEntryImpl.class, cssEntry.getPrimaryKey(), cssEntry);

		if (!isNew &&
				(!Validator.equals(cssEntry.getUuid(),
					cssEntryModelImpl.getOriginalUuid()) ||
				(cssEntry.getGroupId() != cssEntryModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					cssEntryModelImpl.getOriginalUuid(),
					new Long(cssEntryModelImpl.getOriginalGroupId())
				});
		}

		if (isNew ||
				(!Validator.equals(cssEntry.getUuid(),
					cssEntryModelImpl.getOriginalUuid()) ||
				(cssEntry.getGroupId() != cssEntryModelImpl.getOriginalGroupId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { cssEntry.getUuid(), new Long(
						cssEntry.getGroupId()) }, cssEntry);
		}

		if (!isNew &&
				((cssEntry.getClassNameId() != cssEntryModelImpl.getOriginalClassNameId()) ||
				(cssEntry.getClassPK() != cssEntryModelImpl.getOriginalClassPK()) ||
				(cssEntry.getVersion() != cssEntryModelImpl.getOriginalVersion()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
				new Object[] {
					new Long(cssEntryModelImpl.getOriginalClassNameId()),
					new Long(cssEntryModelImpl.getOriginalClassPK()),
					new Double(cssEntryModelImpl.getOriginalVersion())
				});
		}

		if (isNew ||
				((cssEntry.getClassNameId() != cssEntryModelImpl.getOriginalClassNameId()) ||
				(cssEntry.getClassPK() != cssEntryModelImpl.getOriginalClassPK()) ||
				(cssEntry.getVersion() != cssEntryModelImpl.getOriginalVersion()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
				new Object[] {
					new Long(cssEntry.getClassNameId()),
					new Long(cssEntry.getClassPK()),
					new Double(cssEntry.getVersion())
				}, cssEntry);
		}

		return cssEntry;
	}

	protected CSSEntry toUnwrappedModel(CSSEntry cssEntry) {
		if (cssEntry instanceof CSSEntryImpl) {
			return cssEntry;
		}

		CSSEntryImpl cssEntryImpl = new CSSEntryImpl();

		cssEntryImpl.setNew(cssEntry.isNew());
		cssEntryImpl.setPrimaryKey(cssEntry.getPrimaryKey());

		cssEntryImpl.setUuid(cssEntry.getUuid());
		cssEntryImpl.setCssEntryId(cssEntry.getCssEntryId());
		cssEntryImpl.setCreateDate(cssEntry.getCreateDate());
		cssEntryImpl.setModifiedDate(cssEntry.getModifiedDate());
		cssEntryImpl.setCss(cssEntry.getCss());
		cssEntryImpl.setClassNameId(cssEntry.getClassNameId());
		cssEntryImpl.setClassPK(cssEntry.getClassPK());
		cssEntryImpl.setGroupId(cssEntry.getGroupId());
		cssEntryImpl.setVersion(cssEntry.getVersion());
		cssEntryImpl.setStatus(cssEntry.getStatus());
		cssEntryImpl.setStatusDate(cssEntry.getStatusDate());

		return cssEntryImpl;
	}

	/**
	 * Finds the c s s entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the c s s entry to find
	 * @return the c s s entry
	 * @throws com.liferay.portal.NoSuchModelException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the c s s entry with the primary key or throws a {@link com.liferay.portlet.css.NoSuchEntryException} if it could not be found.
	 *
	 * @param cssEntryId the primary key of the c s s entry to find
	 * @return the c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByPrimaryKey(long cssEntryId)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = fetchByPrimaryKey(cssEntryId);

		if (cssEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + cssEntryId);
			}

			throw new NoSuchEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				cssEntryId);
		}

		return cssEntry;
	}

	/**
	 * Finds the c s s entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the c s s entry to find
	 * @return the c s s entry, or <code>null</code> if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the c s s entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cssEntryId the primary key of the c s s entry to find
	 * @return the c s s entry, or <code>null</code> if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByPrimaryKey(long cssEntryId)
		throws SystemException {
		CSSEntry cssEntry = (CSSEntry)EntityCacheUtil.getResult(CSSEntryModelImpl.ENTITY_CACHE_ENABLED,
				CSSEntryImpl.class, cssEntryId, this);

		if (cssEntry == null) {
			Session session = null;

			try {
				session = openSession();

				cssEntry = (CSSEntry)session.get(CSSEntryImpl.class,
						new Long(cssEntryId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (cssEntry != null) {
					cacheResult(cssEntry);
				}

				closeSession(session);
			}
		}

		return cssEntry;
	}

	/**
	 * Finds all the c s s entries where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the c s s entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @return the range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Finds an ordered range of all the c s s entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CSSEntry> list = (List<CSSEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CSSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<CSSEntry>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first c s s entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<CSSEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last c s s entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByUuid(uuid);

		List<CSSEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the c s s entries before and after the current c s s entry in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cssEntryId the primary key of the current c s s entry
	 * @param uuid the uuid to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry[] findByUuid_PrevAndNext(long cssEntryId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = findByPrimaryKey(cssEntryId);

		Session session = null;

		try {
			session = openSession();

			CSSEntry[] array = new CSSEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, cssEntry, uuid,
					orderByComparator, true);

			array[1] = cssEntry;

			array[2] = getByUuid_PrevAndNext(session, cssEntry, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSSEntry getByUuid_PrevAndNext(Session session,
		CSSEntry cssEntry, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSSENTRY_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(cssEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CSSEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the c s s entry where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.portlet.css.NoSuchEntryException} if it could not be found.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = fetchByUUID_G(uuid, groupId);

		if (cssEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return cssEntry;
	}

	/**
	 * Finds the c s s entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching c s s entry, or <code>null</code> if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Finds the c s s entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the matching c s s entry, or <code>null</code> if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CSSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(CSSEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<CSSEntry> list = q.list();

				result = list;

				CSSEntry cssEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					cssEntry = list.get(0);

					cacheResult(cssEntry);

					if ((cssEntry.getUuid() == null) ||
							!cssEntry.getUuid().equals(uuid) ||
							(cssEntry.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, cssEntry);
					}
				}

				return cssEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (CSSEntry)result;
			}
		}
	}

	/**
	 * Finds all the c s s entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the c s s entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @return the range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the c s s entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CSSEntry> list = (List<CSSEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<CSSEntry>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first c s s entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<CSSEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last c s s entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByGroupId(groupId);

		List<CSSEntry> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the c s s entries before and after the current c s s entry in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cssEntryId the primary key of the current c s s entry
	 * @param groupId the group id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry[] findByGroupId_PrevAndNext(long cssEntryId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = findByPrimaryKey(cssEntryId);

		Session session = null;

		try {
			session = openSession();

			CSSEntry[] array = new CSSEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, cssEntry, groupId,
					orderByComparator, true);

			array[1] = cssEntry;

			array[2] = getByGroupId_PrevAndNext(session, cssEntry, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSSEntry getByGroupId_PrevAndNext(Session session,
		CSSEntry cssEntry, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSSENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(cssEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CSSEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the c s s entries where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByClassNameId_ClassPK(long classNameId,
		long classPK) throws SystemException {
		return findByClassNameId_ClassPK(classNameId, classPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the c s s entries where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @return the range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByClassNameId_ClassPK(long classNameId,
		long classPK, int start, int end) throws SystemException {
		return findByClassNameId_ClassPK(classNameId, classPK, start, end, null);
	}

	/**
	 * Finds an ordered range of all the c s s entries where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findByClassNameId_ClassPK(long classNameId,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				classNameId, classPK,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CSSEntry> list = (List<CSSEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CLASSNAMEID_CLASSPK,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				list = (List<CSSEntry>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_CLASSNAMEID_CLASSPK,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CLASSNAMEID_CLASSPK,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first c s s entry in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByClassNameId_ClassPK_First(long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		List<CSSEntry> list = findByClassNameId_ClassPK(classNameId, classPK,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last c s s entry in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByClassNameId_ClassPK_Last(long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		int count = countByClassNameId_ClassPK(classNameId, classPK);

		List<CSSEntry> list = findByClassNameId_ClassPK(classNameId, classPK,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the c s s entries before and after the current c s s entry in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param cssEntryId the primary key of the current c s s entry
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a c s s entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry[] findByClassNameId_ClassPK_PrevAndNext(long cssEntryId,
		long classNameId, long classPK, OrderByComparator orderByComparator)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = findByPrimaryKey(cssEntryId);

		Session session = null;

		try {
			session = openSession();

			CSSEntry[] array = new CSSEntryImpl[3];

			array[0] = getByClassNameId_ClassPK_PrevAndNext(session, cssEntry,
					classNameId, classPK, orderByComparator, true);

			array[1] = cssEntry;

			array[2] = getByClassNameId_ClassPK_PrevAndNext(session, cssEntry,
					classNameId, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CSSEntry getByClassNameId_ClassPK_PrevAndNext(Session session,
		CSSEntry cssEntry, long classNameId, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSSENTRY_WHERE);

		query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSPK_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(CSSEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(cssEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CSSEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the c s s entry where classNameId = &#63; and classPK = &#63; and version = &#63; or throws a {@link com.liferay.portlet.css.NoSuchEntryException} if it could not be found.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param version the version to search with
	 * @return the matching c s s entry
	 * @throws com.liferay.portlet.css.NoSuchEntryException if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry findByClassNameId_ClassPK_Version(long classNameId,
		long classPK, double version)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = fetchByClassNameId_ClassPK_Version(classNameId,
				classPK, version);

		if (cssEntry == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntryException(msg.toString());
		}

		return cssEntry;
	}

	/**
	 * Finds the c s s entry where classNameId = &#63; and classPK = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param version the version to search with
	 * @return the matching c s s entry, or <code>null</code> if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByClassNameId_ClassPK_Version(long classNameId,
		long classPK, double version) throws SystemException {
		return fetchByClassNameId_ClassPK_Version(classNameId, classPK,
			version, true);
	}

	/**
	 * Finds the c s s entry where classNameId = &#63; and classPK = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param version the version to search with
	 * @return the matching c s s entry, or <code>null</code> if a matching c s s entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CSSEntry fetchByClassNameId_ClassPK_Version(long classNameId,
		long classPK, double version, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK, version };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_VERSION_2);

			query.append(CSSEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(version);

				List<CSSEntry> list = q.list();

				result = list;

				CSSEntry cssEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
						finderArgs, list);
				}
				else {
					cssEntry = list.get(0);

					cacheResult(cssEntry);

					if ((cssEntry.getClassNameId() != classNameId) ||
							(cssEntry.getClassPK() != classPK) ||
							(cssEntry.getVersion() != version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
							finderArgs, cssEntry);
					}
				}

				return cssEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMEID_CLASSPK_VERSION,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (CSSEntry)result;
			}
		}
	}

	/**
	 * Finds all the c s s entries.
	 *
	 * @return the c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the c s s entries.
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
	public List<CSSEntry> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the c s s entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of c s s entries to return
	 * @param end the upper bound of the range of c s s entries to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CSSEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<CSSEntry> list = (List<CSSEntry>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CSSENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSSENTRY.concat(CSSEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CSSEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CSSEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the c s s entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (CSSEntry cssEntry : findByUuid(uuid)) {
			remove(cssEntry);
		}
	}

	/**
	 * Removes the c s s entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = findByUUID_G(uuid, groupId);

		remove(cssEntry);
	}

	/**
	 * Removes all the c s s entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (CSSEntry cssEntry : findByGroupId(groupId)) {
			remove(cssEntry);
		}
	}

	/**
	 * Removes all the c s s entries where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByClassNameId_ClassPK(long classNameId, long classPK)
		throws SystemException {
		for (CSSEntry cssEntry : findByClassNameId_ClassPK(classNameId, classPK)) {
			remove(cssEntry);
		}
	}

	/**
	 * Removes the c s s entry where classNameId = &#63; and classPK = &#63; and version = &#63; from the database.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param version the version to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByClassNameId_ClassPK_Version(long classNameId,
		long classPK, double version)
		throws NoSuchEntryException, SystemException {
		CSSEntry cssEntry = findByClassNameId_ClassPK_Version(classNameId,
				classPK, version);

		remove(cssEntry);
	}

	/**
	 * Removes all the c s s entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CSSEntry cssEntry : findAll()) {
			remove(cssEntry);
		}
	}

	/**
	 * Counts all the c s s entries where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the c s s entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @param groupId the group id to search with
	 * @return the number of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSSENTRY_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the c s s entries where groupId = &#63;.
	 *
	 * @param groupId the group id to search with
	 * @return the number of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the c s s entries where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the number of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByClassNameId_ClassPK(long classNameId, long classPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the c s s entries where classNameId = &#63; and classPK = &#63; and version = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param version the version to search with
	 * @return the number of matching c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByClassNameId_ClassPK_Version(long classNameId,
		long classPK, double version) throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK, version };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK_VERSION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CSSENTRY_WHERE);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_VERSION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				qPos.add(version);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEID_CLASSPK_VERSION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the c s s entries.
	 *
	 * @return the number of c s s entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSSENTRY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the c s s entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.portlet.css.model.CSSEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CSSEntry>> listenersList = new ArrayList<ModelListener<CSSEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CSSEntry>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CSSEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CSSEntryPersistence.class)
	protected CSSEntryPersistence cssEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CSSENTRY = "SELECT cssEntry FROM CSSEntry cssEntry";
	private static final String _SQL_SELECT_CSSENTRY_WHERE = "SELECT cssEntry FROM CSSEntry cssEntry WHERE ";
	private static final String _SQL_COUNT_CSSENTRY = "SELECT COUNT(cssEntry) FROM CSSEntry cssEntry";
	private static final String _SQL_COUNT_CSSENTRY_WHERE = "SELECT COUNT(cssEntry) FROM CSSEntry cssEntry WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "cssEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "cssEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(cssEntry.uuid IS NULL OR cssEntry.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "cssEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "cssEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(cssEntry.uuid IS NULL OR cssEntry.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "cssEntry.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "cssEntry.groupId = ?";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSNAMEID_2 =
		"cssEntry.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSPK_CLASSPK_2 = "cssEntry.classPK = ?";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSNAMEID_2 =
		"cssEntry.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_CLASSPK_2 =
		"cssEntry.classPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEID_CLASSPK_VERSION_VERSION_2 =
		"cssEntry.version = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cssEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CSSEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CSSEntry exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(CSSEntryPersistenceImpl.class);
}