<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>${param.title}</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<div class="pull-right"><div class="headerbar-header"></div>
    <c:choose>
        <c:when test="${user == null}"></c:when>
        <c:otherwise>
            <div class="searchbar float-right">
                <form class="form-inline" method="post" action="/ads/search">
                    <input type="text" name="search" class="form-control" placeholder="Looking for an Ad?">
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>
