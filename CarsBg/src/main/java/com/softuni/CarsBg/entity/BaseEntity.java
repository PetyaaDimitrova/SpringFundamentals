package com.softuni.CarsBg.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entity;

    public long getEntity() {
        return entity;
    }

    public void setEntity(long entity) {
        this.entity = entity;
    }
}
