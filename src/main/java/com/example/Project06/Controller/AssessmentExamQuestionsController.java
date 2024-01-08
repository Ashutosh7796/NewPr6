package com.example.Project06.Controller;

import com.example.Project06.Dto.AssessmentExamQuestions.AssessmentExamQuestionsDto;
import com.example.Project06.Dto.AssessmentExamQuestions.ResponseGetAllAssessmentExamQuestionsDto;
import com.example.Project06.Dto.AssessmentExamQuestions.ResponseSingleAssessmentExamQuestionsDto;
import com.example.Project06.Dto.Plan.PlanDto;
import com.example.Project06.Dto.Plan.ResponseGetAllPlanDto;
import com.example.Project06.Dto.Plan.ResponseSinglePlanDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.AssessmentExamQuestionsService;
import com.example.Project06.exception.AssessmentExamQuestionsException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.PlanNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("AssessmentExamQuestions")
@RequiredArgsConstructor
public class AssessmentExamQuestionsController {

      private final AssessmentExamQuestionsService assessmentExamQuestionsService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDto> AssementQAdded(@RequestBody AssessmentExamQuestionsDto assessmentExamQuestionsDto) {
        try {
            String result = assessmentExamQuestionsService.AssessmentExamQuestion(assessmentExamQuestionsDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result)));
        } catch (AssessmentExamQuestionsException assessmentExamQuestionsException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "assessment Exam Questions Not found"));

        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseGetAllAssessmentExamQuestionsDto> getAllAssesmentQ(@RequestParam int pageNo) {

        try {
            List<AssessmentExamQuestionsDto> assessmentExamQuestionsDtoList= assessmentExamQuestionsService.getAllAssessmentExamQuestionWithPages(pageNo);
            ResponseGetAllAssessmentExamQuestionsDto responseGetAllAssessmentExamQuestionsDto = new ResponseGetAllAssessmentExamQuestionsDto("Success");
            responseGetAllAssessmentExamQuestionsDto.setList(assessmentExamQuestionsDtoList);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllAssessmentExamQuestionsDto);
        } catch (AssessmentExamQuestionsException assessmentExamQuestionsException) {
            ResponseGetAllAssessmentExamQuestionsDto responseGetAllAssessmentExamQuestionsDto = new ResponseGetAllAssessmentExamQuestionsDto("unSuccess");
            responseGetAllAssessmentExamQuestionsDto.setException("assessment Exam Questions not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllAssessmentExamQuestionsDto);
        } catch (PageNotFoundException pageNotFoundException) {
            ResponseGetAllAssessmentExamQuestionsDto responseGetAllAssessmentExamQuestionsDto = new ResponseGetAllAssessmentExamQuestionsDto("unSuccess");
            responseGetAllAssessmentExamQuestionsDto.setException("Page not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllAssessmentExamQuestionsDto);
        }
    }

    @GetMapping("/getByID")
    public ResponseEntity<ResponseSingleAssessmentExamQuestionsDto> FindById(@RequestParam Integer AssessmentExamQuestionsID) {
        try {
            ResponseSingleAssessmentExamQuestionsDto responseSinglePlanDto = new ResponseSingleAssessmentExamQuestionsDto("success");
            AssessmentExamQuestionsDto assessmentExamQuestionsDto= assessmentExamQuestionsService.findById(AssessmentExamQuestionsID);
            responseSinglePlanDto.setObject(assessmentExamQuestionsDto);
            return ResponseEntity.status(HttpStatus.OK).body(responseSinglePlanDto);
        } catch (PlanNotFoundException planNotFoundException) {
            ResponseSingleAssessmentExamQuestionsDto responseSinglePlanDto = new ResponseSingleAssessmentExamQuestionsDto("Unsuccess");
            responseSinglePlanDto.setException("assessment Exam Question not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSinglePlanDto);
        }
    }



    @DeleteMapping("/delete/{AssessmentExamQuestionsID}")
    public ResponseEntity<ResponseDto> deleteASSQ(@PathVariable Integer AssessmentExamQuestionsID) {
        try {
            String result = assessmentExamQuestionsService.deletePlan(AssessmentExamQuestionsID);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (AssessmentExamQuestionsException assessmentExamQuestionsException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "assessment Exam Question not found"));
        }
    }
}

