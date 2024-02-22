package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.repositories.TextRepository;
import se.ju23.typespeeder.data.repositories.PlayerRepository;
import se.ju23.typespeeder.io.Menu;
import se.ju23.typespeeder.io.MenuService;
import se.ju23.typespeeder.io.SystemIO;
import se.ju23.typespeeder.logic.GameController;

@SpringBootApplication(scanBasePackages = "se.ju23.typespeeder.data")
public class TypeSpeederApplication implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private TextRepository textRepo;

    public static void main(String[] args) {
        SpringApplication.run(TypeSpeederApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SystemIO io = new SystemIO();
        MenuService menu = new Menu();

        AccountManager accountManager = new AccountManager(playerRepo,io,menu);
        GameController gameController = new GameController(io, menu, playerRepo, textRepo, accountManager);

        gameController.run();
    }

}
