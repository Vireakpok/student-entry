package com.khalibre.student.web.portlet;

import com.khalibre.student.model.StudentEntry;
import com.khalibre.student.service.StudentEntryLocalService;
import com.khalibre.student.service.StudentEntryLocalServiceUtil;
import com.khalibre.student.web.constants.StudentMVCPortletKeys;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;
import javax.portlet.Portlet;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author vireakp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=StudentMVC",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/student/view.jsp",
		"javax.portlet.name=" + StudentMVCPortletKeys.STUDENTMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentMVCPortlet extends MVCPortlet {
	@Reference
	private StudentEntryLocalService studentEntryLocalService;

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		/*
		List<StudentEntry> studentEntries = StudentEntryLocalServiceUtil.getStudentEntryByStudentEntryId(35509);
		String entryName = null, entryGender = null;
		int entryAge = 0;
		for(int i=0; i < studentEntries.size() ; i++) {
		StudentEntry	studentEntry = (StudentEntry) studentEntries.get(i);
			entryName	 = studentEntry.getStudentEntryName();
			entryGender = studentEntry.getStudentEntryGender();
			entryAge = studentEntry.getStudentEntryAge();
			System.out.println("studentEntry size is = " + studentEntries.size());
		}
 */
		StudentEntry studentEntry1 = null;
		List<StudentEntry> studentEntries = StudentEntryLocalServiceUtil.getStudentEntries();
		for(int i= 0; i < studentEntries.size(); i++) {
			StudentEntry studentEntry = (StudentEntry) studentEntries.get(i);
			try {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
						"{'id':'" + studentEntry.getPrimaryKey() + "','name':'" + studentEntry
								.getStudentEntryName() + "','gender':'" + studentEntry.getStudentEntryGender()
								+ "','age':'" + studentEntry.getStudentEntryAge() + "'}");
				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest,resourceResponse,jsonArray);
		super.serveResource(resourceRequest, resourceResponse);
	}
}