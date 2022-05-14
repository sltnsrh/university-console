package test.task.universityconsole.controller.impl;

import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.service.DepartmentService;

@Component
public class DepartmentStatisticsControllerImpl implements MessageController {
    private final DepartmentService departmentService;

    public DepartmentStatisticsControllerImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
        ControllersMap.controllers.put("show  statistics", this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        return null;
    }
}
