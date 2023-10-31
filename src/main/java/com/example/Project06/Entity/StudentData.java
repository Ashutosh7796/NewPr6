package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "StudentDatas")
@Getter
@Setter
public class StudentData {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentData;

    @Column(length = 45)
    private String batch;

    @Column
    private Integer studentId;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String branch;

    @Column(length = 45)
    private String studentDatacol;

}
