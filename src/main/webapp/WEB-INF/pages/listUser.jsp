<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
Привет мир!
<a href="/edit">Изменить данные</a>
<table>
    <caption>Users</caption>
    <tr>
        <th>№</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th colspan="2">action</th>
    </tr>
    <c:forEach var="user" items="${userList}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td><a href="<c:url value="/edit/${user.id}"/>">Изменить</a></td>
            <td><a href="<c:url value="/delete/${user.id}"/>">Удалить</a></td>
        </tr>
    </c:forEach>
</table>

<c:url value="/add" var="add"/>
<a href="${add}">Добавить пользователя</a>
</body>
</html>


