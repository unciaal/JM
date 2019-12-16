<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 11.12.2019
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>

<div style="text-align: center;">
    <h1>User Management</h1>
    <h2>
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>

    </h2>
</div>
<div align="center">
    <c:if test="${user != null}">
    <form action="edit" method="post">
        </c:if>
        <c:if test="${user == null}">
        <form action="new" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${user != null}">
                            Edit User
                        </c:if>
                        <c:if test="${user == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
                </c:if>
                <tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${user.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Surname:</th>
                    <td>
                        <input type="text" name="surname" size="45"
                               value="<c:out value='${user.surname}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Patronymic:</th>
                    <td>
                        <input type="text" name="patronymic" size="45"
                               value="<c:out value='${user.patronymic}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Age:</th>
                    <td>
                        <input type="text" name="age" size="45" placeholder="enter age"
                               value="<c:out value='${user.age}' />"
                        />
                    </td>
                </tr>
                <c:if test="${user != null}">
                    <tr>
                        <th>Car:</th>
                        <td>
                            <input type="text" name="car" size="45"
                                   value="<c:out value='${user.car}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Work:</th>
                        <td>
                            <input type="text" name="work" size="45"
                                   value="<c:out value='${user.work}' />"
                            />
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
