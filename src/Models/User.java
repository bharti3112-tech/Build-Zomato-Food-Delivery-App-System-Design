package Models;

public class User {
    private int userId;
    private String name;
    private String address;
    private Cart cart;
    public User(int id, String name, String address){
        this.userId = id;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public Cart getCart(){
        return cart;
    }
}
