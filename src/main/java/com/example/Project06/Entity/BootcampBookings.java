package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "BootcampBookingses")
@Getter
@Setter
public class BootcampBookings {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bootcampBookingsId;

    @Column
    private OffsetDateTime date;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_bootcamp_id", nullable = false)
    private Bootcamp bootcampBootcamp;

}
