package models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {

    private Long id;
    private User user;
    private List<Goods> goods;

    public void add(Goods good){
        goods.add(good);
    }

    public void remove(Goods good){
        goods.remove(good);
    }

}
