package task.universityconsole.service;

import task.universityconsole.exception.InputException;

public interface ResponseService {
    String getResponse(String consoleRequest) throws InputException;
}
