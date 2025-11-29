<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Admin</title>

    <link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/dashboard">Admin</a>
    <ul class="navbar-nav ms-auto me-3">
        <li class="nav-item"><span class="nav-link">Xin chào, admin</span></li>
        <li class="nav-item"><a class="nav-link" href="#">Đăng xuất</a></li>
    </ul>
</nav>

<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
    </div>

    <div id="layoutSidenav_content">
