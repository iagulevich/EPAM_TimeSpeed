<%@ page import="support.constants.Constants" %>
<%@ page import="static support.constants.Constants.KMH" %>
<%@ page import="static support.constants.Constants.MPH" %>
<%@ page import="static support.constants.Constants.KN" %>
<%@ page import="static support.constants.Constants.*" %><%--
  Created by IntelliJ IDEA.
  User: WESt
  Date: 14.10.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Converter</title>
</head>
<body>

<form action="service" name="form">

    <!-- <pre> <c:import url="input_values.txt"></c:import> </pre> -->

    <input type="text" value="${field}" name="field">

    <select name="select">
        <option value="<%=KMH%>"><%=KMH%>
        </option>
        <option value="<%=MPH%>"><%=MPH%>
        </option>
        <option value="<%=KN%>"><%=KN%>
        </option>
        <option value="<%=MS%>"><%=MS%>
        </option>
    </select>

    <input type="submit" name="submit" value="convertion">
    <input type="text" value="${resultValue}" name="output_field">

</form>

<form name="otput">
    <input type="hidden" name="resultValue" value="">
</form>

<br>
<form action="exception" name="exceptionText">
    <center><input type="text" value="rr" name=""></center>
</form>
<!-- ${result} -->

</body>
</html>
