package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.Menu;
import se.ju23.typespeeder.io.MenuService;
import se.ju23.typespeeder.io.SystemIO;
import se.ju23.typespeeder.logic.GameController;
import se.ju23.typespeeder.logic.TypingGame;

@SpringBootApplication(scanBasePackages = "se.ju23.typespeeder.data")
public class TypeSpeederApplication implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepo;

    public static void main(String[] args) {
        SpringApplication.run(TypeSpeederApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TypingGame game = new TypingGame();
        SystemIO io = new SystemIO();
        MenuService menu = new Menu();

        GameController gameController = new GameController(game,io,menu,playerRepo);
        gameController.run();
    }

}
