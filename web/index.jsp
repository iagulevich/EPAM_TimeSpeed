<%@ page import="static support.constants.Constants.KMH" %>
<%@ page import="static support.constants.Constants.MPH" %>
<%@ page import="static support.constants.Constants.KN" %>
<%@ page import="static support.constants.Constants.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../style/css.css" >

<html>
<head>
    <title>Converter</title>
</head>
<body>

<%@include file="jsp/header.jsp" %>

<div class="general">
    <%--<c:if test="${error != null}">
        <p style="color: red">${error}</p>
    </c:if>--%>

    <form action="service" name="form">

        <%--<c:import url="input_values.txt"></c:import>--%>

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

</div>
</body>
</html>
