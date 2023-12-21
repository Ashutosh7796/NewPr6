package com.example.Project06.Entity;

import com.example.Project06.Dto.Job.JobDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JobId", nullable = false)
    private Integer jobId;

    @Column(length = 250)
    private String companyName;

    @Column(length = 45)
    private String postName;

    @Column(length = 45)
    private String jobLocation;

    @Column(length = 200)
    private String address;

    @Column(length = 250)
    private String[] skills;

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


    @JsonIgnoreProperties("userUser")
    @ManyToOne(fetch = FetchType.LAZY ,optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;


    @ManyToMany
    @JoinTable(
            name = "job_interview_schedule",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "interview_schedule_id"))
    private List<InterviewSchedule> interviewSchedule;
//        = new ArrayList<>();


    public Job(JobDto jobDto ,String logo) {
        this.companyName =jobDto.getCompanyName();
        this.postName = jobDto.getPostName();
        this.jobLocation = jobDto.getJobLocation();
        this.address = jobDto.getAddress();
        this.skills = jobDto.getSkills();
        this.jobDescription = jobDto.getJobDescription();
        this.postDate = jobDto.getPostDate();
        this.salary = jobDto.getSalary();
        this.noOfPost = jobDto.getNoOfPost();
        this.logo = logo;
        this.experienceLevel = jobDto.getExperienceLevel();
        this.jobType = jobDto.getJobType();
        this.status = jobDto.getStatus();
        this.incentives = jobDto.getIncentives();
        this.essentialRequirements = jobDto.getEssentialRequirements();
        this.seatNo = jobDto.getSeatNo();
        this.jobId = jobDto.getJobId();

    }



}
