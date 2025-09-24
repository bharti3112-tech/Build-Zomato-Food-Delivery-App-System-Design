package factory;

import Models.*;
import strategies.PaymentStrategy;
import utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory{
    @Override
    public Order createOrder(User user, Restaurant restaurant, Cart cart, List<MenuItem> items, PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;
        if (orderType.equals("delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(items);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}
