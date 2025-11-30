<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Sửa phòng ban</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/department">Phòng ban</a></li>
        <li class="breadcrumb-item active">Sửa phòng ban</li>
    </ol>

    <div class="card mb-4">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/admin/department" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${department.id}">

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="tenphongban" class="form-label">Tên phòng ban</label>
                        <input type="text" class="form-control" id="tenphongban" name="tenphongban" 
                               value="${department.tenphongban}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="nguoiquanly" class="form-label">Người quản lý</label>
                        <input type="text" class="form-control" id="nguoiquanly" name="nguoiquanly" 
                               value="${department.nguoiquanly}">
                    </div>
                </div>

                <div class="mt-4">
                    <button type="submit" class="btn btn-primary">Cập nhật</button>
                    <a href="${pageContext.request.contextPath}/admin/department" class="btn btn-secondary">Hủy</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>