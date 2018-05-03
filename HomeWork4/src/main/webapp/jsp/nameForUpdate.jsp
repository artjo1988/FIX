<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 02.05.2018
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h1> Enter the name of the user you want to change </h1>
    </div>
    <form method="post" action="/nameForUpdate">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageNameForUpdateServlet}"/> <br>
        <input type="submit" value="Send">
    </form>
</div>
</body>
</html>
