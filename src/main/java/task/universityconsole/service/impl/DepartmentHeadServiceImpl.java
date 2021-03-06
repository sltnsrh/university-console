package task.universityconsole.service.impl;

import org.springframework.stereotype.Service;
import task.universityconsole.model.Lector;
import task.universityconsole.service.ResponseService;
import task.universityconsole.util.ParseUtil;

@Service
public class DepartmentHeadServiceImpl implements ResponseService {
    private final ParseUtil parseUtil;

    public DepartmentHeadServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = parseUtil.getDepartmentName(consoleRequest);
        if (departmentName != null) {
            Lector lector = parseUtil.getDepartmentService().getDepartmentHead(departmentName);
            return "Answer: Head of " + departmentName + " department is "
                    + lector.getFirstName() + " " + lector.getLastName();
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
