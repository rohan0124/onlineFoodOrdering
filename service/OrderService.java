package service;

import entity.FoodItem;
import entity.Order;
import entity.Restaurant;
import entity.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {
    private RestaurantService restaurantService;
    private UserService userService;

    private static OrderService instance = null;
    HashMap<Integer, List<Order>> orderMap;
    HashMap<Integer,List<Review>> reviewMap;
    private OrderService(){
        this.orderMap = new HashMap<>();
        this.reviewMap =  new HashMap<>();

    }
    public static OrderService getInstance(){
        if(instance==null){
            instance=new OrderService();
        }
        return instance;
    }

    void placeOrder( String name, Integer quantity){
        if(quantity ==null){
            System.out.println("Please select valid quantity");
            return;
        }
        restaurantService =RestaurantService.getInstance();
        userService =UserService.getInstance();

        Restaurant restaurant= restaurantService.getByName(name);
        if(restaurant ==null){
            System.out.println("Please select valid Restaurant");
            return;
        }
        FoodItem foodItem =restaurant.getFoodItem();

        if(foodItem.getQuantity()<quantity){
            System.out.println("Unavailable !! Insufficient quantity");
            return;
        }
        Order order= new Order(userService.getCurrentUserId(),restaurant.getId(),foodItem.getId(),quantity);
        List<Order> orderList= orderMap.getOrDefault(userService.getCurrentUserId(),new ArrayList<>());
        orderList.add(order);
        orderMap.put(userService.getCurrentUserId(),orderList);
        Integer currentQuantity = foodItem.getQuantity();
        foodItem.setQuantity(currentQuantity-quantity);
        Integer price =  foodItem.getPrice();
        System.out.println("Order made successfully for " + foodItem.getName()+" from "+ restaurant.getName() +" !! Price paid "+ price*quantity );
    }

    void createReview(String name, Double rating, String comment){
        Restaurant restaurant = restaurantService.getByName(name);
        Review review = new Review(userService.getCurrentUserId(),restaurant.getId(),rating,comment);
        restaurant.addReview(review);
        List<Review> reviewList =reviewMap.getOrDefault(userService.getCurrentUserId(),new ArrayList<>());
        reviewList.add(review);
        reviewMap.put(userService.getCurrentUserId(), reviewList);
    }


}
