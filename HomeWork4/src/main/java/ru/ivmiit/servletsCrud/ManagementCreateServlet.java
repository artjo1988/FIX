package ru.ivmiit.servletsCrud;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ivmiit.DAO.UsersDao;
import ru.ivmiit.DAO.UsersDaoHibernate;
import ru.ivmiit.DAO.UsersDaoJdbcImpl;
import ru.ivmiit.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

/**
 * Created by Макс on 21.04.2018.
 */

@WebServlet("/create")
public class ManagementCreateServlet extends HttpServlet {
    private UsersDao usersDaoHb;
    private UsersDao usersDaoJdbc;

    @Override
    public void init() throws ServletException {
        try {
            DriverManagerDataSource dataSource =
                    new DriverManagerDataSource();
            Properties properties = new Properties();
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.userName");
            String dbPassword = properties.getProperty("db.password");
            String dbDriverClassName = properties.getProperty("db.driverClassName");
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(dbUserName);
            dataSource.setPassword(dbPassword);
            dataSource.setDriverClassName(dbDriverClassName);
            usersDaoHb = new UsersDaoHibernate();
            usersDaoJdbc = new UsersDaoJdbcImpl(dataSource);
        } catch(IOException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String birthDay = req.getParameter("birthDay");
        String city = req.getParameter("city");
        if(usersDaoJdbc.isExist(name,password) || usersDaoJdbc.isExistName(name)){
            String message = "This username already exists!";
            req.setAttribute("messageCreateServlet", message);
            req.getServletContext().getRequestDispatcher("/jsp/create.jsp").forward(req, resp);
        }
        else{
            String hashPassword =  BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User(name, hashPassword, LocalDate.parse(birthDay), city);
            usersDaoHb.create(user);
            User userForAtribute = usersDaoJdbc.find(name);
            req.setAttribute("usersFromServerCreate", userForAtribute);
            req.getServletContext().getRequestDispatcher("/jsp/create.jsp").forward(req, resp);
        }
    }
}
