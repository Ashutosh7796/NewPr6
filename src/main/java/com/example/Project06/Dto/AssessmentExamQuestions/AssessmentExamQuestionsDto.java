package com.example.Project06.Dto.AssessmentExamQuestions;

import com.example.Project06.Entity.AssessmentExamQuestions;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AssessmentExamQuestionsDto {
    private Integer AssessmentExamQuestionsID;


    private String question;


    private String questionType;


    private String subject;

    private String level;

    public AssessmentExamQuestionsDto() {
    }

    public AssessmentExamQuestionsDto(AssessmentExamQuestions assessmentExamQuestions) {
        AssessmentExamQuestionsID = assessmentExamQuestions.getAssessmentExamQuestionsID();
        this.question = assessmentExamQuestions.getQuestion();
        this.questionType = assessmentExamQuestions.getQuestionType();
        this.subject = assessmentExamQuestions.getSubject();
        this.level = assessmentExamQuestions.getLevel();
    }
}
