<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/28/2023
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" action="addEmployee" modelAttribute="employee">
        <table>
            <tr>
                <td><form:label path="id">ID:</form:label></td>
                <td><form:input path="id"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="name">NAME:</form:label></td>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="contactNumber">CONTACT NUMBER:</form:label></td>
                <td><form:input path="contactNumber"></form:input></td>
            </tr>
            <tr>
                <input type="submit" value="submit">
            </tr>
        </table>
    </form:form>
</body>
</html>
