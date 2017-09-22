<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Управление пользователями</title>
    <%--<base href="${pageContext.request.contextPath}/"/>--%>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.15/media/css/dataTables.bootstrap.min.css">

    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="../../resources/userUtils.js" defer></script>
</head>
<body>

<h1>Cписок пользователей</h1>

<a class="btn btn-primary" onclick="add()">
    <span class="glyphicon glyphicon-plus" aria-hidden="true">  ДОБАВИТЬ</span>
</a>
<div class="jumbotron">
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
        <tbody></tbody>
        <%--<c:forEach items="${users}" var="user">
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
        </c:forEach>--%>
    </table>
</div>

<%--Form for add/edit user--%>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title" id="modalTitle"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="firstName" class="control-label col-xs-3">Имя</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="firstName" name="firstName"
                                   placeholder="${user.firstName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="control-label col-xs-3">Фамилия</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="lastName" name="lastName"
                                   placeholder="${user.lastName}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="birthday" class="control-label col-xs-3">День рождения</label>
                        <div class="col-xs-9">
                            <input type="date" class="form-control" id="birthday" name="birthday" placeholder="${user.birthday}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="login" class="control-label col-xs-3">Логин</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="login" name="login"
                                   placeholder="${user.login}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3">Пароль</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="password" name="password"
                                   placeholder="${user.password}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="info" class="control-label col-xs-3">Информация</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="info" name="info"
                                   placeholder="${user.info}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adress" class="control-label col-xs-3">Адрес</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="adress" name="adress"
                                   placeholder="${user.adress}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button class="btn btn-primary" type="button" onclick="save()">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
