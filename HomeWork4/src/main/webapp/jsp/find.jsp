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
        <h1> Enter a name to search for a user </h1>
    </div>
    <form method="post" action="/find">
        <label for="name"> User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <c:out value="${messageFindServlet}"/> <br>
        <input type="submit" value="Send">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h2> You searched for a user: </h2>
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
            <th>City</th>
        </tr>
            <tr>
                <td><c:out value="${usersFromServerFind.name}" /> </td>
                <td><c:out value="${usersFromServerFind.birthDay}" /> </td>
                <td><c:out value="${usersFromServerFind.city}" /> </td>
            </tr>
    </table>
</div>
</body>
</html>
