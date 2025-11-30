package dao;

import model.Department;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM phongban";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setTenphongban(rs.getString("tenphongban"));
                department.setNguoiquanly(rs.getString("nguoiquanly"));
                departments.add(department);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi getAllDepartments: " + e.getMessage());
            e.printStackTrace();
        }
        return departments;
    }
    
    public Department getDepartmentById(int id) {
        Department department = null;
        String sql = "SELECT * FROM phongban WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    department = new Department();
                    department.setId(rs.getInt("id"));
                    department.setTenphongban(rs.getString("tenphongban"));
                    department.setNguoiquanly(rs.getString("nguoiquanly"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi getDepartmentById: " + e.getMessage());
            e.printStackTrace();
        }
        return department;
    }
    
    public boolean addDepartment(Department department) {
        String sql = "INSERT INTO phongban (tenphongban, nguoiquanly) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, department.getTenphongban());
            stmt.setString(2, department.getNguoiquanly());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateDepartment(Department department) {
        String sql = "UPDATE phongban SET tenphongban=?, nguoiquanly=? WHERE id=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, department.getTenphongban());
            stmt.setString(2, department.getNguoiquanly());
            stmt.setInt(3, department.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteDepartment(int id) {
        String sql = "DELETE FROM phongban WHERE id=?";
        
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