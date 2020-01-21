package servlets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.Goods;
import pojo.Indent;
import pojo.User;
import services.IndentService;
import services.IndentServiceImp;
import services.UserServiceImp;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {





        List<Goods> orderedList = new ArrayList<>();
        orderedList = getCartList(30L);
        System.out.println(orderedList);
//
//
//        IndentService orderService = new IndentServiceImp();
//        User user = (new UserServiceImp().getUserByLoginService("pechkin"));
////        req.setAttribute("goodsAll", goodsService.findAll());
////        req.getSession().setAttribute("name", user.getName());
////        req.getSession().setAttribute("login", user.getLogin());
////        req.getSession().setAttribute("userId", user.getIdUser());
//        Long idUser = 22L;
//        Long idGoods = 9L;
//    //    indentService.createIndent(new Indent( idUser, idGoods ));
//        //to be deleted
//     //   System.out.println( " userID: " + user.getIdUser() +" ordered "+idGoods);
//
//
//         Transaction transaction = null;
//        Indent indent = new Indent( idUser, idGoods );
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//         //   session.save(indent);
////            Query query = session.createQuery("insert into indent (id_goods, id_user) values idUser, idGoods" );
////            int result = query.executeUpdate();
////            System.out.println(result);
//
//
//            Query query = session.createNativeQuery(
//                    "INSERT INTO order (id_goods, id_user) VALUES (22, 9)");
//query.executeUpdate();
//          //  transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//
//        }




    }


    public static List<Goods> getCartList (Long idUser) {
        Transaction transaction = null;
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
