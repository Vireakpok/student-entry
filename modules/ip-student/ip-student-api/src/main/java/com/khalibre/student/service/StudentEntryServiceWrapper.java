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
 * Provides a wrapper for {@link StudentEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentEntryService
 * @generated
 */
public class StudentEntryServiceWrapper
	implements ServiceWrapper<StudentEntryService>, StudentEntryService {

	public StudentEntryServiceWrapper(StudentEntryService studentEntryService) {
		_studentEntryService = studentEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public StudentEntryService getWrappedService() {
		return _studentEntryService;
	}

	@Override
	public void setWrappedService(StudentEntryService studentEntryService) {
		_studentEntryService = studentEntryService;
	}

	private StudentEntryService _studentEntryService;

}