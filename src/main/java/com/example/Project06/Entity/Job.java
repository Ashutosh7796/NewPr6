package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Jobs")
@Getter
@Setter
public class Job {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(length = 250)
    private String companyName;

    @Column(length = 45)
    private String postName;

    @Column(length = 45)
    private String jobLoaction;

    @Column(length = 200)
    private String address;

    @Column(length = 250)
    private String skills;

    @Column(length = 250)
    private String jobDescription;

    @Column(length = 250)
    private String postDate;

    @Column(length = 45)
    private String salary;

    @Column
    private Integer noOfPost;

    @Column(length = 250)
    private String logo;

    @Column(length = 45)
    private String experienceLevel;

    @Column(length = 45)
    private String jobType;

    @Column(length = 45)
    private String status;

    @Column(length = 250)
    private String incentives;

    @Column(length = 250)
    private String essentialRequirements;

    @Column(length = 45)
    private String seatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

}
