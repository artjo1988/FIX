package ru.ivmiit.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.ivmiit.models.User;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import org.hibernate.cfg.Configuration;

/**
 * Created by Макс on 02.05.2018.
 */
public class UsersDaoHibernate implements UsersDao {

    private Session session;

    public UsersDaoHibernate() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "20061988");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.addResource("User.hbm.xml");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
    }

    @Override
    public List<User> findAllByCity(String city) {
        return null;
    }

    @Override
    public User find(String name) {
        return null;
    }

    @Override
    public void create(User model) {
        session.beginTransaction();
        session.save(new User(1, model.getName(), model.getPassword(), model.getBirthDay(), model.getCity()));
        session.getTransaction().commit();
    }

    @Override
    public boolean isExist(String name, String password) {
        return false;
    }

    @Override
    public void update(String name, User model) {

    }

    @Override
    public boolean isExistName(String name) {
        return false;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public boolean isExistCity(String city) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
