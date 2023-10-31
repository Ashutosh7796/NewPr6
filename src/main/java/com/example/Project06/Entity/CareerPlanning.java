package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "CareerPlannings")
@Getter
@Setter
public class CareerPlanning {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer careerPlanning;

    @Column(length = 250)
    private String domain;

    @Column(length = 45)
    private String mode;

    @Column
    private OffsetDateTime slot;

    @Column(length = 45)
    private String cost;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String status;

}
