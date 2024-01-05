package com.example.Project06.ServiceImpl;

import com.example.Project06.Entity.Questions;
import com.example.Project06.Entity.SelectedQuestions;
import com.example.Project06.Repository.QuestionRepo;
import com.example.Project06.Repository.SelectedQuestionsRepository;
import com.example.Project06.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SelectedQuestionServiceImpl implements QuestionService {


    private final QuestionRepo questionsRepository;

    private final SelectedQuestionsRepository selectedQuestionsRepository;

    @Override
    public void selectAndSaveRandomQuestions(Integer userId, String subject) {

            List<Questions> allQuestions = questionsRepository.findBySubject(subject);
            int totalQuestions = allQuestions.size();
            int numberOfQuestionsToSelect = Math.min(totalQuestions, 50);

            Random random = new Random();

            for (int i = 0; i < numberOfQuestionsToSelect; i++) {
                int randomIndex = random.nextInt(totalQuestions);
                Questions selectedQuestion = allQuestions.get(randomIndex);

                SelectedQuestions newSelectedQuestion = new SelectedQuestions();
                newSelectedQuestion.setUserId(userId);
                newSelectedQuestion.setSubject(subject);
                newSelectedQuestion.setQuestionId(selectedQuestion.getQuestionId());
                selectedQuestionsRepository.save(newSelectedQuestion);
            }
        }
    }

