<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h1> Enter the details for updating the user </h1>
    </div>
    <form method="post" action="/update">
        <label for="name"> New name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageUpdateServlet}"/>
        <label for="birthDay"> New birth date
            <input class="input-field" type="text" id="birthDay" name="birthDay">
        </label>
        <label for="city"> New city
            <input class="input-field" type="text" id="city" name="city">
        </label>
        <input type="submit" value="Send">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2> You have updated a user: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
        <c:forEach items="${usersFromServerUpdate}" var="user">
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