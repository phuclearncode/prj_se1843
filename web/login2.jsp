<%-- 
    Document   : login2
    Created on : Jan 19, 2024, 10:41:51 AM
    Author     : phuonglh
--%>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h2>Login form</h2>
        <%--
        <%
            String error = request.getParameter("error");
            if (error != null && error.equals("1")){
        %>
        <h3 style="color: red">Username and/or password is not correct.</h3>
        <%
            }
        %>
        --%>
        <%
            String error = (String)request.getAttribute("err");
            Student s = (Student) request.getAttribute("student");
            if (error != null){
        %>
        <h3 style="color: red"><%= error %></h3>
        <h3 style="color: blue"><%= s %></h3>
        <%
            }
        %>
        <form action="login2" method="get">
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/><br/>
            <input type="submit" value="Login"/>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>
