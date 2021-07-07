<%--
  Created by IntelliJ IDEA.
  User: ali_jaber
  Date: 7/4/21
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.task_finalVersion.data.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<html>
<head>
    <title>tasks</title>
</head>
<body>
<jsp:include page="../pages/bootstrap.html"/>
<jsp:include page="../pages/header.jsp"/>

<script>
    function handleSelectChange(event) {

        var selectElement = event.target;

        var value = selectElement.value;
        //document.getElementById("statusForm").submit();

        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {

        }


        xhttp.open("POST", "tasks.do");
        xhttp.setRequestHeader("status", value);



        xhttp.send();
        // alert(value)
    }
</script>


<div style="margin-right: 100px; margin-left: 100px">




    <table class="table caption-top">
        <caption>List of tasks</caption>
        <thead>

        <tr>
            <th scope="col">Id</th>
            <th scope="col">tasks name</th>
            <th scope="col">manager sported</th>
            <th scope="col">statue</th>
            <th scope="col">amount hour</th>
            <th scope="col">tasks description</th>
        </tr>

        </thead>
        <tbody>
        <%
            ArrayList<Task> taskArrayList= (ArrayList<Task>) request.getAttribute("tasks");
            for(int i=0;i<taskArrayList.size();i++){
                       pageContext.setAttribute("status",taskArrayList.get(i).status);
                %>
        <tr>

            <td> <%=taskArrayList.get(i).id %> </td>
            <td><%=taskArrayList.get(i).taskName %> </td>
            <td> <%=taskArrayList.get(i).manager %></td>
            <td>

              <form method="POST" action="tasks.do" id="statusForm">
                  <select   name="status"  class="custom-select"
                           onchange="handleSelectChange(event)">
                      <%
                          if(taskArrayList.get(i).status.equals("Done")){
                              %>
                      <option value="Done,<%=taskArrayList.get(i).id %>" selected >Done</option>
                       <%
                          } else
                          {
                              %>
                      <option value="Done,<%=taskArrayList.get(i).id %>" >Done</option>
                      <%
                          }
                      %>
                      <%
                          if(taskArrayList.get(i).status.equals("Completed")){
                      %>
                      <option value="Completed,<%=taskArrayList.get(i).id %>"  selected>Completed</option>
                      <%
                      } else
                      {
                      %>
                      <option value="Completed,<%=taskArrayList.get(i).id %>">Completed</option>
                      <%
                          }
                      %>
                      <%
                          if(taskArrayList.get(i).status.equals("In Progress")){
                      %>
                      <option value="In Progress,<%=taskArrayList.get(i).id %>" selected >In Progress</option>
                      <%
                      } else
                      {
                      %>

                      <option value="In Progress,<%=taskArrayList.get(i).id %>">In Progress</option>
                      <%
                          }
                      %>



                  </select>
              </form>

            </td>
            <td> <%=taskArrayList.get(i).hour%></td>
            <td> <%=taskArrayList.get(i).description %></td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>

</div>


</body>
</html>
