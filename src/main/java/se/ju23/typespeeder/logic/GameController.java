package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

public class GameController{

    private Game game;
    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;
    private AccountManager accountManager;
    private Player currentPlayer;

    public GameController(Game game,
                          IO io,
                          MenuService menu,
                          PlayerRepository playerRepo,
                          AccountManager accountManager,
                          Player currentPlayer){
        this.game = game;
        this.io = io;
        this.menu = menu;
        this.playerRepo = playerRepo;
        this.accountManager = accountManager;
        this.currentPlayer = currentPlayer;
    }

    public void run(){
        mainMenuSelection();
    }

    private void mainMenuSelection(){
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
                case "3" -> menu.changeLanguage();
                case "0" -> io.exit();
                default -> io.output(menu.menuErrorPrompt());
            }

        }while(!playerChoice.equals("0"));
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
