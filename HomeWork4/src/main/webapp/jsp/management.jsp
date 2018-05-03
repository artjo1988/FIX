<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 20.04.2018
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <h1>Please choose an action from the CRUDE</h1>
    </div>
    <form method="post" action="/management">
        <label>
            <select name="crud">
                <option value="create">To create a user account</option>
                <option value="delete">To remove a user account</option>
                <option value="update">To update the user account</option>
                <option value="find">Find the user account</option>
                <option value="findAll">Find all users</option>
                <option value="findByCity">Find users by city</option>
            </select>
        </label>
        <input type="submit" value="Send">
    </form>
</div>
</body>
</html>
