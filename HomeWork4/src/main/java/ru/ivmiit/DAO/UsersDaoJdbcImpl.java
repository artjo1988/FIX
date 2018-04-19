package ru.ivmiit.DAO;

import ru.ivmiit.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Макс on 16.04.2018.
 */
public class UsersDaoJdbcImpl implements UsersDAO {

    //language=SQL
    private final String SQL_SELECT_All = "SELECT name, birthday, city FROM fix_user ";

    //language=SQL
    private final String SQL_SELECT_BY_NAME = "SELECT name, birthday, city FROM fix_user WHERE name = ?";

    //language=SQL
    private final String SQL_SELECT_BY_CITY = "SELECT name, birthday, city FROM fix_user WHERE city = ?";

    //language=SQL
    private final String SQL_SAVE_USER = "INSERT INTO fix_user (name, password, birthday, city) VALUES (?, ?, ?,)";

    //language=SQL
    private final String SQL_DELETE_BY_NAME = "DELETE FROM fix_user WHERE name = ?";

    //language=SQL
    private final String SQL_UPDATE_BY_NAME = "UPDATE fix_user SET name = ?, password = ?, birthday = ?, city WHERE name = ?";

    private Connection connection;

    public UsersDaoJdbcImpl(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> find(String name){
        try{
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String nameResSet = resultSet.getString("name");
                String birthdayResSet = resultSet.getString("birthday");
                String cityResSet = resultSet.getString("city");
                return Optional.of(new User(nameResSet, LocalDate.parse(birthdayResSet), cityResSet));
            }
            return Optional.empty();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAllByCity(String city) {
        try{
            List<User> list = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_CITY);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String nameResSet = resultSet.getString("name");
                String birthdayResSet = resultSet.getString("birthday");
                String cityResSet = resultSet.getString("city");
                list.add(new User(nameResSet, LocalDate.parse(birthdayResSet), cityResSet));
            }
            return list;
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(User model) {
        try{
            String name = model.getName();
            String hashPassword = model.getPassword();
            String birthday = model.getBirthDay().toString();
            String  city = model.getCity();
            PreparedStatement statement = connection.prepareStatement(SQL_SAVE_USER);
            statement.setString(1, name);
            statement.setString(2, hashPassword);
            statement.setString(3, birthday);
            statement.setString(4, city);
            statement.executeUpdate();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(String name, User model) {
        try{
            String nameModel = model.getName();
            String hashPasswordModel = model.getPassword();
            String birthdayModel = model.getBirthDay().toString();
            String cityModel = model.getCity();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_BY_NAME);
            statement.setString(1, nameModel);
            statement.setString(2, hashPasswordModel);
            statement.setString(3, birthdayModel);
            statement.setString(4, cityModel);
            statement.setString(5, name);
            statement.executeUpdate();

        } catch(SQLException e){
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void delete(String name) {
        try{
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_BY_NAME);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try{
            List<User> list = new ArrayList<>();
            PreparedStatement statment = connection.prepareStatement(SQL_SELECT_All);
            ResultSet resultSet = statment.executeQuery();
            while(resultSet.next()){
                String nameResSet = resultSet.getString("name");
                String birthdayResSet = resultSet.getString("birthday");
                String cityResSet = resultSet.getString("city");
                list.add(new User(nameResSet, LocalDate.parse(birthdayResSet), cityResSet));
            }
            return list;
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }


    }
}
