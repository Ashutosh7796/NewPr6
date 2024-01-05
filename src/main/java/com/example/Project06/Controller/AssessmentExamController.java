package com.example.Project06.Controller;

import com.example.Project06.Dto.Exam.AssessmentExamDto;
import com.example.Project06.Service.AssessmentExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("assessment-exam")
public class AssessmentExamController {


    private final AssessmentExamService assessmentExamService;

    @PostMapping("/create")
    public ResponseEntity<String> createAssessmentExam(@RequestBody AssessmentExamDto requestDTO) {
        assessmentExamService.createAssessmentExam(requestDTO);
        return ResponseEntity.ok("Question Posted successfully");
    }
}
