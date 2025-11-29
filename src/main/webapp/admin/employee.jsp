<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="layout/header.jsp" %>
<%@ include file="layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h2 class="mt-4">Danh sách nhân viên</h2>

    <a href="${pageContext.request.contextPath}/admin/employee?action=new" class="btn btn-success mb-3">+ Thêm nhân viên</a>

    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>ID</th><th>Họ tên</th><th>Giới tính</th><th>Ngày sinh</th><th>Email</th>
                <th>Phone</th><th>Địa chỉ</th><th>Phòng ban</th><th>Ngày vào làm</th><th>Chức vụ</th><th>ID tài khoản</th><th>Hành động</th>
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
                    <a href="${pageContext.request.contextPath}/admin/employee?action=edit&id=${e.id}" class="btn btn-warning btn-sm"><i class="fas fa-edit"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/employee?action=delete&id=${e.id}" class="btn btn-danger btn-sm" onclick="return confirm('Xác nhận xóa?')"><i class="fas fa-trash"></i></a>
                    <a href="${pageContext.request.contextPath}/admin/employee?action=view&id=${e.id}" class="btn btn-info btn-sm"><i class="fas fa-eye"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%@ include file="layout/footer.jsp" %>
