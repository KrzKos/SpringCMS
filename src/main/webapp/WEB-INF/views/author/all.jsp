<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 29/08/2020
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/author/form">Dodaj +</a>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Imię</td>
            <td>Nazwisko</td>
            <td>Akcja</td>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.id}</td>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td><a href="/author/edit/${author.id}">Edytuj</a> | <a href="/author/delete/${author.id}">Usuń</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
