package task.universityconsole.service;

import java.math.BigDecimal;
import java.util.List;
import task.universityconsole.model.Department;
import task.universityconsole.model.Lector;

public interface DepartmentService {
    Department add(Department department);

    Lector getDepartmentHead(String departmentName);

    BigDecimal getAverageSalary(String departmentName);

    Integer getEmployeeCount(String departmentName);

    List<String> getAllNames();

    Integer getDegreeCount(String departmentName, String degreeName);
}
