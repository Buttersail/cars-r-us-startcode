package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser{

    String firstName;
    String lastName;
    String street;
    String city;
    int zip;
    boolean approved;
    int rank;


    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateEdited;


    public Member(String username, String email, String password, String firstName, String lastName, String street, String city, int zip, boolean approved, int rank) {
        super(username, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.rank = rank;
    }

    public Member() {
    }
}
