package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    private Car reservedCar;

    @ManyToOne
    private Member reservedBy;

    @CreationTimestamp
    private LocalDateTime reservationDate;

    private LocalDate rentalDate;

    public Reservation(Car reservedCar, Member reservedBy, LocalDate rentalDate) {
        this.reservedCar = reservedCar;
        this.reservedBy = reservedBy;
        this.rentalDate = rentalDate;
        reservedCar.addReservation(this);
        reservedBy.addReservation(this);
    }

    public Reservation() {
    }
}
