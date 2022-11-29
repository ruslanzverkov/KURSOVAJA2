package com.example.kursovaja2.SERVICE;

import com.example.kursovaja2.MODEL.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    private Random random;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }


}
