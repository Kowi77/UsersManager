<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Управление пользователями</title>
</head>
<body>
<h1>Cписок пользователей</h1>

<table class="table table-striped display" id="datatable">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Дата рождения</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Информация</th>
        <th>Адрес</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthday}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.info}</td>
            <td>${user.adress}</td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
