package servlets;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.DoubleType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import pojo.Goods;
import pojo.Indent;
import pojo.User;
import services.IndentService;
import services.IndentServiceImp;
import services.UserServiceImp;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

//List <Object[]>
   static public List <Goods> getCartList(Long idUser) {
         Transaction transaction = null;
        Indent indent;
        List<Goods> goodsList = new ArrayList<>();
       // List<Goods>  orderedList1 = new ArrayList<Goods>();
       List <Object[]>  orderedList1;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
       //     Query query = session.createQuery(" From Goods g left join Indent i ON g.idGoods = i.idGoods where i.idUser = '" + idUser + "' AND i.indentStatus = 1 ");
            Query query = session.createSQLQuery("SELECT g.goods_name, g.goods_price from goods g left join indent i ON g.id_goods = i.id_goods where i.id_user = 30 AND i.indent_status = 1")
                    .addScalar("goods_name", new StringType())
                    .addScalar("goods_price", new DoubleType());

            //     orderedList = (List) query.getResultList();

            orderedList1 = query.list();
            for(Object [] row : orderedList1){
                Goods goods = new Goods();
                goods.setGoodsName(row[0].toString());
                goods.setGoodsPrice(Double.parseDouble(row[1].toString()));
              //  System.out.println(goods);
                goodsList.add(goods);
            }

         //   System.out.println(" start: " + goodsList.toString());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return goodsList;
    }

    public static void main(String[] args) {
        System.out.println(" start: " + getCartList(22L));
       // getCartList(30L);


        }




}