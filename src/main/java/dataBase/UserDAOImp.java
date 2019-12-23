package dataBase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.User;
import util.HibernateUtil;

public class UserDAOImp implements UserDAO {
    private Transaction transaction = null;

    User user;
    public User getUser(String login) {
        System.out.println("DAO: "+login  );
        user = new User();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query query = session.createQuery("SELECT * FROM User  where login = '"+login+"'");
            user = session.get(User.class, login);
         //   user = (User) query.getSingleResult();
            System.out.println("DAO2: "+user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackaddTrace();
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
