package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.entity.Category;
import com.quizz.quizPortal.entity.Question;
import com.quizz.quizPortal.entity.Quiz;
import com.quizz.quizPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;

    @PostMapping("/save")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
        return this.quizService.getQuiz(quizId);
    }
    @GetMapping("/{quizId}/questions")
    public Set<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
        return quizService.getQuestionsByQuizId(quizId);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getQuizzes() {
        return ResponseEntity.ok(this.quizService.getAlQuizzes());
    }

    @PutMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId) {
        quizService.deleteQuizById(quizId);
    }

}
