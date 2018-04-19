package ru.ivmiit.repository;

import ru.ivmiit.model.User;

import java.util.List;

/**
 * Created by Макс on 24.03.2018.
 */
public interface Repository {
    List<User> findAll();
    void save(User user);
    boolean isExist(String name, String password);
    User getUser(String name);
    boolean isExistName(String name);
}
