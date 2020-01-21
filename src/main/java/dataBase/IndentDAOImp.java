package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
    public List<Goods> getCartList (Long idUser) {
        List<Goods> orderedList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("Select g.goods_name, g.goods_price from \n" +
                    "( SELECT id_goods, name FROM indent left join user ON indent.id_user = user.id_user where indent_status = 1 AND user.id_user = '"+ idUser +"') a\n" +
                    "left join goods g\n" +
                    "ON a.id_goods = g.id_goods\n");
            orderedList = (List) query.getResultList();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return orderedList;
    }
}
