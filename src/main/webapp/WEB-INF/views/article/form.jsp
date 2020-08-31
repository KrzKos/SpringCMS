<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form modelAttribute="article"  method="post">
        <form:hidden path="created"/>
        <form:hidden path="id"/>
        Tytuł: <form:input path="title"/><br>
        Treść: <form:textarea path="content"/><br>
        Autor:
        <form:select path="author.id">
<%--            <form:option value="0" label="-Wybierz-"/>--%>
            <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
        </form:select><br>
        Kategorie:
        <form:select path="categories" multiple="true">
            <form:options items="${categories}" itemLabel="name" itemValue="id"/>
        </form:select>
        <button type="submit">Zapisz</button>
    </form:form>
</body>
</html>
