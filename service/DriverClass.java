package service;


import entity.Restaurant;
import entity.User;

import java.util.Arrays;
import java.util.List;


public class DriverClass{
    public static void main(String[] args){
        System.out.println("Execution started");
        UserService userService = UserService.getInstance();
        RestaurantService restaurantService = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();

        User user1 = userService.registerUser("User_a","F","9898989891L","HSR");
        User user2 = userService.registerUser("User_b","M","9898989892L","ITPL");
        User user3 = userService.registerUser("User_c","F","9898989893L","BTM");

        User logIn = userService.login(user1.getPhoneNumber());
        Restaurant r1 = restaurantService.registerRestaurant("r_a", Arrays.asList("HSR","ITPL","BTM"),"pizza",100,3);
        Restaurant r2 = restaurantService.registerRestaurant("r_b",Arrays.asList("HSR","ITPL"),"burger",50,35);
        logIn=userService.login(user2.getPhoneNumber());
        Restaurant r3 = restaurantService.registerRestaurant("r_c",Arrays.asList("HSR","ITPL","BTM","WhiteField"),"burger",50,75);


        Restaurant r4 = restaurantService.registerRestaurant("r_d",Arrays.asList("Sarjapur","WhiteField"),"burger",50,15);

        logIn=userService.login(user1.getPhoneNumber());
        orderService.placeOrder("r_a",10);
        restaurantService.updateQuantity("r_a",30);
        orderService.placeOrder("r_a",10);

        logIn=userService.login(user3.getPhoneNumber());
        orderService.placeOrder("r_b",10);


        orderService.placeOrder("r_b",10);

//        List<Order> orderList=orderService.listOrders();
//        restaurantService.showRestaurant("rating");

        System.out.println("Execution ended");
    }
}
