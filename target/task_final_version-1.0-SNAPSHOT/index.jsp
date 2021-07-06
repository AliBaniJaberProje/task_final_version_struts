<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="pages/bootstrap.html"/>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>singIn</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<%
    pageContext.setAttribute("isFailed",request.getParameter("failed"));
    String error= (String) request.getAttribute("failed");
%>
<body style="background-image: url('img/bg.jpg');" >





<div class="bs-example" style="background-color: purple;height: 120px;">
    <nav class="nav justify-content-center">
        <a href="#" class="nav-item nav-link active" style="color: aliceblue;font-size: 25px ; margin-top: 30px">
            <h3>ARK Company </h3>
        </a>

    </nav>
</div>

<div style="height: 170px">

</div>
<%
    if(error!=null){
%>

<center>
    <div class="alert alert-danger" style="width: 300px">
        <strong>error !</strong> <%= error %>
    </div>
</center>

<%

    }%>
<center>
    <div >
        <div class="card" style="width: 300px;">
            <div class="nav justify-content-center" style="background-color: purple;height: 50px;width: 100%"> <h6 style="color: white; margin-top: 15px">SignIn</h6> </div>
            <div class="card-body text-center">
                <html:form action="home.do">

                    <div class="form-group">
                        <html:text name="authForm" property="email" styleClass="form-control" value="alijaber@gmail.com"   />

                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <div class="form-group">
                        <html:password name="authForm" property="password" title="password" styleClass="form-control" value="11223344" >

                        </html:password>
                        <div class="valid-feedback">Valid.</div>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>

                    <div style="height: 20px">

                    </div>
                    <html:submit value="singIn" styleClass="btn btn-success">

                    </html:submit>
                </html:form>
            </div>
        </div>
    </div>
</center>





</body>


</html>
