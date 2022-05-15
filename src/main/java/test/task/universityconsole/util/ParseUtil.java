package test.task.universityconsole.util;

import java.util.List;
import test.task.universityconsole.service.DepartmentService;

public class ParseUtil {

    public static String getDepartmentName(DepartmentService departmentService,
                                           String consoleRequest) {
        List<String> departmentNames = departmentService.getAllNames();
        for (String name: departmentNames) {
            if (consoleRequest.toLowerCase().contains(name.toLowerCase())) {
                return name;
            }
        }
        return null;
    }

    public static String getSearchTemplate(String consoleRequest) {
        return consoleRequest.substring(consoleRequest.lastIndexOf(" " + 1));
    }
}
