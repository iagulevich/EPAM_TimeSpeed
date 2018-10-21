<%@ page import="support.constants.Constants" %>
<%@ page import="static support.constants.Constants.KMH" %>
<%@ page import="static support.constants.Constants.MPH" %>
<%@ page import="static support.constants.Constants.KN" %>
<%@ page import="static support.constants.Constants.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Converter</title>
</head>
<body>

<%@include file="header.jsp" %>
<hr>
<form action="service" name="form">

    <!-- <pre> <c:import url="input_values.txt"></c:import> </pre> -->

    <input type="text" value="${field}" name="field">

    <select name="selectFrom">
        <option value="<%=KMH%>"><%=KMH%>
        </option>
        <option value="<%=MPH%>"><%=MPH%>
        </option>
        <option value="<%=KN%>"><%=KN%>
        </option>
        <option value="<%=MS%>"><%=MS%>
        </option>
    </select>
    to
    <select name="selectTo">
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
    <input type="hidden" name="resultValue" value="" style="width: 500px">
</form>


<!-- br>
<form action="exception" name="exceptionText">
    <center><input type="text" value="rr" name=""></center>
</form>
${result} -->

</body>
</html>
