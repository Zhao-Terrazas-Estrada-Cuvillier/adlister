<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${user.username}!</h1>
</div>

<div class="container">
    <h1>All the Ads created by yourself</h1>

    <c:forEach var="ad" items="${ads}">

        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="" class="form-inline">
                <input name="ad_id" type="hidden" value=${ad.id}>
                <button type="submit" class="btn btn-sm btn-warning"
                        formaction="${pageContext.request.contextPath}/profile" formmethod="post">EDIT
                </button>
                <button type="submit" class="btn btn-sm btn-danger"
                        formaction="${pageContext.request.contextPath}/ads/delete" formmethod="get">DELETE
                </button>
            </form>
            <p>Ad ID: ${ad.id}</p>
            <hr>
        </div>
    </c:forEach>
</div>


</body>
</html>
