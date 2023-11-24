package com.example.Project06.Dto.LiveProject;

import com.example.Project06.Entity.LiveProject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class LiveProjectDto {

    private Integer liveProjectID;

    private String domain;

    private String internshipType;

    private String internshipDuration;

    private String pointOfContact;

    private String pointOfContact01;

    private String company;

    private String location;

    private String jobDescription;

    private String keySkill;

    public LiveProjectDto(LiveProject liveProject) {
        this.liveProjectID = liveProject.getLiveProjectID();
        this.domain = liveProject.getDomain();
        this.internshipType = liveProject.getInternshipType();
        this.internshipDuration = liveProject.getInternshipDuration();
        this.pointOfContact = liveProject.getPointOfContact();
        this.pointOfContact01 = liveProject.getPointOfContact01();
        this.company = liveProject.getCompany();
        this.location = liveProject.getLocation();
        this.jobDescription = liveProject.getJobDescription();
        this.keySkill = liveProject.getKeySkill();
    }
}
