package com.softuni.CoffeeShop.services.impl;

import com.softuni.CoffeeShop.models.entity.Category;
import com.softuni.CoffeeShop.models.entity.CategoryNameEnum;
import com.softuni.CoffeeShop.repositories.CategoryRepository;
import com.softuni.CoffeeShop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum) {
                        case CAKE -> category.setNeededTime(10);
                        case DRINK -> category.setNeededTime(1);
                        case COFFEE -> category.setNeededTime(2);
                        case OTHER -> category.setNeededTime(5);
                    }

                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {

        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
