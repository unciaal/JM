<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 21.02.2020
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Домашняя</title>
</head>
<body>
    <hr>
    <p>
        Добро пожаловать домой!
    </p>

    <hr>

    <p>
        User: <security:authentication property="principal.username"/>
        <br><br>
        Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

        <input type="submit" value="Logout"/>

    </form:form>




</body>
</html>
