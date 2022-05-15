package test.task.universityconsole.controller.impl;

import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.service.DepartmentService;
import test.task.universityconsole.util.ParseUtil;

@Component
public class CountEmployeeControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^show count of employee for ";
    private final DepartmentService departmentService;

    public CountEmployeeControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = ParseUtil.getDepartmentName(departmentService,
                consoleRequest);
        if (departmentName != null) {
            int countEmployee = departmentService.getEmployeeCount(departmentName);
            return "Answer: " + countEmployee;
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
