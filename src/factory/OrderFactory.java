package factory;

import Models.*;
import strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Restaurant restaurant, Cart cart, List<MenuItem> items,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
