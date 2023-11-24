package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "LiveProjectBookings")
@Getter
@Setter
public class LiveProjectBooking {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer liveProjectBookingId;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String userId;

    @Column
    private Integer liveProjectID;

}
