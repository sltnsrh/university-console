package test.task.universityconsole.service.impl;

import java.math.BigDecimal;
import java.util.List;
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
    public Lector getDepartmentHead(String departmentName) {
        return departmentRepository.getHeadOfDepartment(departmentName);
    }

    @Override
    public BigDecimal getAverageSalary(String departmentName) {
        return departmentRepository.getAverageSalary(departmentName);
    }

    @Override
    public Integer getEmployeeCount(String departmentName) {
        return departmentRepository.getEmployeeCount(departmentName);
    }

    @Override
    public List<String> getAllNames() {
        return departmentRepository.getAllNames();
    }

    @Override
    public Integer getDegreeCount(String departmentName, String degreeName) {
        return departmentRepository.getDegreeCount(departmentName, degreeName);
    }
}
