package Manager;

import Models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Order> orderList = new ArrayList<>();
    private static OrderManager instance = null;
    private OrderManager(){
        //constructor
    }
    public static OrderManager getInstance(){
        if(instance == null){
            instance = new OrderManager();
        }
        return instance;
    }
    public void addOrder(Order r){
        orderList.add(r);
    }
    public void listOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orderList) {
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }
}
