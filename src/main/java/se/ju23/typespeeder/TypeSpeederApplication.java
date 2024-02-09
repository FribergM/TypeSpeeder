package se.ju23.typespeeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ju23.typespeeder.io.SystemIO;
import se.ju23.typespeeder.logic.GameController;
import se.ju23.typespeeder.logic.TypingGame;

@SpringBootApplication
public class TypeSpeederApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TypeSpeederApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TypingGame game = new TypingGame();
        SystemIO io = new SystemIO();

        GameController gameController = new GameController(game,io);
    }

}
