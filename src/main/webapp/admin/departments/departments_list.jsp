<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/header.jsp" %>
<%@ include file="../layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Quản lý phòng ban</h1>
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a></li>
        <li class="breadcrumb-item active">Phòng ban</li>
    </ol>

    <div class="card mb-4">
        <div class="card-header">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <i class="fas fa-table me-1"></i>
                    Danh sách phòng ban
                </div>
                <a href="${pageContext.request.contextPath}/admin/department?action=new" class="btn btn-success">
                    <i class="fas fa-plus me-1"></i>Thêm phòng ban
                </a>
            </div>
        </div>
        <div class="card-body">
            <table id="datatablesSimple" class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Tên phòng ban</th>
                        <th>Người quản lý</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${listDepartment}" var="d">
                    <tr>
                        <td>${d.id}</td>
                        <td>${d.tenphongban}</td>
                        <td>${d.nguoiquanly}</td>
                        <td>
                            <div class="btn-group" role="group">
                                <a href="${pageContext.request.contextPath}/admin/department?action=edit&id=${d.id}" class="btn btn-warning btn-sm" title="Sửa">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a href="${pageContext.request.contextPath}/admin/department?action=delete&id=${d.id}" class="btn btn-danger btn-sm" title="Xóa" 
                                   onclick="return confirm('Bạn có chắc chắn muốn xóa phòng ban này?')">
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