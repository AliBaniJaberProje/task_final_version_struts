<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ali_jaber
  Date: 7/3/21
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="../pages/bootstrap.html"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>team</title>
</head>
<body>
<jsp:include page="../pages/header.jsp"/>

<div class="container-fluid">
    <div class="row">
<%
    HashMap<String,HashMap<String,String>> hashMapHashMap= (HashMap<String, HashMap<String, String>>) request.getAttribute("myTeam");

    for(Map.Entry<String, HashMap<String, String>> entry : hashMapHashMap.entrySet()) {
        String key = entry.getKey();
        HashMap value = entry.getValue();
        %>
        <div class="card" style="width:200px; margin-left: 20px ; margin-top: 20px">
            <img class="card-img-top  "style="height: 150px" src="<%=value.get("img")%>" alt="Card image">
            <div class="card-body">
                <h4 class="card-title"><%=value.get("username")%></h4>
                <p class="card-title"><%=value.get("email")%></p>
                <p class="card-text"><%=value.get("role")%></p>
            </div>
        </div>
<%
    }
%>
    </div>
</div>


<h1> </h1>


</body>
</html>
