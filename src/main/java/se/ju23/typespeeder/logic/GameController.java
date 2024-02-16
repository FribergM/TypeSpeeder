package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.Menu;
import se.ju23.typespeeder.io.MenuService;
import se.ju23.typespeeder.io.MenuSwe;

import java.util.List;

public class GameController{

    private Game game;
    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;
    private AccountManager accountManager;
    private Player currentPlayer;

    public GameController(Game game, IO io, MenuService menu,
                          PlayerRepository playerRepo, AccountManager accountManager,Player currentPlayer){
        this.game = game;
        this.io = io;
        this.menu = menu;
        this.playerRepo = playerRepo;
        this.accountManager = accountManager;
        this.currentPlayer = currentPlayer;
    }

    public void run(){

        String playerChoice;

        do{
            menu.displayMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> {
                    if(accountManager.login()){
                        gameMenuSelection();
                    }
                }
                case "2" -> {
                    if(accountManager.createAccount()){
                        gameMenuSelection();
                    }
                }
                case "3" -> changeLanguage();
                case "0" -> io.exit();
                default -> io.output(menu.menuErrorPrompt());
            }

        }while(!playerChoice.equals("0"));

    }

    private void changeLanguage(){

        boolean continueLoop = true;

        do{
            String languagePrompt = menu.changeLanguagePrompt();
            io.output(languagePrompt);

            String choice = io.input();

            switch(choice){
                case "1" -> {
                    if(languagePrompt.contains("Swedish")){
                        menu = new MenuSwe();
                    }else{
                        menu = new Menu();
                    }
                    accountManager.setMenu(menu);
                    continueLoop = false;
                }
                case "2" -> continueLoop = false;
                default -> io.output(menu.menuErrorPrompt());
            }
        }while(continueLoop);

    }

    private void gameMenuSelection(){

        String playerChoice;

        do{
            menu.displayGameMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> io.output("Play Eng");
                case "2" -> io.output("Play Swe");
                case "3" -> io.output("Show res");
                case "4" -> io.output("Acc settings");
                case "0" -> io.output("Logging out...");
                default -> io.output(menu.menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));

    }
}
