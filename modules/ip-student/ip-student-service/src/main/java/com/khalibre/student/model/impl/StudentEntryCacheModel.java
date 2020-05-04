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

package com.khalibre.student.model.impl;

import com.khalibre.student.model.StudentEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StudentEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentEntryCacheModel
	implements CacheModel<StudentEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentEntryCacheModel)) {
			return false;
		}

		StudentEntryCacheModel studentEntryCacheModel =
			(StudentEntryCacheModel)obj;

		if (studentEntryId == studentEntryCacheModel.studentEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentEntryId=");
		sb.append(studentEntryId);
		sb.append(", studentEntryName=");
		sb.append(studentEntryName);
		sb.append(", studentEntryGender=");
		sb.append(studentEntryGender);
		sb.append(", studentEntryAge=");
		sb.append(studentEntryAge);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentEntry toEntityModel() {
		StudentEntryImpl studentEntryImpl = new StudentEntryImpl();

		if (uuid == null) {
			studentEntryImpl.setUuid("");
		}
		else {
			studentEntryImpl.setUuid(uuid);
		}

		studentEntryImpl.setStudentEntryId(studentEntryId);

		if (studentEntryName == null) {
			studentEntryImpl.setStudentEntryName("");
		}
		else {
			studentEntryImpl.setStudentEntryName(studentEntryName);
		}

		if (studentEntryGender == null) {
			studentEntryImpl.setStudentEntryGender("");
		}
		else {
			studentEntryImpl.setStudentEntryGender(studentEntryGender);
		}

		studentEntryImpl.setStudentEntryAge(studentEntryAge);

		studentEntryImpl.resetOriginalValues();

		return studentEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studentEntryId = objectInput.readLong();
		studentEntryName = objectInput.readUTF();
		studentEntryGender = objectInput.readUTF();

		studentEntryAge = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studentEntryId);

		if (studentEntryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentEntryName);
		}

		if (studentEntryGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentEntryGender);
		}

		objectOutput.writeInt(studentEntryAge);
	}

	public String uuid;
	public long studentEntryId;
	public String studentEntryName;
	public String studentEntryGender;
	public int studentEntryAge;

}