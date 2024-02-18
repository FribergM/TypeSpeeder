package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

public class GameController{

    private Challenge game;
    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;
    private AccountManager accountManager;
    private Player currentPlayer;

    public GameController(Challenge game,
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
                default -> io.output(menu.getLanguage().menuErrorPrompt());
            }

        }while(!playerChoice.equals("0"));
    }

    private void gameMenuSelection(){
        String playerChoice;

        do{
            menu.displayGameMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> gameModeSelection(true);
                case "2" -> gameModeSelection(false);
                //TODO Fix this & Add lang prompts
                case "3" -> io.output("Show res");
                case "4" -> io.output("Acc settings");
                case "0" -> io.output("Logging out...");
                default -> io.output(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    private void gameModeSelection(Boolean language){
        String playerChoice;

        do{
            menu.displayGameModes();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> difficultySelection(language,1);
                case "2" -> difficultySelection(language,2);
                case "3" -> difficultySelection(language,3);
                case "4" -> difficultySelection(language,4);
                case "0" -> {}//TODO RETURN TO MENU lang prompts
                default -> io.output(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }
    private void difficultySelection(Boolean language, int gameMode){
        String playerChoice;

        do{
            menu.displayDifficulties();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> play(language,gameMode,1);
                case "2" -> play(language,gameMode,2);
                case "3" -> play(language,gameMode,3);
                case "0" -> {}//TODO RETURN TO MENU lang prompts
                default -> io.output(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }
    private void play(Boolean yesNo, int gameMode, int difficulty){
        game.playInEnglish(yesNo);
        game.setGameMode(gameMode);
        game.setDifficulty(difficulty);
    }
}
