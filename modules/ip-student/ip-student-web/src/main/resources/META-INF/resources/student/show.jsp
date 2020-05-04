<%@ include file="../init.jsp" %>

  <h1>Data Entry</h1>
  <table class="table table-dark">
    <thead>
      <tr>
        <th scope="col">No</th>
        <th scope="col">Name</th>
        <th scope="col">Gender</th>
        <th scope="col">Age</th>
        <th scope="col"></th>
        <th scope="col"></th>
      </tr>
    </thead>
    <tbody>
      <%
        List<StudentEntry> studentEntries = StudentEntryLocalServiceUtil.getStudentEntries();
        for(int i= 0; i < studentEntries.size(); i++) {
            StudentEntry  studentEntry = (StudentEntry) studentEntries.get(i);
            int j= i + 1;
      %>
      <portlet:actionURL name="deleteStudentEntry" var="deleteActionUrl" >
        <portlet:param name="mvcActionCommand" value="deleteStudentEntry" />
        <portlet:param name="studentEntryId" value="<%=String.valueOf(studentEntries.get(i).getStudentEntryId())%>" />
      </portlet:actionURL>

      <portlet:renderURL var="editUrl">
        <portlet:param name="mvcRenderCommandName" value="/student/edit" />
        <portlet:param name="studentEntryId" value="<%=String.valueOf(studentEntries.get(i).getStudentEntryId())%>" />
      </portlet:renderURL>
          <tr>
            <th scope="row"><%= String.valueOf(j)%></th>
            <th><%= studentEntries.get(i).getStudentEntryName() %></th>
            <th><%= studentEntries.get(i).getStudentEntryGender() %></th>
            <th><%= String.valueOf(studentEntries.get(i).getStudentEntryAge()) %></th>
            <th><a href="<%=editUrl%>">Edit</a></th>
            <th><a href="<%=deleteActionUrl%>">Delete</a></th>
          </tr>
      <%
            }
      %>
    </tbody>
  </table>


  <portlet:resourceURL var="searchResourceURL" id="searchResource">
          <liferay-portlet:param name="cmd" value="seachContent"/>
  </portlet:resourceURL>
  <aui:script>
    function getData() {
        AUI().use('aui-io-request', function(A) {
            A.io.request('<%= searchResourceURL %>' , {
                method: 'get',
                on: {
                   success: function() {
                    var data = this.get('responseData');
                    console.log(data);
                    var object = JSON.parse(data);

                    var show = "";
                    for(var key in object)
                    {
                      show = show +"<tr><td>" + object[key].id + "</td><td>" + object[key].name + "</td><td>" + object[key].gender + "</td><td>" + object[key].age + "</td></tr>";
                    }
                    document.getElementById("showTableData").innerHTML = show;

                   }
                }
            });
          });
    }
  </aui:script>

  <a href="javascript:;" onClick="getData()">Show data</a>
  <table border="1px" id="showTableData" >

  </table>