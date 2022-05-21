package test.task.universityconsole.util;

import java.util.List;
import lombok.Getter;
import org.springframework.stereotype.Component;
import test.task.universityconsole.service.DepartmentService;
import test.task.universityconsole.service.LectorService;

@Getter
@Component
public class ParseUtil {
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public ParseUtil(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    public String getDepartmentName(String consoleRequest) {
        List<String> departmentNames = departmentService.getAllNames();
        for (String name: departmentNames) {
            if (consoleRequest.toLowerCase().contains(name.toLowerCase())) {
                return name;
            }
        }
        return null;
    }

    public String getSearchTemplate(String consoleRequest) {
        String trimmedConsoleRequest = consoleRequest.trim();
        return trimmedConsoleRequest.substring(trimmedConsoleRequest.lastIndexOf(" ") + 1);
    }
}
