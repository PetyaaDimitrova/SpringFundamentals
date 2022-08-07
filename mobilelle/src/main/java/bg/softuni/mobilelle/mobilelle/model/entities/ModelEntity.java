package bg.softuni.mobilelle.mobilelle.model.entities;

import bg.softuni.mobilelle.mobilelle.model.entities.enums.Categories;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categories category;

    @Column(length = 512)
    private String imageUrl;

    private int startYear;

    private int endYear;

    @ManyToOne
    private BrandEntity brand;

    @Override
    public String toString() {
        return "ModelEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand + (brand != null ? brand.getName() : null) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }
}
