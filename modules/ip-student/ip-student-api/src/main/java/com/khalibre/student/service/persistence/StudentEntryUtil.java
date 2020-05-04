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

package com.khalibre.student.service.persistence;

import com.khalibre.student.model.StudentEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the student entry service. This utility wraps <code>com.khalibre.student.service.persistence.impl.StudentEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntryPersistence
 * @generated
 */
public class StudentEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(StudentEntry studentEntry) {
		getPersistence().clearCache(studentEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, StudentEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StudentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudentEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StudentEntry update(StudentEntry studentEntry) {
		return getPersistence().update(studentEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StudentEntry update(
		StudentEntry studentEntry, ServiceContext serviceContext) {

		return getPersistence().update(studentEntry, serviceContext);
	}

	/**
	 * Returns all the student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student entries
	 */
	public static List<StudentEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<StudentEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public static StudentEntry findByUuid_First(
			String uuid, OrderByComparator<StudentEntry> orderByComparator)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public static StudentEntry fetchByUuid_First(
		String uuid, OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public static StudentEntry findByUuid_Last(
			String uuid, OrderByComparator<StudentEntry> orderByComparator)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public static StudentEntry fetchByUuid_Last(
		String uuid, OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static StudentEntry[] findByUuid_PrevAndNext(
			long studentEntryId, String uuid,
			OrderByComparator<StudentEntry> orderByComparator)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			studentEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the student entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the matching student entries
	 */
	public static List<StudentEntry> findByStudentEntryId(long studentEntryId) {
		return getPersistence().findByStudentEntryId(studentEntryId);
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
	public static List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end) {

		return getPersistence().findByStudentEntryId(
			studentEntryId, start, end);
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
	public static List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().findByStudentEntryId(
			studentEntryId, start, end, orderByComparator);
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
	public static List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStudentEntryId(
			studentEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public static StudentEntry findByStudentEntryId_First(
			long studentEntryId,
			OrderByComparator<StudentEntry> orderByComparator)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByStudentEntryId_First(
			studentEntryId, orderByComparator);
	}

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public static StudentEntry fetchByStudentEntryId_First(
		long studentEntryId,
		OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().fetchByStudentEntryId_First(
			studentEntryId, orderByComparator);
	}

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public static StudentEntry findByStudentEntryId_Last(
			long studentEntryId,
			OrderByComparator<StudentEntry> orderByComparator)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByStudentEntryId_Last(
			studentEntryId, orderByComparator);
	}

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public static StudentEntry fetchByStudentEntryId_Last(
		long studentEntryId,
		OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().fetchByStudentEntryId_Last(
			studentEntryId, orderByComparator);
	}

	/**
	 * Removes all the student entries where studentEntryId = &#63; from the database.
	 *
	 * @param studentEntryId the student entry ID
	 */
	public static void removeByStudentEntryId(long studentEntryId) {
		getPersistence().removeByStudentEntryId(studentEntryId);
	}

	/**
	 * Returns the number of student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the number of matching student entries
	 */
	public static int countByStudentEntryId(long studentEntryId) {
		return getPersistence().countByStudentEntryId(studentEntryId);
	}

	/**
	 * Caches the student entry in the entity cache if it is enabled.
	 *
	 * @param studentEntry the student entry
	 */
	public static void cacheResult(StudentEntry studentEntry) {
		getPersistence().cacheResult(studentEntry);
	}

	/**
	 * Caches the student entries in the entity cache if it is enabled.
	 *
	 * @param studentEntries the student entries
	 */
	public static void cacheResult(List<StudentEntry> studentEntries) {
		getPersistence().cacheResult(studentEntries);
	}

	/**
	 * Creates a new student entry with the primary key. Does not add the student entry to the database.
	 *
	 * @param studentEntryId the primary key for the new student entry
	 * @return the new student entry
	 */
	public static StudentEntry create(long studentEntryId) {
		return getPersistence().create(studentEntryId);
	}

	/**
	 * Removes the student entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry that was removed
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	public static StudentEntry remove(long studentEntryId)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().remove(studentEntryId);
	}

	public static StudentEntry updateImpl(StudentEntry studentEntry) {
		return getPersistence().updateImpl(studentEntry);
	}

	/**
	 * Returns the student entry with the primary key or throws a <code>NoSuchStudentEntryException</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	public static StudentEntry findByPrimaryKey(long studentEntryId)
		throws com.khalibre.student.exception.NoSuchStudentEntryException {

		return getPersistence().findByPrimaryKey(studentEntryId);
	}

	/**
	 * Returns the student entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry, or <code>null</code> if a student entry with the primary key could not be found
	 */
	public static StudentEntry fetchByPrimaryKey(long studentEntryId) {
		return getPersistence().fetchByPrimaryKey(studentEntryId);
	}

	/**
	 * Returns all the student entries.
	 *
	 * @return the student entries
	 */
	public static List<StudentEntry> findAll() {
		return getPersistence().findAll();
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
	public static List<StudentEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<StudentEntry> findAll(
		int start, int end, OrderByComparator<StudentEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<StudentEntry> findAll(
		int start, int end, OrderByComparator<StudentEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the student entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of student entries.
	 *
	 * @return the number of student entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StudentEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<StudentEntryPersistence, StudentEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StudentEntryPersistence.class);

		ServiceTracker<StudentEntryPersistence, StudentEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<StudentEntryPersistence, StudentEntryPersistence>(
						bundle.getBundleContext(),
						StudentEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}