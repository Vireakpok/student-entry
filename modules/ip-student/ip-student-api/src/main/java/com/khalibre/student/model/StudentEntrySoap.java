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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.khalibre.student.service.http.StudentEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentEntrySoap implements Serializable {

	public static StudentEntrySoap toSoapModel(StudentEntry model) {
		StudentEntrySoap soapModel = new StudentEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStudentEntryId(model.getStudentEntryId());
		soapModel.setStudentEntryName(model.getStudentEntryName());
		soapModel.setStudentEntryGender(model.getStudentEntryGender());
		soapModel.setStudentEntryAge(model.getStudentEntryAge());

		return soapModel;
	}

	public static StudentEntrySoap[] toSoapModels(StudentEntry[] models) {
		StudentEntrySoap[] soapModels = new StudentEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentEntrySoap[][] toSoapModels(StudentEntry[][] models) {
		StudentEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentEntrySoap[] toSoapModels(List<StudentEntry> models) {
		List<StudentEntrySoap> soapModels = new ArrayList<StudentEntrySoap>(
			models.size());

		for (StudentEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentEntrySoap[soapModels.size()]);
	}

	public StudentEntrySoap() {
	}

	public long getPrimaryKey() {
		return _studentEntryId;
	}

	public void setPrimaryKey(long pk) {
		setStudentEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStudentEntryId() {
		return _studentEntryId;
	}

	public void setStudentEntryId(long studentEntryId) {
		_studentEntryId = studentEntryId;
	}

	public String getStudentEntryName() {
		return _studentEntryName;
	}

	public void setStudentEntryName(String studentEntryName) {
		_studentEntryName = studentEntryName;
	}

	public String getStudentEntryGender() {
		return _studentEntryGender;
	}

	public void setStudentEntryGender(String studentEntryGender) {
		_studentEntryGender = studentEntryGender;
	}

	public int getStudentEntryAge() {
		return _studentEntryAge;
	}

	public void setStudentEntryAge(int studentEntryAge) {
		_studentEntryAge = studentEntryAge;
	}

	private String _uuid;
	private long _studentEntryId;
	private String _studentEntryName;
	private String _studentEntryGender;
	private int _studentEntryAge;

}