package com.example.Project06.ServiceImpl;

import com.example.Project06.Entity.Questions;
import com.example.Project06.Entity.SelectedQuestions;
import com.example.Project06.Repository.QuestionRepo;
import com.example.Project06.Repository.SelectedQuestionsRepository;
import com.example.Project06.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SelectedQuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionsRepository;
    private final SelectedQuestionsRepository selectedQuestionsRepository;

    private static final Logger logger = LoggerFactory.getLogger(SelectedQuestionServiceImpl.class);

    @Override
    public void selectAndSaveRandomQuestions(Integer userId, String subject, Integer numberOfQuestions)
            throws IllegalArgumentException {
        try {
            List<Questions> allQuestions = questionsRepository.findBySubject(subject);

            int totalQuestions = allQuestions.size();

            if (numberOfQuestions > totalQuestions) {
                throw new IllegalArgumentException("Number of requested questions exceeds the total available questions. Please choose a smaller number.");
            }

            int questionsToSelect = Math.min(totalQuestions, numberOfQuestions);

            Random random = new Random();


            List<Questions> shuffledQuestions = new ArrayList<>(allQuestions);
            for (int i = shuffledQuestions.size() - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                Questions temp = shuffledQuestions.get(index);
                shuffledQuestions.set(index, shuffledQuestions.get(i));
                shuffledQuestions.set(i, temp);
            }

            for (int i = 0; i < questionsToSelect; i++) {
                Questions selectedQuestion = shuffledQuestions.get(i);

                SelectedQuestions newSelectedQuestion = new SelectedQuestions();
                newSelectedQuestion.setUserId(userId);
                newSelectedQuestion.setSubject(subject);
                newSelectedQuestion.setQuestionId(selectedQuestion.getQuestionId());
                selectedQuestionsRepository.save(newSelectedQuestion);
            }

            logger.info("Questions selected successfully");
        } catch (IllegalArgumentException e) {
            logger.error("IllegalArgumentException: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected Exception: {}", e.getMessage());
            throw new RuntimeException("Something went wrong. Please try again later.", e);
        }
    }
}
