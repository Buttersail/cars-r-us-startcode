package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Member member;

    @CreationTimestamp
    private LocalDateTime reservationDate;

    private LocalDateTime rentalDate;

    public Reservation(Car car, Member member, LocalDateTime rentalDate) {
        this.car = car;
        this.member = member;
        this.rentalDate = rentalDate;
    }

    public Reservation() {
    }
}
