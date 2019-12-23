package services;

public interface OrderService {
    boolean createOrder (Long idOrder);
    boolean setOrderFalse (Long idOrder);
    boolean setOrderTrue (Long idOrder);
    }
