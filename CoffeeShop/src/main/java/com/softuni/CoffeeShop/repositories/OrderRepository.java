package com.softuni.CoffeeShop.repositories;

import com.softuni.CoffeeShop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByName(String name);

    List<Order> findByUserId(long ownerId);

    List<Order> findByUserIdNot(long ownerId);

    List<Order>findByOrderByPriceDesc();
}
