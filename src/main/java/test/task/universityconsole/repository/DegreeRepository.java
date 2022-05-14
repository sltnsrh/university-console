package test.task.universityconsole.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.task.universityconsole.model.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
    Degree getDegreeByDegreeName(Degree.DegreeName degreeName);

    @Query("from  Degree")
    List<Degree> getAll();
}
