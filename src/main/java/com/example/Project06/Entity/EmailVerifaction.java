package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "EmailVerifactions")
@Getter
@Setter
public class EmailVerifaction {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String email;

    @Column(length = 45)
    private String otp;

    @Column
    private OffsetDateTime creationTime;

    @Column(length = 45)
    private String userotp;

    @Column(length = 45)
    private String status;

}
