package task.universityconsole.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import task.universityconsole.exception.InputException;
import task.universityconsole.service.ResponseService;
import task.universityconsole.util.ParseUtil;

@Service
public class AvgSalaryServiceImpl implements ResponseService {
    private static final String INCORRECT_DEPARTMENT_EXCEPTION = "Incorrect department name, "
            + "try another or enter 'exit' to finish the app";
    private final ParseUtil parseUtil;

    public AvgSalaryServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public String getResponse(String consoleRequest) throws InputException {
        String departmentName = parseUtil.getDepartmentName(consoleRequest);
        if (departmentName != null) {
            BigDecimal avgDepartmentSalary = parseUtil.getDepartmentService()
                    .getAverageSalary(departmentName)
                    .setScale(2, RoundingMode.HALF_UP);

            return "Answer: The average salary of " + departmentName
                    + " is " + avgDepartmentSalary;
        }
        throw new InputException(INCORRECT_DEPARTMENT_EXCEPTION);
    }
}
