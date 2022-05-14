package test.task.universityconsole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.task.universityconsole.model.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("select distinct l from Lector l left join fetch l.departments")
    List<Lector> getAll();
}
