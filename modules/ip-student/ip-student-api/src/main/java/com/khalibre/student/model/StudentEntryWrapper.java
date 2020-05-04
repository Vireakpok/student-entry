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

package com.khalibre.student.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StudentEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntry
 * @generated
 */
public class StudentEntryWrapper
	extends BaseModelWrapper<StudentEntry>
	implements ModelWrapper<StudentEntry>, StudentEntry {

	public StudentEntryWrapper(StudentEntry studentEntry) {
		super(studentEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("studentEntryId", getStudentEntryId());
		attributes.put("studentEntryName", getStudentEntryName());
		attributes.put("studentEntryGender", getStudentEntryGender());
		attributes.put("studentEntryAge", getStudentEntryAge());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long studentEntryId = (Long)attributes.get("studentEntryId");

		if (studentEntryId != null) {
			setStudentEntryId(studentEntryId);
		}

		String studentEntryName = (String)attributes.get("studentEntryName");

		if (studentEntryName != null) {
			setStudentEntryName(studentEntryName);
		}

		String studentEntryGender = (String)attributes.get(
			"studentEntryGender");

		if (studentEntryGender != null) {
			setStudentEntryGender(studentEntryGender);
		}

		Integer studentEntryAge = (Integer)attributes.get("studentEntryAge");

		if (studentEntryAge != null) {
			setStudentEntryAge(studentEntryAge);
		}
	}

	/**
	 * Returns the primary key of this student entry.
	 *
	 * @return the primary key of this student entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the student entry age of this student entry.
	 *
	 * @return the student entry age of this student entry
	 */
	@Override
	public int getStudentEntryAge() {
		return model.getStudentEntryAge();
	}

	/**
	 * Returns the student entry gender of this student entry.
	 *
	 * @return the student entry gender of this student entry
	 */
	@Override
	public String getStudentEntryGender() {
		return model.getStudentEntryGender();
	}

	/**
	 * Returns the student entry ID of this student entry.
	 *
	 * @return the student entry ID of this student entry
	 */
	@Override
	public long getStudentEntryId() {
		return model.getStudentEntryId();
	}

	/**
	 * Returns the student entry name of this student entry.
	 *
	 * @return the student entry name of this student entry
	 */
	@Override
	public String getStudentEntryName() {
		return model.getStudentEntryName();
	}

	/**
	 * Returns the uuid of this student entry.
	 *
	 * @return the uuid of this student entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this student entry.
	 *
	 * @param primaryKey the primary key of this student entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the student entry age of this student entry.
	 *
	 * @param studentEntryAge the student entry age of this student entry
	 */
	@Override
	public void setStudentEntryAge(int studentEntryAge) {
		model.setStudentEntryAge(studentEntryAge);
	}

	/**
	 * Sets the student entry gender of this student entry.
	 *
	 * @param studentEntryGender the student entry gender of this student entry
	 */
	@Override
	public void setStudentEntryGender(String studentEntryGender) {
		model.setStudentEntryGender(studentEntryGender);
	}

	/**
	 * Sets the student entry ID of this student entry.
	 *
	 * @param studentEntryId the student entry ID of this student entry
	 */
	@Override
	public void setStudentEntryId(long studentEntryId) {
		model.setStudentEntryId(studentEntryId);
	}

	/**
	 * Sets the student entry name of this student entry.
	 *
	 * @param studentEntryName the student entry name of this student entry
	 */
	@Override
	public void setStudentEntryName(String studentEntryName) {
		model.setStudentEntryName(studentEntryName);
	}

	/**
	 * Sets the uuid of this student entry.
	 *
	 * @param uuid the uuid of this student entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected StudentEntryWrapper wrap(StudentEntry studentEntry) {
		return new StudentEntryWrapper(studentEntry);
	}

}