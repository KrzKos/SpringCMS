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
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="category" method="post">
        Nazwa: <form:input path="name" />
        Opis: <form:input path="description" />
        <button type="submit">Zapisz</button>
    </form:form>
</body>
</html>
