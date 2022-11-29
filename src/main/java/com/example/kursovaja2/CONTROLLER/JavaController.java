package com.example.kursovaja2.CONTROLLER;

import com.example.kursovaja2.MODEL.Question;
import com.example.kursovaja2.SERVICE.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaController {

    private final QuestionService service;


    public JavaController(QuestionService service) {
        this.service = service;
    }

    public Question addQuestion(String question, String answer) {
        return service.add(question,answer);
    }

    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    public Question removeQuestions(String question, String answer) {
        return null;
    }
}
