<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="author" method="post">
        <form:hidden path="id"/>
        Imię: <form:input path="firstName"/><br>
        Nazwisko: <form:input path="lastName" /><br>
        <button type="submit">Zapisz</button>
    </form:form>
</body>
</html>