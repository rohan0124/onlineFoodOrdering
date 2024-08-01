package entity;

public class Review {
    private static int count=0;
    private Integer id;
    private Integer userId;
    private Integer restaurantId;
    private Double rating;
    private String comment;

    public Review(Integer userId, Integer restaurantId, Double rating, String comment) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.comment = comment;
    }
}
