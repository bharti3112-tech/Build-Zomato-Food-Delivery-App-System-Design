package Models;

import strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private static int nextOrderId =0;
    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> menuItemList;
    protected double total;
    protected PaymentStrategy paymentStrategy;
    protected String scheduled;

    public Order() {
        this.user = null;
        this.restaurant = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }
    public void setPaymentStrategy(PaymentStrategy p) {
        paymentStrategy = p;
    }
    public boolean processPayment(){
       if(paymentStrategy != null){
           paymentStrategy.pay(total);
           return true;
       }
       else {
           System.out.println("Please choose a payment mode first");
           return false;
       }
    }
    public void setScheduled(String s) {
        scheduled = s;
    }

    public String getScheduled() {
        return scheduled;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setUser(User u) {
        user = u;
    }

    public User getUser() {
        return user;
    }

    public void setRestaurant(Restaurant r) {
        restaurant = r;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    public abstract String getType();
    public void setItems(List<MenuItem> its) {
        menuItemList  = its;
        total = 0;
        for (MenuItem i : menuItemList) {
            total += i.getPrice();
        }
    }

    public List<MenuItem> getItems() {
        return menuItemList;
    }
}
