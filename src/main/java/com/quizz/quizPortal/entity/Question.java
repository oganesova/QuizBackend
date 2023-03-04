package  com.quizz.quizPortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ques_id")
    private Long quesId;
    private String answer;/*
    @Column(name = "given_answer")
    private String givenAnswer;*/
    private String content;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;

    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;
}
