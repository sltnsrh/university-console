package task.universityconsole.service;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import task.universityconsole.service.impl.AvgSalaryServiceImpl;
import task.universityconsole.service.impl.CountEmployeeServiceImpl;
import task.universityconsole.service.impl.DepartmentHeadServiceImpl;
import task.universityconsole.service.impl.DepartmentStatisticsServiceImpl;
import task.universityconsole.service.impl.GlobalSearchServiceImpl;
import task.universityconsole.util.ParseUtil;

@Getter
@Component
@Order(value = 1)
public class ServicesStorage implements CommandLineRunner {
    private static final String AVG_SALARY_PATTERN = "^show the average salary for the department";
    private static final String COUNT_EMPLOYEE_PATTERN = "^show count of employee for";
    private static final String HEAD_DEPARTMENT_PATTERN = "^who is head of department";
    private static final String SHOW_STATISTICS_PATTERN = "^Show\\s+\\w+\\s+statistics";
    private static final String GLOBAL_SEARCH_PATTERN = "^global search by";
    private final Map<String, ResponseService> services = new HashMap<>();
    private final ParseUtil parseUtil;

    public ServicesStorage(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    private void fillServiceMap() {
        services.put(AVG_SALARY_PATTERN, new AvgSalaryServiceImpl(parseUtil));
        services.put(COUNT_EMPLOYEE_PATTERN, new CountEmployeeServiceImpl(parseUtil));
        services.put(HEAD_DEPARTMENT_PATTERN, new DepartmentHeadServiceImpl(parseUtil));
        services.put(SHOW_STATISTICS_PATTERN,
                new DepartmentStatisticsServiceImpl(parseUtil));
        services.put(GLOBAL_SEARCH_PATTERN, new GlobalSearchServiceImpl(parseUtil));
    }

    @Override
    public void run(String... args) throws Exception {
        fillServiceMap();
    }
}
