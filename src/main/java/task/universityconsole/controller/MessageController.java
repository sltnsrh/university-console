package task.universityconsole.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import task.universityconsole.exception.InputException;
import task.universityconsole.service.ServicesStorage;
import task.universityconsole.util.ConsoleOutput;

@Component
public class MessageController {
    private static final String EXIT_COMMAND = "exit";
    private static final String INCORRECT_QUESTION_RESPONSE = "Incorrect question, try another "
            + "or enter 'exit' to finish the app";
    private final ServicesStorage servicesStorage;
    private final ConsoleOutput consoleOutput;

    public MessageController(ServicesStorage servicesStorage, ConsoleOutput consoleOutput) {
        this.servicesStorage = servicesStorage;
        this.consoleOutput = consoleOutput;
    }

    public void startBot() throws IOException, InputException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String consoleRequest = reader.readLine();

        while (!consoleRequest.equalsIgnoreCase(EXIT_COMMAND)) {
            handleRequest(consoleRequest);
            consoleRequest = reader.readLine();
        }
    }

    private void handleRequest(String consoleRequest) throws InputException {
        for (String key: servicesStorage.getServices().keySet()) {
            Pattern pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(consoleRequest.trim());
            if (matcher.find()) {
                String answerMessage = servicesStorage.getServices().get(key)
                        .getResponse(consoleRequest);
                System.out.println(answerMessage);
                return;
            }
        }
        consoleOutput.outMessage(INCORRECT_QUESTION_RESPONSE);
    }
}
