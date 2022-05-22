package task.universityconsole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import task.universityconsole.controller.MessageController;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {
    private static MessageController messageController;

    public UniversityApplication(MessageController messageController) {
        UniversityApplication.messageController = messageController;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter your question bellow or enter 'exit' to finish the app");
        messageController.startBot();
    }
}
