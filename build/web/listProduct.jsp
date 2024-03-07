<%-- 
    Document   : listProduct
    Created on : Mar 5, 2024, 9:03:53 AM
    Author     : phuonglh
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List Of Products</h1>
        <c:set var="listPro" value="${requestScope.listPro}"/>
        <c:set var="listCat" value="${requestScope.listCat}"/>
        <form id='f' action="listProduct">
            Category: 
            <select name="cid" onchange="document.getElementById('f').submit()">
                <option value="0">All Categories</option>
                <c:forEach items="${listCat.keySet()}" var = "catId">
                    <option value="${catId}" ${catId==requestScope.cid?"selected":""}>${listCat[catId].name}</option>
                </c:forEach>
            </select>
        </form>
        <c:choose>
            <c:when test="${empty listPro}">
                Empty list of products. <br/>
            </c:when>
            <c:otherwise>
                <table border="1px solid">
                    <tr>
                        <td>ProductCode</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>StockQuantity</td>
                        <td>StartDate</td>
                        <td>Category's name</td>
                        <td>Image</td>
                    </tr>
                    <c:forEach items="${listPro}" var="p">
                    <tr>
                        <td>${p.productCode}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.stockQuantity}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.startDate}"/>             </td>
                        <td>${listCat[p.categoryId].name}</td>
                        <td>
                            <img src="${p.image}" width="80px" height="50px"/>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
        <br/>
        10/3 = <fmt:formatNumber pattern=".##" value="${10/3}"/><br/> 
        <c:set var="str" value="Welcome to prj301"/>
        <c:if test="${fn:containsIgnoreCase(str,'PRJ301')}">
            Found PRJ301 
        </c:if>
    </body>
</html>
