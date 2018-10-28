<%--
  Created by IntelliJ IDEA.
  User: WESt
  Date: 27.10.2018
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>
<form action="login" name="login_form" method="get" style="text-align: center">
    <input type="text" name="login" value="" placeholder="login">
    <input type="password" name="password" value="" placeholder="password">
    <input type="submit" value="log in">
</form>
</body>
</html>
