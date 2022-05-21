package test.task.universityconsole.service.impl;

import org.springframework.stereotype.Service;
import test.task.universityconsole.service.ResponseService;
import test.task.universityconsole.util.ParseUtil;

@Service
public class CountEmployeeServiceImpl implements ResponseService {
    private final ParseUtil parseUtil;

    public CountEmployeeServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = parseUtil.getDepartmentName(consoleRequest);
        if (departmentName != null) {
            int countEmployee = parseUtil.getDepartmentService().getEmployeeCount(departmentName);
            return "Answer: " + countEmployee;
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
