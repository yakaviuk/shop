package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Goods;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImp implements GoodsDAO {
    private Transaction transaction = null;

    @Override
    public List<Goods> findAll() {
        List<Goods> goodsAll = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("From Goods");
            goodsAll = (List) query.getResultList();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return goodsAll;
    }
}