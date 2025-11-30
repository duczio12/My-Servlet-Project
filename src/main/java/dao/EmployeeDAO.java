package dao;

import model.Employee;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT n.*, p.tenphongban FROM nhanvien n LEFT JOIN phongban p ON n.phongban_id = p.id";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setHoten(rs.getString("hoten"));
                employee.setGioitinh(rs.getString("gioitinh"));
                employee.setNgaysinh(rs.getDate("ngaysinh"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setDiachi(rs.getString("diachi"));
                employee.setPhongban_id(rs.getInt("phongban_id"));
                employee.setPhongban_ten(rs.getString("tenphongban"));
                employee.setNgayvaolam(rs.getDate("ngayvaolam"));
                employee.setChucvu(rs.getString("chucvu"));
                employee.setTaikhoan_id(rs.getInt("taikhoan_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi getAllEmployees: " + e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }
    
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT n.*, p.tenphongban FROM nhanvien n LEFT JOIN phongban p ON n.phongban_id = p.id WHERE n.id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setHoten(rs.getString("hoten"));
                    employee.setGioitinh(rs.getString("gioitinh"));
                    employee.setNgaysinh(rs.getDate("ngaysinh"));
                    employee.setEmail(rs.getString("email"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setDiachi(rs.getString("diachi"));
                    employee.setPhongban_id(rs.getInt("phongban_id"));
                    employee.setPhongban_ten(rs.getString("tenphongban"));
                    employee.setNgayvaolam(rs.getDate("ngayvaolam"));
                    employee.setChucvu(rs.getString("chucvu"));
                    employee.setTaikhoan_id(rs.getInt("taikhoan_id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi getEmployeeById: " + e.getMessage());
            e.printStackTrace();
        }
        return employee;
    }
    
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO nhanvien (hoten, gioitinh, ngaysinh, email, phone, diachi, phongban_id, ngayvaolam, chucvu, taikhoan_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, employee.getHoten());
            stmt.setString(2, employee.getGioitinh());
            stmt.setDate(3, new java.sql.Date(employee.getNgaysinh().getTime()));
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getDiachi());
            stmt.setInt(7, employee.getPhongban_id());
            stmt.setDate(8, new java.sql.Date(employee.getNgayvaolam().getTime()));
            stmt.setString(9, employee.getChucvu());
            stmt.setInt(10, employee.getTaikhoan_id());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE nhanvien SET hoten=?, gioitinh=?, ngaysinh=?, email=?, phone=?, diachi=?, phongban_id=?, ngayvaolam=?, chucvu=?, taikhoan_id=? WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, employee.getHoten());
            stmt.setString(2, employee.getGioitinh());
            stmt.setDate(3, new java.sql.Date(employee.getNgaysinh().getTime()));
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getDiachi());
            stmt.setInt(7, employee.getPhongban_id());
            stmt.setDate(8, new java.sql.Date(employee.getNgayvaolam().getTime()));
            stmt.setString(9, employee.getChucvu());
            stmt.setInt(10, employee.getTaikhoan_id());
            stmt.setInt(11, employee.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM nhanvien WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}