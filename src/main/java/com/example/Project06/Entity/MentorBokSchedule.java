package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "MentorBokSchedules")
@Getter
@Setter
public class MentorBokSchedule {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorBokSchedule;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String mode;

    @Column(length = 45)
    private String time;

    @Column(length = 45)
    private String payment;

    @Column(length = 45)
    private String status;

    @Column(nullable = false)
    private Integer mentorScheduleMentorScheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    @OneToMany(mappedBy = "mentorBokScheduleMentorBokSchedule")
    private Set<MentorBookings> mentorBokScheduleMentorBokScheduleMentorBookingses;

}
