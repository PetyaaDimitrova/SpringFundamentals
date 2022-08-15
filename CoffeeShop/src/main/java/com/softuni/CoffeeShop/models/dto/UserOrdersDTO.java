package com.softuni.CoffeeShop.models.dto;

public class UserOrdersDTO {

    private String username;
    private Integer countOfOrders;

    public UserOrdersDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
    }
}
