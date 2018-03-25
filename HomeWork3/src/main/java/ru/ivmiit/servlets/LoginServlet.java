package ru.ivmiit.servlets;

import ru.ivmiit.repository.DataBaseImplRep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Макс on 25.03.2018.
 */

@WebServlet("/login")

public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if(new DataBaseImplRep().isExist(name, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user",name);
            String city = req.getParameter("city");
            Cookie cookieCity = new Cookie("city", city);
            resp.addCookie(cookieCity);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }


    }
}
