<%-- 
    Document   : listStudents
    Created on : Jan 23, 2024, 9:33:16 AM
    Author     : phuonglh
--%>

<%@page import="model.Student"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function doDelete(id){
                if (confirm("Are you sure to delete student with id = " + id +"?")){
                    window.location = "student?action=delete&id="+id;
                }
            }
        </script>
    </head>
    <body>
        <%
            Map<Integer,Student> listStudents = (Map<Integer,Student>)request.getAttribute("list");
            if (listStudents==null || listStudents.size()==0){
                out.println("Empty list of students.<br/>");
            }
            else {
            %>
            <h1>List of students</h1>
            <table border="1px solid black">
                <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
                <td>Address</td>
                <td>Action</td>
                </tr>
                <%
                    for (int id:listStudents.keySet()){
                        Student s = listStudents.get(id);
                        %>
                        <tr>
                            <td><%=id%></td>
                            <td><%=s.getName()%></td>
                            <td><%=s.getAge()%></td>
                            <td><%=s.getAddress()%></td>
                            <td>
                                <a href="student?action=edit&id=<%=id%>">Edit</a> &nbsp; &nbsp; 
                                <a href="#" onclick="doDelete('<%=id%>')">Delete</a>
                            </td>
                        </tr>
                        <%
                    }
                %>
            </table>
            <%
            }
        %><br/>
        <a href="addStudent.jsp"><input type="submit" value="Add Student"/></a>
    </body>
</html>
