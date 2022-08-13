package com.softuni.battleShips.models.dto;

import javax.validation.constraints.Positive;

public class StartBattleDTO {
    @Positive
    private long attackerId;
    @Positive
    private long defenderId;

    public long getAttackerId() {
        return attackerId;
    }

    public void setAttackerId(long attackerId) {
        this.attackerId = attackerId;
    }

    public long getDefenderId() {
        return defenderId;
    }

    public void setDefenderId(long defenderId) {
        this.defenderId = defenderId;
    }
}
