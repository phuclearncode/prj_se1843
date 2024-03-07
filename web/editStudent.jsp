<%-- 
    Document   : addStudent
    Created on : Jan 26, 2024, 10:15:57 AM
    Author     : phuonglh
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Input information for a new student</h1>
        <%
            ArrayList<String> error = (ArrayList<String>)request.getAttribute("error");
            if (error !=null){
            for (String s : error){
        %>
        <p style="color: red"><%=s%></p>
        <%
            }
            }
            Student s = (Student)request.getAttribute("student");
        %>
        <form action="student" method="get">
            ID: <input type="number" name="id1" value="<%=s.getId()%>" disabled/> <br/><br/>
            Name: <input type="text" name="name" value="<%=s.getName()%>"/> <br/><br/>
            Age: <input type="number" name="age" value="<%=s.getAge()%>"/> <br/><br/>
            Address: <input type="text" name="address" value="<%=s.getAddress()%>"/> <br/><br/>
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<%=s.getId()%>"/>
            <input type="submit" value="Update Student"/> &nbsp;&nbsp;
            <input type="reset" value="Reset"/> <br/>
        </form>
    </body>
</html>
