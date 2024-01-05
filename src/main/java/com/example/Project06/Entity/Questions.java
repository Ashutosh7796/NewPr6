package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId", nullable = false)
    private Integer questionId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "question")
    private String question;
}
