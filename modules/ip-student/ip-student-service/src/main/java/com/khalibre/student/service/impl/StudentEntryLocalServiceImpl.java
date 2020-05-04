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

package com.khalibre.student.service.impl;

import com.khalibre.student.model.StudentEntry;
import com.khalibre.student.service.base.StudentEntryLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import java.util.List;
import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the student entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.khalibre.student.service.StudentEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.khalibre.student.model.StudentEntry",
	service = AopService.class
)
public class StudentEntryLocalServiceImpl
	extends StudentEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.khalibre.student.service.StudentEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.khalibre.student.service.StudentEntryLocalServiceUtil</code>.
	 */
	public StudentEntry addStudentEntry(String studentEntryName, String studentEntryGender, int studentEntryAge) {
		long studentEntryId = counterLocalService.increment();

		StudentEntry studentEntry = studentEntryLocalService.createStudentEntry(studentEntryId);

		studentEntry.setStudentEntryName(studentEntryName);
		studentEntry.setStudentEntryGender(studentEntryGender);
		studentEntry.setStudentEntryAge(studentEntryAge);

		studentEntryPersistence.update(studentEntry);
		return studentEntry;
	}
	public StudentEntry updateStudentEntry(long studentEntryId,String studentEntryName, String studentEntryGender, int studentEntryAge) {
		StudentEntry studentEntry = (StudentEntry) studentEntryPersistence.fetchByPrimaryKey(studentEntryId);

		studentEntry.setStudentEntryName(studentEntryName);
		studentEntry.setStudentEntryGender(studentEntryGender);
		studentEntry.setStudentEntryAge(studentEntryAge);

		studentEntryPersistence.update(studentEntry);

		return studentEntry;
	}
	public StudentEntry deleteStudentEntry(long studentEntryId) throws PortalException {
		StudentEntry studentEntry = studentEntryPersistence.fetchByPrimaryKey(studentEntryId);
		return 	studentEntryPersistence.remove(studentEntryId);
	}
	public List<StudentEntry> getStudentEntries() {
		return studentEntryPersistence.findAll();
	}
}