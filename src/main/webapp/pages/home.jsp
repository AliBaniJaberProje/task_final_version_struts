<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.task_finalVersion.data.ORM.Manager" %>



<%--
  Created by IntelliJ IDEA.
  User: ali_jaber
  Date: 7/3/21
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>



<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<jsp:include page="../pages/bootstrap.html"/>


<html>
<head>
    <title>Title</title>


</head>
<body>


<jsp:include page="../pages/header.jsp"/>

<%
    if(session.getAttribute("role").equals("manager")){


%>

<div class="row">
    <div class="col" style="margin: 20px">
        <html:form styleClass="row g-3" action="addEmployee.do" >
            <label for="inputEmail4" class="form-label">first name </label>
            <html:text name="addEmployeeForm" property="firstname" styleClass="form-control" styleId="inputEmail4"/>
            <label for="inputPassword4" class="form-label">last name</label>
            <html:text name="addEmployeeForm" property="lastname" styleClass="form-control" styleId="inputPassword4"/>
            <label for="email" class="form-label">Email</label>
            <html:text name="addEmployeeForm" property="email" styleClass="form-control" styleId="email"/>
            <label for="inputAddress" class="form-label">birthday</label>
            <html:text name="addEmployeeForm" property="birthday" styleClass="form-control" styleId="inputAddress"/>
            <label for="EmployeeType" class="form-label">Employee Type</label>
            <html:select name="addEmployeeForm" property="role" styleClass="form-control" styleId="EmployeeType">
                <html:option value="manager"/>
                <html:option value="developer"/>
            </html:select>
            <html:submit/>
        </html:form>
    </div>
    <div class="col" style="margin: 20px" >
<%
    Manager manager=new Manager((String) session.getAttribute("id"));
    HashMap<String, HashMap<String,String>> emp=  manager.getMyEmployee();
%>
        <html:form styleClass="row g-3" action="AddTasksPage.do" >
            <label for="inputEmail4" class="form-label">taskName</label>
            <html:text name="addTaskForm" property="taskName" styleClass="form-control" styleId="inputEmail4"/>
            <label for="inputPassword4" class="form-label">hour</label>
            <html:text name="addTaskForm" property="hour" styleClass="form-control" styleId="inputPassword4"/>
            <label for="email" class="form-label">descraption</label>
            <html:text name="addTaskForm" property="descraption" styleClass="form-control" styleId="email"/>
            <label for="EmployeeType" class="form-label">Employee</label>
            <html:select name="addTaskForm" property="idEmployee" styleClass="form-control" styleId="EmployeeType">
                <%
                    for(Map.Entry<String, HashMap<String, String>> entry : emp.entrySet()) {
                        String key = entry.getKey();
                        HashMap value = entry.getValue();
                %>
                <html:option value="<%=key%>">
                <%=value.get("username")%></html:option>
                <%
                    }
                %>
            </html:select>


            <html:submit/>
        </html:form>
    </div>
</div>


<%}%>


</body>
</html>
