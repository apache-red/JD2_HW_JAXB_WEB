<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 15.03.2019
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Found result</h1>
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
