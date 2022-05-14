package test.task.universityconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.task.universityconsole.model.Department;
import test.task.universityconsole.model.Lector;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select d.head from Department d where d.name = ?1")
    Lector getHeadOfDepartment(String departmentName);
}
