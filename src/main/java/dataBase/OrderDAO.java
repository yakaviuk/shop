package dataBase;

import pojo.Indent;

public interface OrderDAO {
    boolean createOrder (Indent indent);
    boolean updateOrder (Indent indent);
    Indent getOrder (Long idUser); //return array?
}
