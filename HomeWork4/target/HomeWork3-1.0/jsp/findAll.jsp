<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 21.04.2018
  Time: 8:59
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
        <h2> All users found: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
        <c:forEach items="${usersFromServerFindAll}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDay}</td>
                <td>${user.city}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
