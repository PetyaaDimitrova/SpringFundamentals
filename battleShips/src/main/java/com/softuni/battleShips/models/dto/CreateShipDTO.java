package com.softuni.battleShips.models.dto;

import com.softuni.battleShips.models.Category;
import com.softuni.battleShips.models.enums.ShipType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class CreateShipDTO {

    @Size(min = 2, max = 10)
    @NotBlank
    private String name;
    @Positive
    private long health;
    @Positive
    private long power;

    @Positive
    private int category = -1;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
