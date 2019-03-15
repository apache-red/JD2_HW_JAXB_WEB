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
  <h3>Show ALL News:</h3>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="all_news_command"/>
    <input type="submit" value="show all news"/>
  </form>
  <br>
  <h3>Create News:</h3>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="add_news_command"/>
    <input type="text" name="title" /><br>
    <input type="text" name="director" /><br>
    <input type="date" name="date"/><br>
    <input type="text" name="news_body" /><br>
    <input type="submit" value="add news"/>
  </form>
  <br>
  <h3>Find News:</h3>
  <h3>Enter search query or leave blank</h3>
  <form action="controller" method="post">
    <input type="hidden" name="command" value="find_news_command"/>
    <input type="text" name="title" /><br>
    <input type="text" name="director" /><br>
    <input type="date" name="date"/><br>
    <input type="text" name="news_body" /><br>
    <input type="submit" value="find news"/>
  </form>
  </body>
</html>
