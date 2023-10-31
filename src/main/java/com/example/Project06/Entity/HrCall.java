package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "HrCalls")
@Getter
@Setter
public class HrCall {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrCall;

    @Column
    private Integer userId;

    @Column
    private Integer selfId;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Column(length = 45)
    private String poastion;

    @Column(length = 45)
    private String status;

    @Column(length = 45)
    private String respond;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hr_hr_id", nullable = false)
    private Hr hrHr;

}
