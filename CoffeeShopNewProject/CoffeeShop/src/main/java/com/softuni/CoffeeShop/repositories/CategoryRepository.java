package com.softuni.CoffeeShop.repositories;

import com.softuni.CoffeeShop.models.entity.Category;
import com.softuni.CoffeeShop.models.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum name);
}
