package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SelectedQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "selectedQuestionId", nullable = false)
    private Integer selectedQuestionId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "questionId")
    private Integer questionId;


}
