package com.example.Project06.Dto.StudentProfileDto;

import com.example.Project06.Entity.StudentProfile;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetSingleProfileDto {

        private Integer StudentProfileId;

        private String experienceType;

        private String workExperience;

        private String lastWorkDuration;

        private String lastCompany;

        private String lastSalary;

        private String previousDesignation;

        private String careerBreak;

        private String highestLevelOfEud;

        private String currentLocation;

        private String availableToJoin;

        private String specialization;

        private String course;

        private String courseDuration;

        private String[] skills;

        private String shortAboutYourself;

        private String preferredSalary;

        public GetSingleProfileDto(StudentProfile studentProfile) {
            this.StudentProfileId = studentProfile.getStudentProfileId();
            this.experienceType = studentProfile.getExperienceType();
            this.workExperience = studentProfile.getWorkExperience();
            this.lastWorkDuration = studentProfile.getLastWorkDuration();
            this.lastCompany = studentProfile.getLastCompany();
            this.lastSalary = studentProfile.getLastSalary();
            this.previousDesignation = studentProfile.getPreviousDesignation();
            this.careerBreak = studentProfile.getCareerBreak();
            this.highestLevelOfEud = studentProfile.getHighestLevelOfEud();
            this.currentLocation = studentProfile.getCurrentLocation();
            this.availableToJoin = studentProfile.getAvailableToJoin();
            this.specialization = studentProfile.getSpecialization();
            this.course = studentProfile.getCourse();
            this.courseDuration = studentProfile.getCourseDuration();
            this.skills = studentProfile.getSkills();
            this.shortAboutYourself = studentProfile.getShortAboutYourself();
            this.preferredSalary = studentProfile.getPreferredSalary();
        }
    }


