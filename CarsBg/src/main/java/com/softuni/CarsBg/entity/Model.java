package com.softuni.CarsBg.entity;

import com.softuni.CarsBg.entity.enums.CategoryEnum;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model  extends BaseEntity{
    private String name;
    private CategoryEnum category;
    private  String imageUrl;
    private int startYear;
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToOne
    private Brand brand;


}
