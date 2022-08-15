package com.softuni.shoppingList.models;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "style_name", nullable = false, unique = true)
    private StyleName styleName;

    private String description;

    public Style() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StyleName getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleName styleName) {
        this.styleName = styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
