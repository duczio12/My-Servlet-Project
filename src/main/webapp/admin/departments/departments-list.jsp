<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách phòng ban</title></head>
<body>

<h2>Danh sách phòng ban</h2>

<a href="departments?action=add">Thêm phòng ban</a>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Tên phòng ban</th>
        <th>Hành động</th>
    </tr>

    <c:forEach items="${list}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.tenPhongBan}</td>
            <td>
                <a href="departments?action=edit&id=${d.id}">Sửa</a> |
                <a href="departments?action=delete&id=${d.id}"
                   onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
