package com.quizz.quizPortal.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(String message) {
        super(message);
    }
}
