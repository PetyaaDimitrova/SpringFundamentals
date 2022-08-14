package com.softuni.battleShips.services;

import com.softuni.battleShips.models.Category;
import com.softuni.battleShips.models.Ship;
import com.softuni.battleShips.models.User;
import com.softuni.battleShips.models.dto.CreateShipDTO;
import com.softuni.battleShips.models.dto.ShipDTO;
import com.softuni.battleShips.models.enums.ShipType;
import com.softuni.battleShips.repositories.CategoryRepository;
import com.softuni.battleShips.repositories.ShipRepository;
import com.softuni.battleShips.repositories.UserRepository;
import com.softuni.battleShips.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository,
                       CategoryRepository categoryRepository,
                       LoggedUser loggedUser,
                       UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    public boolean create(CreateShipDTO createShipDTO) {

        Optional<Ship> byName =
                this.shipRepository.findByName(createShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        ShipType type = switch (createShipDTO.getCategory()) {
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
            default -> ShipType.BATTLE;
        };

        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());

        Ship ship = new Ship();
        ship.setName(createShipDTO.getName());
        ship.setPower(createShipDTO.getPower());
        ship.setHealth(createShipDTO.getHealth());
        ship.setCreated(createShipDTO.getCreated());
        ship.setCategory(category);
        ship.setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }

    public List<ShipDTO> getShipsOwnedBy(long ownerId) {
        return this.shipRepository.findByUserId(ownerId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }


    public List<ShipDTO> getShipsNotOwnedBy(long ownerId) {
        return this.shipRepository.findByUserIdNot(ownerId)
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }


    public List<ShipDTO> getAllSorted() {
        return this.shipRepository.findByOrderByHealthAscNameDescPowerAsc()
                .stream()
                .map(ShipDTO::new)
                .collect(Collectors.toList());
    }
}
