package ru.ivmiit.servlets;

import org.mindrot.jbcrypt.BCrypt;
import ru.ivmiit.models.User;
import ru.ivmiit.repository.DataBaseImplRep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Макс on 24.03.2018.
 */

@WebServlet("/signUp")

public class SingUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = null;
        users = new DataBaseImplRep().findAll();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String hashPassword =  BCrypt.hashpw(password, BCrypt.gensalt());
        LocalDate birthDay = LocalDate.parse(req.getParameter("birthDay"));
        String city = req.getParameter("city");
        if (new DataBaseImplRep().isExist(name, password) || new DataBaseImplRep().isExistName(name)) doGet(req, resp);
        else {
            User user = new User(name, hashPassword, birthDay,city);
            new DataBaseImplRep().save(user);
            req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
        }
    }

}
