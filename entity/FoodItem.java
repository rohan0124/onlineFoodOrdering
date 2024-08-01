package entity;

import java.util.List;

public class FoodItem {
    private static int count;
    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;


    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public FoodItem(String name, Integer price, Integer quantity) {
        this.id=++count;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
