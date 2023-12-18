package com.example.Project06.Dto.StudentApplication;

import com.example.Project06.Entity.StudentApplication;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
public class StudentApplicationDto {
    private LocalDate date;
    private LocalTime time;
    private String recruiterNote;
    private Integer jobId;
    private String studentApplicationStatus;

    public StudentApplicationDto(StudentApplication studentApplication) {
        this.date = studentApplication.getDate();
        this.time = studentApplication.getTime();
        this.recruiterNote = studentApplication.getRecruiterNote();
        this.jobId = studentApplication.getJobId();
        this.studentApplicationStatus = studentApplication.getStudentApplicationStatus();
    }
}
