package com.softuni.CoffeeShop.models.dto;

import com.softuni.CoffeeShop.models.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {

    private long id;
    private String name;
    private BigDecimal price;
    private LocalDateTime time;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.price = order.getPrice();
        this.time = order.getTime();
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
