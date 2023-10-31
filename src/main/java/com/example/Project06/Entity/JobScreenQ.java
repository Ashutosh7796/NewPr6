package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "JobScreenQs")
@Getter
@Setter
public class JobScreenQ {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobScreenQid;

    @Column(length = 250)
    private String question;

    @Column
    private Integer jobId;

    @Column(length = 45)
    private String type;

}
