<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/27/2023
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form id="calculator" method="post">
    <div style="display: flex">
        <input type="text" name="numberOne" placeholder="Nhap so thu nhat">
        <input type="text" name="numberTwo" placeholder="Nhap so thu hai">
    </div>
    <div style="display: flex">
        <input type="submit" formaction="add" value="(+) Addition">
        <input type="submit" formaction="subtract" value="(-) Subtraction">
        <input type="submit" formaction="multiple" value="(*) Multiplication">
        <input type="submit" formaction="divide" value="(/) Division">
    </div>
</form>
<c:if test="${messageError != null}">
    <h3 style="color: red">${messageError}</h3>
</c:if>
<c:if test="${messageError == null && result != null}">
    <h3 style="color:forestgreen;">Result: ${result}</h3>
</c:if>
</body>
</html>
