<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/27/2023
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calculate/result" method="post">
  <label>Amount USD</label>
  <input type="number" name="usd">
  <input type="submit" value="Calculate">
</form>
</body>
</html>
