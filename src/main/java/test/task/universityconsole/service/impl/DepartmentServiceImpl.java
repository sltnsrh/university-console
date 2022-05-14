package test.task.universityconsole.service.impl;

import org.springframework.stereotype.Service;
import test.task.universityconsole.model.Department;
import test.task.universityconsole.model.Lector;
import test.task.universityconsole.repository.DepartmentRepository;
import test.task.universityconsole.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department add(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Lector getLectorByDepartment(String departmentName) {
        return departmentRepository.getHeadOfDepartment(departmentName);
    }
}
