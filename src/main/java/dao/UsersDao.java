package dao;

import models.User;
/**
 * 16.03.2019
 * UsersDao
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public interface UsersDao extends BaseCrudDao<User> {

    User findByEmail(String email);

}
