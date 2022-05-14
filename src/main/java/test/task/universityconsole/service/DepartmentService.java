package test.task.universityconsole.service;

import test.task.universityconsole.model.Department;
import test.task.universityconsole.model.Lector;

public interface DepartmentService {
    Department add(Department department);

    Lector getLectorByDepartment(String departmentName);
}
