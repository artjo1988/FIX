package ru.ivmiit.DAO;

import ru.ivmiit.model.User;

import java.util.List;

/**
 * Created by Макс on 16.04.2018.
 */
public interface UsersDAO extends CrudDAO <User>  {
   List<User> findAllByCity (String city);
}
