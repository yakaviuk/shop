package pojo;

import javax.persistence.*;

@Entity
@Table(name = "indent")
public class Indent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_indent")
    private Long idIndent;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_goods")
    private Long idGoods;

    @Column(name = "indent_status")
    private Integer indentStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_goods", insertable = false, updatable = false)
    private Goods goods;

    public Indent() {
    }

    public Indent(Long idUser, Long idGoods, Integer indentStatus) {
        this.idUser = idUser;
        this.idGoods = idGoods;
        this.indentStatus = indentStatus;
    }

    public Indent(Long idUser, Long idGoods) {
        this.idUser = idUser;
        this.idGoods = idGoods;
        this.indentStatus = 1;
    }

    public Long getIdIndent() {
        return idIndent;
    }

    public void setIdIndent(Long idIndent) {
        this.idIndent = idIndent;
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
        return indentStatus;
    }

    public void setStatus(Integer indentStatus) {
        this.indentStatus = indentStatus;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "idIndent=" + idIndent +
                ", idUser=" + idUser +
                ", idGoods=" + idGoods +
                ", indentStatus='" + indentStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indent indent = (Indent) o;
        if (getIdIndent() != null ? !getIdIndent().equals(indent.getIdIndent()) : indent.getIdIndent() != null)
            return false;
        if (getIdUser() != null ? !getIdUser().equals(indent.getIdUser()) : indent.getIdUser() != null) return false;
        if (getIdGoods() != null ? !getIdGoods().equals(indent.getIdGoods()) : indent.getIdGoods() != null)
            return false;
        return getStatus() != null ? getStatus().equals(indent.getStatus()) : indent.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdIndent() != null ? getIdIndent().hashCode() : 0;
        result = 31 * result + (getIdUser() != null ? getIdUser().hashCode() : 0);
        result = 31 * result + (getIdGoods() != null ? getIdGoods().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}