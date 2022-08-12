package com.softuni.battleShips.repositories;

import com.softuni.battleShips.models.Ship;
import com.softuni.battleShips.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);
}
