package com.softuni.shoppingList.repositories;

import com.softuni.shoppingList.models.Style;
import com.softuni.shoppingList.models.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {

    Style findByStyleName(StyleName type);
}
