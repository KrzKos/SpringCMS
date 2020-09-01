<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 28/08/2020
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="category" method="post">
        <form:errors path="name" cssClass="error"/>
        Nazwa: <form:input path="name"/><br>
        <form:errors path="description" cssClass="error"/>
        Opis: <form:input path="description" /><br>
        <button type="submit">Zapisz</button>
    </form:form>
</body>
</html>
