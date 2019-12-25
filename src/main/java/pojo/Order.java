package pojo;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_goods")
    private Long idGoods;

    @Column(name = "order_status")
    private boolean status;


    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_user", insertable = false, updatable = false) //, referencedColumnName = "id_user", insertable = false, updatable = false
    private User user1;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_order", insertable = false, updatable = false) //, referencedColumnName = "id_order", insertable = false, updatable = false)
    Goods goods;

    public Order() {
    }

    public Order(Long idUser, Long idGoods, boolean status) {
        this.idUser = idUser;
        this.idGoods = idGoods;
        this.status = status;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Long idGoods) {
        this.idGoods = idGoods;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (idUser != order.idUser) return false;
        if (idGoods != order.idGoods) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (int) (idGoods ^ (idGoods >>> 32));
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idGoods=" + idGoods +
                ", status=" + status +
                '}';
    }
}
