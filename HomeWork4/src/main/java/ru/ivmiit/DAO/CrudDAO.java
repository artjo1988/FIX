package ru.ivmiit.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Макс on 16.04.2018.
 */
public interface CrudDAO <T> {
    Optional <T> find (String name);

    void save(T model);
    void update(String name, T model);
    void delete(String name);

    List <T> findAll();
}
