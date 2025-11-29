<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm phòng ban</title></head>
<body>

<h2>Thêm phòng ban</h2>

<form action="departments" method="post">
    <input type="hidden" name="action" value="add">

    Tên phòng ban:
    <input type="text" name="tenphongban" required><br><br>

    <button type="submit">Lưu</button>
</form>

</body>
</html>
