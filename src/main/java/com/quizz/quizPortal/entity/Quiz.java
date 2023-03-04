package com.quizz.quizPortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "quiz")
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;
    private boolean active=false;
    @Column(length = 5000)
    private String description;
    private String maxMark;
    private String numOfQuestions;
    private String title;
    @ManyToOne
    @JoinColumn(name="cid")
    private Category category;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private Set<Question> question = new HashSet<>();

    public Set<Question> getQuestion() {
        return question;
    }
}
