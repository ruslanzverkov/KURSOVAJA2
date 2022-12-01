package com.example.kursovaja2.CONTROLLER;

import com.example.kursovaja2.MODEL.Question;
import com.example.kursovaja2.SERVICE.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaController {

    private final QuestionService service;


    public JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestions(@RequestParam String question,
                                    @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}
