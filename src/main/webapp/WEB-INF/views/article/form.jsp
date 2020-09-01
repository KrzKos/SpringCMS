<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form modelAttribute="article"  method="post">
        <form:hidden path="created"/>
        <form:hidden path="id"/>
        <form:errors path="title" cssClass="error" />
        Tytuł: <form:input path="title"/><br>
        <form:errors path="content" cssClass="error"/>
        Treść: <form:textarea path="content"/><br>
        <form:errors path="author" cssClass="error"/>
        Autor:
        <form:select path="author.id">
            <form:option value="0" label="-Wybierz-"/>
            <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
        </form:select><br>
        <form:errors path="categories" cssClass="error"/>
        Kategorie:
        <form:select path="categories" multiple="true">
            <form:options items="${categories}" itemLabel="name" itemValue="id"/>
        </form:select>
        <br>
        <button type="submit">Zapisz</button>
    </form:form>
</body>
</html>
