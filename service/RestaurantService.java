package service;

import entity.FoodItem;
import entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static RestaurantService restaurantService=null;
    List<Restaurant> restaurantList;
    private RestaurantService(){
        this.restaurantList = new ArrayList<>();

    }
    public static RestaurantService getInstance(){
        if(restaurantService==null){
            restaurantService=new RestaurantService();
        }
        return restaurantService;
    }

    Restaurant registerRestaurant(String name, List<String> serviceableArea, String foodName, Integer foodPrice, Integer foodQuantity){
        FoodItem foodItem = new FoodItem(foodName,foodPrice,foodQuantity );
        Restaurant restaurant = new Restaurant(name,serviceableArea);
        restaurant.addFoodItem(foodItem);
        restaurantList.add(restaurant);
        System.out.println("Restaurant registered successfully - " + restaurant.getName() );
        return restaurant;
    }
    Restaurant getByName(String name){
        for(Restaurant res:restaurantList){
            if(res.getName().equals(name)){
                return res;
            }
        }
        return null;
    }
    void updateQuantity(String name, Integer newQuantity){
        Restaurant restaurant = getByName(name);
        restaurant.getFoodItem().setQuantity(newQuantity);
        System.out.println("Quantity updated successfully "+ restaurant.getName() );
    }



}
