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
        <h1> Enter the details for creating the user </h1>
    </div>
    <form method="post" action="/create">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageCreateServlet}"  /> <br>
        <label for="password"> Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="birthDay"> Birth Date
            <input class="input-field" type="text" id="birthDay" name="birthDay">
        </label>
        <label for="city"> City
            <input class="input-field" type="text" id="city" name="city">
        </label>
        <input type="submit" value="Send">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2> You have created a user: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
        <tr>
                <td> <c:out value="${usersFromServerCreate.name}" /> </td>
                <td> <c:out value="${usersFromServerCreate.birthDay}" /> </td>
                <td> <c:out value="${usersFromServerCreate.city}" /> </td>
        </tr>
    </table>
</div>
</body>
</html>
