<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 28/08/2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            border: 0px solid;
        }
        td {
            border-right: 1px solid;
        }
        tr.bottomLine td{
            border-bottom: solid 2px;
            font-weight: bold;
        }
    </style>
    <title>Category</title>
</head>
<body>
<a href="/category/form">Dodaj +</a>
    <table>
        <tr class="bottomLine">
            <td>Id</td>
            <td>Nazwa</td>
            <td>Opis</td>
            <td>Akcja</td>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td><a href="/category/edit/${category.id}">Edytuj</a> | <a href="/category/delete/${category.id}">Usuń</a> </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
