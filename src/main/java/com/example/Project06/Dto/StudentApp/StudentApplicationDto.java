package com.example.Project06.Dto.StudentApp;

import com.example.Project06.Entity.StudentApplication;
import com.example.Project06.Entity.User;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class StudentApplicationDto {

    private Integer StudentApplicationId;

    private LocalDate date;

    private LocalTime time;

    private String RecruiterNotes;

    private Integer jobId;

    private String Status;

    private User UserId;

    public StudentApplicationDto() {
    }

    public StudentApplicationDto(StudentApplication studentApplication) {
        this.StudentApplicationId = studentApplication.getStudentApplicationId();
        this.date = studentApplication.getDate();
        this.time = studentApplication.getTime();
        this.RecruiterNotes = studentApplication.getRecruiterNotes();
        this.jobId = studentApplication.getJobId();
        this.Status = studentApplication.getStatus();
        this.UserId = studentApplication.getUserId();
    }
}