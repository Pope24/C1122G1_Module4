<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/29/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Version Current</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<body>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <td colspan="2">Version Current Email Configuration</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Language</td>
        <td>${versionUpdateLatest.language}</td>
    </tr>
    <tr>
        <td>Page Size</td>
        <td>${versionUpdateLatest.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter</td>
        <td>${versionUpdateLatest.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>${versionUpdateLatest.signature}</td>
    </tr>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"></script>
</html>
