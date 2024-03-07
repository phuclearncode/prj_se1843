<%-- 
    Document   : main
    Created on : Jan 23, 2024, 8:10:00 AM
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
        <h1>Đây là trang main</h1>
        Dùng @include <br/>
        <%
            String address = "Ha Noi";
        %>
        <%@include file="includePage.jsp" %><br/>
        Dùng jsp:include <br/>
        <%--<jsp:include page="includePage.jsp" />--%>
        Forward <br/>
        <jsp:forward page="includePage.jsp"/>
        <%@include file="footer.jsp" %>
    </body>
</html>
