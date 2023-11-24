package com.example.Project06.Entity;

import com.example.Project06.Dto.Event.EventsDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

         public Events(EventsDto eventsDto) {
        this.eventsid = eventsDto.getEventsid();
        this.eventName = eventsDto.getEventName();
        this.eventDetails = eventsDto.getEventDetails();
        this.eventTagline = eventsDto.getEventTagline();
        this.eventDate = eventsDto.getEventDate();
        this.date = eventsDto.getDate();
        this.status = eventsDto.getStatus();
        this.photo = eventsDto.getPhoto();
        this.price = eventsDto.getPrice();
    }

}
