<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./layout/header.jsp" %>
<%@ include file="./layout/sidebar.jsp" %>

<main class="container-fluid px-4">
    <h1 class="mt-4">Dashboard Tổng Quan</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item active">Dashboard</li>
    </ol>

    <div class="row">
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card bg-primary text-white h-100">
                <div class="card-body">NHÂN VIÊN <div class="h2">—</div></div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card bg-success text-white h-100">
                <div class="card-body">PHÒNG BAN <div class="h2">—</div></div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card bg-warning text-white h-100">
                <div class="card-body">CHẤM CÔNG <div class="h2">—</div></div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card bg-danger text-white h-100">
                <div class="card-body">LƯƠNG <div class="h2">—</div></div>
            </div>
        </div>
    </div>

</main>

<%@ include file="./layout/footer.jsp" %>
