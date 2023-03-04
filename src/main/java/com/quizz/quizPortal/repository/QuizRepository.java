package  com.quizz.quizPortal.repository;
import com.quizz.quizPortal.entity.Category;
import com.quizz.quizPortal.entity.Question;
import com.quizz.quizPortal.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
/*
Set<Question> getAllQuestionsByQuizId(Long quizId);*/
}
