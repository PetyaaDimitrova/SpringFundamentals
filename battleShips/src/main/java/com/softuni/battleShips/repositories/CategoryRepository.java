package com.softuni.battleShips.repositories;

import com.softuni.battleShips.models.Category;
import com.softuni.battleShips.models.enums.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Category findByName(ShipType type);
}
