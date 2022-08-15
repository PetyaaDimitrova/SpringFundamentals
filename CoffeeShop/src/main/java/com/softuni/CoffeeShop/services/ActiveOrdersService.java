package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.Order;
import com.softuni.CoffeeShop.models.dto.OrderDTO;
import com.softuni.CoffeeShop.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ActiveOrdersService {

    private final OrderRepository orderRepository;

    public ActiveOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void prepare(OrderDTO orderDTO) {
        Optional<Order> employeeOpt = this.orderRepository.findById((long) orderDTO.getId());

        if (employeeOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Order order = employeeOpt.get();

        long newOrderTime = orderDTO.getTime().getMinute() - order.getCategory().getNeededTime();

        if (newOrderTime <= 0) {
            this.orderRepository.delete(order);
        }
    }


}
