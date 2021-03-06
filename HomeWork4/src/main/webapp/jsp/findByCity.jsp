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
        <h1> Enter a city name to search </h1>
    </div>
    <form method="post" action="/findByCity">
        <label for="name"> City name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageFindByCityServlet}"/> <br>
        <input type="submit" value="Send">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2> You searched for a users by city: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
        <c:forEach items="${usersFromServerFindByCity}" var="user">
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
