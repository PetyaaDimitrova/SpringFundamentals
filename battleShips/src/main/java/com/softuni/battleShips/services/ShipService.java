package com.softuni.battleShips.services;

import com.softuni.battleShips.models.Category;
import com.softuni.battleShips.models.Ship;
import com.softuni.battleShips.models.User;
import com.softuni.battleShips.models.dto.CreateShipDTO;
import com.softuni.battleShips.models.enums.ShipType;
import com.softuni.battleShips.repositories.CategoryRepository;
import com.softuni.battleShips.repositories.ShipRepository;
import com.softuni.battleShips.repositories.UserRepository;
import com.softuni.battleShips.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository, LoggedUser loggedUser, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDTO shipDTO) {


        Optional<Ship> byName = this.shipRepository.findByName(shipDTO.getName());
        if(byName.isPresent()){
            return false;
        }

        ShipType type = null;

        switch (shipDTO.getCategory()){
            case 0: type = ShipType.BATTLE;
            break;
            case 1: type = ShipType.CARGO;
            break;
            case 2: type = ShipType.PATROL;
            break;
        }

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Ship ship = new Ship();
        ship.setName(shipDTO.getName());
        ship.setCreated(shipDTO.getCreated());
        ship.setCategory(category);
        ship.setHealth(shipDTO.getHealth());
        ship.setPower(shipDTO.getPower());
        ship.setUser(owner.get());
        shipRepository.save(ship);
        return true;

    }
}
