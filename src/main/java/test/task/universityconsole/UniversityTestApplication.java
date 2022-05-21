package test.task.universityconsole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.task.universityconsole.controller.MessageController;

@SpringBootApplication
public class UniversityTestApplication implements CommandLineRunner {
    public static MessageController messageController;

    public UniversityTestApplication(MessageController messageController) {
        UniversityTestApplication.messageController = messageController;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter your question bellow or enter 'exit' to finish the app");
        messageController.startBot();
    }
}
