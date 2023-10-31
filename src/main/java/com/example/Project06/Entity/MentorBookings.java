package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Table(name = "MentorBookingses")
@Getter
@Setter
public class MentorBookings {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorBookingsId;

    @Column
    private OffsetDateTime date;

    @Column
    private Integer userId;

    @Column
    private Integer mentorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_bok_schedule_mentor_bok_schedule_id", nullable = false)
    private MentorBokSchedule mentorBokScheduleMentorBokSchedule;

}
