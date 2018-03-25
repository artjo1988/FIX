
<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 25.03.2018
  Time: 17:00
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
<%--Цвет текста берем из значения куки color --%>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <span style="color: ${cookie.color.value}"> <h1> Hello Friend from <c:out value="${cookie.city.value}" /> </h1>
</span>
    </div>
<form method="post" action="/home">
    <label for="color">
        <select name="color" id="color">
            <option value="red">Красный</option>
            <option value="black">Черный</option>
            <option value="blue">Синий</option>
            <option value="white">Белый</option>
        </select>
    </label>
    <input type="submit" value="Color send">
</form>
</div>
</body>
</html>
