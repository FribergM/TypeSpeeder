package se.ju23.typespeeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.repositories.TextRepository;
import se.ju23.typespeeder.data.repositories.PlayerRepository;
import se.ju23.typespeeder.services.LeaderboardService;
import se.ju23.typespeeder.ui.Menu;
import se.ju23.typespeeder.ui.MenuService;
import se.ju23.typespeeder.ui.SystemIO;
import se.ju23.typespeeder.logic.GameController;

@SpringBootApplication(scanBasePackages = {"se.ju23.typespeeder.data","se.ju23.typespeeder.services"})
public class TypeSpeederApplication implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private TextRepository textRepo;
    @Autowired
    LeaderboardService ls;

    public static void main(String[] args) {
        SpringApplication.run(TypeSpeederApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SystemIO io = new SystemIO();
        MenuService menu = new Menu();

        AccountManager accountManager = new AccountManager(playerRepo,io,menu);
        GameController gameController = new GameController(io, menu, playerRepo, textRepo, accountManager,ls);

        gameController.run();
    }

}
