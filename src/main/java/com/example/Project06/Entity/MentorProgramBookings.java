package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "MentorProgramBookingses")
@Getter
@Setter
public class MentorProgramBookings {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorProgramBookings;

    @Column
    private LocalDate date;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String mentorProgramBookingscol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_program_mentor_program_id", nullable = false)
    private MentorProgram mentorProgramMentorProgram;

}
