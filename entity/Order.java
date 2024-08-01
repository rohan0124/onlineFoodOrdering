package entity;

public class Order {
    private static int count=0;

    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Integer foodItemId;
    private Integer quantity;

    public Order(Integer userId, Integer restaurantId, Integer foodItemId, Integer quantity) {
        this.id =++count;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.foodItemId = foodItemId;
        this.quantity = quantity;
    }
}
