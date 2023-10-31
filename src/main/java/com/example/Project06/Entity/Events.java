package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Eventses")
@Getter
@Setter
public class Events {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventsid;

    @Column(length = 250)
    private String eventName;

    @Column(length = 250)
    private String eventDetails;

    @Column(length = 45)
    private String eventTagline;

    @Column
    private LocalDate eventDate;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String photo;

    @Column(length = 45)
    private String price;

    @OneToMany(mappedBy = "eventsEventsid")
    private Set<EventBooking> eventsEventsidEventBookings;

}
