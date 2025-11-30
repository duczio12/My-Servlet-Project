package model;

public class Department {
    private int id;
    private String tenphongban;
    private String nguoiquanly;

    // Constructors
    public Department() {}

    public Department(int id, String tenphongban, String nguoiquanly) {
        this.id = id;
        this.tenphongban = tenphongban;
        this.nguoiquanly = nguoiquanly;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenphongban() { return tenphongban; }
    public void setTenphongban(String tenphongban) { this.tenphongban = tenphongban; }

    public String getNguoiquanly() { return nguoiquanly; }
    public void setNguoiquanly(String nguoiquanly) { this.nguoiquanly = nguoiquanly; }
}