<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
Привет мир!
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
            <td>${user.roles}</td>
            <td><a href="<c:url value="/edit/${user.id}"/>">Изменить</a></td>
            <td><a href="<c:url value="/delete/${user.id}"/>">Удалить</a></td>
        </tr>

    </c:forEach>
</table>

<c:url value="/add" var="add"/>
<a href="${add}">Добавить пользователя</a>
<br>
<c:url value="/listRole" var="listRole"/>
<a href="${listRole}">Список ролей</a>
<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>

<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Logout" />

</form:form>
<form:form action="/userHome" method="GET">

    <input type="submit" value="Домашняя пользователя" />

</form:form>
<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}" />
<hr>


</body>
</html>


