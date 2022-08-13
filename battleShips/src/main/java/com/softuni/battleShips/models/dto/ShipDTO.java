package com.softuni.battleShips.models.dto;

import com.softuni.battleShips.models.Ship;

public class ShipDTO {
    private long id;
    private String name;
    private long health;
    private long power;

    public ShipDTO(Ship ship) {
        this.id = ship.getId();
        this.health = ship.getHealth();
        this.name = ship.getName();
        this.power = ship.getPower();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getHealth() {
        return health;
    }

    public long getPower() {
        return power;
    }
}
