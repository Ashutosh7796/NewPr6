package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "MentorFeedbacks")
@Getter
@Setter
public class MentorFeedback {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorFeedback;

    @Column(length = 200)
    private String feedback;

    @Column
    private Integer userId;

    @JoinColumn(name = "mentor_mentor_id")
    private Integer mentorId;

}
