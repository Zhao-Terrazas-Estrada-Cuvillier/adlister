<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/bg.jsp" />
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Ads4Coders!" />
    </jsp:include>
</head>
<style>
    .jumbotron{
        background-color:#60628D;
        text-align:center;
    }
</style>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
<%--        <h1>Welcome to Ads4Coders!</h1>--%>
        <div class="jumbotron mx-auto d-inline text-center" >
            <p class="h1 py-1 display-4">Welcome to Ads4Coders!</p>
        </div>
        <div class="p-3">
            <a class="btn btn-primary" href="/login">LOG IN</a>
        </div>
        <br>
        <div class="p-3">
            <a class="btn btn-primary" href="/profile">GO TO PROFILE</a>
        </div>
        <br>
        <div class="p-3">
            <a class="btn btn-primary" href="/register">CREATE AN ACCOUNT</a>
        </div>
    </div>

    </div>
</body>
</html>
