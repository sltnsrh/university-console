package test.task.universityconsole;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityTestApplication implements CommandLineRunner {
    public static MessageDispatcher messageDispatcher;

    public UniversityTestApplication(MessageDispatcher messageDispatcher) {
        UniversityTestApplication.messageDispatcher = messageDispatcher;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter your question bellow or enter 'exit' to finish the app");
        messageDispatcher.startBot();
    }
}
