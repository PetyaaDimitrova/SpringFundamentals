package com.softuni.CarsBg.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Model> model = new ArrayList<>();

    public Brand() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
