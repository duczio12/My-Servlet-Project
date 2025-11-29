<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Sửa phòng ban</title></head>
<body>

<h2>Sửa phòng ban</h2>

<form action="departments" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${dept.id}">

    Tên phòng ban:
    <input type="text" name="tenphongban" value="${dept.tenPhongBan}" required><br><br>

    <button type="submit">Cập nhật</button>
</form>

</body>
</html>
