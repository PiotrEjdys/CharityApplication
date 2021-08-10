<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"/>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle basename="messages"/>
<section id="stats" class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <%--            <c:if test="${totalBags != 0}">--%>
            <em>${totalBags}</em>
            <%--            </c:if>--%>
            <h3><fmt:message key="label.bags"/> </h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <%--            <c:if test="${totalDonations != 0}">--%>
            <em>${totalDonations}</em>
            <%--            </c:if>--%>
            <h3><fmt:message key="label.donation"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section id="steps" class="steps">
    <h2><fmt:message key="label.steps"/></h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3><fmt:message key="label.choose"/></h3>
            <p><fmt:message key="label.items"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3><fmt:message key="label.pack"/></h3>
            <p><fmt:message key="label.useBags"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3><fmt:message key="label.who"/></h3>
            <p><fmt:message key="label.place"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3><fmt:message key="label.delivery"/></h3>
            <p><fmt:message key="label.deliveryDate"/></p>
        </div>
    </div>
    <sec:authorize access="!isAuthenticated()">
        <a href="<c:url value="/register"/>" class="btn btn--large"><fmt:message key="label.register"/></a>
    </sec:authorize>

</section>

<section id="about-us" class="about-us">
    <div class="about-us--text">
        <h2><fmt:message key="label.aboutUs"/></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>


<section id="help" class="help">
    <h2><fmt:message key="label.help"/></h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p><fmt:message key="label.foundation"/></p>

        <ul class="help--slides-items">
            <c:forEach items="${institutions}" varStatus="status" var="institution" step="2">
                <li>
                    <div class="col">
                        <div class="title">"<c:out value="${institution.name}"/>"</div>
                        <div class="subtitle"><c:out value="${institution.description}"/></div>
                    </div>

                    <div class="col">
                        <c:if test="${!(status.index + 1 eq institutions.size())}">
                            <div class="title">"<c:out value="${institutions[status.index+1].name}"/>"</div>
                            <div class="subtitle"><c:out value="${institutions[status.index+1].description}"/></div>
                        </c:if>
                    </div>
                </li>
            </c:forEach>

        </ul>


    </div>

</section>
<jsp:include page="footer.jsp"/>