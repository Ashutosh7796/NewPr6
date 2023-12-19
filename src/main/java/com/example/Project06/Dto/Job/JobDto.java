package com.example.Project06.Dto.Job;

import com.example.Project06.Entity.Job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class JobDto {

    private Integer jobId;

    private String companyName;

    private String postName;

    private String jobLocation;

    private String address;

    private String[] skills;

    private String jobDescription;

    private String postDate;

    private String salary;

    private Integer noOfPost;

    private String logo;

    private String experienceLevel;

    private String jobType;

    private String status;

    private String incentives;

    private String essentialRequirements;

    private String seatNo;

    private Integer User_Id;



    public JobDto(Job job) {
        this.jobId = job.getJobId();
        this.companyName = job.getCompanyName();
        this.postName = job.getPostName();
        this.jobLocation = job.getJobLocation();
        this.address = job.getAddress();
        this.skills = job.getSkills();
        this.jobDescription = job.getJobDescription();
        this.postDate = job.getPostDate();
        this.salary = job.getSalary();
        this.noOfPost = job.getNoOfPost();
        this.logo = job.getLogo();
        this.experienceLevel = job.getExperienceLevel();
        this.jobType = job.getJobType();
        this.status = job.getStatus();
        this.incentives = job.getIncentives();
        this.essentialRequirements = job.getEssentialRequirements();
        this.seatNo = job.getSeatNo();
        this.User_Id=job.getUserUser().getUser_id();

    }




}
