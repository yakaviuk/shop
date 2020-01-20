package pojo;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Indent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_goods")
    private Long idGoods;

    @Column(name = "order_status")
    private Integer status;


    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    //, referencedColumnName = "id_user", insertable = false, updatable = false
    private User user1;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
            // (optional = false)
    @JoinColumn(name = "id_goods", insertable = false, updatable = false) //, referencedColumnName = "id_order", insertable = false, updatable = false)
    private Goods goods;

    public Indent() {
    }

    public Indent(Long idUser, Long idGoods, Integer status) {
        this.idUser = idUser;
        this.idGoods = idGoods;
        this.status = status;
    }

    public Indent(Long idUser, Long idGoods) {
        this.idUser = idUser;
        this.idGoods = idGoods;
        this.status = 1;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", idGoods=" + idGoods +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Indent indent = (Indent) o;

        if (getIdOrder() != null ? !getIdOrder().equals(indent.getIdOrder()) : indent.getIdOrder() != null) return false;
        if (getIdUser() != null ? !getIdUser().equals(indent.getIdUser()) : indent.getIdUser() != null) return false;
        if (getIdGoods() != null ? !getIdGoods().equals(indent.getIdGoods()) : indent.getIdGoods() != null) return false;
        return getStatus() != null ? getStatus().equals(indent.getStatus()) : indent.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdOrder() != null ? getIdOrder().hashCode() : 0;
        result = 31 * result + (getIdUser() != null ? getIdUser().hashCode() : 0);
        result = 31 * result + (getIdGoods() != null ? getIdGoods().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}
