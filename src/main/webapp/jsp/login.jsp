<%--
  Created by IntelliJ IDEA.
  User: WESt
  Date: 27.10.2018
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<!-- вывод ошибки при пом. скриплета -->
<% if (request.getParameter("error") != null) %>
    <p style="color: red">${error}</p>

<!-- вывод ошибки при  пом. jstl -->
<%--<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>--%>
<form action="log" name="login_form" method="get" style="text-align: center">
    <input type="text" name="login" value="" placeholder="login">
    <input type="password" name="password" value="" placeholder="password">
    <input type="submit" value="log in">
</form>
</body>
</html>
