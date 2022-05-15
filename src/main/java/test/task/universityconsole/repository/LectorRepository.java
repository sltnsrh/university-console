package test.task.universityconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.task.universityconsole.model.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
}
