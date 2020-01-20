package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Indent;
import util.HibernateUtil;

public class OrderDAOImp implements OrderDAO {
    private Transaction transaction = null;
    Indent indent;

    @Override
    public boolean createOrder(Indent indent) {
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
    public boolean updateOrder(Indent indent) {
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
    public Indent getOrder(Long idUser) {
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
}
