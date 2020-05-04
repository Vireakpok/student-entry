package com.khalibre.student.web.constants;

import com.khalibre.student.service.StudentEntryLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component (
    immediate = true,
    property = {
        "javax.portlet.name=" + StudentMVCPortletKeys.STUDENTMVC,
        "mvc.command.name=viewAdd"
    },
    service = MVCActionCommand.class
)
public class AddStudentMVCActionCommand implements MVCActionCommand {
  @Reference
  private StudentEntryLocalService studentEntryLocalService;
  @Override
  public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws PortletException {

    String studentEntryName = ParamUtil.getString(actionRequest, "studentEntryName");
    String studentEntryGender = ParamUtil.getString(actionRequest, "studentEntryGender");
    int studentEntryAge = ParamUtil.getInteger(actionRequest, "studentEntryAge");
    studentEntryLocalService.addStudentEntry(studentEntryName,studentEntryGender,studentEntryAge);
    actionResponse.setRenderParameter("mvcRenderCommandName","/student/show");

    return false;
  }
}
