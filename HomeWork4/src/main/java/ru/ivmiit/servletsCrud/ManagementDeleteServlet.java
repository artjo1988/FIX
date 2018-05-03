package ru.ivmiit.servletsCrud;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ivmiit.DAO.UsersDao;
import ru.ivmiit.DAO.UsersDaoJdbcImpl;
import ru.ivmiit.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@WebServlet("/delete")
public class ManagementDeleteServlet extends HttpServlet {

    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {
        try{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
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
            usersDao = new UsersDaoJdbcImpl(dataSource);
        } catch(IOException e){
            throw new IllegalStateException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if(usersDao.isExistName(name)){
            User user = usersDao.find(name);
            req.setAttribute("usersFromServerDelete", user);
            usersDao.delete(name);
            req.getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req,resp);
        }
        else {
            String message = "A user with this name does not exist!";
            req.setAttribute("messageDeleteServlet", message);
            req.getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(req,resp);
        }
    }
}
