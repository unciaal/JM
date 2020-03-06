<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 05.03.2020
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users room</title>
</head>
<body>
<hr>


<form:form action="/userHome"
           method = "GET">

    <input type="submit" value="User Home"/>

</form:form>
<hr>


<form:form action="/adminHome"
           method="GET">

    <input type="submit" value="Admin Home"/>

</form:form>
</body>
</html>
