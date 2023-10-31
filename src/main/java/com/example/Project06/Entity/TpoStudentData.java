package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "TpoStudentDatas")
@Getter
@Setter
public class TpoStudentData {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpoStudentData;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String testName;

    @Column(length = 45)
    private String totalMarks;

    @Column(length = 45)
    private String marks;

    @Column(length = 45)
    private String result;

    @Column(length = 45)
    private String tpoStudentDatacol;

}
