package dao;

import model.Department;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    public List<Department> getAll() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT id, tenphongban, nguoiquanly FROM phongban ORDER BY id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setTenphongban(rs.getString("tenphongban"));
                d.setNguoiquanly(rs.getString("nguoiquanly"));
                list.add(d);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
