package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "JobScreenAnses")
@Getter
@Setter
public class JobScreenAns {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobScreenAns;

    @Column(length = 250)
    private String question;

    @Column(length = 250)
    private String ans;

    @Column(length = 45)
    private String type;

    @Column
    private Integer userId;

    @Column
    private Integer jobId;

    @Column(length = 45)
    private String seatNo;

}
