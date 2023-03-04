package com.quizz.quizPortal.service;

import com.quizz.quizPortal.entity.Question;
import com.quizz.quizPortal.entity.Quiz;
import com.quizz.quizPortal.exception.QuizNotFoundException;
import com.quizz.quizPortal.exception.UserNotFoundException;
import com.quizz.quizPortal.repository.QuestionRepository;
import com.quizz.quizPortal.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }
    public Quiz getQuiz(Long quizId){
        return quizRepository.findById(quizId).get();
    }
    public List<Quiz> getAlQuizzes(){
        return this.quizRepository.findAll();
    }
    public Quiz updateQuiz(Quiz quiz){
        return  this.quizRepository.save(quiz);
    }
    public void deleteQuizById(Long quizId){quizRepository.deleteById(quizId);}
    @Autowired
    private QuestionRepository questionRepository;

    public Set<Question> getQuestionsByQuizId(Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            return quiz.get().getQuestion();
        } else {
            throw new QuizNotFoundException("Quiz not found with ID: " + quizId);
        }
    }

}

