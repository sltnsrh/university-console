package task.universityconsole.util;

import org.springframework.stereotype.Component;

@Component
public class ConsoleOutput {
    public void outMessage(String message) {
        System.out.println(message);
    }
}
