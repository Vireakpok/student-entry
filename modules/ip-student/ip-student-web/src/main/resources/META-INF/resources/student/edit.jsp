<%@ include file="../init.jsp" %>

<%
  String studentEntryName = (String) renderRequest.getAttribute("studentEntryName");
  String studentEntryGender = (String) renderRequest.getAttribute("studentEntryGender");
  Integer studentEntryAge = (Integer) renderRequest.getAttribute("studentEntryAge");
  Long studentEntryId = (Long) renderRequest.getAttribute("studentEntryId");
%>

<h1>Edit View</h1>

<portlet:actionURL name="editStudentEntry" var="editStudentEntry" >
      <portlet:param name="mvcActionCommand" value="editStudentEntry" />
</portlet:actionURL>

<aui:form action="<%= editStudentEntry %>" name="fm">
  <aui:input label="Student name" name="studentEntryName" value="<%= studentEntryName %>" />
  <aui:input label="Student gender" name="studentEntryGender" value="<%= studentEntryGender %>" />
  <aui:input label="Student age" name="studentEntryAge" value="<%= studentEntryAge %>" />
  <aui:input type="hidden" name="studentEntryId" value="<%= studentEntryId %>" />
  <aui:button type="submit" value="submit" />
</aui:form>