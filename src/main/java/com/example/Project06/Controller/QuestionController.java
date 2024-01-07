package com.example.Project06.Controller;

import com.example.Project06.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("selQue")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/selectAndSaveRandomQuestions")
    public ResponseEntity<String> selectAndSaveRandomQuestions(@RequestParam Integer userId, @RequestParam String subject, @RequestParam Integer numberOfQuestions ) {
        try {
            questionService.selectAndSaveRandomQuestions(userId, subject, numberOfQuestions);
            return new ResponseEntity<>("Questions selected successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Number of requested questions exceeds the total available questions",
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
