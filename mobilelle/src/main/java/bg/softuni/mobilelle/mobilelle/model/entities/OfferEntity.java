package bg.softuni.mobilelle.mobilelle.model.entities;

import bg.softuni.mobilelle.mobilelle.model.entities.enums.Engines;
import bg.softuni.mobilelle.mobilelle.model.entities.enums.Transmissions;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    private String description;
    @Enumerated(EnumType.STRING)
    private Engines engine;

    private String imageUrl;

    private int mileage;

    private int price;

    @Enumerated(EnumType.STRING)
    private Transmissions transmission;

    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engines getEngine() {
        return engine;
    }

    public void setEngine(Engines engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Transmissions getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmissions transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                '}';
    }
}
