package com.example.kursovaja2.CONTROLLER;


import com.example.kursovaja2.SERVICE.ExaminerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public int getQuestions(int amount) {
        return amount;
    }
}
