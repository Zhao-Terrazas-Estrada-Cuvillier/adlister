<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header ">
            <a class="navbar-brand" href="/">Adlister</a>
            <c:choose>
                <c:when test="${user == null}"></c:when>
                <c:otherwise>
                    <div class="searchbar">
                        <form class="form-inline" method="post" action="/ads/search">
                            <input type="text" name="search" class="form-control" placeholder="Looking for an Ad?">
                            <button type="submit" class="btn btn-primary">Search</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        <ul class="nav navbar-nav navbar-right d-flex">
            <c:choose>
                <c:when test="${user == null}">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:when>
                <c:otherwise>
                    <nav class="navbar navbar-light">
                        <ul class="nav nav-pills nav-fill">
                    <li class="nav-item"><a class="nav-link active" href="/profile">Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="/profile/edit">Edit Profile</a></li>
                    <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
                        </ul>
                    </nav>
                </c:otherwise>
            </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
