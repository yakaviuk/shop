package servlets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Indent;
import pojo.User;
import services.IndentService;
import services.IndentServiceImp;
import services.UserServiceImp;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        IndentService orderService = new IndentServiceImp();
        User user = (new UserServiceImp().getUserByLoginService("pechkin"));
//        req.setAttribute("goodsAll", goodsService.findAll());
//        req.getSession().setAttribute("name", user.getName());
//        req.getSession().setAttribute("login", user.getLogin());
//        req.getSession().setAttribute("userId", user.getIdUser());
        Long idUser = 22L;
        Long idGoods = 9L;
    //    indentService.createIndent(new Indent( idUser, idGoods ));
        //to be deleted
     //   System.out.println( " userID: " + user.getIdUser() +" ordered "+idGoods);


         Transaction transaction = null;
        Indent indent = new Indent( idUser, idGoods );

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
         //   session.save(indent);
//            Query query = session.createQuery("insert into indent (id_goods, id_user) values idUser, idGoods" );
//            int result = query.executeUpdate();
//            System.out.println(result);


            Query query = session.createNativeQuery(
                    "INSERT INTO order (id_goods, id_user) VALUES (22, 9)");
query.executeUpdate();
          //  transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }
}
