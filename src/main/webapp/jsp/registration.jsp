<%--
  Created by IntelliJ IDEA.
  User: WESt
  Date: 28.10.2018
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>
<form action="registration" name="registr" method="get" style="text-align: center" >

    <input type="text" name="name" value="" placeholder="name">
    <input type="text" name="login" value="" placeholder="login">
    <input type="text" name="password" value="" placeholder="password">
    <input type="submit" value="registration">

</form>

</body>
</html>
