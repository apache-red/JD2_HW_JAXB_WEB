<%--
  Created by IntelliJ IDEA.
  User: RED
  Date: 14.03.2019
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <li><a href="/jsp/AddNewsPage.jsp">Add News </a></li>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="all_news_command"/>
    <input type="submit" value="show all news"/>
  </form>
  Create News:
  <form action="controller" method="post">
    <input type="hidden" name="command" value="add_news_command"/>
    <input type="text" name="title" /><br>
    <input type="text" name="director" /><br>
    <input type="date" name="date"/><br>
    <input type="text" name="news_body" /><br>
    <input type="submit" value="add news"/>
  </form>
  </body>
</html>
