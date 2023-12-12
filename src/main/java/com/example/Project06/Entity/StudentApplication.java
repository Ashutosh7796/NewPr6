package com.example.Project06.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "StudentApplicationses")
@Getter
@Setter
public class StudentApplication {

        @Id
        @Column(nullable = false, updatable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer studentApplicationsId;

        @Column
        private LocalDate date;

        @Column
        private LocalTime time;

        @Column(length = 250)
        private String recruiterNote;

        @Column(nullable = false)
        private Integer jobId;

        @Column(length = 45)
        private String studentApplicationStatus;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_user_id", nullable = false)
        private User userUser;

    }




