<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/bg.jsp" />
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to Ads4Coders!" />
    </jsp:include>
    <style>
        .jumbotron{
            background-color:#645A97;
            text-align:center;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">

    <div class="jumbotron mx-auto d-inline text-center" >
        <p class="h1 py-1 display-4">Welcome to the Ads4Coders!</p>
    </div>
</div>
</body>
</html>