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
    <title>Form Email Configuration</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
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
            <td><form:label path="language" cssClass="fw-bold">Language</form:label></td>
            <td><form:select path="language">
                <option value="English">English</option>
                <option value="Vietnamese">Vietnamese</option>
                <option value="Japanese">Japanese</option>
                <option value="Chinese">Chinese</option>
            </form:select></td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize" cssClass="fw-bold">Page size</form:label>
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
            <td>
                <form:label path="spamsFilter" cssClass="fw-bold">Spams filter</form:label>
            </td>
            <td>
                <form:checkbox path="spamsFilter"/>
                <span> Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signature" cssClass="fw-bold">Signature</form:label>
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" class="btn btn-info" value="Update"></td>
            <td><input type="button" class="btn btn-dark" onclick="window.location.href='version-current'"
                       value="Check version"></td>
        </tr>
    </table>
</form:form>
<div style="color: red">
    <c:if test="${versionUpdateLatest != null}">
        <h3>Version Update Email configuration latest</h3>
        <h4>Language: ${versionUpdateLatest.language}</h4>
        <h4>Page size: ${versionUpdateLatest.pageSize}</h4>
    </c:if>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</html>
