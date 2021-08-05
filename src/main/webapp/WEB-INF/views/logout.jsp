<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <%--          <li><a href="#">Zaloguj</a></li>--%>
            <%--          <li class="highlighted"><a href="#">Załóż konto</a></li>--%>
        </ul>

        <ul>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/#steps"/>" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="<c:url value="/#about-us"/>" class="btn btn--without-border">O nas</a></li>
            <li><a href="<c:url value="/#help"/>" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="<c:url value="/#contact"/>" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Wyloguj się</h2>

    <form action="<c:url value="/logout"/>" method="post">
        <div class="form-group">
            <input class="fa fa-id-badge" type="submit" value="Wyloguj">
        </div>
        <div class="form-group">
            <a style="font-size: large" href="javascript:history.back()">Powrót</a>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</section>
<jsp:include page="footer.jsp"/>