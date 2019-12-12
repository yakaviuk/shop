package pojo;

import javax.persistence.*;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goods")
    private Long idGoods;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_price")
    private Double goodsPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "country")
    private String country;

    @Column(name = "goods_image")
    private String goodsImage;


}
