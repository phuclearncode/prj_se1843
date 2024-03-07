<%-- 
    Document   : includePage
    Created on : Jan 23, 2024, 8:09:04 AM
    Author     : phuonglh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Đây là trang include</h1><br/>
        <%= request.getParameter("name") %> <br/>
        <%@include file="footer.jsp" %>
    </body>
</html>
