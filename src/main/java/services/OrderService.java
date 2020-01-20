package services;

import pojo.Indent;

public interface OrderService {
    boolean createOrder (Indent indent);
    boolean setOrderFalse (Long idOrder);
    boolean setOrderTrue (Long idOrder);
    }
