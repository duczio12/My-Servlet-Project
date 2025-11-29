package model;

public class Employee {
    private int id;
    private String hoten;
    private String gioitinh;
    private String ngaysinh;
    private String email;
    private String phone;
    private String diachi;
    private int phongban_id;
    private String phongban_ten;
    private String ngayvaolam;
    private String chucvu;
    private int taikhoan_id;

    // GETTER & SETTER
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }

    public String getGioitinh() { return gioitinh; }
    public void setGioitinh(String gioitinh) { this.gioitinh = gioitinh; }

    public String getNgaysinh() { return ngaysinh; }
    public void setNgaysinh(String ngaysinh) { this.ngaysinh = ngaysinh; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDiachi() { return diachi; }
    public void setDiachi(String diachi) { this.diachi = diachi; }

    public int getPhongban_id() { return phongban_id; }
    public void setPhongban_id(int phongban_id) { this.phongban_id = phongban_id; }

    public String getPhongban_ten() { return phongban_ten; }
    public void setPhongban_ten(String phongban_ten) { this.phongban_ten = phongban_ten; }

    public String getNgayvaolam() { return ngayvaolam; }
    public void setNgayvaolam(String ngayvaolam) { this.ngayvaolam = ngayvaolam; }

    public String getChucvu() { return chucvu; }
    public void setChucvu(String chucvu) { this.chucvu = chucvu; }

    public int getTaikhoan_id() { return taikhoan_id; }
    public void setTaikhoan_id(int taikhoan_id) { this.taikhoan_id = taikhoan_id; }
}
