package dao;

import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.InitializingBean;
import javax.sql.DataSource;
import java.util.List;

/**
 * 16.03.2019
 * UsersDaoImpl
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class UsersDaoImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from users where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from users";

    //language=SQL
    private static final String SQL_INSERT_USER =
            "insert into users(login, hashpassword, status) values (?,?,?)";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL =
            "select * from users where email = ?";

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .login(resultSet.getString("login"))
            .hashPassword(resultSet.getString("hashpassword"))
            .build();

    public UsersDaoImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL,userRowMapper,email);
    }

    @Override
    public User find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, id);
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(SQL_INSERT_USER, model.getLogin(),model.getHashPassword(), model.getStatus());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }
}
