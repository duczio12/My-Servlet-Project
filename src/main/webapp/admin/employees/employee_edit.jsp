<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Sửa nhân viên</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/employee">Nhân viên</a></li>
        <li class="breadcrumb-item active">Sửa nhân viên</li>
    </ol>

    <div class="card mb-4">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/admin/employee" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="${employee.id}">

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="hoten" class="form-label">Họ tên</label>
                        <input type="text" class="form-control" id="hoten" name="hoten" 
                               value="${employee.hoten}" required>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Giới tính</label>
                        <div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gioitinh" id="nam" value="Nam" 
                                    ${employee.gioitinh == 'Nam' ? 'checked' : ''} required>
                                <label class="form-check-label" for="nam">Nam</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gioitinh" id="nu" value="Nữ"
                                    ${employee.gioitinh == 'Nữ' ? 'checked' : ''}>
                                <label class="form-check-label" for="nu">Nữ</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gioitinh" id="khac" value="Khác"
                                    ${employee.gioitinh == 'Khác' ? 'checked' : ''}>
                                <label class="form-check-label" for="khac">Khác</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="ngaysinh" class="form-label">Ngày sinh</label>
                        <input type="date" class="form-control" id="ngaysinh" name="ngaysinh" 
                               value="${employee.ngaysinh}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" 
                               value="${employee.email}" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="phone" class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" id="phone" name="phone" 
                               value="${employee.phone}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="diachi" class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" id="diachi" name="diachi" 
                               value="${employee.diachi}" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="phongban_id" class="form-label">Phòng ban</label>
                        <select class="form-select" id="phongban_id" name="phongban_id" required>
                            <option value="">-- Chọn phòng ban --</option>
                            <c:forEach items="${listDepartment}" var="d">
                                <option value="${d.id}" ${employee.phongban_id == d.id ? 'selected' : ''}>
                                    ${d.tenphongban}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label for="ngayvaolam" class="form-label">Ngày vào làm</label>
                        <input type="date" class="form-control" id="ngayvaolam" name="ngayvaolam" 
                               value="${employee.ngayvaolam}" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="chucvu" class="form-label">Chức vụ</label>
                        <input type="text" class="form-control" id="chucvu" name="chucvu" 
                               value="${employee.chucvu}" required>
                    </div>
                    <div class="col-md-6">
                        <label for="taikhoan_id" class="form-label">ID tài khoản</label>
                        <input type="number" class="form-control" id="taikhoan_id" name="taikhoan_id" 
                               value="${employee.taikhoan_id}" required>
                        <div class="form-text">Tự động tạo tài khoản</div>
                    </div>
                </div>

                <div class="mt-4">
                    <button type="submit" class="btn btn-primary">Cập nhật</button>
                    <a href="${pageContext.request.contextPath}/admin/employee" class="btn btn-secondary">Hủy</a>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>