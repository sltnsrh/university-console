package test.task.universityconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;
import test.task.universityconsole.controller.ControllersMap;

@Component
public class MessageDispatcher {
    private static final String EXIT = "exit";

    public void startBot() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String consoleRequest = reader.readLine();

        while (!consoleRequest.equalsIgnoreCase(EXIT)) {
            getStrategy(consoleRequest);
            consoleRequest = reader.readLine();
        }
    }

    private void getStrategy(String consoleRequest) {
        for (String key: ControllersMap.controllers.keySet()) {
            if (consoleRequest.toLowerCase().contains(key)) {
                String answerMessage = ControllersMap.controllers.get(key).getResponse(consoleRequest);
                System.out.println(answerMessage);
                return;
            }
        }
        System.out.println("Incorrect question, try another "
                + "or enter 'exit' to finish the app");
    }
}
