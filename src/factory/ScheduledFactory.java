package factory;

import Models.*;
import strategies.PaymentStrategy;

import java.util.List;

public class ScheduledFactory implements OrderFactory{
    private String scheduleTime;
    public ScheduledFactory(String scheduleTime){
        this.scheduleTime = scheduleTime;
    }
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
        order.setScheduled(scheduleTime);
        order.setTotal(totalCost);
        return order;
    }
}
