package test;

import util.DBConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        System.out.println("🧪 Testing database connection...");
        
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Kết nối database THÀNH CÔNG!");
            try {
                conn.close();
                System.out.println("✅ Đóng kết nối thành công!");
            } catch (Exception e) {
                System.err.println("❌ Lỗi khi đóng kết nối: " + e.getMessage());
            }
        } else {
            System.out.println("❌ Kết nối database THẤT BẠI!");
        }
    }
}