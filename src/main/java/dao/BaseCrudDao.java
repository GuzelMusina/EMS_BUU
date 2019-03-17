package dao;

import java.util.List;

/**
 * 16.03.2019
 * BaseCrudDao
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public interface BaseCrudDao<T> {
    T find(Long id);
    void save(T model);
    void delete(Long id);
    void update(T model);

    List<T> findAll();
}
