package ru.ivmiit.DAO;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.ivmiit.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Макс on 02.05.2018.
 */
public class UsersDaoJdbcTemplateImpl implements UsersDao {

    private JdbcTemplate template;
    //language=SQL
    private final String SQL_SELECT_All = "SELECT name, password, birthday, city FROM fix_user";
    //language=SQL
    private final String SQL_SELECT_BY_CITY = "SELECT name, birthday, city FROM fix_user WHERE city = ?";

    public UsersDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userrowMapper = (ResultSet resultSet, int i) -> {
        return new User(
                resultSet.getString("name"),
                LocalDate.parse(resultSet.getString("birthday")),
                resultSet.getString("city")
        );
    };


    @Override
    public List<User> findAllByCity(String city) {
        return template.query(SQL_SELECT_BY_CITY, userrowMapper);
    }

    @Override
    public User find(String name) {
        return null;
    }

    @Override
    public void create(User model) {

    }

    @Override
    public void update(String name, User model) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public boolean isExist(String name, String password) {
        for(User user : findAll()){
            if(user.getName().equals(name) && BCrypt.checkpw(password, user.getPassword()))
                return true;
        }
        return false;
    }

    @Override
    public boolean isExistName(String name) {
        for(User user : findAll()) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isExistCity(String city) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_All, userrowMapper);
    }
}
