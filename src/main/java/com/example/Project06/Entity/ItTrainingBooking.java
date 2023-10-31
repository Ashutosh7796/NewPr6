package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "ItTrainingBookings")
@Getter
@Setter
public class ItTrainingBooking {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itTrainingBooking;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

    @Column
    private OffsetDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "it_training_it_training_id", nullable = false)
    private ItTraining itTrainingItTraining;

}
