package  com.quizz.quizPortal.repository;
import com.quizz.quizPortal.entity.DataStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataStatisticsRepository extends JpaRepository<DataStatistics,Long> {
}
