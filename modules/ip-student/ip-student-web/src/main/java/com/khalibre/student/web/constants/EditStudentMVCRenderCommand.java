package com.khalibre.student.web.constants;

import com.khalibre.student.model.StudentEntry;
import com.khalibre.student.service.StudentEntryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component (
    immediate = true,
    property = {
        "javax.portlet.name=" + StudentMVCPortletKeys.STUDENTMVC,
        "mvc.command.name=/student/edit"
    },
    service = MVCRenderCommand.class
)
public class EditStudentMVCRenderCommand implements MVCRenderCommand {

  @Override
  public String render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws PortletException {

    long studentEntryId = ParamUtil.getLong(renderRequest, "studentEntryId");

    List<StudentEntry> studentEntries =StudentEntryLocalServiceUtil.getStudentEntries();
    for(int i=0;i<studentEntries.size();i++) {
      StudentEntry studentEntry = studentEntries.get(i);
        if(studentEntry.getStudentEntryId() == studentEntryId) {
          renderRequest.setAttribute("studentEntryName", studentEntry.getStudentEntryName());
          renderRequest.setAttribute("studentEntryGender",studentEntry.getStudentEntryGender());
          renderRequest.setAttribute("studentEntryAge",studentEntry.getStudentEntryAge());
          renderRequest.setAttribute("studentEntryId",studentEntry.getStudentEntryId());
        }
    }

    return "/student/edit.jsp";
  }
}
