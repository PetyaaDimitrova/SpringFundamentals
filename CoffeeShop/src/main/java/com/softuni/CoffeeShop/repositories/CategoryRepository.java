package com.softuni.CoffeeShop.repositories;

import com.softuni.CoffeeShop.models.Category;
import com.softuni.CoffeeShop.models.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByName(OrderType name);
}
