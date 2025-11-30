<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Quản lý nhân viên</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item active">Nhân viên</li>
    </ol>

    <div class="card mb-4">
        <div class="card-header">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <i class="fas fa-table me-1"></i>
                    Danh sách nhân viên
                </div>
                <a href="${pageContext.request.contextPath}/admin/employee?action=new" class="btn btn-success">
                    <i class="fas fa-plus me-1"></i>Thêm nhân viên
                </a>
            </div>
        </div>
        <div class="card-body">
            <table id="datatablesSimple" class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Họ tên</th>
                        <th>Giới tính</th>
                        <th>Ngày sinh</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Địa chỉ</th>
                        <th>Phòng ban</th>
                        <th>Ngày vào làm</th>
                        <th>Chức vụ</th>
                        <th>ID tài khoản</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listEmployee}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.hoten}</td>
                        <td>${e.gioitinh}</td>
                        <td>${e.ngaysinh}</td>
                        <td>${e.email}</td>
                        <td>${e.phone}</td>
                        <td>${e.diachi}</td>
                        <td>${e.phongban_ten}</td>
                        <td>${e.ngayvaolam}</td>
                        <td>${e.chucvu}</td>
                        <td>${e.taikhoan_id}</td>
                        <td>
                            <div class="btn-group" role="group">
                                <a href="${pageContext.request.contextPath}/admin/employee?action=view&id=${e.id}" class="btn btn-info btn-sm" title="Xem">
                                    <i class="fas fa-eye"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/admin/employee?action=edit&id=${e.id}" class="btn btn-warning btn-sm" title="Sửa">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/admin/employee?action=delete&id=${e.id}" class="btn btn-danger btn-sm" title="Xóa" 
                                   onclick="return confirm('Bạn có chắc chắn muốn xóa nhân viên này?')">
                                    <i class="fas fa-trash"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>