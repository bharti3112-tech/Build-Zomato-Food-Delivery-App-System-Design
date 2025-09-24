import Manager.OrderManager;
import Manager.RestaurantManager;
import Models.*;
import factory.NowOrderFactory;
import factory.OrderFactory;
import factory.ScheduledFactory;
import services.NotificationService;
import strategies.PaymentStrategy;

import java.util.List;

public class Tomato {
    public Tomato(){
        initalizeRest();
    }
    public void initalizeRest(){
        Restaurant r1  = new Restaurant("Hiralal","Patna");
        r1.addItem(new MenuItem("P1", "Chole Bhature", 120));
        r1.addItem(new MenuItem("P2", "Samosa", 15));
        Restaurant r2  = new Restaurant("Bikaner","UP");
        r2.addItem(new MenuItem("P1", "Raj Kachori", 80));
        r2.addItem(new MenuItem("P2", "Pav Bhaji", 100));
        r2.addItem(new MenuItem("P3", "Dhokla", 50));
        Restaurant r3  = new Restaurant("Haldiram","Delhi");
        r3.addItem(new MenuItem("P1", "Masala Dosa", 90));
        r3.addItem(new MenuItem("P2", "Idli Vada", 60));
        r3.addItem(new MenuItem("P3", "Filter Coffee", 30));
        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(r1);
        restaurantManager.addRestaurant(r2);
        restaurantManager.addRestaurant(r3);
    }
    public List<Restaurant> searchRestaurant(String loc){
       return RestaurantManager.getInstance().searchByLoc(loc);
    }
    public void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }
    public void addToCart(User user,String itemcode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first.");
            return;
        }
        for(MenuItem menuItem:restaurant.getMenu()){
            if(menuItem.getCode().equals(itemcode)){
                user.getCart().addItems(menuItem);
              break;
            }
        }
    }
    public Order checkoutNow(User user, String orderType, PaymentStrategy paymentStrategy){
        return checkoutOrder(user,orderType,paymentStrategy,new NowOrderFactory());
    }
    public Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy,String scheduleTime){
        return checkoutOrder(user,orderType,paymentStrategy,new ScheduledFactory(scheduleTime));
    }
   public Order checkoutOrder(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){
        if(user.getCart().isEmpty()) return null;
        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();
        List<MenuItem> menuItemList = cart.getMenuItemList();
        double totalCost = cart.getTotalCost();
        Order order = orderFactory.createOrder(user,restaurant,cart,menuItemList,paymentStrategy,totalCost,orderType);
       OrderManager.getInstance().addOrder(order);
       return order;
   }
   public void payForOrder(User user, Order order){
       boolean isPaymentSuccess = order.processPayment();
       if(isPaymentSuccess){
           NotificationService.notify(order);
           user.getCart().clear();
       }
   }
   public void printUserCart(User user){
        for(MenuItem item: user.getCart().getMenuItemList()){
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
       System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
   }
}
