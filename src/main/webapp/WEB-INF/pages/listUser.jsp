<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User List</title>
</head>
<body>

<p>
    Пользователь: <security:authentication property="principal.username"/>
    <br><br>
    Роль(и): <security:authentication property="principal.authorities"/>
</p>
<hr>
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
            <td>
                <form:form action="/edit/${user.id}" method="GET">

                    <input type="submit" value="Изменить"/>
                </form:form>
            </td>
            <td>
                <form:form action="/delete/${user.id}" method="GET">

                    <input type="submit" value="Удалить"/>
                </form:form>
            </td>
        </tr>

    </c:forEach>
</table>
<hr>
<c:url value="/add" var="add"/>
<form:form action="${add}" method="GET">
    <input type="submit" value="Добавить пользователя"/>
</form:form>


<c:url value="/listRole" var="listRole"/>
<form:form action="${listRole}" method="GET">
    <input type="submit" value="Список ролей"/>
</form:form>
<hr>


<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Выйти"/>

</form:form>
<form:form action="/home" method="GET">

    <input type="submit" value="Публичная страница"/>

</form:form>
<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>
<hr>


</body>
</html>


