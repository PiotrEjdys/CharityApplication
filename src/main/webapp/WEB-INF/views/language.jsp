<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 10.08.2021
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <select name="language">
        <option value="pl"><fmt:message key="label.plLang"/></option>
        <option value="en"><fmt:message key="label.enLang"/></option>
    </select>
    <input type="submit" value="click">
</form>
</body>
</html>
