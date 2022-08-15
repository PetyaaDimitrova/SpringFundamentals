package com.softuni.shoppingList.seeders;

import com.softuni.shoppingList.models.Style;
import com.softuni.shoppingList.models.StyleName;
import com.softuni.shoppingList.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {
    private final StyleRepository styleRepository;

    @Autowired
    public CategorySeeder(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.styleRepository.count() == 0) {
            Arrays.stream(StyleName.values())
                    .forEach(styleNameEnum -> {
                        Style style = new Style();
                        style.setStyleName(styleNameEnum);
                        this.styleRepository.save(style);
                    });
        }
    }
}
