<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update an existing Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<div class="container">
    <h1>Update an existing Ad</h1>
    <form action="/ads/update" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${sessionScope.ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${sessionScope.ad.description}</textarea>
        </div>
        <input name="ad_id" type="hidden" value=${ad.id}>
        <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/profile" formmethod="get">Submit</button>
    </form>
</div>
</body>
</html>