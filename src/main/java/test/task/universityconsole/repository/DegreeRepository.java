package test.task.universityconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.universityconsole.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
