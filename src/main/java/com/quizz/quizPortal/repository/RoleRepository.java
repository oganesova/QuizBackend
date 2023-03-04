package  com.quizz.quizPortal.repository;
import com.quizz.quizPortal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRolename(String rolename);
}
