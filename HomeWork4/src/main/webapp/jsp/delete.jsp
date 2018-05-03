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
        <h1> Enter data to delete the user </h1>
    </div>
    <form method="post" action="/delete">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageDeleteServlet}"  /> <br>
        <input type="submit" value="Send">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2> You deleted the user: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
            <tr>
                <td> <c:out value="${usersFromServerDelete.name}" /> </td>
                <td> <c:out value="${usersFromServerDelete.birthDay}" /> </td>
                <td> <c:out value="${usersFromServerDelete.city}" /> </td>
            </tr>
    </table>
</div>
</body>
</html>
