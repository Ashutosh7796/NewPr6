package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


@Entity
@Table(name = "MentorPrograms")
@Getter
@Setter
public class MentorProgram {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorProgramId;

    @Column(length = 250)
    private String programName;

    @Column(length = 250)
    private String programDetails;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String price;

    @Column
    private LocalTime time;

    @Column(length = 45)
    private String mentorProgramcol;

    @Column(length = 45)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_mentor_id", nullable = false)
    private Mentor mentorMentor;

    @OneToMany(mappedBy = "mentorProgramMentorProgram")
    private Set<MentorProgramBookings> mentorProgramMentorProgramMentorProgramBookingses;

}
