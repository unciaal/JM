<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.login}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.login}">
        <title>Edit</title>
    </c:if>
</head>
<body>
Изменим мир!
<a href="/">На главную</a>
<c:if test="${empty user.login}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.login}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.login}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Имя</label>
    <input type="text" name="name" id="name">
    <label for="login">Логин</label>
    <input type="text" name="login" id="login">
    <label for="password">Пароль</label>
    <input type="text" name="password" id="password">
    <label for="email">эл.адрес</label>
    <input type="text" name="email" id="email">
    <c:if test="${empty user.login}">
        <input type="submit" value="Добавить пользователя">
    </c:if>
    <c:if test="${!empty user.login}">
        <input type="submit" value="Изменить пользователя">
    </c:if>
</form>
</table>
</body>
</html>


