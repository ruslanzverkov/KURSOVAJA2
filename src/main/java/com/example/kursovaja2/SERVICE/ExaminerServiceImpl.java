package com.example.kursovaja2.SERVICE;

import com.example.kursovaja2.EXCEPTION.NotEnoughQuestionsException;
import com.example.kursovaja2.MODEL.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = questionService.getAll();
        if (amount > questions.size() || amount < 1) {
            throw new NotEnoughQuestionsException();
        }

        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }


}
