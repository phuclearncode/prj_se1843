<%-- 
    Document   : addStudent
    Created on : Jan 26, 2024, 10:15:57 AM
    Author     : phuonglh
--%>

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
            String id = (String)request.getAttribute("id");
            String name = (String)request.getAttribute("name");
            String age = (String)request.getAttribute("age");
            String address = (String)request.getAttribute("address");
        %>
        <form action="student" method="get">
            ID: <input type="number" name="id" value="<%=id%>"/> <br/><br/>
            Name: <input type="text" name="name" value="<%=name!=null?name:""%>"/> <br/><br/>
            Age: <input type="number" name="age" value="<%=age%>"/> <br/><br/>
            Address: <input type="text" name="address" value="<%=address!=null?address:""%>"/> <br/><br/>
            <input type="hidden" name="action" value="add"/>
            <input type="submit" value="Add Student"/> &nbsp;&nbsp;
            <input type="reset" value="Reset"/> <br/>
        </form>
    </body>
</html>
