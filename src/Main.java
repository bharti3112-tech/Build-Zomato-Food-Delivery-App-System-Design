import Models.Order;
import Models.Restaurant;
import Models.User;
import strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tomato tomato = new Tomato();
        User user = new User(101, "Aditya", "Delhi");
        List<Restaurant> restaurantList = tomato.searchRestaurant("Delhi");
        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }
        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }
        tomato.selectRestaurant(user,restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);
        Order order = tomato.checkoutNow(user, "delivery", new UpiPaymentStrategy("1234567890"));
        tomato.payForOrder(user, order);
    }
}