package com.softuni.battleShips;

import com.softuni.battleShips.models.Category;
import com.softuni.battleShips.models.enums.ShipType;
import com.softuni.battleShips.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {


    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(ShipType.values())
                    .map(Category::new)
                    .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
            // n + 1 queries problem
        }
    }
}
