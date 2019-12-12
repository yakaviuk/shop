package pojo;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private long idOrder;

    @Column(name = "id_user")
    private long idUser;

    @Column(name = "id_goods")
    private long idGoods;

    @Column(name = "order_status")
    private boolean status;
}
