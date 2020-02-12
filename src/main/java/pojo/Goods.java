package pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="goods")
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

    @OneToMany(mappedBy = "goods")
    private List<Indent> orders;

    public Goods() {
    }

    public Goods(String goodsName, Double goodsPrice, String description, String country, String goodsImage) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.description = description;
        this.country = country;
        this.goodsImage = goodsImage;
    }

    public Long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Long idGoods) {
        this.idGoods = idGoods;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (idGoods != null ? !idGoods.equals(goods.idGoods) : goods.idGoods != null) return false;
        if (goodsName != null ? !goodsName.equals(goods.goodsName) : goods.goodsName != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(goods.goodsPrice) : goods.goodsPrice != null) return false;
        if (description != null ? !description.equals(goods.description) : goods.description != null) return false;
        if (country != null ? !country.equals(goods.country) : goods.country != null) return false;
        return goodsImage != null ? goodsImage.equals(goods.goodsImage) : goods.goodsImage == null;
    }

    @Override
    public int hashCode() {
        int result = idGoods != null ? idGoods.hashCode() : 0;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (goodsImage != null ? goodsImage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "idGoods=" + idGoods +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }
}