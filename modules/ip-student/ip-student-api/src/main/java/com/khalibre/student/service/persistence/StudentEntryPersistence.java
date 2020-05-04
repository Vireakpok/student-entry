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

import com.khalibre.student.exception.NoSuchStudentEntryException;
import com.khalibre.student.model.StudentEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the student entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntryUtil
 * @generated
 */
@ProviderType
public interface StudentEntryPersistence extends BasePersistence<StudentEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentEntryUtil} to access the student entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching student entries
	 */
	public java.util.List<StudentEntry> findByUuid(String uuid);

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
	public java.util.List<StudentEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

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
	public java.util.List<StudentEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public StudentEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
				orderByComparator)
		throws NoSuchStudentEntryException;

	/**
	 * Returns the first student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public StudentEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public StudentEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
				orderByComparator)
		throws NoSuchStudentEntryException;

	/**
	 * Returns the last student entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public StudentEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

	/**
	 * Returns the student entries before and after the current student entry in the ordered set where uuid = &#63;.
	 *
	 * @param studentEntryId the primary key of the current student entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	public StudentEntry[] findByUuid_PrevAndNext(
			long studentEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
				orderByComparator)
		throws NoSuchStudentEntryException;

	/**
	 * Removes all the student entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of student entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching student entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the matching student entries
	 */
	public java.util.List<StudentEntry> findByStudentEntryId(
		long studentEntryId);

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
	public java.util.List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end);

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
	public java.util.List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

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
	public java.util.List<StudentEntry> findByStudentEntryId(
		long studentEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public StudentEntry findByStudentEntryId_First(
			long studentEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
				orderByComparator)
		throws NoSuchStudentEntryException;

	/**
	 * Returns the first student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public StudentEntry fetchByStudentEntryId_First(
		long studentEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry
	 * @throws NoSuchStudentEntryException if a matching student entry could not be found
	 */
	public StudentEntry findByStudentEntryId_Last(
			long studentEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
				orderByComparator)
		throws NoSuchStudentEntryException;

	/**
	 * Returns the last student entry in the ordered set where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student entry, or <code>null</code> if a matching student entry could not be found
	 */
	public StudentEntry fetchByStudentEntryId_Last(
		long studentEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

	/**
	 * Removes all the student entries where studentEntryId = &#63; from the database.
	 *
	 * @param studentEntryId the student entry ID
	 */
	public void removeByStudentEntryId(long studentEntryId);

	/**
	 * Returns the number of student entries where studentEntryId = &#63;.
	 *
	 * @param studentEntryId the student entry ID
	 * @return the number of matching student entries
	 */
	public int countByStudentEntryId(long studentEntryId);

	/**
	 * Caches the student entry in the entity cache if it is enabled.
	 *
	 * @param studentEntry the student entry
	 */
	public void cacheResult(StudentEntry studentEntry);

	/**
	 * Caches the student entries in the entity cache if it is enabled.
	 *
	 * @param studentEntries the student entries
	 */
	public void cacheResult(java.util.List<StudentEntry> studentEntries);

	/**
	 * Creates a new student entry with the primary key. Does not add the student entry to the database.
	 *
	 * @param studentEntryId the primary key for the new student entry
	 * @return the new student entry
	 */
	public StudentEntry create(long studentEntryId);

	/**
	 * Removes the student entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry that was removed
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	public StudentEntry remove(long studentEntryId)
		throws NoSuchStudentEntryException;

	public StudentEntry updateImpl(StudentEntry studentEntry);

	/**
	 * Returns the student entry with the primary key or throws a <code>NoSuchStudentEntryException</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry
	 * @throws NoSuchStudentEntryException if a student entry with the primary key could not be found
	 */
	public StudentEntry findByPrimaryKey(long studentEntryId)
		throws NoSuchStudentEntryException;

	/**
	 * Returns the student entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry, or <code>null</code> if a student entry with the primary key could not be found
	 */
	public StudentEntry fetchByPrimaryKey(long studentEntryId);

	/**
	 * Returns all the student entries.
	 *
	 * @return the student entries
	 */
	public java.util.List<StudentEntry> findAll();

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
	public java.util.List<StudentEntry> findAll(int start, int end);

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
	public java.util.List<StudentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator);

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
	public java.util.List<StudentEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the student entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of student entries.
	 *
	 * @return the number of student entries
	 */
	public int countAll();

}