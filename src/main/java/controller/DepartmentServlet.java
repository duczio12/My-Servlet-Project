package controller;

import dao.DepartmentDAO;
import model.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DepartmentServlet extends HttpServlet {
    private DepartmentDAO departmentDAO;
    
    @Override
    public void init() {
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
                    insertDepartment(request, response);
                    break;
                case "delete":
                    deleteDepartment(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateDepartment(request, response);
                    break;
                default:
                    listDepartments(request, response);
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
    
    private void listDepartments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> listDepartment = departmentDAO.getAllDepartments();
        request.setAttribute("listDepartment", listDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/departments/department_list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/departments/department_add.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Department existingDepartment = departmentDAO.getDepartmentById(id);
        request.setAttribute("department", existingDepartment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/departments/department_edit.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tenphongban = request.getParameter("tenphongban");
        String nguoiquanly = request.getParameter("nguoiquanly");
        
        Department newDepartment = new Department();
        newDepartment.setTenphongban(tenphongban);
        newDepartment.setNguoiquanly(nguoiquanly);
        
        boolean success = departmentDAO.addDepartment(newDepartment);
        if (success) {
            response.sendRedirect("department?action=list");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi thêm phòng ban");
            showNewForm(request, response);
        }
    }
    
    private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenphongban = request.getParameter("tenphongban");
        String nguoiquanly = request.getParameter("nguoiquanly");
        
        Department department = new Department();
        department.setId(id);
        department.setTenphongban(tenphongban);
        department.setNguoiquanly(nguoiquanly);
        
        boolean success = departmentDAO.updateDepartment(department);
        if (success) {
            response.sendRedirect("department?action=list");
        } else {
            request.setAttribute("errorMessage", "Có lỗi xảy ra khi cập nhật phòng ban");
            showEditForm(request, response);
        }
    }
    
    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.deleteDepartment(id);
        response.sendRedirect("department?action=list");
    }
}