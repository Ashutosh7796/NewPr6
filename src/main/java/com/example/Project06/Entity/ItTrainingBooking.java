package com.example.Project06.Entity;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;


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
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "it_training_it_training_id", nullable = false)
    private ItTraining itTrainingItTraining;

    public ItTrainingBooking(ItTrianningBookingDto itTrianningBookingDto) {
        this.itTrainingBooking = itTrianningBookingDto.getItTrainingBooking();
        this.userId = itTrianningBookingDto.getUserId();
        this.status = itTrianningBookingDto.getStatus();
        this.date = itTrianningBookingDto.getDate();
        this.itTrainingItTraining = itTrianningBookingDto.getItTrainingItTraining();
    }
}
