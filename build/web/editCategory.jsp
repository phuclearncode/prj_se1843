<%-- 
    Document   : AddCategory
    Created on : Feb 20, 2024, 9:30:17 AM
    Author     : phuonglh
--%>

<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit category</h1>
        <p style="color: red">
            <%
                String error = (String)request.getAttribute("error");
                if (error != null){
                    out.println(error + "<br/>");
                }
                Category c  = (Category)request.getAttribute("category");
            %>
        </p>
        <form action="<%=request.getContextPath()%>/editCategory" method="post">
            ID: <input type="number" readonly name="id" value="<%=c!=null?c.getId():""%>"/><br/>
            Name: <input type="text" name="name" value="<%=c!=null?c.getName():""%>"/><br/><br/>
            <input type="submit" value="Update Category"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
