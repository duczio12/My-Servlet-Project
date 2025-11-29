package controller;

import dao.DepartmentDAO;
import model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class DepartmentServlet extends HttpServlet {

    private DepartmentDAO dao = new DepartmentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            // LIST
            List<Department> list = dao.getAll();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/admin/departments/department-list.jsp").forward(req, resp);
            return;
        }

        switch (action) {
            case "add":
                req.getRequestDispatcher("/admin/departments/department-add.jsp").forward(req, resp);
                break;

            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("dept", dao.getById(id));
                req.getRequestDispatcher("/admin/departments/department-edit.jsp").forward(req, resp);
                break;

            case "delete":
                int idDel = Integer.parseInt(req.getParameter("id"));
                dao.delete(idDel);
                resp.sendRedirect(req.getContextPath() + "/admin/departments");
                break;

            default:
                resp.sendRedirect(req.getContextPath() + "/admin/departments");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        switch (action) {
            case "add":
                Department d1 = new Department();
                d1.setTenphongban(req.getParameter("tenphongban"));
                d1.setNguoiquanly(req.getParameter("nguoiquanly"));
                dao.insert(d1);
                resp.sendRedirect(req.getContextPath() + "/admin/departments");
                break;

            case "update":
                Department d2 = new Department();
                d2.setId(Integer.parseInt(req.getParameter("id")));
                d2.setTenphongban(req.getParameter("tenphongban"));
                d2.setNguoiquanly(req.getParameter("nguoiquanly"));
                dao.update(d2);
                resp.sendRedirect(req.getContextPath() + "/admin/departments");
                break;

            default:
                resp.sendRedirect(req.getContextPath() + "/admin/departments");
        }
    }
}
