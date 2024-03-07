<%-- 
    Document   : listCategory
    Created on : Feb 20, 2024, 7:44:57 AM
    Author     : phuonglh
--%>

<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id){
                if (confirm("Are you sure to delete category with id = " + id + "?")){
                    window.location = "deleteCategory?id=" + id;
                }
            }
        </script>
            
    </head>
    <body>
        <h1>List of categories</h1>
        <%
            ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
            if (list==null || list.size()==0){
                out.println("Empty list. <br/>");
            }
            else {
            %>
            <table border="1px solid" style="border-collapse: collapse">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            <%
                for (Category c:list){
                %>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><a href="<%=request.getContextPath()%>/listProduct?cid=<%=c.getId()%>"><%=c.getName()%></a>
                    </td>
                    <td>
                        <a href="<%=request.getContextPath()%>/editCategory?id=<%=c.getId()%>">Edit</a> &nbsp;
                        <a href="#" onclick="doDelete('<%=c.getId()%>')">Delete</a>
                    </td>
                </tr>
                <%
                }
            %>
            </table><br/>
            <a href="<%=request.getContextPath()%>/AddCategory.jsp"><input type="submit" value="Add Category"/></a>
            <%
            }
        %>
    </body>
</html>
