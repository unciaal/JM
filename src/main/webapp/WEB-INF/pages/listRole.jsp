<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Role List</title>
</head>
<body>
Роли!
<h2><a href="/adminHome">Список пользователей</a></h2>
<table>
    <tr>
        <th>№</th>
        <th>role</th>

        <th colspan="2">action</th>
    </tr>

    <c:forEach var="role" items="${roleList}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>
                <form:form action="/editRole" method="POST">
                    <input type="hidden" name="id" value="${role.id}">
                    <input type="text" name="role" value=${role.role}>
                    <input type="submit" value="Изменить"/>
                </form:form>
            </td>
            <td>
                <form:form action="/deleteRole" method="POST">
                    <input type="hidden" name="id" value="${role.id}">
                    <input type="submit" value="Удалить"/>
                </form:form>
            </td>
        </tr>

    </c:forEach>
</table>

    <form:form action="/addRole" method="POST">
        <input type="text" name="role" value=${role.role}>
        <input type="submit" value="Добавить"/>
    </form:form>
<hr>


<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Logout"/>

</form:form>

<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>
<hr>


</body>
</html>


