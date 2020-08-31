<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 28/08/2020
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Tytuł</td>
            <td>Data dodania</td>
            <td>Treść</td>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.created}</td>
                <td>${article.content}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
