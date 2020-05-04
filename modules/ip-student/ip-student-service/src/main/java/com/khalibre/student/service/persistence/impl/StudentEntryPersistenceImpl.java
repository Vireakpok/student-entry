/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.khalibre.student.service.persistence.impl;

import com.khalibre.student.exception.NoSuchStudentEntryException;
import com.khalibre.student.model.StudentEntry;
import com.khalibre.student.model.impl.StudentEntryImpl;
import com.khalibre.student.model.impl.StudentEntryModelImpl;
import com.khalibre.student.service.persistence.StudentEntryPersistence;
import com.khalibre.student.service.persistence.impl.constants.STUDENTPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the student entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StudentEntryPersistence.class)
public class StudentEntryPersistenceImpl
	extends BasePersistenceImpl<StudentEntry>
	implements StudentEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StudentEntryUtil</code> to access the student entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StudentEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student entries
	 */
	@Override
	public List<StudentEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @return the range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<StudentEntry> list = null;

		if (useFinderCache) {
			list = (List<StudentEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentEntry studentEntry : list) {
					if (!uuid.equals(studentEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(StudentEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<StudentEntry>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	@Override
	public StudentEntry findByUuid_First(
			String uuid, OrderByComparator<StudentEntry> orderByComparator)
		throws NoSuchStudentEntryException {

		StudentEntry studentEntry = fetchByUuid_First(uuid, orderByComparator);

		if (studentEntry != null) {
			return studentEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStudentEntryException(msg.toString());
	}

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	@Override
	public StudentEntry fetchByUuid_First(
		String uuid, OrderByComparator<StudentEntry> orderByComparator) {

		List<StudentEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	@Override
	public StudentEntry findByUuid_Last(
			String uuid, OrderByComparator<StudentEntry> orderByComparator)
		throws NoSuchStudentEntryException {

		StudentEntry studentEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (studentEntry != null) {
			return studentEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStudentEntryException(msg.toString());
	}

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	@Override
	public StudentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<StudentEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StudentEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the student entries before and after the current student entry in the ordered set where uuid = &#63;.
	 *
	 * @param studentEntryId the primary key of the current student entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry[] findByUuid_PrevAndNext(
			long studentEntryId, String uuid,
			OrderByComparator<StudentEntry> orderByComparator)
		throws NoSuchStudentEntryException {

		uuid = Objects.toString(uuid, "");

		StudentEntry studentEntry = findByPrimaryKey(studentEntryId);

		Session session = null;

		try {
			session = openSession();

			StudentEntry[] array = new StudentEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, studentEntry, uuid, orderByComparator, true);

			array[1] = studentEntry;

			array[2] = getByUuid_PrevAndNext(
				session, studentEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudentEntry getByUuid_PrevAndNext(
		Session session, StudentEntry studentEntry, String uuid,
		OrderByComparator<StudentEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENTENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
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

			String[] orderByFields = orderByComparator.getOrderByFields();

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
			query.append(StudentEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(studentEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<StudentEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the student entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StudentEntry studentEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(studentEntry);
		}
	}

	/**
	 * Returns the number of student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"studentEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(studentEntry.uuid IS NULL OR studentEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByStudentEntryId;
	private FinderPath _finderPathWithoutPaginationFindByStudentEntryId;
	private FinderPath _finderPathCountByStudentEntryId;

	/**
	 * Returns all the student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the matching student entries
	 */
	@Override
	public List<StudentEntry> findByStudentEntryId(long studentEntryId) {
		return findByStudentEntryId(
			studentEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student entries where studentEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param studentEntryId the student entry ID
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @return the range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end) {

		return findByStudentEntryId(studentEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the student entries where studentEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param studentEntryId the student entry ID
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator) {

		return findByStudentEntryId(
			studentEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student entries where studentEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param studentEntryId the student entry ID
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching student entries
	 */
	@Override
	public List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStudentEntryId;
				finderArgs = new Object[] {studentEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStudentEntryId;
			finderArgs = new Object[] {
				studentEntryId, start, end, orderByComparator
			};
		}

		List<StudentEntry> list = null;

		if (useFinderCache) {
			list = (List<StudentEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StudentEntry studentEntry : list) {
					if (studentEntryId != studentEntry.getStudentEntryId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_STUDENTENTRYID_STUDENTENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(StudentEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentEntryId);

				list = (List<StudentEntry>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	@Override
	public StudentEntry findByStudentEntryId_First(
			long studentEntryId,
			OrderByComparator<StudentEntry> orderByComparator)
		throws NoSuchStudentEntryException {

		StudentEntry studentEntry = fetchByStudentEntryId_First(
			studentEntryId, orderByComparator);

		if (studentEntry != null) {
			return studentEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentEntryId=");
		msg.append(studentEntryId);

		msg.append("}");

		throw new NoSuchStudentEntryException(msg.toString());
	}

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	@Override
	public StudentEntry fetchByStudentEntryId_First(
		long studentEntryId,
		OrderByComparator<StudentEntry> orderByComparator) {

		List<StudentEntry> list = findByStudentEntryId(
			studentEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	@Override
	public StudentEntry findByStudentEntryId_Last(
			long studentEntryId,
			OrderByComparator<StudentEntry> orderByComparator)
		throws NoSuchStudentEntryException {

		StudentEntry studentEntry = fetchByStudentEntryId_Last(
			studentEntryId, orderByComparator);

		if (studentEntry != null) {
			return studentEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentEntryId=");
		msg.append(studentEntryId);

		msg.append("}");

		throw new NoSuchStudentEntryException(msg.toString());
	}

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	@Override
	public StudentEntry fetchByStudentEntryId_Last(
		long studentEntryId,
		OrderByComparator<StudentEntry> orderByComparator) {

		int count = countByStudentEntryId(studentEntryId);

		if (count == 0) {
			return null;
		}

		List<StudentEntry> list = findByStudentEntryId(
			studentEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the student entries where studentEntryId = &#63; from the database.
	 *
	 * @param studentEntryId the student entry ID
	 */
	@Override
	public void removeByStudentEntryId(long studentEntryId) {
		for (StudentEntry studentEntry :
				findByStudentEntryId(
					studentEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(studentEntry);
		}
	}

	/**
	 * Returns the number of student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the number of matching student entries
	 */
	@Override
	public int countByStudentEntryId(long studentEntryId) {
		FinderPath finderPath = _finderPathCountByStudentEntryId;

		Object[] finderArgs = new Object[] {studentEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_STUDENTENTRYID_STUDENTENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentEntryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STUDENTENTRYID_STUDENTENTRYID_2 =
		"studentEntry.studentEntryId = ?";

	public StudentEntryPersistenceImpl() {
		setModelClass(StudentEntry.class);

		setModelImplClass(StudentEntryImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the student entry in the entity cache if it is enabled.
	 *
	 * @param studentEntry the student entry
	 */
	@Override
	public void cacheResult(StudentEntry studentEntry) {
		entityCache.putResult(
			entityCacheEnabled, StudentEntryImpl.class,
			studentEntry.getPrimaryKey(), studentEntry);

		studentEntry.resetOriginalValues();
	}

	/**
	 * Caches the student entries in the entity cache if it is enabled.
	 *
	 * @param studentEntries the student entries
	 */
	@Override
	public void cacheResult(List<StudentEntry> studentEntries) {
		for (StudentEntry studentEntry : studentEntries) {
			if (entityCache.getResult(
					entityCacheEnabled, StudentEntryImpl.class,
					studentEntry.getPrimaryKey()) == null) {

				cacheResult(studentEntry);
			}
			else {
				studentEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentEntry studentEntry) {
		entityCache.removeResult(
			entityCacheEnabled, StudentEntryImpl.class,
			studentEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentEntry> studentEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentEntry studentEntry : studentEntries) {
			entityCache.removeResult(
				entityCacheEnabled, StudentEntryImpl.class,
				studentEntry.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StudentEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new student entry with the primary key. Does not add the student entry to the database.
	 *
	 * @param studentEntryId the primary key for the new student entry
	 * @return the new student entry
	 */
	@Override
	public StudentEntry create(long studentEntryId) {
		StudentEntry studentEntry = new StudentEntryImpl();

		studentEntry.setNew(true);
		studentEntry.setPrimaryKey(studentEntryId);

		String uuid = PortalUUIDUtil.generate();

		studentEntry.setUuid(uuid);

		return studentEntry;
	}

	/**
	 * Removes the student entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry that was removed
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry remove(long studentEntryId)
		throws NoSuchStudentEntryException {

		return remove((Serializable)studentEntryId);
	}

	/**
	 * Removes the student entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student entry
	 * @return the student entry that was removed
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry remove(Serializable primaryKey)
		throws NoSuchStudentEntryException {

		Session session = null;

		try {
			session = openSession();

			StudentEntry studentEntry = (StudentEntry)session.get(
				StudentEntryImpl.class, primaryKey);

			if (studentEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(studentEntry);
		}
		catch (NoSuchStudentEntryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StudentEntry removeImpl(StudentEntry studentEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentEntry)) {
				studentEntry = (StudentEntry)session.get(
					StudentEntryImpl.class, studentEntry.getPrimaryKeyObj());
			}

			if (studentEntry != null) {
				session.delete(studentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (studentEntry != null) {
			clearCache(studentEntry);
		}

		return studentEntry;
	}

	@Override
	public StudentEntry updateImpl(StudentEntry studentEntry) {
		boolean isNew = studentEntry.isNew();

		if (!(studentEntry instanceof StudentEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(studentEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					studentEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in studentEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StudentEntry implementation " +
					studentEntry.getClass());
		}

		StudentEntryModelImpl studentEntryModelImpl =
			(StudentEntryModelImpl)studentEntry;

		if (Validator.isNull(studentEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			studentEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (studentEntry.isNew()) {
				session.save(studentEntry);

				studentEntry.setNew(false);
			}
			else {
				studentEntry = (StudentEntry)session.merge(studentEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {studentEntryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {studentEntryModelImpl.getStudentEntryId()};

			finderCache.removeResult(_finderPathCountByStudentEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStudentEntryId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((studentEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					studentEntryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {studentEntryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((studentEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStudentEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					studentEntryModelImpl.getOriginalStudentEntryId()
				};

				finderCache.removeResult(
					_finderPathCountByStudentEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStudentEntryId, args);

				args = new Object[] {studentEntryModelImpl.getStudentEntryId()};

				finderCache.removeResult(
					_finderPathCountByStudentEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStudentEntryId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StudentEntryImpl.class,
			studentEntry.getPrimaryKey(), studentEntry, false);

		studentEntry.resetOriginalValues();

		return studentEntry;
	}

	/**
	 * Returns the student entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student entry
	 * @return the student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentEntryException {

		StudentEntry studentEntry = fetchByPrimaryKey(primaryKey);

		if (studentEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return studentEntry;
	}

	/**
	 * Returns the student entry with the primary key or throws a <code>NoSuchStudentEntryException</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry findByPrimaryKey(long studentEntryId)
		throws NoSuchStudentEntryException {

		return findByPrimaryKey((Serializable)studentEntryId);
	}

	/**
	 * Returns the student entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry, or <code>null</code> if a student entry with the primary key could not be found
	 */
	@Override
	public StudentEntry fetchByPrimaryKey(long studentEntryId) {
		return fetchByPrimaryKey((Serializable)studentEntryId);
	}

	/**
	 * Returns all the student entries.
	 *
	 * @return the student entries
	 */
	@Override
	public List<StudentEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @return the range of student entries
	 */
	@Override
	public List<StudentEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student entries
	 */
	@Override
	public List<StudentEntry> findAll(
		int start, int end, OrderByComparator<StudentEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of student entries
	 */
	@Override
	public List<StudentEntry> findAll(
		int start, int end, OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<StudentEntry> list = null;

		if (useFinderCache) {
			list = (List<StudentEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENTENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTENTRY;

				sql = sql.concat(StudentEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<StudentEntry>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the student entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StudentEntry studentEntry : findAll()) {
			remove(studentEntry);
		}
	}

	/**
	 * Returns the number of student entries.
	 *
	 * @return the number of student entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "studentEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STUDENTENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student entry persistence.
	 */
	@Activate
	public void activate() {
		StudentEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StudentEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			StudentEntryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByStudentEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStudentEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStudentEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StudentEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStudentEntryId",
			new String[] {Long.class.getName()},
			StudentEntryModelImpl.STUDENTENTRYID_COLUMN_BITMASK);

		_finderPathCountByStudentEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStudentEntryId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StudentEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = STUDENTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.khalibre.student.model.StudentEntry"),
			true);
	}

	@Override
	@Reference(
		target = STUDENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = STUDENTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STUDENTENTRY =
		"SELECT studentEntry FROM StudentEntry studentEntry";

	private static final String _SQL_SELECT_STUDENTENTRY_WHERE =
		"SELECT studentEntry FROM StudentEntry studentEntry WHERE ";

	private static final String _SQL_COUNT_STUDENTENTRY =
		"SELECT COUNT(studentEntry) FROM StudentEntry studentEntry";

	private static final String _SQL_COUNT_STUDENTENTRY_WHERE =
		"SELECT COUNT(studentEntry) FROM StudentEntry studentEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "studentEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StudentEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StudentEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StudentEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(STUDENTPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}