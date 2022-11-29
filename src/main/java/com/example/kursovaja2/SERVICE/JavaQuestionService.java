package com.example.kursovaja2.SERVICE;

import com.example.kursovaja2.MODEL.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }


    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
