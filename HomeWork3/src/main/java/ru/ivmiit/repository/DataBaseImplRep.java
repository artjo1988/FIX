package ru.ivmiit.repository;

import org.mindrot.jbcrypt.BCrypt;
import ru.ivmiit.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.postgresql.jdbc.EscapedFunctions.INSERT;

/**
 * Created by Макс on 24.03.2018.
 */
public class DataBaseImplRep implements Repository {

    static private Connection connection;
    static private Statement statement;
    private List<User> users;
    private User user;

    static{
         try {
             String dbUser = "postgres";
             String dbPassword = "20061988";
             String connectionUrl = "jdbc:postgresql://localhost:5432/fix_users";
             Class.forName("org.postgresql.Driver");

             connection = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
             statement = connection.createStatement();
         }
         catch(Exception e){

         }
    }

    public DataBaseImplRep(){
        this.users = new ArrayList<>();
    }

    @Override
    public List<User> findAll (){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fix_user");
            while (resultSet.next()) {
                users.add(new User(resultSet.getString("name"), resultSet.getString("password"),
                        LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("city")));
            }

        }
        catch(Exception e){}
        return users;
    }

    @Override
    public void save (User user) {
        try {
            String nameUs = user.getName();
            String passwordUs = user.getPassword();
            String birthdayUs = user.getBirthDay().toString();
            String cityUs = user.getCity();
            int i = statement.executeUpdate("INSERT INTO fix_user(name, password, birthday, city) VALUES( '" + nameUs + "', '" + passwordUs + "', '" + birthdayUs + "', '" + cityUs + "')");
        }
        catch(Exception e){}
    }

    @Override
    public boolean isExist (String name, String password) {
        for(User user : findAll()) {
            if (user.getName().equals(name) && BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public User getUser (String name) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fix_user WHERE name = '" + name + "'");
            while(resultSet.next())user = new User(resultSet.getString("name"), resultSet.getString("password"),
                    LocalDate.parse(resultSet.getString("birthday")), resultSet.getString("city"));
        }
        catch(Exception e){}
        return user;
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
}
