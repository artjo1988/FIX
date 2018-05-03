package ru.ivmiit.servletsCrud;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Макс on 20.04.2018.
 */

@WebServlet("/management")
public class ManagementServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/management.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("crud");
        if (s.equals("create")) resp.sendRedirect(req.getContextPath() + "/create");
        else if (s.equals("update")) resp.sendRedirect(req.getContextPath() + "/nameForUpdate");
        else if (s.equals("delete")) resp.sendRedirect(req.getContextPath() + "/delete");
        else if (s.equals("find")) resp.sendRedirect(req.getContextPath() + "/find");
        else if (s.equals("findAll")) resp.sendRedirect(req.getContextPath() + "/findAll");
        else if (s.equals("findByCity")) resp.sendRedirect(req.getContextPath() + "/findByCity");
        else resp.sendRedirect(req.getContextPath() + "/management");
    }
}
