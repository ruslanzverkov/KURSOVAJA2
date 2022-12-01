package com.example.kursovaja2.CONTROLLER;


import com.example.kursovaja2.MODEL.Question;
import com.example.kursovaja2.SERVICE.ExaminerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount ) {
        return examinerService.getQuestions(amount);
    }
}
