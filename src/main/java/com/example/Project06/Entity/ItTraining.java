package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "ItTrainings")
@Getter
@Setter
public class ItTraining {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itTrainingId;

    @Column(length = 45)
    private String domaimn;

    @Column(length = 45)
    private String mode;

    @Column(length = 45)
    private String mentor;

    @Column(length = 45)
    private String cost;

    @Column(length = 45)
    private String topic;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column(length = 45)
    private String duration;

    @OneToMany(mappedBy = "itTrainingItTraining")
    private Set<ItTrainingBooking> itTrainingItTrainingItTrainingBookings;

}
