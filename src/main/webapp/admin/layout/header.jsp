<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/admin/dashboard">
            <i class="fas fa-users me-2"></i>Amin BĐS
        </a>
        
        <!-- Sidebar Toggle-->
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
            <i class="fas fa-bars"></i>
        </button>
        
        <!-- Page Navigation -->
        <div class="d-none d-md-inline-block ms-3">
            <a href="${pageContext.request.contextPath}/admin/dashboard" class="text-light fw-bold text-decoration-none border-bottom border-white me-3">Trang Admin</a>
            <a href="${pageContext.request.contextPath}/admin/dashboard" class="text-light fw-bold text-decoration-none">Trang nhân viên</a>
        </div>
        
        <!-- Navbar-->
        <div class="ms-auto">
	        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
	            <li class="nav-item">
	                <span class="nav-link">
	                    <i class="fas fa-user-circle me-1"></i>
	                    <span class="fw-bold">Xin chào, Admin</span>
	                </span>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link btn btn-danger btn-sm text-white px-3 ms-2" href="#!">
	                    <i class="fas fa-sign-out-alt me-1"></i>Đăng xuất
	                </a>
	            </li>
	        </ul>
	    </div>
    </nav>