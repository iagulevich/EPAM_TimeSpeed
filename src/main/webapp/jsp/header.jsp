<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<html>
<head>
    <title>header</title>
</head>
<body>

<div class="container">
    <div class="header-panel" >

            <c:choose>
                <c:when test="${user.login == null}">
                    <c:out value="USER: guest"/>
                </c:when>
                <c:otherwise>
                    <c:out value="USER: ${user.login}"/>
                </c:otherwise>
            </c:choose>

            <td><a href="${pageContext.request.contextPath}/jsp/login.jsp"
                   <c:if test="${not empty user.login}">hidden</c:if>>Login</a></td>
            <td><a href="${pageContext.request.contextPath}/jsp/registration.jsp"
                   <c:if test="${not empty user.login}">hidden</c:if>>Registration</a></td>
            <td><a href="${pageContext.request.contextPath}/logout"
                   <c:if test="${empty user.login}">hidden</c:if>>logout</a></td>
    </div>
</div>


</body>
</html>
