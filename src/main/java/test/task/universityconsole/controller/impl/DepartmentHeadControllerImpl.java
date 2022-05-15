package test.task.universityconsole.controller.impl;

import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.model.Lector;
import test.task.universityconsole.service.DepartmentService;
import test.task.universityconsole.util.ParseUtil;

@Component
public class DepartmentHeadControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^who is head of department ";
    private final DepartmentService departmentService;

    public DepartmentHeadControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = ParseUtil.getDepartmentName(departmentService,
                consoleRequest);
        if (departmentName != null) {
            Lector lector = departmentService.getDepartmentHead(departmentName);
            return "Answer: Head of " + departmentName + " department is "
                    + lector.getFirstName() + " " + lector.getLastName();
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
