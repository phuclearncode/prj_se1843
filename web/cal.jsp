<%-- 
    Document   : cal
    Created on : Jan 19, 2024, 11:59:13 AM
    Author     : phuonglh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate JSP</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Calculate</h1>
        <%
            String xStr = request.getParameter("x");
            String yStr = request.getParameter("y");
            String op = request.getParameter("op");
        %>
        <form>
            x = <input type="number" step="any" name="x" value="<%=xStr%>"/><br/>
            y = <input type="number" step="any" name="y" value="<%=yStr%>"/><br/>
            Operator: 
            <input type="radio" name="op" value="+" <%= op==null?"checked":(op.equals("+")?"checked":"")%>/>Add
            <input type="radio" name="op" value="-" <%= op!=null && op.equals("-")?"checked":""%>/>Subtract
            <input type="radio" name="op" value="*" <%= op!=null && op.equals("*")?"checked":""%>/>Multiply
            <input type="radio" name="op" value="/" <%= op!=null && op.equals("/")?"checked":""%>/>Divide<br/><br/>
            <input type="submit" value="Calculate"/>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="Reset"/>
        </form><br/>
        <%
            if (xStr != null && yStr!=null && op != null){
                String result = "";
                try{
                    double x = Double.parseDouble(xStr);
                    double y = Double.parseDouble(yStr);
                    switch (op) {
                            case "+":
                                result = x + op + y + " = " + (x+y);
                                break;
                            case "-":
                                result = x + op + y + " = " + (x-y);
                                break;
                            case "*":
                                result = x + op + y + " = " + (x*y);
                                break;
                            case "/":
                                result = x + op + y + " = " + (x/y);
                                break;
                            default:
                                result = "Invalid operator.";
                        }
                }
                catch (Exception e){
                     result = "Invalid inputs.";
                }%>
                <h3 style="color: blue"><%= result %></h3>
                <%
            }
        %>
        <%@include file="footer.jsp" %>s
    </body>
</html>
