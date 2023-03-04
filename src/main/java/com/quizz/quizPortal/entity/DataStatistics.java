package  com.quizz.quizPortal.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "data_statistics")
public class DataStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "programm_language")
    private String programmLanguage;
    private String rating;
    private String year;
}
