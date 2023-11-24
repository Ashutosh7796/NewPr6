package com.example.Project06.Entity;

import com.example.Project06.Dto.StudentProfileDto.StudentProfileDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "StudentProfiles")
@Getter
@Setter
@NoArgsConstructor
public class StudentProfile {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentProfileId;

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
    private String highestLevelOfEud;

    @Column(length = 45)
    private String currentLocation;

    @Column(length = 45)
    private String availableToJoin;

    @Column(length = 45)
    private String specialization;

    @Column(length = 45)
    private String course;

    @Column(length = 45)
    private String courseDuration;

    @Column(length = 250)
    private String[] skills;

    @Column(length = 250)
    private String shortAboutYourself;

    @Column(length = 45)
    private String preferredSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    public StudentProfile(StudentProfileDto studentProfileDto) {
        this.experienceType = studentProfileDto.getExperienceType();
        this.workExperience = studentProfileDto.getWorkExperience();
        this.lastWorkDuration = studentProfileDto.getLastWorkDuration();
        this.lastCompany = studentProfileDto.getLastCompany();
        this.lastSalary = studentProfileDto.getLastSalary();
        this.previousDesignation = studentProfileDto.getPreviousDesignation();
        this.careerBreak = studentProfileDto.getCareerBreak();
        this.highestLevelOfEud = studentProfileDto.getHighestLevelOfEud();
        this.currentLocation = studentProfileDto.getCurrentLocation();
        this.availableToJoin = studentProfileDto.getAvailableToJoin();
        this.specialization = studentProfileDto.getSpecialization();
        this.course = studentProfileDto.getCourse();
        this.courseDuration = studentProfileDto.getCourseDuration();
        this.skills = studentProfileDto.getSkills();
        this.shortAboutYourself = studentProfileDto.getShortAboutYourself();
        this.preferredSalary = studentProfileDto.getPreferredSalary();
    }
}
