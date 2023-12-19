package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "Tpoes")
@Getter
@Setter
public class Tpo {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpoId;

    @Column(length = 200)
    private String collageName;

    @Column(length = 200)
    private String address;

    @Column(length = 200)
    private String state;

    @Column(length = 45)
    private String dist;

    @Column(length = 45)
    private String city;

    @Column(length = 45)
    private String pincode;

    @Column(length = 45)
    private String type;

    @Column
    private LocalDate date;

    @Column
    private LocalDate establishedDate;

    @Column(name = "user_user_id", nullable = false)
    private Integer userUser;

}
