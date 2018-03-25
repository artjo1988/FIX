<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 24.03.2018
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/signUp">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="birthDay"> Birth Date
            <input class="input-field" type="text" id="birthDay" name="birthDay">
        </label>
        <label for="password"> Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="city"> City
            <input class="input-field" type="text" id="city" name="city">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
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
