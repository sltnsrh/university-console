package test.task.universityconsole.controller.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.model.Lector;
import test.task.universityconsole.service.DepartmentService;

@Component
public class DepartmentHeadControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "who is head of department ";
    private final DepartmentService departmentService;

    public DepartmentHeadControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String parameter = parseParameter(consoleRequest);
        if (parameter == null) {
            System.out.println("Incorrect question parameter, try another "
                    + "or enter 'exit' to finish the app");
        }
        Lector lector = departmentService.getLectorByDepartment(parameter);
        return "Answer: Head of " + parameter + " department is "
                + lector.getFirstName() + " " + lector.getLastName();
    }

    private String parseParameter(String consoleRequest) {
        return StringUtils
                .capitalize(consoleRequest.substring(CONTROLLER_KEY.length()).toLowerCase());
    }
}
