<%@ include file="../init.jsp" %>

  <h1>Adding View</h1>

  <portlet:renderURL var="showUrl">
    <portlet:param name="mvcRenderCommandName" value="/student/show" />
  </portlet:renderURL>

  <portlet:actionURL name="viewAdd" var="viewAddUrl" />

    <aui:form action="<%=viewAddUrl%>" name="frm">
        <aui:input label="Student name" name="studentEntryName" />
        <aui:select label="student gender" name="studentEntryGender" >
            <aui:option label="Male" />
            <aui:option label="Female" />
        </aui:select>
        <aui:input label="Student age" name="studentEntryAge" />
        <aui:button type="submit" value="Add" />
    </aui:form>

  <a href="<%=showUrl%>">To Show Data Entry</a>