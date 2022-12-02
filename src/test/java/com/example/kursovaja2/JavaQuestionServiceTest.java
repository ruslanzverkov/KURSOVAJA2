package com.example.kursovaja2;

import com.example.kursovaja2.EXCEPTION.QuestionNotFoundException;
import com.example.kursovaja2.MODEL.Question;
import com.example.kursovaja2.SERVICE.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();



    @Test
    public void add1Test() {
        javaQuestionService.add(new Question("question", "answer"));

        assertThat(javaQuestionService.getAll())
                .containsExactlyInAnyOrder(new Question("question", "answer"));
    }
    @Test
    public void add2Test() {
        String question = "test";
        String answer= "test";
        Question q=new Question(question,answer);
        javaQuestionService.add(question, answer);

        assertThat(javaQuestionService.getAll())
                .containsExactlyInAnyOrder(q);
    }

    @Test
    public void removeTest() {
        javaQuestionService.add(new Question("question", "answer"));
        javaQuestionService.remove(new Question("question", "answer"));

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()->javaQuestionService.remove(new Question("question", "answer")));
    }

    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<Question> questions) {
        questions.forEach(javaQuestionService::add);

        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAll());
    }



    public static Stream<Arguments> questions() {
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Question("Question1", "answer1"),
                                new Question("Question2", "answer2"),
                                new Question("Question3", "answer3")
                        )
                )
        );
    }

}
