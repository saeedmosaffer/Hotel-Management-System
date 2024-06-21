package edu.birzeit.saeedmosaffer.Hotel_Management_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String facilities;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String status; // Available, Reserved, etc.

    @OneToMany(mappedBy = "room")
    private Set<Reservation> reservations;
}
