package com.softuni.CoffeeShop.services;

import com.softuni.CoffeeShop.models.entity.Category;
import com.softuni.CoffeeShop.models.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
