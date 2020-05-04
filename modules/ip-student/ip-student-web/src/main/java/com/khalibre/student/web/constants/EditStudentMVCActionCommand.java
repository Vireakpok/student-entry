package com.khalibre.student.web.constants;

import com.khalibre.student.service.StudentEntryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;

@Component (
    immediate = true,
    property = {
    "javax.portlet.name=" + StudentMVCPortletKeys.STUDENTMVC,
    "mvc.command.name=editStudentEntry"
    },
    service = MVCActionCommand.class
)
public class EditStudentMVCActionCommand implements MVCActionCommand {

  @Override
  public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws PortletException {

    String studentEntryName = ParamUtil.getString(actionRequest, "studentEntryName");
    String studentEntryGender = ParamUtil.getString(actionRequest, "studentEntryGender");
    int studentEntryAge = ParamUtil.getInteger(actionRequest, "studentEntryAge");
    long studentEntryId = ParamUtil.getLong(actionRequest, "studentEntryId");
    StudentEntryLocalServiceUtil.updateStudentEntry(studentEntryId,studentEntryName,studentEntryGender,studentEntryAge);
    actionResponse.setRenderParameter("mvcRenderCommandName","/student/show");

    return false;
  }

}
