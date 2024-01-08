package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class AssessmentExamQuestionsException extends RuntimeException{
    private HttpStatus httpStatus;

    public AssessmentExamQuestionsException(String message) {
        super(message);
    }

    public AssessmentExamQuestionsException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

}