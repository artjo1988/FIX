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
import java.util.List;
import java.util.Properties;

/**
 * Created by Макс on 02.05.2018.
 */
@WebServlet("/findByCity")
public class ManagementFindByCityServlet extends HttpServlet {

    private UsersDao usersDao;

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
            usersDao = new UsersDaoJdbcImpl(dataSource);
        } catch(IOException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/findByCity.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("name");
        if (usersDao.isExistCity(city)){
            List <User> list = usersDao.findAllByCity(city);
            req.setAttribute("usersFromServerFindByCity",list);
            req.getServletContext().getRequestDispatcher("/jsp/findByCity.jsp").forward(req, resp);
        }
        else {
            String message = "This city is missing!";
            req.setAttribute("messageFindByCityServlet", message);
            req.getServletContext().getRequestDispatcher("/jsp/findByCity.jsp").forward(req, resp);
        }
    }
}
