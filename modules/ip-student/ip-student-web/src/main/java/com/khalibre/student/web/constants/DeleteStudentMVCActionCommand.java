package com.khalibre.student.web.constants;

import com.khalibre.student.service.StudentEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
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
        "mvc.command.name=deleteStudentEntry"
    },
    service = MVCActionCommand.class
)
public class DeleteStudentMVCActionCommand implements MVCActionCommand {
  @Reference
  private StudentEntryLocalService studentEntryLocalService;
  @Override
  public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws PortletException {

    long studentEntryId = ParamUtil.getLong(actionRequest, "studentEntryId");

    try {
      studentEntryLocalService.deleteStudentEntry(studentEntryId);
      actionResponse.setRenderParameter("mvcRenderCommandName","/student/show");
    } catch (PortalException e) {
      e.printStackTrace();
    }

    return false;
  }
}
