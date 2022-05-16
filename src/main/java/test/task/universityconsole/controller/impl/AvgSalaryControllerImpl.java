package test.task.universityconsole.controller.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.service.DepartmentService;
import test.task.universityconsole.util.ParseUtil;

@Component
public class AvgSalaryControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^show the average salary for the department";
    private final DepartmentService departmentService;

    public AvgSalaryControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = ParseUtil.getDepartmentName(departmentService,
                consoleRequest);
        if (departmentName != null) {
            BigDecimal avgDepartmentSalary = departmentService.getAverageSalary(departmentName)
                    .setScale(2, RoundingMode.HALF_UP);

            return "Answer: The average salary of " + departmentName
                    + " is " + avgDepartmentSalary;
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
