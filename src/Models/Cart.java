package Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> menuItemList = new ArrayList<>();
    public Cart(){
        restaurant = null;
    }
    public void setRestaurant(Restaurant r){
        this.restaurant = r;
    }
    public void addItems(MenuItem item){
        if(restaurant == null){
            System.out.println("Please add restaurant first");
            return;
        }
        menuItemList.add(item);
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public List<MenuItem> getMenuItemList(){
        return menuItemList;
    }
    public boolean isEmpty(){
        return restaurant==null || menuItemList.isEmpty();
    }
    public void clear(){
        menuItemList.clear();
        restaurant = null;
    }
    public double getTotalCost(){
        double price =0;
        for(MenuItem it : menuItemList){
            price += it.getPrice();
        }
        return price;
    }
}
