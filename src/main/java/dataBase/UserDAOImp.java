package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.User;
import util.HibernateUtil;

public class UserDAOImp implements UserDAO {
    private Transaction transaction = null;

    User user;
    public User getUser(String login) {
        user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = session.get(User.class, login);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public boolean createUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.save(user);
            // commit transaction
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
}
