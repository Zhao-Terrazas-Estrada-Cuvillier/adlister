<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        body {
            font-family: "Lato", sans-serif;
            transition: background-color .5s;
        }
        .sidenav {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #D4DFE5;
            background-image: linear-gradient(0deg, #6A4162 0%, #F39DB6 0%, #232653 33%);
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
            box-shadow: 10px 10px 20px 0 #8479A1 inset, -10px -10px 20px 0 #8479A1 inset;
        }
        .sidenav a {
            padding: 8px 8px 8px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #F39DB6;
            display: block;
            transition: 0.3s;
        }
        .sidenav a:hover {
            color: #f1f1f1;
        }
        .sidenav .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
        }
        #main {
            transition: margin-left .5s;
            padding: 16px;
        }
        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }
    </style>
    <title>nav</title>
</head>
<body>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <c:choose>
        <c:when test="${user== null}">
            <a href="/">Home</a>
            <a href="/login">Login</a>
            <a href="/register">Register</a>
        </c:when>
        <c:otherwise>
            <a class="nav-link active" href="/profile">Profile</a>
            <a class="nav-link" href="/profile/edit">Edit Profile</a>
            <a class="nav-link" href="/ads">Ads</a>
            <a class="nav-link" href="/ads/create">Create New Ads</a>
            <a class="nav-link" href="/logout">Logout</a>
        </c:otherwise>
    </c:choose>
</div>
<div id="main">
    <span style="font-size:30px;cursor:pointer" onclick="openNav()"><img src="https://img.icons8.com/pastel-glyph/64/000000/hamburger.png" /></span>
</div>

<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
    }
    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
        document.getElementById("main").style.marginLeft= "0";
        document.body.style.backgroundColor = "white";
    }
</script>
</body>
