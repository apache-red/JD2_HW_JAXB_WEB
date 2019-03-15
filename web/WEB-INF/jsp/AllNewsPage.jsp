<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 15.03.2019
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>News List</h1>
<table>
    <thead>
    <tr>
        <th>Test </th>
        <th>Table</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="subCategoryTypes" items="${SubCategories}">
        <td>${subCategoryTypes.id}</td>
        <tr>
            <c:forEach var="movieType" items="${subCategoryTypes.movie}">
                <td>${movieType.id}</td>
                <td>${movieType.title}</td>
                <td>${movieType.director}</td>
                <td>${movieType.dateOfIssue}</td>
                <td>${movieType.newsBody}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
<input type="button" value="<== Previous page" onclick="history.back()">
</body>
</html>
