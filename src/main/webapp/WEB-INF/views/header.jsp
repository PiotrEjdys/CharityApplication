<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<fmt:setLocale value="pl" />
<fmt:setBundle basename="messages"/>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <sec:authorize access="isAuthenticated()">
            <ul class="nav--actions">
                <li class="logged-user">
                   <fmt:message key="hello.message"/> <sec:authentication property="principal.username"/>
                    <ul class="dropdown">
                        <li><a href="#"><fmt:message key="label.profile"/></a></li>
                        <li><a href="#"><fmt:message key="label.myDonation"/></a></li>
                        <li><a href="<c:url value="/logout"/>"><fmt:message key="label.logout"/></a></li>
                    </ul>
                </li>
            </ul>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav--actions">
                <li><a href="<c:url value="/login"/>" class="btn btn--small btn--without-border"><fmt:message key="label.login"/></a></li>
                <li><a href="<c:url value="/register"/>" class="btn btn--small btn--highlighted"><fmt:message key="label.register"/></a></li>
            </ul>
        </sec:authorize>
        <ul>
            <li><form method="post" action="/">
               <select name="language">
                   <option><fmt:message key="label.plLang"/></option>
                   <option><fmt:message key="label.enLang"/></option>
               </select>
                <input type="submit" value="click">
            </form> </li>
            <li><a href="<c:url value="/"/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value="/#steps"/>" class="btn btn--without-border"><fmt:message key="label.whatsAbout"/></a></li>
            <li><a href="<c:url value="/#about-us"/>" class="btn btn--without-border"><fmt:message key="label.aboutUs"/></a></li>
            <li><a href="<c:url value="/#help"/>" class="btn btn--without-border"><fmt:message key="label.foundOrg"/></a></li>
            <li><a href="<c:url value="/form"/>" class="btn btn--without-border"><fmt:message key="label.makeDonation"/></a></li>
            <li><a href="<c:url value="/#contact"/>" class="btn btn--without-border"><fmt:message key="label.contact"/></a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                <fmt:message key="label.startHelping"/><br/>
                <fmt:message key="label.startHelping2"/>
            </h1>
        </div>
    </div>
</header>
