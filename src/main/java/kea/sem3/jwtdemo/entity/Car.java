package kea.sem3.jwtdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class Car extends BaseUser {

    String brand;
    String model;
    int pricePrDay;

    public Car(String username, String email, String password, String brand, String model, int pricePrDay) {
        super(username, email, password);
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
    }

    public Car() {
    }
}
