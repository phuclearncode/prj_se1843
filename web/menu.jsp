<%-- 
    Document   : menu
    Created on : Jan 23, 2024, 8:52:58 AM
    Author     : phuonglh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/myStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menu">
            <a href="<%=request.getContextPath()%>/login2.jsp">Login</a> 
            <a href="<%=request.getContextPath()%>/cal.jsp">Calculate</a> 
            <a href="<%=request.getContextPath()%>/main.jsp">Main</a> 
            <a href="<%=request.getContextPath()%>/student">Students</a> 
            <a href="<%=request.getContextPath()%>/listCategory">Categories</a> 
        </div>
    </body>
</html>
