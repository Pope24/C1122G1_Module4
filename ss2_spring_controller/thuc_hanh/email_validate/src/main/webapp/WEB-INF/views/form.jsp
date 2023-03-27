<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/27/2023
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Email</title>
</head>
<body>
  <c:choose>
    <c:when test="${statusFalse != null}">
      <h3 style="color: red">${statusFalse}</h3>
    </c:when>
    <c:when test="${statusTrue != null}">
      <h3 style="color: green">${statusTrue}</h3>
    </c:when>
  </c:choose>
  <form action="validate" method="post">
    <input type="text" name="email">
    <input type="submit" value="Check email">
  </form>
</body>
</html>
