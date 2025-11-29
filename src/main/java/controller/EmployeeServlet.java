package controller;

import dao.EmployeeDAO;
import dao.DepartmentDAO;
import model.Employee;
import model.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO dao = new EmployeeDAO();
    private DepartmentDAO deptDao = new DepartmentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showForm(req, resp, new Employee(), "Thêm nhân viên", "insert");
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Employee empEdit = dao.getById(idEdit);
                showForm(req, resp, empEdit, "Chỉnh sửa nhân viên", "update");
                break;
            case "delete":
                int idDel = Integer.parseInt(req.getParameter("id"));
                dao.delete(idDel);
                resp.sendRedirect(req.getContextPath() + "/admin/employee");
                break;
            case "view":
                int idView = Integer.parseInt(req.getParameter("id"));
                Employee empView = dao.getById(idView);
                req.setAttribute("employee", empView);
                req.getRequestDispatcher("/admin/employee_view.jsp").forward(req, resp);
                break;
            case "list":
            default:
                list(req, resp);
                break;
        }
    }

    private void showForm(HttpServletRequest req, HttpServletResponse resp, Employee emp, String title, String formAction) throws ServletException, IOException {
        List<Department> depts = deptDao.getAll();
        req.setAttribute("departments", depts);
        req.setAttribute("employee", emp);
        req.setAttribute("formTitle", title);
        req.setAttribute("formAction", formAction);
        req.getRequestDispatcher("/admin/employee_form.jsp").forward(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list = dao.getAll();
        req.setAttribute("listEmployee", list);
        req.getRequestDispatcher("/admin/employees.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String formAction = req.getParameter("action");
        if ("insert".equals(formAction)) {
            Employee emp = readEmployeeFromRequest(req);
            dao.insert(emp);
            resp.sendRedirect(req.getContextPath() + "/admin/employee");
        } else if ("update".equals(formAction)) {
            Employee emp = readEmployeeFromRequest(req);
            emp.setId(Integer.parseInt(req.getParameter("id")));
            dao.update(emp);
            resp.sendRedirect(req.getContextPath() + "/admin/employee");
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/employee");
        }
    }

    private Employee readEmployeeFromRequest(HttpServletRequest req) {
        Employee emp = new Employee();
        emp.setHoten(req.getParameter("hoten"));
        emp.setGioitinh(req.getParameter("gioitinh"));
        emp.setNgaysinh(req.getParameter("ngaysinh"));
        emp.setEmail(req.getParameter("email"));
        emp.setPhone(req.getParameter("phone"));
        emp.setDiachi(req.getParameter("diachi"));
        String pb = req.getParameter("phongban_id");
        emp.setPhongban_id((pb == null || pb.isEmpty()) ? 0 : Integer.parseInt(pb));
        emp.setNgayvaolam(req.getParameter("ngayvaolam"));
        emp.setChucvu(req.getParameter("chucvu"));
        String tk = req.getParameter("taikhoan_id");
        emp.setTaikhoan_id((tk == null || tk.isEmpty()) ? 0 : Integer.parseInt(tk));
        return emp;
    }
}
