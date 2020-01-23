package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import pojo.Goods;
import pojo.Indent;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class IndentDAOImp implements IndentDAO {
    private Transaction transaction = null;
    Indent indent;

    @Override
    public boolean createIndent(Indent indent) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(indent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateIndent(Indent indent) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(indent);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Indent getIndent(Long idUser) {
        indent = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            indent = session.get(Indent.class, idUser);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return indent;
    }

    @Override
    public List<Goods> getCartList(Long idUser) {
        List<Goods> cartList = new ArrayList<>();
        List<Object[]> orderedList1;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createSQLQuery("SELECT g.goods_name, g.goods_price from goods g left join indent i ON g.id_goods = i.id_goods where i.id_user = 30 AND i.indent_status = 1")
                    .addScalar("goods_name", new StringType())
                    .addScalar("goods_price", new DoubleType());
            orderedList1 = query.list();
            for (Object[] row : orderedList1) {
                Goods goods = new Goods();
                goods.setGoodsName(row[0].toString());
                goods.setGoodsPrice(Double.parseDouble(row[1].toString()));
                cartList.add(goods);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cartList;
    }
}