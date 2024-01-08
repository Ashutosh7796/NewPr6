package com.example.Project06.Dto.AssessmentExamQuestions;

import lombok.Data;

@Data
public class ResponseSingleAssessmentExamQuestionsDto {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleAssessmentExamQuestionsDto(String message)
    {
        this.message = message;
    }

}
