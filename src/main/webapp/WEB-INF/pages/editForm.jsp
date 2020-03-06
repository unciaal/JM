<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
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
        <%--@declare id="roles"--%><input type="hidden" name="id" value="${user.id}">
    </c:if>

    <label for="name">Имя</label>
    <input type="text" name="name" id="name" value="${user.name}">
    <label for="login">Логин</label>
    <input type="text" name="login" required id="login"value="${user.login}">
    <label for="password">Пароль</label>
    <input type="text" name="password" id="password" value="">
    <label for="email">эл.адрес</label>
    <input type="text" name="email" id="email" value="${user.email}">
    <label for="roles">роль</label>
    <select name="role">
        <c:forEach var="item" items="${roles}">
            <option name = "role" value="${item.id}" >${item.role}</option>
        </c:forEach>
    </select>

    <c:if test="${empty user.login}">
        <input type="submit" value="Добавить пользователя">
    </c:if>
    <c:if test="${!empty user.login}">
        <input type="submit" value="Изменить пользователя">
    </c:if>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>

</table>
</body>
</html>


