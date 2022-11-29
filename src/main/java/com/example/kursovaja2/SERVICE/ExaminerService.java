package com.example.kursovaja2.SERVICE;

import com.example.kursovaja2.MODEL.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
