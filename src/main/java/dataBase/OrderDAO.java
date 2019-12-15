package dataBase;

import pojo.Order;

public interface OrderDAO {
    boolean createOrder (Order order);
    boolean updateOrder (Order order);
    Order getOrder (Long id_user); //return array?
}
