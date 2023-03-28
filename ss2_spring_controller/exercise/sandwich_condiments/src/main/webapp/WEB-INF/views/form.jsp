<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/27/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<form action="save" method="post">
  <input type="checkbox" name="condiments" value="Lettuce"><label>Lettuce</label>
  <input type="checkbox" name="condiments" value="Tomato"><label>Tomato</label>
  <input type="checkbox" name="condiments" value="Mustard"><label>Mustard</label>
  <input type="checkbox" name="condiments" value="Sprouts"><label>Sprouts</label>
  <input type="submit" value="Save">
</form>
<c:if test="${condiments != null}">
  <h3>Result:
    <c:forEach items="${condiments}" var="condiment">
      <span>${condiment}</span>
    </c:forEach>
  </h3>
</c:if>
</body>
</html>
