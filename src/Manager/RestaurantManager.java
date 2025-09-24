package Manager;

import Models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    List<Restaurant> restaurantsList = new ArrayList<>();
    private static RestaurantManager instance = null;
    private RestaurantManager(){
        //constructor
    }
    public static RestaurantManager getInstance(){
        if(instance == null){
            instance = new RestaurantManager();
        }
        return instance;
    }
    public void addRestaurant(Restaurant r){
        restaurantsList.add(r);
    }
    public List<Restaurant> searchByLoc(String loc){
        List<Restaurant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restaurant r: restaurantsList){
            String rl = r.getLocation().toLowerCase();
            if (rl.equals(loc)) {
                result.add(r);
            }
        }
        return result;
    }
}
