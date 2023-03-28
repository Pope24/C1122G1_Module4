<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/28/2023
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Configuration</title>
</head>
<style>
    tr {
        height: 40px;
    }
</style>
<body>
    <h2 style="font-weight: bold">Setting</h2>
<form:form action="email-configuration" modelAttribute="emailConfiguration">
    <table>
        <tr>
            <td><form:label path="language" cssStyle="font-weight: bold">Language</form:label></td>
            <td><form:select path="language">
                <option value="English">English</option>
                <option value="Vietnamese">Vietnamese</option>
                <option value="Japanese">Japanese</option>
                <option value="Chinese">Chinese</option>
            </form:select></td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize" cssStyle="font-weight: bold">Page size</form:label>
            </td>
            <td>
                <span>Show </span>
                <form:select path="pageSize">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </form:select>
                <span> emails per page</span>
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold">Spams filter</td>
            <td>
                <form:checkbox path="spamsFilter"/>
                <span> Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td style="font-weight: bold">Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Update" style="background: #146ce0; color: #fff"></td>
            <td><input type="button" value="Cancel"></td>
        </tr>
    </table>
</form:form>
<div style="color: red">
    <c:if test="${versionUpdateLatest != null}">
        <h2>Version Update Email configuration latest</h2>
        <h3>Language: ${versionUpdateLatest.language}</h3>
        <h3>Page size: ${versionUpdateLatest.pageSize}</h3>
        <h3>Spams filter: ${versionUpdateLatest.spamsFilter}</h3>
        <h3>Signature: ${versionUpdateLatest.signature}</h3>
    </c:if>
</div>
</body>
</html>
