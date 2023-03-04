package  com.quizz.quizPortal.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Long categoryId;
    @Column(length = 5000)
    private String description;
    private String title;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Quiz> quizzes = new LinkedHashSet<>();
}
