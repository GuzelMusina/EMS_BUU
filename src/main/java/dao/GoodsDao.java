package dao;

import models.Goods;

import java.util.List;
/**
 * 16.03.2019
 * GoodsDao
 *
 * @author Guzel Musina (ITIS)
 * @version v1.0
 */
public interface GoodsDao extends BaseCrudDao<Goods> {

    List<Goods> findAllByName(String name);

}
