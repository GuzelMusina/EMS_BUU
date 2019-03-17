package dao;

import models.Goods;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
/**
 * 16.03.2019
 * GoodsDaoImpl
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_GOODS_BY_ID =
            "select * from goods where id = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL_GOODS =
            "select * from goods";
    //language=SQL
    private static final String SQL_INSERT_GOODS =
            "insert into goods(name) values (?)";
    //language=SQL
    private static final String SQL_UPDATE_GOODS =
            "update goods set(name) = (?) where id = ?";
    //language=SQL
    private static final String SQL_DELETE_GOODS =
            "DELETE * FROM goods where id=?";
    //language=SQL
    private static final String SQL_SEARCH=
            "SELECT * from goods WHERE goods.name ilike ?";

    private RowMapper<Goods> goodsRowMapper = (resultSet, i) -> Goods.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .build();
    public GoodsDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Goods> findAllByName(String name) {
        return jdbcTemplate.query(SQL_SEARCH, goodsRowMapper, "%" + name + "%");
    }

    @Override
    public Goods find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_GOODS_BY_ID, goodsRowMapper, id);
    }

    @Override
    public void save(Goods model) {
        jdbcTemplate.update(SQL_INSERT_GOODS, goodsRowMapper, model.getName());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE_GOODS,goodsRowMapper, id);
    }

    @Override
    public void update(Goods model) {

    }

    @Override
    public List<Goods> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_GOODS, goodsRowMapper);

    }
}
