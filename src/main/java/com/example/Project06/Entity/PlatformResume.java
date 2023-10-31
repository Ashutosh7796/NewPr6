package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "PlatformResumes")
@Getter
@Setter
public class PlatformResume {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformResume;

    @Column(length = 250)
    private String address;

    @Column(length = 200)
    private String highstLevelOfEud;

    @Column(length = 200)
    private String collageName;

    @Column(length = 250)
    private String universityName;

    @Column(length = 45)
    private String percentages;

    @Column(length = 45)
    private String experienceType;

    @Column(length = 45)
    private String experience;

    @Column(length = 250)
    private String lastCompany;

    @Column(length = 200)
    private String lastCompanyDesignation;

    @Column(length = 250)
    private String skills;

    @Column(length = 45)
    private String lastCompanyJoingDate;

    @Column(length = 45)
    private String lastDateOrCurrentlyWorking;

    @Column(length = 250)
    private String lastCompanyDescription1;

    @Column(length = 250)
    private String lastCompanyDescription2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

}
