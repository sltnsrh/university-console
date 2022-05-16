package test.task.universityconsole.controller.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;
import test.task.universityconsole.controller.MessageController;
import test.task.universityconsole.service.LectorService;
import test.task.universityconsole.util.ParseUtil;

@Component
public class GlobalSearchControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^global search by";
    private static  final String ANSWER_TEMPLATE = "Answer: ";
    private static final String COMMA_SEPARATOR = ",";
    private static final String WHITESPACE_SEPARATOR = " ";
    private static final int FIRST_NAME_INDEX = 0;
    public static final int LAST_NAME_INDEX = 1;
    private final LectorService lectorService;

    public GlobalSearchControllerImpl(LectorService lectorService) {
        this.lectorService = lectorService;
        ControllersMap.controllers.put(CONTROLLER_KEY, this);
    }

    @Override
    public String getResponse(String consoleRequest) {
        String template = ParseUtil.getSearchTemplate(consoleRequest).toLowerCase();
        if (!template.trim().isEmpty()) {
            List<String> resultList = lectorService.findByTemplate(template);
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
