package test.task.universityconsole.service;

import java.math.BigDecimal;
import java.util.List;
import test.task.universityconsole.model.Department;
import test.task.universityconsole.model.Lector;

public interface DepartmentService {
    Department add(Department department);

    Lector getDepartmentHead(String departmentName);

    BigDecimal getAverageSalary(String departmentName);

    Integer getEmployeeCount(String departmentName);

    List<String> getAllNames();

    Integer getAssistantsCount(String departmentName);

    Integer getAssociateProfessorsCount(String departmentName);

    Integer getProfessorsCount(String departmentName);
}
