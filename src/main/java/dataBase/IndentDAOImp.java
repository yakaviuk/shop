package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Indent;
import util.HibernateUtil;

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
}
