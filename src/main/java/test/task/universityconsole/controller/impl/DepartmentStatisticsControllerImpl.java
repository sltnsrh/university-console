package test.task.universityconsole.controller.impl;

import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.service.DepartmentService;
import test.task.universityconsole.util.ParseUtil;

@Component
public class DepartmentStatisticsControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^Show\\s+\\w+\\s+statistics";
    private final DepartmentService departmentService;

    public DepartmentStatisticsControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = ParseUtil.getDepartmentName(departmentService, consoleRequest);
        if (departmentName != null) {
            int assistantsCount = departmentService.getAssistantsCount(departmentName);
            int associateProfessorsCount = departmentService
                    .getAssociateProfessorsCount(departmentName);
            int professorsCount = departmentService.getProfessorsCount(departmentName);
            return "Answer: " + System.lineSeparator()
                    + "assistants - " + assistantsCount + System.lineSeparator()
                    + "associate professors - " + associateProfessorsCount + System.lineSeparator()
                    + "professors - " + professorsCount;
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
