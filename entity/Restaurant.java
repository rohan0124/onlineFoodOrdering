package entity;

import java.util.ArrayList;
import java.util.List;


public class Restaurant {
    private static int count;
    private Integer id;
    private String name;
    List<String> serviceArea;
    List<FoodItem> foodItems;
    private Float rating;

    public String getName() {
        return name;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public Integer getId() {
        return id;
    }

    public FoodItem getFoodItem(){
        return foodItems.get(0);
    }

    private List<Review> reviews;

    public Restaurant(String name, List<String> serviceArea) {
        this.id =++count;
        this.name = name;
        this.serviceArea = serviceArea;
        this.foodItems = new ArrayList<>();
        this.reviews= new ArrayList<>();
    }
    public void addFoodItem(FoodItem foodItem){
        this.foodItems.add(foodItem);
    }
    public void addReview(Review review){
        this.reviews.add((review));
    }
}
