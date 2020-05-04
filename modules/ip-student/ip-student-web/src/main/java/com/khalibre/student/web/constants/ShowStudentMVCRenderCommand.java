package com.khalibre.student.web.constants;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component (
    immediate = true,
    property = {
        "javax.portlet.name=" + StudentMVCPortletKeys.STUDENTMVC,
        "mvc.command.name=/student/show"
    },
    service = MVCRenderCommand.class
)

public class ShowStudentMVCRenderCommand implements MVCRenderCommand {

  @Override
  public String render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws PortletException {
    return "/student/show.jsp";
  }
}
