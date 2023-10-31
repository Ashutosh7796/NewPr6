package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "LiveProjects")
@Getter
@Setter
public class LiveProject {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer liveProject;

    @Column(length = 45)
    private String domain;

    @Column(length = 45)
    private String internshipType;

    @Column(length = 45)
    private String internshipDuration;

    @Column(length = 45)
    private String pointOfContact;

    @Column(length = 45)
    private String pointOfContact01;

    @Column(length = 45)
    private String company;

    @Column(length = 45)
    private String location;

    @Column(length = 250)
    private String jobDescription;

    @Column(length = 250)
    private String keySkill;

}
