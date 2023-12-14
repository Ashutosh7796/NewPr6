package com.example.Project06.Entity;
import com.example.Project06.Dto.StudentApplication.StudentApplicationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "StudentApplication")
@Getter
@Setter
@NoArgsConstructor
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

        public StudentApplication(StudentApplicationDto studentApplicationDto) {

                this.date = studentApplicationDto.getDate();
                this.time = studentApplicationDto.getTime();
                this.recruiterNote = studentApplicationDto.getRecruiterNote();
                this.jobId = studentApplicationDto.getJobId();
                this.studentApplicationStatus = studentApplicationDto.getStudentApplicationStatus();
        }
}




