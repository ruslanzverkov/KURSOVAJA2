package com.example.kursovaja2.SERVICE;

import com.example.kursovaja2.EXCEPTION.QuestionNotFoundException;
import com.example.kursovaja2.EXCEPTION.QuestionsEmptyException;
import com.example.kursovaja2.MODEL.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random;

    private final Set<Question> questions;

    public JavaQuestionService() {
        this.random =new Random();
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size() == 0) {
            throw new QuestionsEmptyException();
        }
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
