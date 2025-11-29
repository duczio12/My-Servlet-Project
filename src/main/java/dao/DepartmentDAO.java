package dao;

import model.Department;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Department> getAll() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM phongban ORDER BY id DESC";
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

    public Department getById(int id) {
        String sql = "SELECT * FROM phongban WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Department d = new Department();
                    d.setId(rs.getInt("id"));
                    d.setTenphongban(rs.getString("tenphongban"));
                    d.setNguoiquanly(rs.getString("nguoiquanly"));
                    return d;
                }
            }

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public boolean insert(Department d) {
        String sql = "INSERT INTO phongban (tenphongban, nguoiquanly) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getTenphongban());
            ps.setString(2, d.getNguoiquanly());
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean update(Department d) {
        String sql = "UPDATE phongban SET tenphongban=?, nguoiquanly=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getTenphongban());
            ps.setString(2, d.getNguoiquanly());
            ps.setInt(3, d.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM phongban WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
