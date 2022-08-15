package com.softuni.CoffeeShop.models.dto;

import com.softuni.CoffeeShop.models.Category;
import com.softuni.CoffeeShop.models.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {

    private long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime time;
    private Category category;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.price = order.getPrice();
        this.time = order.getTime();
        this.category = order.getCategory();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public OrderDTO() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
