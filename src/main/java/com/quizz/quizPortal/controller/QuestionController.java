package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.entity.Question;
import com.quizz.quizPortal.entity.Quiz;
import com.quizz.quizPortal.repository.QuestionRepository;
import com.quizz.quizPortal.service.QuestionService;
import com.quizz.quizPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable("quesId") Long quesId) {
        return this.questionService.getQuestion(quesId);
    }
/*
    @GetMapping("/api/{quizId}")
    public Set<Question> getQuestionsOfQuiz(@PathVariable Long quizId){

        return questionService.getQuestionsOfQuiz(quizId);
    }*/
    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(questionService.updateQuestion(question));
    }
    @GetMapping("/list")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(questionService.getAlQuestions());
    }

    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId) {
        questionService.deleteQuestion(quesId);
    }



}
