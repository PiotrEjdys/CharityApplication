<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
  </head>
  <body>
    <header>
      <nav class="container container--70">
        <ul class="nav--actions">
          <li><a href="<c:url value="/login"/>">Zaloguj</a></li>
          <li class="highlighted"><a href="<c:url value="/register"/>">Załóż konto</a></li>
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
      <h2>Zaloguj się</h2>
      <form>
        <div class="form-group">
          <input type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
          <input type="password" name="password" placeholder="Hasło" />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
          <a href="<c:url value="/register"/>" class="btn btn--without-border">Załóż konto</a>
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form>
    </section>
  <jsp:include page="footer.jsp"/>