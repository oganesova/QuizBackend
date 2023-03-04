package com.quizz.quizPortal.service;

import com.quizz.quizPortal.entity.Question;
import com.quizz.quizPortal.entity.Quiz;
import com.quizz.quizPortal.repository.QuestionRepository;
import com.quizz.quizPortal.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository=quizRepository;
    }

    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    public Question getQuestion(Long quesId) {
        return questionRepository.findById(quesId).get();
    }
    /*
    public Set<Question> getQuestionsOfQuiz(Long quizId){
        Set<Question> questions = quizRepository.getAllQuestionsByQuizId(quizId);
        return questions;
    }*/
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> getAlQuestions() {
        return this.questionRepository.findAll();
    }

    public void deleteQuestion(Long quesId) {
        this.questionRepository.deleteById(quesId);
    }

}
