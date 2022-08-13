package com.softuni.battleShips.repositories;

import com.softuni.battleShips.models.Ship;
import com.softuni.battleShips.models.User;
import com.softuni.battleShips.models.dto.ShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    Optional<Ship> findByName(String name);

    List<Ship> findByUserId(long ownerId);
    List<Ship> findByUserIdNot(long ownerId);
    List<Ship> findByOrderByHealthAscNameDescPowerAsc();
}
