package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.service.OrderServiceModel;
import com.softuni.CoffeeShop.models.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);
}
