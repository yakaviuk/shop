package services;

import dataBase.OrderDAO;
import dataBase.OrderDAOImp;
import pojo.Indent;

public class OrderServiceImp implements OrderService {
    OrderDAO orderDAO;

    @Override
    public boolean createOrder(Indent indent) {
        orderDAO = new OrderDAOImp();
        return orderDAO.createOrder(indent);
    }

    @Override
    public boolean setOrderFalse(Long idOrder) {
        return false;
    }

    @Override
    public boolean setOrderTrue(Long idOrder) {
        return false;
    }
}
