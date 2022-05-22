package task.universityconsole.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task.universityconsole.model.Department;
import task.universityconsole.model.Lector;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select d.head from Department d where d.name = ?1")
    Lector getHeadOfDepartment(String departmentName);

    @Query(value = "SELECT AVG(l.salary) FROM lectors l "
            + "JOIN lectors_departments ld ON ld.lector_id = l.id "
            + "JOIN departments d ON ld.department_id = d.id "
            + "WHERE d.name = ?1", nativeQuery = true)
    BigDecimal getAverageSalary(String departmentName);

    @Query(value = "SELECT COUNT(ld.lector_id) FROM lectors_departments ld "
            + "JOIN departments d ON ld.department_id = d.id "
            + "WHERE d.name = ?1", nativeQuery = true)
    Integer getEmployeeCount(String departmentName);

    @Query("select d.name from Department d")
    List<String> getAllNames();

    @Query(value = "SELECT COUNT(ds.id) FROM departments d "
            + "JOIN lectors_departments ld ON d.id = ld.department_id "
            + "JOIN lectors l ON ld.lector_id = l.id "
            + "JOIN degrees ds ON l.degree_id = ds.id "
            + "WHERE d.name = ?1 AND ds.degree_name = ?2", nativeQuery = true)
    Integer getDegreeCount(String departmentName, String degreeName);
}
