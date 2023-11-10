package com.example.Project06.Entity;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "ItTrainingBookings")
@Getter
@Setter
public class ItTrainingBooking {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itTrainingBookingId;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

    @Column
    private LocalDate date;

    @Column
    private Integer itTrainingId;

    public ItTrainingBooking() {

    }

    public ItTrainingBooking(ItTrianningBookingDto itTrianningBookingDto) {
        this.itTrainingBookingId = itTrianningBookingDto.getItTrainingBookingId();
        this.userId = itTrianningBookingDto.getUserId();
        this.status = itTrianningBookingDto.getStatus();
        this.date = itTrianningBookingDto.getDate();
        this.itTrainingId = itTrianningBookingDto.getItTrainingId();
    }
}
