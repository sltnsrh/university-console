package test.task.universityconsole.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import test.task.universityconsole.service.ServicesStorage;

@Component
public class MessageController {
    private static final String EXIT_COMMAND = "exit";
    private final ServicesStorage servicesStorage;

    public MessageController(ServicesStorage servicesStorage) {
        this.servicesStorage = servicesStorage;
    }

    public void startBot() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String consoleRequest = reader.readLine();

        while (!consoleRequest.equalsIgnoreCase(EXIT_COMMAND)) {
            handleRequest(consoleRequest);
            consoleRequest = reader.readLine();
        }
    }

    private void handleRequest(String consoleRequest) {
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
        System.out.println("Incorrect question, try another "
                + "or enter 'exit' to finish the app");
    }
}
