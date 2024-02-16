package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.Player;
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
        Player player = new Player();

        AccountManager accountManager = new AccountManager(playerRepo,io,menu,player);
        GameController gameController = new GameController(game, io, menu, playerRepo, accountManager, player);
        gameController.run();
    }

}
