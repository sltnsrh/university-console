package task.universityconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.universityconsole.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
