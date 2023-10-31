package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "EventBookings")
@Getter
@Setter
public class EventBooking {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventBookingId;

    @Column
    private OffsetDateTime date;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "events_eventsid_id", nullable = false)
    private Events eventsEventsid;

}
