package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "StudentProfiles")
@Getter
@Setter
public class StudentProfile {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(length = 45)
    private String experienceType;

    @Column(length = 45)
    private String workExperience;

    @Column(length = 45)
    private String lastWorkDuration;

    @Column(length = 250)
    private String lastCompany;

    @Column(length = 45)
    private String lastSalary;

    @Column(length = 45)
    private String previousDesignation;

    @Column(length = 45)
    private String careerBreak;

    @Column(length = 250)
    private String highestLevleOfEud;

    @Column(length = 45)
    private String currentLoaction;

    @Column(length = 45)
    private String availableToJoin;

    @Column(length = 45)
    private String specialization;

    @Column(length = 45)
    private String course;

    @Column(length = 45)
    private String courseDuration;

    @Column(length = 250)
    private String skills;

    @Column(length = 250)
    private String shortAboutYoureself;

    @Column(length = 45)
    private String preferredSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

}
