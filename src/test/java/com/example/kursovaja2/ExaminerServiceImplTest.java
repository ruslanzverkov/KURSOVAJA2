package com.example.kursovaja2;

import com.example.kursovaja2.EXCEPTION.NotEnoughQuestionsException;
import com.example.kursovaja2.MODEL.Question;
import com.example.kursovaja2.SERVICE.ExaminerServiceImpl;
import com.example.kursovaja2.SERVICE.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final Set<Question> javaQuestion = new HashSet<>();

    @BeforeEach
    public void beforeEach() {
        javaQuestion.clear();

        javaQuestion.addAll(
                Stream.of(
                        new Question("question1", "answer1"),
                        new Question("question2", "answer2"),
                        new Question("question3", "answer3")
                ).collect(Collectors.toSet())
        );
        when(javaQuestionService.getAll()).thenReturn(javaQuestion);
    }

    @Test
    public void getQuestionsNegativeTest() {
        assertThatExceptionOfType(NotEnoughQuestionsException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
    }

    @Test
    public void getQuestionsPositiveTest() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question1", "answer1"),
                new Question("question1", "answer1"),
                new Question("question3", "answer3")
        );

        assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("question1", "answer1"),
                        new Question("question2", "answer2"),
                        new Question("question3", "answer3")
                );
    }
}
