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

package com.khalibre.student.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntryLocalService
 * @generated
 */
public class StudentEntryLocalServiceWrapper
	implements ServiceWrapper<StudentEntryLocalService>,
			   StudentEntryLocalService {

	public StudentEntryLocalServiceWrapper(
		StudentEntryLocalService studentEntryLocalService) {

		_studentEntryLocalService = studentEntryLocalService;
	}

	@Override
	public com.khalibre.student.model.StudentEntry addStudentEntry(
		String studentEntryName, String studentEntryGender,
		int studentEntryAge) {

		return _studentEntryLocalService.addStudentEntry(
			studentEntryName, studentEntryGender, studentEntryAge);
	}

	/**
	 * Adds the student entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntry the student entry
	 * @return the student entry that was added
	 */
	@Override
	public com.khalibre.student.model.StudentEntry addStudentEntry(
		com.khalibre.student.model.StudentEntry studentEntry) {

		return _studentEntryLocalService.addStudentEntry(studentEntry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentEntryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new student entry with the primary key. Does not add the student entry to the database.
	 *
	 * @param studentEntryId the primary key for the new student entry
	 * @return the new student entry
	 */
	@Override
	public com.khalibre.student.model.StudentEntry createStudentEntry(
		long studentEntryId) {

		return _studentEntryLocalService.createStudentEntry(studentEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the student entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry that was removed
	 * @throws PortalException if a student entry with the primary key could not be found
	 */
	@Override
	public com.khalibre.student.model.StudentEntry deleteStudentEntry(
			long studentEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentEntryLocalService.deleteStudentEntry(studentEntryId);
	}

	/**
	 * Deletes the student entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntry the student entry
	 * @return the student entry that was removed
	 */
	@Override
	public com.khalibre.student.model.StudentEntry deleteStudentEntry(
		com.khalibre.student.model.StudentEntry studentEntry) {

		return _studentEntryLocalService.deleteStudentEntry(studentEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentEntryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studentEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.khalibre.student.model.impl.StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _studentEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.khalibre.student.model.impl.StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _studentEntryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studentEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _studentEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.khalibre.student.model.StudentEntry fetchStudentEntry(
		long studentEntryId) {

		return _studentEntryLocalService.fetchStudentEntry(studentEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _studentEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _studentEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.khalibre.student.model.StudentEntry>
		getStudentEntries() {

		return _studentEntryLocalService.getStudentEntries();
	}

	/**
	 * Returns a range of all the student entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.khalibre.student.model.impl.StudentEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of student entries
	 * @param end the upper bound of the range of student entries (not inclusive)
	 * @return the range of student entries
	 */
	@Override
	public java.util.List<com.khalibre.student.model.StudentEntry>
		getStudentEntries(int start, int end) {

		return _studentEntryLocalService.getStudentEntries(start, end);
	}

	/**
	 * Returns the number of student entries.
	 *
	 * @return the number of student entries
	 */
	@Override
	public int getStudentEntriesCount() {
		return _studentEntryLocalService.getStudentEntriesCount();
	}

	/**
	 * Returns the student entry with the primary key.
	 *
	 * @param studentEntryId the primary key of the student entry
	 * @return the student entry
	 * @throws PortalException if a student entry with the primary key could not be found
	 */
	@Override
	public com.khalibre.student.model.StudentEntry getStudentEntry(
			long studentEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentEntryLocalService.getStudentEntry(studentEntryId);
	}

	@Override
	public com.khalibre.student.model.StudentEntry updateStudentEntry(
		long studentEntryId, String studentEntryName, String studentEntryGender,
		int studentEntryAge) {

		return _studentEntryLocalService.updateStudentEntry(
			studentEntryId, studentEntryName, studentEntryGender,
			studentEntryAge);
	}

	/**
	 * Updates the student entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param studentEntry the student entry
	 * @return the student entry that was updated
	 */
	@Override
	public com.khalibre.student.model.StudentEntry updateStudentEntry(
		com.khalibre.student.model.StudentEntry studentEntry) {

		return _studentEntryLocalService.updateStudentEntry(studentEntry);
	}

	@Override
	public StudentEntryLocalService getWrappedService() {
		return _studentEntryLocalService;
	}

	@Override
	public void setWrappedService(
		StudentEntryLocalService studentEntryLocalService) {

		_studentEntryLocalService = studentEntryLocalService;
	}

	private StudentEntryLocalService _studentEntryLocalService;

}