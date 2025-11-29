package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT n.*, p.tenphongban AS phongban_ten FROM nhanvien n " +
                     "LEFT JOIN phongban p ON n.phongban_id = p.id " +
                     "ORDER BY n.id DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee emp = mapRow(rs);
                list.add(emp);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public Employee getById(int id) {
        String sql = "SELECT n.*, p.tenphongban AS phongban_ten FROM nhanvien n " +
                     "LEFT JOIN phongban p ON n.phongban_id = p.id WHERE n.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    public boolean insert(Employee emp) {
        String sql = "INSERT INTO nhanvien (hoten, gioitinh, ngaysinh, email, phone, diachi, phongban_id, ngayvaolam, chucvu, taikhoan_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setPreparedStatementFromEmployee(ps, emp);
            int row = ps.executeUpdate();
            return row > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean update(Employee emp) {
        String sql = "UPDATE nhanvien SET hoten=?, gioitinh=?, ngaysinh=?, email=?, phone=?, diachi=?, phongban_id=?, ngayvaolam=?, chucvu=?, taikhoan_id=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            setPreparedStatementFromEmployee(ps, emp);
            ps.setInt(11, emp.getId());
            int row = ps.executeUpdate();
            return row > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM nhanvien WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            return row > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // helper
    private Employee mapRow(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setId(rs.getInt("id"));
        emp.setHoten(rs.getString("hoten"));
        emp.setGioitinh(rs.getString("gioitinh"));
        emp.setNgaysinh(rs.getString("ngaysinh"));
        emp.setEmail(rs.getString("email"));
        emp.setPhone(rs.getString("phone"));
        emp.setDiachi(rs.getString("diachi"));
        emp.setPhongban_id(rs.getInt("phongban_id"));
        // phongban_ten trong DB là tenphongban
        try { emp.setPhongban_ten(rs.getString("phongban_ten")); } catch (SQLException ignored) {}
        emp.setNgayvaolam(rs.getString("ngayvaolam"));
        emp.setChucvu(rs.getString("chucvu"));
        emp.setTaikhoan_id(rs.getInt("taikhoan_id"));
        return emp;
    }

    private void setPreparedStatementFromEmployee(PreparedStatement ps, Employee emp) throws SQLException {
        ps.setString(1, emp.getHoten());
        ps.setString(2, emp.getGioitinh());
        ps.setString(3, emp.getNgaysinh());
        ps.setString(4, emp.getEmail());
        ps.setString(5, emp.getPhone());
        ps.setString(6, emp.getDiachi());
        if (emp.getPhongban_id() == 0) ps.setNull(7, Types.INTEGER); else ps.setInt(7, emp.getPhongban_id());
        ps.setString(8, emp.getNgayvaolam());
        ps.setString(9, emp.getChucvu());
        if (emp.getTaikhoan_id() == 0) ps.setNull(10, Types.INTEGER); else ps.setInt(10, emp.getTaikhoan_id());
    }
}
