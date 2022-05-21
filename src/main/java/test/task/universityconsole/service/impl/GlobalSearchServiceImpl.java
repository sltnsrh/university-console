package test.task.universityconsole.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import test.task.universityconsole.service.ResponseService;
import test.task.universityconsole.util.ParseUtil;

@Service
public class GlobalSearchServiceImpl implements ResponseService {
    private static  final String ANSWER_TEMPLATE = "Answer: ";
    private static final String COMMA_SEPARATOR = ",";
    private static final String WHITESPACE_SEPARATOR = " ";
    private static final int FIRST_NAME_INDEX = 0;
    public static final int LAST_NAME_INDEX = 1;
    private final ParseUtil parseUtil;

    public GlobalSearchServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public String getResponse(String consoleRequest) {
        String template = parseUtil.getSearchTemplate(consoleRequest).toLowerCase();
        if (!template.trim().isEmpty()) {
            List<String> resultList = parseUtil.getLectorService().findByTemplate(template);
            StringBuilder answerBuilder = new StringBuilder();
            answerBuilder.append(ANSWER_TEMPLATE);
            if (resultList.isEmpty()) {
                return answerBuilder + "nothing was found";
            }
            for (int i = 0; i < resultList.size(); i++) {
                String[] firstLastName = resultList.get(i).split(COMMA_SEPARATOR);
                answerBuilder.append(firstLastName[FIRST_NAME_INDEX])
                        .append(WHITESPACE_SEPARATOR)
                        .append(firstLastName[LAST_NAME_INDEX]);
                if (i < resultList.size() - 1) {
                    answerBuilder.append(COMMA_SEPARATOR + WHITESPACE_SEPARATOR);
                }
            }
            return answerBuilder.toString();
        }
        return "Incorrect find template, try another "
                + "or enter 'exit' to finish the app";
    }
}
