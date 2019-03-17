package dao;

import models.Basket;
import models.Goods;
import models.User;

import java.util.List;

/**
 * 16.03.2019
 * BasketDao
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public interface BasketsDao extends BaseCrudDao<Basket> {

    List<Goods> getGoodsList(Basket basket);

    void addGoods(Goods goods, Basket basket);

    boolean isExistByUser(User basketOwner);

    void deleteGoods(Goods goods, Basket basket);

    Basket findByOwner(User basketOwner);

}
