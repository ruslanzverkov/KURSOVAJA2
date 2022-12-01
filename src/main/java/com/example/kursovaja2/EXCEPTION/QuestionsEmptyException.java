package com.example.kursovaja2.EXCEPTION;

public class QuestionsEmptyException extends RuntimeException {
    public QuestionsEmptyException() {
    }

    public QuestionsEmptyException(String message) {
        super(message);
    }

    public QuestionsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsEmptyException(Throwable cause) {
        super(cause);
    }

    public QuestionsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
