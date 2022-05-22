package task.universityconsole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task.universityconsole.model.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query(value = "SELECT l.first_name, l.last_name FROM lectors l "
            + "WHERE LOWER(l.first_name) REGEXP ?1 "
            + "OR LOWER(l.last_name) REGEXP ?1", nativeQuery = true)
    List<String> findByTemplate(String template);
}
