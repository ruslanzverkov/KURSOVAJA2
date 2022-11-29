package com.example.kursovaja2.CONTROLLER;


import com.example.kursovaja2.SERVICE.ExaminerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exam/get/")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping("{amount}")
    public int getQuestions( @PathVariable int amount ) {
        return amount;
    }
}
