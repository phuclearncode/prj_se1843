<%-- 
    Document   : EL
    Created on : Mar 1, 2024, 10:12:52 AM
    Author     : phuonglh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${5+2} <br/>
        ${5>2} <br/>
        <form>
            x1 = <input type="number" step="any" name="x1" value="${param.x1}"/> <br/> 
            x2 = <input type="number" step="any" name="x2" value="${param.x2}"/> <br/> 
            Phép tính: 
            <select name="op">
                <option value="+" ${param.op=="+"?"selected":""}>Add</option>
                <option value="-" ${param.op=="-"?"selected":""}>Subtract</option>
                <option value="*" ${param.op=="*"?"selected":""}>Multiply</option>
                <option value="/" ${param.op=="/"?"selected":""}>Divide</option>
            </select>
            <input type="submit" value="Calculate">
        </form><br/>
        Sum: ${param.x1} + ${param.x2} = ${param.x1 + param.x2} <br/>
        Result: ${param.op == "+" ? param.x1 + param.x2 : (
                  param.op == "-" ? param.x1 - param.x2 :(
                  param.op == "*" ? param.x1 * param.x2 :(
                  param.x2 != 0 ? param.x1 / param.x2 : "Divided by 0")))}<br/>
        Category: ${requestScope.category.result} <br/>
        ArrayList: ${requestScope.list.size()} categories<br/>
        Category 1: ${requestScope.list[0]} <br/>
        Category 2: ${requestScope.list[1]} <br/>
        Context init parameter: ${initParam.user1} <br/>
        
        <c:set var="x" value="10"/>
        x = ${x} <br/>
        <c:if test="${x<20}">
            x < 20 <br/>
        </c:if>
        <c:choose>
            <c:when test="x>20"> x>20 </c:when>
            <c:when test="x>10"> x>10 </c:when>
            <c:otherwise> x<=10 </c:otherwise>
        </c:choose><br/>
        <c:set var="cat" value="${requestScope.category}"/>
        Category: ${cat.id}<br/>
        <c:set var="list" value="${requestScope.list}"/>
        List co ${list.size()} phan tu. <br/>
        <c:forEach items="${list}" var="c">
            id = ${c.id}, name = ${c.name} <br/>
        </c:forEach>
        <c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
            Category ${i+1}: ${list[i].name} <br/>
        </c:forEach>
    </body>
</html>
