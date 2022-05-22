package task.universityconsole.service.impl;

import org.springframework.stereotype.Service;
import task.universityconsole.service.ResponseService;
import task.universityconsole.util.ParseUtil;

@Service
public class DepartmentStatisticsServiceImpl implements ResponseService {
    private static final String ASSISTANT_DEGREE = "ASSISTANT";
    private static final String ASSOCIATE_PROFESSOR_DEGREE = "ASSOCIATE_PROFESSOR";
    private static final String PROFESSOR_DEGREE = "PROFESSOR";

    private final ParseUtil parseUtil;

    public DepartmentStatisticsServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public String getResponse(String consoleRequest) {
        String departmentName = parseUtil.getDepartmentName(consoleRequest);
        if (departmentName != null) {
            int assistantsCount = parseUtil.getDepartmentService()
                    .getDegreeCount(departmentName, ASSISTANT_DEGREE);
            int associateProfessorsCount = parseUtil.getDepartmentService()
                    .getDegreeCount(departmentName, ASSOCIATE_PROFESSOR_DEGREE);
            int professorsCount = parseUtil.getDepartmentService()
                    .getDegreeCount(departmentName, PROFESSOR_DEGREE);
            return "Answer: " + System.lineSeparator()
                    + "assistants - " + assistantsCount + System.lineSeparator()
                    + "associate professors - " + associateProfessorsCount + System.lineSeparator()
                    + "professors - " + professorsCount;
        }
        return "Incorrect department name, try another "
                + "or enter 'exit' to finish the app";
    }
}
