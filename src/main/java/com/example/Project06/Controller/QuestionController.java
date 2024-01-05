package com.example.Project06.Controller;

import com.example.Project06.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void selectAndSaveRandomQuestions(@RequestParam Integer userId, @RequestParam String subject ) {
        questionService.selectAndSaveRandomQuestions(userId,subject);
    }


}
