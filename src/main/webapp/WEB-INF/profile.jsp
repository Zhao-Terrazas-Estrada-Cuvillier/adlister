<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, <c:out value="${sessionScope.user.username}"/>!</h1>
</div>
<div class="container">
    <hr>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="" class="form-inline">
                <input name="ad_id" type="hidden" value=${ad.id}>
                <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/ads/update"
                        formmethod="get">EDIT
                </button>
                <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/ads/delete"
                        formmethod="get">DELETE
                </button>
            </form>
            <hr>
        </div>
    </c:forEach>
</div>
</body>
</html>