<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 28/08/2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Artykuły</title>
</head>
<body>
<a href="/article/form">Dodaj +</a>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Tytuł</td>
            <td>Dodano</td>
            <td>Treść</td>
            <td>Akcja</td>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.title}</td>
                <td>${article.created}</td>
                <td width="300px">${article.content}</td>
                <td><a href="/article/edit/${article.id}"> Edytuj </a> | <a href="/article/delete/${article.id}"> Usuń</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
