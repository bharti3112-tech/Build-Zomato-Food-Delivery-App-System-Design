package Models;

public class PickupOrder extends Order{
    private String restaurantAddress;

    @Override
    public String getType() {
        return "pickup";
    }
    public PickupOrder() {
        restaurantAddress = "";
    }
    public void setRestaurantAddress(String addr) {
        restaurantAddress = addr;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

}
