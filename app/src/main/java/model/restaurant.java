package model;

public class restaurant {
    private String restaurantName, description, address;
    private int id;

    public restaurant() {
    }

    public restaurant(String restaurantName, String description, String address) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.address = address;
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
}
