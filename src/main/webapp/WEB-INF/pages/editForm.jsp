<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
<c:if test="${empty user.login}">
    <c:url value="/add" var="var"/>
    <c:set value="Добавить пользователя" var="Headline"/>
</c:if>
<c:if test="${!empty user.login}">
    <c:url value="/edit" var="var"/>
    <c:set value="Изменить пользователя" var="Headline"/>
</c:if>
<%--<form action="${var}" method="POST">
    <c:if test="${!empty user.login}">
        &lt;%&ndash;@declare id="roles"&ndash;%&gt;<input type="hidden" name="id" value="${user.id}">
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

        <c:forEach var="role" items="${roles}">
              <c:out value="${role.role}"></c:out>
                        <input type="checkbox" name="selectRole" value="${role.id}" />
        </c:forEach>




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

</table>&ndash;%&gt;--%>

        <sf:form action="${var}" method="POST" modelAttribute="user">
    <fieldset>
        <h1>${Headline}</h1>
        <sf:input type="hidden" name="id" value="${user.id}" path="id"/>
        <table>
            <tr>
                <td>Name <sf:input path="name" value="${user.name}" required="required"/></td>
                <td>Login <sf:input path="login" value="${user.login}" required="required"/></td>
                <td>Password <sf:password path="password" showPassword="false"/></td>
                <td>Email <sf:input path="email" value="${user.email}" required="required"/></td>
                <td>Role<sf:checkboxes items = "${troles}" path = "strIdRoles" itemValue="id"/></td>

            </tr>
            <tr>
                <h2><td><input type="submit" value="Сохранить"></td>
                </h2>
            </tr>
        </table>
    </fieldset>
</sf:form>
</body>
</html>


