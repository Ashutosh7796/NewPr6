package com.example.Project06.Entity;

import com.example.Project06.Dto.AssessmentExamQuestions.AssessmentExamQuestionsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "AssessmentExamQuestions")
public class AssessmentExamQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssessmentExamQuestionsID", nullable = false)
    private Integer AssessmentExamQuestionsID;

    @Column(name = "Question", length = 250)
    private String question;

    @Column(name = "QuestionType")
    private String questionType;

    @Column(name = "Subject")
    private String subject;

    @Column(name = "Level")
    private String level;

    public AssessmentExamQuestions() {
    }

    public AssessmentExamQuestions(AssessmentExamQuestionsDto assessmentExamQuestionsDto) {
        AssessmentExamQuestionsID = assessmentExamQuestionsDto.getAssessmentExamQuestionsID();
        this.question = assessmentExamQuestionsDto.getQuestion();
        this.questionType = assessmentExamQuestionsDto.getQuestionType();
        this.subject = assessmentExamQuestionsDto.getSubject();
        this.level = assessmentExamQuestionsDto.getLevel();
    }
}
