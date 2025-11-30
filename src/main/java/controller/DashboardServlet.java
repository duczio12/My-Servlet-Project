package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward đến trang dashboard
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/dashboard.jsp");
        dispatcher.forward(request, response);
    }
}