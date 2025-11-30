<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Menu quản lý</div>
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Trang chủ
                    </a>
                            
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/employee">
                        <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                        Nhân viên
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/departments">
                        <div class="sb-nav-link-icon"><i class="fas fa-building"></i></div>
                        Phòng ban
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/attendance">
                        <div class="sb-nav-link-icon"><i class="fas fa-clock"></i></div>
                        Chấm công
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/salary">
                        <div class="sb-nav-link-icon"><i class="fas fa-wallet"></i></div>
                        Quản lý lương
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/leave">
                        <div class="sb-nav-link-icon"><i class="fas fa-calendar-day"></i></div>
                        Nghỉ phép
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/contract">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-alt"></i></div>
                        Hợp đồng
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/reward">
                        <div class="sb-nav-link-icon"><i class="fas fa-award"></i></div>
                        Thưởng / Phạt
                    </a>
                
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/report">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-bar"></i></div>
                        Báo cáo
                    </a>
                    
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/account">
                        <div class="sb-nav-link-icon"><i class="fas fa-user-cog"></i></div>
                        Tài khoản
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                <strong>Admin</strong>
            </div>
        </nav>
    </div>
    <div id="layoutSidenav_content">
        <main>