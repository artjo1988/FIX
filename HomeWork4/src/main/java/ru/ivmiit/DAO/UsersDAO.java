package ru.ivmiit.DAO;

import ru.ivmiit.models.User;

import java.util.List;

/**
 * Created by Макс on 16.04.2018.
 */
public interface UsersDao extends CrudDao<User> {
   List<User> findAllByCity (String city);
   boolean isExist(String name, String password);
   boolean isExistName(String name);
   boolean isExistCity(String city);

}
