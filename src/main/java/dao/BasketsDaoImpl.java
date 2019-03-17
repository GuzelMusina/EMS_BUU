package dao;

import lombok.SneakyThrows;
import models.Basket;
import models.Goods;
import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * 16.03.2019
 * BasketDaoImpl
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public class BasketsDaoImpl implements BasketsDao {
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_BASKET_BY_OWNER_ID =
            "select * from basket where userowner = ?;";

    //language=SQL
    private static final String SQL_INSERT_BASKET =
            "insert into basket(userowner) values (?);";

    //language=SQL
    private static final String SQL_INSERT_INTO_BASKET_GOODS =
            "insert into basket_goods (goods_id, basket_id) values (?, ?);";


    private RowMapper<Basket> basketRowMapper = (resultSet, i) -> Basket.builder()
            .id(resultSet.getLong("id"))
            .build();

    private RowMapper<Goods> goodsRowMapper = (resultSet, i) -> Goods.builder()
            .id(resultSet.getLong("goods_id"))
            .name(resultSet.getString("name"))
            .build();


    @SneakyThrows
    public BasketsDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Basket find(Long id) {
        return null;
    }

    @Override
    public void save(Basket model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Basket model) {

    }

    @Override
    public List<Basket> findAll() {
        return null;
    }

    @Override
    public List<Goods> getGoodsList(Basket basket) {
        return null;
    }

    @Override
    public void addGoods(Goods goods, Basket basket) {
        jdbcTemplate.update(SQL_INSERT_INTO_BASKET_GOODS, goods.getId(), basket.getId());
    }

    @Override
    public boolean isExistByUser(User basketOwner) {
        List<Basket> baskets = jdbcTemplate.query(SQL_SELECT_BASKET_BY_OWNER_ID, basketRowMapper, basketOwner.getId());
        return baskets.size() > 0;
    }

    @Override
    public void deleteGoods(Goods goods, Basket basket) {

    }

    @Override
    public Basket findByOwner(User basketOwner) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BASKET_BY_OWNER_ID, basketRowMapper, basketOwner.getId());
    }
}
