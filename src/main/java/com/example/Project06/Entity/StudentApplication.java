package com.example.Project06.Entity;

import com.example.Project06.Dto.StudentApp.StudentApplicationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "StudentApplication")
@Getter
@Setter
public class StudentApplication {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer StudentApplicationId;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @Column(length = 250)
    private String RecruiterNotes;

    @Column(nullable = false)
    private Integer jobId;

    @Column(length = 45)
    private String Status;

    @Column(nullable = false)
    private User UserId;

    public StudentApplication(StudentApplicationDto studentApplicationDto) {
        this.StudentApplicationId = studentApplicationDto.getStudentApplicationId();
        this.date = studentApplicationDto.getDate();
        this.time = studentApplicationDto.getTime();
        this.RecruiterNotes = studentApplicationDto.getRecruiterNotes();
        this.jobId = studentApplicationDto.getJobId();
        this.Status = studentApplicationDto.getStatus();
        this.UserId = studentApplicationDto.getUserId();
    }
}
