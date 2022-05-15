package test.task.universityconsole.controller.impl;

import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.MessageController;

@Component
public class GlobalSearchControllerImpl implements MessageController {
    private static final String CONTROLLER_KEY = "^global search by ";

    @Override
    public String getResponse(String consoleRequest) {
        return null;
    }
}
