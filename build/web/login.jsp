<%-- 
    Document   : login
    Created on : Jan 12, 2024, 11:53:33 AM
    Author     : phuonglh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"  errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%!
        int z = 20;
        public int sum(int x, int y){
            return (x+y);
        }
    %>
    <body>
        <h2>Login form</h2>
        <form action="second" method="post">
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/><br/>
            <input type="submit" value="Login"/>
        </form>
        <%
            int x = 10;
            x = x+10;
            z++;
            out.println("x=" + x + "<br/>");
            out.println("z=" + z + "<br/>");
            int y=0;
            try{
                y = Integer.parseInt(request.getParameter("y"));
            }
            catch(Exception e){
                y = 0;
            }
            out.println("x + y=" + (x+y) + "<br/>");
            out.println("z=" + z + "<br/>");
            out.println("z + x = " + sum(x,z) + "<br/>");
        %>
        Gia tri cua x = <%= x %><br/>
        <!-- comment html 
            Gia tri cua x = <%= x %>
        <%
            x = x+2;
            out.println(x);
        %>
        -->
        Gia tri cua x = <%= x %> <br/>
        <%-- comment jsp
            <%
            x = x+2;
            out.println(x);
            %>
            Gia tri cua x = <%= x %>
        --%>
        Gia tri cua x = <%= x %>
    </body>
</html>
