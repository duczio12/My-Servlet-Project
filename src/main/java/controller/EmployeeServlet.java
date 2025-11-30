package controller;

import dao.EmployeeDAO;
import dao.DepartmentDAO;
import model.Employee;
import model.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    private DepartmentDAO departmentDAO;
    
    @Override
    public void init() {
        employeeDAO = new EmployeeDAO();
        departmentDAO = new DepartmentDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmployee(request, response);
                    break;
                case "view":
                    viewEmployee(request, response);
                    break;
                default:
                    listEmployees(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listEmployee = employeeDAO.getAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/employees/employee_list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> listDepartment = departmentDAO.getAllDepartments();
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/employees/employee_add.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.getEmployeeById(id);
        List<Department> listDepartment = departmentDAO.getAllDepartments();
        request.setAttribute("employee", existingEmployee);
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/employees/employee_edit.jsp");
        dispatcher.forward(request, response);
    }
    
    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.getEmployeeById(id);
        request.setAttribute("employee", employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/employees/employee_view.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hoten = request.getParameter("hoten");
        String gioitinh = request.getParameter("gioitinh");
        String ngaysinhStr = request.getParameter("ngaysinh");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String diachi = request.getParameter("diachi");
        int phongban_id = Integer.parseInt(request.getParameter("phongban_id"));
        String ngayvaolamStr = request.getParameter("ngayvaolam");
        String chucvu = request.getParameter("chucvu");
        int taikhoan_id = Integer.parseInt(request.getParameter("taikhoan_id"));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ngaysinh = null;
        java.util.Date ngayvaolam = null;
        
        try {
            ngaysinh = dateFormat.parse(ngaysinhStr);
            ngayvaolam = dateFormat.parse(ngayvaolamStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Employee newEmployee = new Employee();
        newEmployee.setHoten(hoten);
        newEmployee.setGioitinh(gioitinh);
        newEmployee.setNgaysinh(ngaysinh);
        newEmployee.setEmail(email);
        newEmployee.setPhone(phone);
        newEmployee.setDiachi(diachi);
        newEmployee.setPhongban_id(phongban_id);
        newEmployee.setNgayvaolam(ngayvaolam);
        newEmployee.setChucvu(chucvu);
        newEmployee.setTaikhoan_id(taikhoan_id);
        
        boolean success = employeeDAO.addEmployee(newEmployee);
        if (success) {
            response.sendRedirect("employee?action=list");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm nhân viên");
            showNewForm(request, response);
        }
    }
    
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String hoten = request.getParameter("hoten");
        String gioitinh = request.getParameter("gioitinh");
        String ngaysinhStr = request.getParameter("ngaysinh");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String diachi = request.getParameter("diachi");
        int phongban_id = Integer.parseInt(request.getParameter("phongban_id"));
        String ngayvaolamStr = request.getParameter("ngayvaolam");
        String chucvu = request.getParameter("chucvu");
        int taikhoan_id = Integer.parseInt(request.getParameter("taikhoan_id"));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ngaysinh = null;
        java.util.Date ngayvaolam = null;
        
        try {
            ngaysinh = dateFormat.parse(ngaysinhStr);
            ngayvaolam = dateFormat.parse(ngayvaolamStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Employee employee = new Employee();
        employee.setId(id);
        employee.setHoten(hoten);
        employee.setGioitinh(gioitinh);
        employee.setNgaysinh(ngaysinh);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setDiachi(diachi);
        employee.setPhongban_id(phongban_id);
        employee.setNgayvaolam(ngayvaolam);
        employee.setChucvu(chucvu);
        employee.setTaikhoan_id(taikhoan_id);
        
        boolean success = employeeDAO.updateEmployee(employee);
        if (success) {
            response.sendRedirect("employee?action=list");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật nhân viên");
            showEditForm(request, response);
        }
    }
    
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("employee?action=list");
    }
}