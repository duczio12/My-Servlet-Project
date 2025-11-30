<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Thông tin nhân viên</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/employee">Nhân viên</a></li>
        <li class="breadcrumb-item active">Thông tin nhân viên</li>
    </ol>

    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-user me-1"></i>
            Thông tin chi tiết nhân viên
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <table class="table table-bordered">
                        <tr>
                            <th width="30%">ID:</th>
                            <td>${employee.id}</td>
                        </tr>
                        <tr>
                            <th>Họ tên:</th>
                            <td>${employee.hoten}</td>
                        </tr>
                        <tr>
                            <th>Giới tính:</th>
                            <td>${employee.gioitinh}</td>
                        </tr>
                        <tr>
                            <th>Ngày sinh:</th>
                            <td>${employee.ngaysinh}</td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>${employee.email}</td>
                        </tr>
                        <tr>
                            <th>Số điện thoại:</th>
                            <td>${employee.phone}</td>
                        </tr>
                    </table>
                </div>
                <div class="col-md-6">
                    <table class="table table-bordered">
                        <tr>
                            <th width="40%">Địa chỉ:</th>
                            <td>${employee.diachi}</td>
                        </tr>
                        <tr>
                            <th>Phòng ban:</th>
                            <td>${employee.phongban_ten}</td>
                        </tr>
                        <tr>
                            <th>Ngày vào làm:</th>
                            <td>${employee.ngayvaolam}</td>
                        </tr>
                        <tr>
                            <th>Chức vụ:</th>
                            <td>${employee.chucvu}</td>
                        </tr>
                        <tr>
                            <th>ID tài khoản:</th>
                            <td>${employee.taikhoan_id}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="mt-4">
                <a href="${pageContext.request.contextPath}/admin/employee" class="btn btn-secondary">Quay lại</a>
                <a href="${pageContext.request.contextPath}/admin/employee?action=edit&id=${employee.id}" class="btn btn-warning">Sửa</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>